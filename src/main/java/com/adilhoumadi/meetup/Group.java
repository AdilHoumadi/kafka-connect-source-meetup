package com.adilhoumadi.meetup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonPropertyOrder({
        "join_mode",
        "country",
        "city",
        "name",
        "group_lon",
        "id",
        "state",
        "urlname",
        "category",
        "group_lat",
        "group_photo"
})
public class Group {

    @JsonProperty("join_mode")
    public String joinMode = "";
    @JsonProperty("country")
    public String country = "";
    @JsonProperty("city")
    public String city = "";
    @JsonProperty("name")
    public String name = "";
    @JsonProperty("id")
    public Integer id = 0;
    @JsonProperty("state")
    public String state = "";
    @JsonProperty("urlname")
    public String urlname = "";
    @JsonProperty("category")
    public Category category = null;
    @JsonProperty("group_lat")
    public Float groupLat = 0F;
    @JsonProperty("group_lon")
    public Float groupLon = 0F;
    @JsonProperty("group_photo")
    public GroupPhoto groupPhoto = null;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("joinMode", joinMode)
                .append("country", country)
                .append("city", city)
                .append("name", name)
                .append("groupLon", groupLon)
                .append("id", id)
                .append("state", state)
                .append("urlname", urlname)
                .append("category", category)
                .append("groupLat", groupLat)
                .append("groupPhoto", groupPhoto)
                .toString();
    }

}