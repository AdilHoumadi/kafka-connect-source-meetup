package com.adilhoumadi;

import com.adilhoumadi.meetup.Event;

import com.adilhoumadi.schema.Fee;
import com.adilhoumadi.schema.Group;
import com.adilhoumadi.schema.Venue;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.adilhoumadi.schema.Event.*;

public class MeetupSourceTask extends SourceTask {

    private static final Logger LOG = LoggerFactory.getLogger(MeetupSourceTask.class);
    private MeetupSourceConnectorConfig config;
    MeetupClient meetupClient;

    @Override
    public void start(Map<String, String> map) {
        config = new MeetupSourceConnectorConfig(map);
        meetupClient = new MeetupClient();
    }

    @Override
    public List<SourceRecord> poll() {
        final ArrayList<SourceRecord> records = new ArrayList<>();
        meetupClient.pollEvent().toBlocking().forEach(
                event -> {
                    SourceRecord sourceRecord = processEvent(event);
                    LOG.info(sourceRecord.toString());
                    records.add(sourceRecord);
                }
        );
        return records;
    }

    @Override
    public void stop() {
        LOG.info("Shutting down Meetup source task");
    }

    @Override
    public String version() {
        return MeetupVersion.getCurrentVersion();
    }

    private Map<String, String> source(Event event) {
        Map<String, String> map = new HashMap<>();
        map.put(ID, event.id);
        return map;
    }
    private Map<String, String> sourcePartition(Event event) {
        return source(event);
    }

    private Map<String, String> sourceOffset(Event event) {
        return source(event);
    }

    private Struct recordKey(Event event) {
        return new Struct(SCHEMA_KEY_EVENT).put(ID, event.id);
    }

    public Struct recordValue(Event event) {
        Struct struct = new Struct(SCHEMA_VALUE_EVENT)
                .put(UTC_OFFSET, event.utcOffset)
                .put(RSVP_LIMIT, event.rsvpLimit)
                .put(VENUE_VISIBILITY, event.venueVisibility)
                .put(VISIBILITY, event.visibility)
                .put(MAYBE_RSVP_COUNT, event.maybeRsvpCount)
                .put(DESCRIPTION, event.description)
                .put(MTIME, event.mtime)
                .put(EVENT_URL, event.eventUrl)
                .put(YES_RSVP_COUNT, event.yesRsvpCount)
                .put(DURATION, event.duration)
                .put(PAYMENT_REQUIRED, event.paymentRequired)
                .put(NAME, event.name)
                .put(ID, event.id)
                .put(TIME, event.time)
                .put(STATUS, event.status);
        if (event.venue != null) {
            struct.put(VENUE, Venue.getVenue(event.venue));
        }
        if (event.group != null) {
            struct.put(GROUP, Group.getGroup(event.group));
        }
        if (event.fee != null) {
            struct.put(FEE, Fee.getFee(event.fee));
        }
        return struct;
    }

    private SourceRecord processEvent(Event event) {
        return new SourceRecord(
                sourcePartition(event),
                sourceOffset(event),
                config.getTopic(),
                null,
                SCHEMA_KEY_EVENT,
                recordKey(event),
                SCHEMA_VALUE_EVENT,
                recordValue(event),
                event.time);
    }
}
