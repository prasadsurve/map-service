package com.map.json.model;

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
@JsonPropertyOrder({ "latitude", "longitude", "name", "rating", "address", "categories", "information" })
public class PlaceMarksResponse implements Serializable {

	@JsonProperty("latitude")
	private Double latitude;
	@JsonProperty("longitude")
	private Double longitude;
	@JsonProperty("name")
	private String name;
	@JsonProperty("rating")
	private String rating;
	@JsonProperty("address")
	@Valid
	private Address address;
	@JsonProperty("categories")
	@Valid
	private List<Category> categories = null;
	@JsonProperty("information")
	@Valid
	private Information information;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 1788699335494013965L;

	@JsonProperty("latitude")
	public Double getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("longitude")
	public Double getLongitude() {
		return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("rating")
	public String getRating() {
		return rating;
	}

	@JsonProperty("rating")
	public void setRating(String rating) {
		this.rating = rating;
	}

	@JsonProperty("address")
	public Address getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(Address address) {
		this.address = address;
	}

	@JsonProperty("categories")
	public List<Category> getCategories() {
		return categories;
	}

	@JsonProperty("categories")
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@JsonProperty("information")
	public Information getInformation() {
		return information;
	}

	@JsonProperty("information")
	public void setInformation(Information information) {
		this.information = information;
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
		return new ToStringBuilder(this).append("latitude", latitude).append("longitude", longitude)
				.append("name", name).append("rating", rating).append("address", address)
				.append("categories", categories).append("information", information)
				.append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(information).append(address).append(additionalProperties).append(name)
				.append(categories).append(longitude).append(rating).append(latitude).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof PlaceMarksResponse) == false) {
			return false;
		}
		PlaceMarksResponse rhs = ((PlaceMarksResponse) other);
		return new EqualsBuilder().append(information, rhs.information).append(address, rhs.address)
				.append(additionalProperties, rhs.additionalProperties).append(name, rhs.name)
				.append(categories, rhs.categories).append(longitude, rhs.longitude).append(rating, rhs.rating)
				.append(latitude, rhs.latitude).isEquals();
	}

}