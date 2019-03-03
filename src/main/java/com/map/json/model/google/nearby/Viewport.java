
package com.map.json.model.google.nearby;

import java.io.Serializable;
import java.util.HashMap;
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
    "northeast",
    "southwest"
})
public class Viewport implements Serializable
{

    @JsonProperty("northeast")
    @Valid
    private Northeast northeast;
    @JsonProperty("southwest")
    @Valid
    private Southwest southwest;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6244493519565408303L;

    @JsonProperty("northeast")
    public Northeast getNortheast() {
        return northeast;
    }

    @JsonProperty("northeast")
    public void setNortheast(Northeast northeast) {
        this.northeast = northeast;
    }

    @JsonProperty("southwest")
    public Southwest getSouthwest() {
        return southwest;
    }

    @JsonProperty("southwest")
    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
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
        return new ToStringBuilder(this).append("northeast", northeast).append("southwest", southwest).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(southwest).append(northeast).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Viewport) == false) {
            return false;
        }
        Viewport rhs = ((Viewport) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(southwest, rhs.southwest).append(northeast, rhs.northeast).isEquals();
    }

}
