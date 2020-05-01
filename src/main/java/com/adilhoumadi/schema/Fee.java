package com.adilhoumadi.schema;

import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaBuilder;
import org.apache.kafka.connect.data.Struct;

public class Fee {

    public static final String SCHEMA_VALUE_FEE_NAME = "com.adilhoumadi.meetup.FeeValue";

    public static final String AMOUNT = "amount";
    public static final String CURRENCY = "currency";

    public static final Schema SCHEMA_VALUE_FEE = SchemaBuilder
            .struct()
            .name(SCHEMA_VALUE_FEE_NAME)
            .version(1)
            .field(AMOUNT, Schema.INT32_SCHEMA)
            .field(CURRENCY, Schema.STRING_SCHEMA)
            .optional()
            .build();

    private Fee() {
        // Nothing to do
    }

    public static Struct getFee(com.adilhoumadi.meetup.Fee fee) {
        return new Struct(SCHEMA_VALUE_FEE)
                .put(AMOUNT, fee.amount)
                .put(CURRENCY, fee.currency)
                ;
    }
}
