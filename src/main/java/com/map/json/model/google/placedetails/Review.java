
package com.map.json.model.google.placedetails;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "author_name",
    "author_url",
    "language",
    "profile_photo_url",
    "rating",
    "relative_time_description",
    "text",
    "time"
})
public class Review implements Serializable
{

    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("author_url")
    private String authorUrl;
    @JsonProperty("language")
    private String language;
    @JsonProperty("profile_photo_url")
    private String profilePhotoUrl;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("relative_time_description")
    private String relativeTimeDescription;
    @JsonProperty("text")
    private String text;
    @JsonProperty("time")
    private Integer time;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 2992158714651445363L;

    @JsonProperty("author_name")
    public String getAuthorName() {
        return authorName;
    }

    @JsonProperty("author_name")
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @JsonProperty("author_url")
    public String getAuthorUrl() {
        return authorUrl;
    }

    @JsonProperty("author_url")
    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("profile_photo_url")
    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    @JsonProperty("profile_photo_url")
    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    @JsonProperty("rating")
    public Integer getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @JsonProperty("relative_time_description")
    public String getRelativeTimeDescription() {
        return relativeTimeDescription;
    }

    @JsonProperty("relative_time_description")
    public void setRelativeTimeDescription(String relativeTimeDescription) {
        this.relativeTimeDescription = relativeTimeDescription;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("time")
    public Integer getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Integer time) {
        this.time = time;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("authorName", authorName).append("authorUrl", authorUrl).append("language", language).append("profilePhotoUrl", profilePhotoUrl).append("rating", rating).append("relativeTimeDescription", relativeTimeDescription).append("text", text).append("time", time).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(time).append(text).append(profilePhotoUrl).append(additionalProperties).append(authorName).append(authorUrl).append(rating).append(language).append(relativeTimeDescription).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Review) == false) {
            return false;
        }
        Review rhs = ((Review) other);
        return new EqualsBuilder().append(time, rhs.time).append(text, rhs.text).append(profilePhotoUrl, rhs.profilePhotoUrl).append(additionalProperties, rhs.additionalProperties).append(authorName, rhs.authorName).append(authorUrl, rhs.authorUrl).append(rating, rhs.rating).append(language, rhs.language).append(relativeTimeDescription, rhs.relativeTimeDescription).isEquals();
    }

}
