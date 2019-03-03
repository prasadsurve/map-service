package com.map.json.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
@JsonPropertyOrder({ "location", "categories" })
public class PlaceMark implements Serializable {

	@JsonProperty("location")
	@Valid
	@NotNull
	private Location location;
	@JsonProperty("categories")
	@Valid
	private List<Category> categories = null;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 6194739278005017198L;

	@JsonProperty("location")
	public Location getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(Location location) {
		this.location = location;
	}

	@JsonProperty("categories")
	public List<Category> getCategories() {
		return categories;
	}

	@JsonProperty("categories")
	public void setCategories(List<Category> categories) {
		this.categories = categories;
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
		return new ToStringBuilder(this).append("location", location).append("categories", categories)
				.append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(location).append(additionalProperties).append(categories).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof PlaceMark) == false) {
			return false;
		}
		PlaceMark rhs = ((PlaceMark) other);
		return new EqualsBuilder().append(location, rhs.location).append(additionalProperties, rhs.additionalProperties)
				.append(categories, rhs.categories).isEquals();
	}

}
