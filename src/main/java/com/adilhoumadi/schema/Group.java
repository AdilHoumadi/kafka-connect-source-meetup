package com.adilhoumadi.schema;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

public class Group {
    public static final String SCHEMA_VALUE_GROUP_NAME = "com.adilhoumadi.meetup.GroupValue";

    public static final String JOIN_MODE = "join_mode";
    public static final String COUNTRY = "country";
    public static final String CITY = "city";
    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String STATE = "state";
    public static final String URLNAME = "urlname";
    public static final String CATEGORY = "category";
    public static final String GROUP_LON = "group_lon";
    public static final String GROUP_LAT = "group_lat";
    public static final String GROUP_PHOTO = "group_photo";

    public static final Schema SCHEMA_VALUE_GROUP = SchemaBuilder
            .struct()
            .name(SCHEMA_VALUE_GROUP_NAME)
            .version(1)
            .field(JOIN_MODE, Schema.STRING_SCHEMA)
            .field(COUNTRY, Schema.STRING_SCHEMA)
            .field(CITY, Schema.STRING_SCHEMA)
            .field(NAME, Schema.STRING_SCHEMA)
            .field(ID, Schema.INT32_SCHEMA)
            .field(STATE, Schema.STRING_SCHEMA)
            .field(URLNAME, Schema.STRING_SCHEMA)
            .field(GROUP_LON, Schema.FLOAT32_SCHEMA)
            .field(GROUP_LAT, Schema.FLOAT32_SCHEMA)
            .field(CATEGORY, Category.SCHEMA_VALUE_CATEGORY)
            .field(GROUP_PHOTO, GroupPhoto.SCHEMA_VALUE_GROUP_PHOTO)
            .optional()
            .build();

    private Group() {
        // Nothing to do
    }

    public static Struct getGroup(com.adilhoumadi.meetup.Group group) {
        Struct struct = new Struct(SCHEMA_VALUE_GROUP)
                .put(JOIN_MODE, group.joinMode)
                .put(COUNTRY, group.country)
                .put(CITY, group.city)
                .put(NAME, group.name)
                .put(ID, group.id)
                .put(STATE, group.state)
                .put(URLNAME, group.urlname)
                .put(GROUP_LON, group.groupLon)
                .put(GROUP_LAT, group.groupLat);

        if (group.category != null) {
            struct.put(CATEGORY, Category.getCategory(group.category));
        }
        if (group.groupPhoto != null) {
            struct.put(GROUP_PHOTO, GroupPhoto.getGroupPhoto(group.groupPhoto));
        }
        return struct;
    }
}
