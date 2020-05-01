package com.adilhoumadi.meetup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonPropertyOrder({
        "zip",
        "country",
        "city",
        "address_1",
        "address_2",
        "name",
        "lon",
        "state",
        "lat",
        "phone"
})
public class Venue {

    @JsonProperty("phone")
    public String phone = "";
    @JsonProperty("zip")
    public String zip = "";
    @JsonProperty("country")
    public String country = "";
    @JsonProperty("city")
    public String city = "";
    @JsonProperty("address_1")
    public String address1 = "";
    @JsonProperty("address_2")
    public String address2 = "";
    @JsonProperty("name")
    public String name = "";
    @JsonProperty("lon")
    public Float lon = 0F;
    @JsonProperty("lat")
    public Float lat = 0F;
    @JsonProperty("state")
    public String state = "";

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("zip", zip)
                .append("country", country)
                .append("city", city)
                .append("address1", address1)
                .append("address2", address2)
                .append("name", name)
                .append("lon", lon)
                .append("state", state)
                .append("lat", lat)
                .append("phone", phone)
                .toString();
    }

}