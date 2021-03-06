
package com.map.json.model.google.directions;

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
    "geocoded_waypoints",
    "routes",
    "status"
})
public class DirectionResponse implements Serializable
{

    @JsonProperty("geocoded_waypoints")
    @Valid
    private List<GeocodedWaypoint> geocodedWaypoints = null;
    @JsonProperty("routes")
    @Valid
    private List<Route> routes = null;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3909947058560006881L;

    @JsonProperty("geocoded_waypoints")
    public List<GeocodedWaypoint> getGeocodedWaypoints() {
        return geocodedWaypoints;
    }

    @JsonProperty("geocoded_waypoints")
    public void setGeocodedWaypoints(List<GeocodedWaypoint> geocodedWaypoints) {
        this.geocodedWaypoints = geocodedWaypoints;
    }

    @JsonProperty("routes")
    public List<Route> getRoutes() {
        return routes;
    }

    @JsonProperty("routes")
    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
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
        return new ToStringBuilder(this).append("geocodedWaypoints", geocodedWaypoints).append("routes", routes).append("status", status).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(status).append(routes).append(additionalProperties).append(geocodedWaypoints).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DirectionResponse) == false) {
            return false;
        }
        DirectionResponse rhs = ((DirectionResponse) other);
        return new EqualsBuilder().append(status, rhs.status).append(routes, rhs.routes).append(additionalProperties, rhs.additionalProperties).append(geocodedWaypoints, rhs.geocodedWaypoints).isEquals();
    }

}
