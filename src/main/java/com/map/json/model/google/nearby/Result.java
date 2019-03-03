
package com.map.json.model.google.nearby;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
    "geometry",
    "icon",
    "id",
    "name",
    "photos",
    "place_id",
    "reference",
    "scope",
    "types",
    "vicinity",
    "opening_hours",
    "plus_code",
    "rating",
    "user_ratings_total"
})
public class Result implements Serializable
{

    @JsonProperty("geometry")
    @Valid
    private Geometry geometry;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photos")
    @Valid
    private List<Photo> photos = null;
    @JsonProperty("place_id")
    private String placeId;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("types")
    @Valid
    private List<String> types = null;
    @JsonProperty("vicinity")
    private String vicinity;
    @JsonProperty("opening_hours")
    @Valid
    private OpeningHours openingHours;
    @JsonProperty("plus_code")
    @Valid
    private PlusCode plusCode;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("user_ratings_total")
    private Integer userRatingsTotal;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4432269650863810558L;

    @JsonProperty("geometry")
    public Geometry getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("photos")
    public List<Photo> getPhotos() {
        return photos;
    }

    @JsonProperty("photos")
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @JsonProperty("place_id")
    public String getPlaceId() {
        return placeId;
    }

    @JsonProperty("place_id")
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(String reference) {
        this.reference = reference;
    }

    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    @JsonProperty("types")
    public List<String> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(List<String> types) {
        this.types = types;
    }

    @JsonProperty("vicinity")
    public String getVicinity() {
        return vicinity;
    }

    @JsonProperty("vicinity")
    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    @JsonProperty("opening_hours")
    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    @JsonProperty("opening_hours")
    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

    @JsonProperty("plus_code")
    public PlusCode getPlusCode() {
        return plusCode;
    }

    @JsonProperty("plus_code")
    public void setPlusCode(PlusCode plusCode) {
        this.plusCode = plusCode;
    }

    @JsonProperty("rating")
    public Double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Double rating) {
        this.rating = rating;
    }

    @JsonProperty("user_ratings_total")
    public Integer getUserRatingsTotal() {
        return userRatingsTotal;
    }

    @JsonProperty("user_ratings_total")
    public void setUserRatingsTotal(Integer userRatingsTotal) {
        this.userRatingsTotal = userRatingsTotal;
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
        return new ToStringBuilder(this).append("geometry", geometry).append("icon", icon).append("id", id).append("name", name).append("photos", photos).append("placeId", placeId).append("reference", reference).append("scope", scope).append("types", types).append("vicinity", vicinity).append("openingHours", openingHours).append("plusCode", plusCode).append("rating", rating).append("userRatingsTotal", userRatingsTotal).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(icon).append(scope).append(openingHours).append(plusCode).append(reference).append(geometry).append(photos).append(id).append(vicinity).append(placeId).append(additionalProperties).append(name).append(rating).append(userRatingsTotal).append(types).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Result) == false) {
            return false;
        }
        Result rhs = ((Result) other);
        return new EqualsBuilder().append(icon, rhs.icon).append(scope, rhs.scope).append(openingHours, rhs.openingHours).append(plusCode, rhs.plusCode).append(reference, rhs.reference).append(geometry, rhs.geometry).append(photos, rhs.photos).append(id, rhs.id).append(vicinity, rhs.vicinity).append(placeId, rhs.placeId).append(additionalProperties, rhs.additionalProperties).append(name, rhs.name).append(rating, rhs.rating).append(userRatingsTotal, rhs.userRatingsTotal).append(types, rhs.types).isEquals();
    }

}
