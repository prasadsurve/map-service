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
@JsonPropertyOrder({ "duration", "polyline", "startLocation", "endLocation", "steps", "distance" })
public class Leg implements Serializable {

	@JsonProperty("duration")
	private Integer duration;
	@JsonProperty("polyline")
	private String polyline;
	@JsonProperty("startLocation")
	@Valid
	private StartLocation startLocation;
	@JsonProperty("endLocation")
	@Valid
	private EndLocation endLocation;
	@JsonProperty("steps")
	@Valid
	private List<Step> steps = null;
	@JsonProperty("distance")
	private Integer distance;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 920525749399833966L;

	@JsonProperty("duration")
	public Integer getDuration() {
		return duration;
	}

	@JsonProperty("duration")
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@JsonProperty("polyline")
	public String getPolyline() {
		return polyline;
	}

	@JsonProperty("polyline")
	public void setPolyline(String polyline) {
		this.polyline = polyline;
	}

	@JsonProperty("startLocation")
	public StartLocation getStartLocation() {
		return startLocation;
	}

	@JsonProperty("startLocation")
	public void setStartLocation(StartLocation startLocation) {
		this.startLocation = startLocation;
	}

	@JsonProperty("endLocation")
	public EndLocation getEndLocation() {
		return endLocation;
	}

	@JsonProperty("endLocation")
	public void setEndLocation(EndLocation endLocation) {
		this.endLocation = endLocation;
	}

	@JsonProperty("steps")
	public List<Step> getSteps() {
		return steps;
	}

	@JsonProperty("steps")
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	@JsonProperty("distance")
	public Integer getDistance() {
		return distance;
	}

	@JsonProperty("distance")
	public void setDistance(Integer distance) {
		this.distance = distance;
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
		return new ToStringBuilder(this).append("duration", duration).append("polyline", polyline)
				.append("startLocation", startLocation).append("endLocation", endLocation).append("steps", steps)
				.append("distance", distance).append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(distance).append(duration).append(polyline).append(additionalProperties)
				.append(endLocation).append(startLocation).append(steps).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Leg) == false) {
			return false;
		}
		Leg rhs = ((Leg) other);
		return new EqualsBuilder().append(distance, rhs.distance).append(duration, rhs.duration)
				.append(polyline, rhs.polyline).append(additionalProperties, rhs.additionalProperties)
				.append(endLocation, rhs.endLocation).append(startLocation, rhs.startLocation).append(steps, rhs.steps)
				.isEquals();
	}

}