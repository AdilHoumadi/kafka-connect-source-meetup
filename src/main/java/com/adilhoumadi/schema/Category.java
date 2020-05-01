package com.adilhoumadi.schema;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

public class Category {

    public static final String SCHEMA_VALUE_CATEGORY_NAME = "com.adilhoumadi.meetup.CategoryValue";
    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String SHORTNAME = "shortname";

    public static final Schema SCHEMA_VALUE_CATEGORY = SchemaBuilder
            .struct()
            .name(SCHEMA_VALUE_CATEGORY_NAME)
            .version(1)
            .field(NAME, Schema.STRING_SCHEMA)
            .field(ID, Schema.INT32_SCHEMA)
            .field(SHORTNAME, Schema.STRING_SCHEMA)
            .optional()
            .build();

    private Category() {
        // Nothing to do
    }
    
    public static Struct getCategory(com.adilhoumadi.meetup.Category category) {
        return new Struct(SCHEMA_VALUE_CATEGORY)
                .put(NAME, category.name)
                .put(ID, category.id)
                .put(SHORTNAME, category.shortname)
                ;
    }
}
