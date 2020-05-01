package com.adilhoumadi.meetup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonPropertyOrder({
        "name",
        "id",
        "shortname"
})
public class Category {

    @JsonProperty("name")
    public String name = "";
    @JsonProperty("id")
    public Integer id = 0;
    @JsonProperty("shortname")
    public String shortname = "";

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("id", id)
                .append("shortname", shortname)
                .toString();
    }
}