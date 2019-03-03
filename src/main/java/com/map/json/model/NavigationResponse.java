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
@JsonPropertyOrder({ "routes" })
public class NavigationResponse implements Serializable {

	@JsonProperty("routes")
	@Valid
	private List<Route> routes = null;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -1007929246479478525L;

	@JsonProperty("routes")
	public List<Route> getRoutes() {
		return routes;
	}

	@JsonProperty("routes")
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
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
		return new ToStringBuilder(this).append("routes", routes).append("additionalProperties", additionalProperties)
				.toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(routes).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof NavigationResponse) == false) {
			return false;
		}
		NavigationResponse rhs = ((NavigationResponse) other);
		return new EqualsBuilder().append(routes, rhs.routes).append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

}
