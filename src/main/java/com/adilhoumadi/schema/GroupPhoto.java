package com.adilhoumadi.schema;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

public class GroupPhoto {

    public static final String SCHEMA_VALUE_GROUP_PHOTO_NAME = "com.adilhoumadi.meetup.GroupPhotoValue";

    public static final String HIGHRES_LINK = "highres_link";
    public static final String PHOTO_LINK = "photo_link";
    public static final String PHOTO_ID = "photo_id";
    public static final String THUMB_LINK = "thumb_link";

    public static final Schema SCHEMA_VALUE_GROUP_PHOTO = SchemaBuilder
            .struct()
            .name(SCHEMA_VALUE_GROUP_PHOTO_NAME)
            .version(1)
            .field(HIGHRES_LINK, Schema.STRING_SCHEMA)
            .field(PHOTO_LINK, Schema.STRING_SCHEMA)
            .field(PHOTO_ID, Schema.INT32_SCHEMA)
            .field(THUMB_LINK, Schema.STRING_SCHEMA)
            .optional()
            .build();

    private GroupPhoto() {
        // Nothing to do
    }

    public static Struct getGroupPhoto(com.adilhoumadi.meetup.GroupPhoto groupPhoto) {
        return new Struct(SCHEMA_VALUE_GROUP_PHOTO)
                .put(HIGHRES_LINK, groupPhoto.highresLink)
                .put(PHOTO_LINK, groupPhoto.photoLink)
                .put(PHOTO_ID, groupPhoto.photoId)
                .put(THUMB_LINK, groupPhoto.thumbLink)
                ;
    }

}
