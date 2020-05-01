package com.adilhoumadi.meetup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "highres_link",
        "photo_link",
        "photo_id",
        "thumb_link"
})
public class GroupPhoto {

    @JsonProperty("highres_link")
    public String highresLink = "";
    @JsonProperty("photo_link")
    public String photoLink = "";
    @JsonProperty("photo_id")
    public Integer photoId = 0;
    @JsonProperty("thumb_link")
    public String thumbLink = "";

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("highresLink", highresLink)
                .append("photoLink", photoLink)
                .append("photoId", photoId)
                .append("thumbLink", thumbLink)
                .toString();
    }

}