package com.adilhoumadi.schema;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

public class Venue {

    public static final String SCHEMA_VALUE_VENUE_NAME = "com.adilhoumadi.meetup.VenueValue";

    public static final String ZIP = "zip";
    public static final String COUNTRY = "country";
    public static final String CITY = "city";
    public static final String ADDRESS_1 = "address_1";
    public static final String ADDRESS_2 = "address_2";
    public static final String NAME = "name";
    public static final String LON = "lon";
    public static final String STATE = "state";
    public static final String LAT = "lat";
    public static final String PHONE = "phone";

    public static final Schema SCHEMA_VALUE_VENUE = SchemaBuilder
            .struct()
            .name(SCHEMA_VALUE_VENUE_NAME)
            .version(1)
            .field(ZIP, Schema.STRING_SCHEMA)
            .field(COUNTRY, Schema.STRING_SCHEMA)
            .field(CITY, Schema.STRING_SCHEMA)
            .field(ADDRESS_1, Schema.STRING_SCHEMA)
            .field(ADDRESS_2, Schema.STRING_SCHEMA)
            .field(NAME, Schema.STRING_SCHEMA)
            .field(STATE, Schema.STRING_SCHEMA)
            .field(LON, Schema.FLOAT32_SCHEMA)
            .field(LAT, Schema.FLOAT32_SCHEMA)
            .field(PHONE, Schema.STRING_SCHEMA)
            .optional()
            .build();

    private Venue() {
        // Nothing to do
    }

    public static Struct getVenue(com.adilhoumadi.meetup.Venue venue) {
        return new Struct(SCHEMA_VALUE_VENUE)
                .put(ZIP, venue.zip)
                .put(COUNTRY, venue.country)
                .put(CITY, venue.city)
                .put(ADDRESS_1, venue.address1)
                .put(ADDRESS_2, venue.address2)
                .put(NAME, venue.name)
                .put(STATE, venue.state)
                .put(LON, venue.lon)
                .put(LAT, venue.lat)
                .put(PHONE, venue.phone)
                ;
    }

}
