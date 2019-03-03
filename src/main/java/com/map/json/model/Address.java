package com.map.json.model;

import java.io.Serializable;
import java.util.HashMap;
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
@JsonPropertyOrder({ "street", "city", "postalCode" })
public class Address implements Serializable {

	@JsonProperty("street")
	@Valid
	@NotNull
	private String street;
	@JsonProperty("city")
	@Valid
	@NotNull
	private String city;
	@JsonProperty("postalCode")
	private String postalCode;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 1089149531862560461L;

	@JsonProperty("street")
	public String getStreet() {
		return street;
	}

	@JsonProperty("street")
	public void setStreet(String street) {
		this.street = street;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("postalCode")
	public String getPostalCode() {
		return postalCode;
	}

	@JsonProperty("postalCode")
	public void setPostalCode(String string) {
		this.postalCode = string;
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
		return new ToStringBuilder(this).append("street", street).append("city", city).append("postalCode", postalCode)
				.append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(postalCode).append(additionalProperties).append(street).append(city)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Address) == false) {
			return false;
		}
		Address rhs = ((Address) other);
		return new EqualsBuilder().append(postalCode, rhs.postalCode)
				.append(additionalProperties, rhs.additionalProperties).append(street, rhs.street)
				.append(city, rhs.city).isEquals();
	}

}