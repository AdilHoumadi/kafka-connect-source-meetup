package com.adilhoumadi.schema;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;

public class Event {

    public static final String SCHEMA_VALUE_EVENT_NAME = "com.adilhoumadi.meetup.EventValue";

    public static final String UTC_OFFSET = "utc_offset";
    public static final String VENUE = "venue";
    public static final String RSVP_LIMIT = "rsvp_limit";
    public static final String VENUE_VISIBILITY = "venue_visibility";
    public static final String VISIBILITY = "visibility";
    public static final String MAYBE_RSVP_COUNT = "maybe_rsvp_count";
    public static final String DESCRIPTION = "description";
    public static final String MTIME = "mtime";
    public static final String EVENT_URL = "event_url";
    public static final String YES_RSVP_COUNT = "yes_rsvp_count";
    public static final String DURATION = "duration";
    public static final String PAYMENT_REQUIRED = "payment_required";
    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String TIME = "time";
    public static final String GROUP = "group";
    public static final String STATUS = "status";
    public static final String FEE = "fee";

    public static final Schema SCHEMA_VALUE_EVENT = SchemaBuilder
            .struct()
            .name(SCHEMA_VALUE_EVENT_NAME)
            .version(1)
            .field(UTC_OFFSET, Schema.INT64_SCHEMA)
            .field(RSVP_LIMIT, Schema.INT64_SCHEMA)
            .field(VENUE_VISIBILITY, Schema.STRING_SCHEMA)
            .field(VISIBILITY, Schema.STRING_SCHEMA)
            .field(MAYBE_RSVP_COUNT, Schema.INT64_SCHEMA)
            .field(DESCRIPTION, Schema.STRING_SCHEMA)
            .field(MTIME, Schema.INT64_SCHEMA)
            .field(EVENT_URL, Schema.STRING_SCHEMA)
            .field(YES_RSVP_COUNT, Schema.INT64_SCHEMA)
            .field(DURATION, Schema.INT64_SCHEMA)
            .field(PAYMENT_REQUIRED, Schema.STRING_SCHEMA)
            .field(NAME, Schema.STRING_SCHEMA)
            .field(ID, Schema.STRING_SCHEMA)
            .field(TIME, Schema.INT64_SCHEMA)
            .field(STATUS, Schema.STRING_SCHEMA)
            .field(GROUP, Group.SCHEMA_VALUE_GROUP)
            .field(VENUE, Venue.SCHEMA_VALUE_VENUE)
            .field(FEE, Fee.SCHEMA_VALUE_FEE)
            .build();


    public static final String SCHEMA_KEY_EVENT_NAME = "com.adilhoumadi.meetup.EventKey";

    public static final Schema SCHEMA_KEY_EVENT = SchemaBuilder
            .struct()
            .name(SCHEMA_KEY_EVENT_NAME)
            .version(1)
            .field(NAME, Schema.STRING_SCHEMA)
            .field(ID, Schema.STRING_SCHEMA)
            .build();

    private Event() {
        // Nothing to do
    }
}
