package com.adilhoumadi.meetup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonPropertyOrder({
        "utc_offset",
        "venue",
        "rsvp_limit",
        "venue_visibility",
        "visibility",
        "maybe_rsvp_count",
        "description",
        "mtime",
        "event_url",
        "yes_rsvp_count",
        "duration",
        "payment_required",
        "name",
        "id",
        "time",
        "group",
        "status",
        "fee"
})
public class Event {

    @JsonProperty("utc_offset")
    public Long utcOffset = 0L;
    @JsonProperty("rsvp_limit")
    public Long rsvpLimit = 0L;
    @JsonProperty("maybe_rsvp_count")
    public Long maybeRsvpCount = 0L;
    @JsonProperty("mtime")
    public Long mtime = 0L;
    @JsonProperty("yes_rsvp_count")
    public Long yesRsvpCount = 0L;
    @JsonProperty("duration")
    public Long duration = 0L;
    @JsonProperty("time")
    public Long time = 0L;
    @JsonProperty("venue_visibility")
    public String venueVisibility = "";
    @JsonProperty("visibility")
    public String visibility = "";
    @JsonProperty("description")
    public String description = "";
    @JsonProperty("event_url")
    public String eventUrl = "";
    @JsonProperty("payment_required")
    public String paymentRequired = "";
    @JsonProperty("name")
    public String name = "";
    @JsonProperty("id")
    public String id = "";
    @JsonProperty("status")
    public String status = "";
    @JsonProperty("group")
    public Group group = null;
    @JsonProperty("fee")
    public Fee fee = null;
    @JsonProperty("venue")
    public Venue venue = null;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("utcOffset", utcOffset)
                .append("venue", venue)
                .append("rsvpLimit", rsvpLimit)
                .append("venueVisibility", venueVisibility)
                .append("visibility", visibility)
                .append("maybeRsvpCount", maybeRsvpCount)
                .append("description", description)
                .append("mtime", mtime)
                .append("eventUrl", eventUrl)
                .append("yesRsvpCount", yesRsvpCount)
                .append("duration", duration)
                .append("paymentRequired", paymentRequired)
                .append("name", name)
                .append("id", id)
                .append("time", time)
                .append("group", group)
                .append("status", status)
                .append("fee", fee)
                .toString();
    }

}