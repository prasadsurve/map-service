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
@JsonPropertyOrder({ "duration", "circular", "placemarks" })
public class Navigation implements Serializable {

	@JsonProperty("duration")
	private Integer duration;
	@JsonProperty("circular")
	private Boolean circular;
	@JsonProperty("placemarks")
	@Valid
	private List<PlaceMark> placemarks = null;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -8712050462611054122L;

	@JsonProperty("duration")
	public Integer getDuration() {
		return duration;
	}

	@JsonProperty("duration")
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@JsonProperty("circular")
	public Boolean getCircular() {
		return circular;
	}

	@JsonProperty("circular")
	public void setCircular(Boolean circular) {
		this.circular = circular;
	}

	@JsonProperty("placemarks")
	public List<PlaceMark> getPlacemarks() {
		return placemarks;
	}

	@JsonProperty("placemarks")
	public void setPlacemarks(List<PlaceMark> placemarks) {
		this.placemarks = placemarks;
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
		return new ToStringBuilder(this).append("duration", duration).append("circular", circular)
				.append("placemarks", placemarks).append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(circular).append(duration).append(additionalProperties).append(placemarks)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Navigation) == false) {
			return false;
		}
		Navigation rhs = ((Navigation) other);
		return new EqualsBuilder().append(circular, rhs.circular).append(duration, rhs.duration)
				.append(additionalProperties, rhs.additionalProperties).append(placemarks, rhs.placemarks).isEquals();
	}

}
