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
@JsonPropertyOrder({ "license", "warnings", "legs" })
public class Route implements Serializable {

	@JsonProperty("license")
	private String license;
	@JsonProperty("warnings")
	@Valid
	private List<String> warnings = null;
	@JsonProperty("legs")
	@Valid
	private List<Leg> legs = null;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -2805214656408772555L;

	@JsonProperty("license")
	public String getLicense() {
		return license;
	}

	@JsonProperty("license")
	public void setLicense(String license) {
		this.license = license;
	}

	@JsonProperty("warnings")
	public List<String> getWarnings() {
		return warnings;
	}

	@JsonProperty("warnings")
	public void setWarnings(List<String> warnings) {
		this.warnings = warnings;
	}

	@JsonProperty("legs")
	public List<Leg> getLegs() {
		return legs;
	}

	@JsonProperty("legs")
	public void setLegs(List<Leg> legs) {
		this.legs = legs;
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
		return new ToStringBuilder(this).append("license", license).append("warnings", warnings).append("legs", legs)
				.append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(additionalProperties).append(legs).append(license).append(warnings)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Route) == false) {
			return false;
		}
		Route rhs = ((Route) other);
		return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(legs, rhs.legs)
				.append(license, rhs.license).append(warnings, rhs.warnings).isEquals();
	}

}
