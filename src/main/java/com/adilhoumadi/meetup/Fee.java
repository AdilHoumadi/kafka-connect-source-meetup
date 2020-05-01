package com.adilhoumadi.meetup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonPropertyOrder({
        "amount",
        "currency"
})
public class Fee {

    @JsonProperty("amount")
    public Integer amount = 0;
    @JsonProperty("currency")
    public String currency = "";

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("amount", amount)
                .append("currency", currency)
                .toString();
    }
}