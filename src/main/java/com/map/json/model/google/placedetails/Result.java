
package com.map.json.model.google.placedetails;

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
    "address_components",
    "adr_address",
    "formatted_address",
    "formatted_phone_number",
    "geometry",
    "icon",
    "id",
    "international_phone_number",
    "name",
    "opening_hours",
    "photos",
    "place_id",
    "plus_code",
    "rating",
    "reference",
    "reviews",
    "scope",
    "types",
    "url",
    "user_ratings_total",
    "utc_offset",
    "vicinity",
    "website"
})
public class Result implements Serializable
{

    @JsonProperty("address_components")
    @Valid
    private List<AddressComponent> addressComponents = null;
    @JsonProperty("adr_address")
    private String adrAddress;
    @JsonProperty("formatted_address")
    private String formattedAddress;
    @JsonProperty("formatted_phone_number")
    private String formattedPhoneNumber;
    @JsonProperty("geometry")
    @Valid
    private Geometry geometry;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("id")
    private String id;
    @JsonProperty("international_phone_number")
    private String internationalPhoneNumber;
    @JsonProperty("name")
    private String name;
    @JsonProperty("opening_hours")
    @Valid
    private OpeningHours openingHours;
    @JsonProperty("photos")
    @Valid
    private List<Photo> photos = null;
    @JsonProperty("place_id")
    private String placeId;
    @JsonProperty("plus_code")
    @Valid
    private PlusCode plusCode;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("reviews")
    @Valid
    private List<Review> reviews = null;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("types")
    @Valid
    private List<String> types = null;
    @JsonProperty("url")
    private String url;
    @JsonProperty("user_ratings_total")
    private Integer userRatingsTotal;
    @JsonProperty("utc_offset")
    private Integer utcOffset;
    @JsonProperty("vicinity")
    private String vicinity;
    @JsonProperty("website")
    private String website;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4284422863516040059L;

    @JsonProperty("address_components")
    public List<AddressComponent> getAddressComponents() {
        return addressComponents;
    }

    @JsonProperty("address_components")
    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.addressComponents = addressComponents;
    }

    @JsonProperty("adr_address")
    public String getAdrAddress() {
        return adrAddress;
    }

    @JsonProperty("adr_address")
    public void setAdrAddress(String adrAddress) {
        this.adrAddress = adrAddress;
    }

    @JsonProperty("formatted_address")
    public String getFormattedAddress() {
        return formattedAddress;
    }

    @JsonProperty("formatted_address")
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    @JsonProperty("formatted_phone_number")
    public String getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }

    @JsonProperty("formatted_phone_number")
    public void setFormattedPhoneNumber(String formattedPhoneNumber) {
        this.formattedPhoneNumber = formattedPhoneNumber;
    }

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

    @JsonProperty("international_phone_number")
    public String getInternationalPhoneNumber() {
        return internationalPhoneNumber;
    }

    @JsonProperty("international_phone_number")
    public void setInternationalPhoneNumber(String internationalPhoneNumber) {
        this.internationalPhoneNumber = internationalPhoneNumber;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("opening_hours")
    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    @JsonProperty("opening_hours")
    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
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

    @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(String reference) {
        this.reference = reference;
    }

    @JsonProperty("reviews")
    public List<Review> getReviews() {
        return reviews;
    }

    @JsonProperty("reviews")
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
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

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("user_ratings_total")
    public Integer getUserRatingsTotal() {
        return userRatingsTotal;
    }

    @JsonProperty("user_ratings_total")
    public void setUserRatingsTotal(Integer userRatingsTotal) {
        this.userRatingsTotal = userRatingsTotal;
    }

    @JsonProperty("utc_offset")
    public Integer getUtcOffset() {
        return utcOffset;
    }

    @JsonProperty("utc_offset")
    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    @JsonProperty("vicinity")
    public String getVicinity() {
        return vicinity;
    }

    @JsonProperty("vicinity")
    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    @JsonProperty("website")
    public String getWebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setWebsite(String website) {
        this.website = website;
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
        return new ToStringBuilder(this).append("addressComponents", addressComponents).append("adrAddress", adrAddress).append("formattedAddress", formattedAddress).append("formattedPhoneNumber", formattedPhoneNumber).append("geometry", geometry).append("icon", icon).append("id", id).append("internationalPhoneNumber", internationalPhoneNumber).append("name", name).append("openingHours", openingHours).append("photos", photos).append("placeId", placeId).append("plusCode", plusCode).append("rating", rating).append("reference", reference).append("reviews", reviews).append("scope", scope).append("types", types).append("url", url).append("userRatingsTotal", userRatingsTotal).append("utcOffset", utcOffset).append("vicinity", vicinity).append("website", website).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(scope).append(plusCode).append(id).append(vicinity).append(placeId).append(formattedPhoneNumber).append(name).append(formattedAddress).append(types).append(icon).append(reviews).append(website).append(openingHours).append(adrAddress).append(url).append(reference).append(internationalPhoneNumber).append(geometry).append(photos).append(additionalProperties).append(utcOffset).append(rating).append(userRatingsTotal).append(addressComponents).toHashCode();
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
        return new EqualsBuilder().append(scope, rhs.scope).append(plusCode, rhs.plusCode).append(id, rhs.id).append(vicinity, rhs.vicinity).append(placeId, rhs.placeId).append(formattedPhoneNumber, rhs.formattedPhoneNumber).append(name, rhs.name).append(formattedAddress, rhs.formattedAddress).append(types, rhs.types).append(icon, rhs.icon).append(reviews, rhs.reviews).append(website, rhs.website).append(openingHours, rhs.openingHours).append(adrAddress, rhs.adrAddress).append(url, rhs.url).append(reference, rhs.reference).append(internationalPhoneNumber, rhs.internationalPhoneNumber).append(geometry, rhs.geometry).append(photos, rhs.photos).append(additionalProperties, rhs.additionalProperties).append(utcOffset, rhs.utcOffset).append(rating, rhs.rating).append(userRatingsTotal, rhs.userRatingsTotal).append(addressComponents, rhs.addressComponents).isEquals();
    }

}
