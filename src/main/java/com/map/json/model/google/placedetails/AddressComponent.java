
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
    "long_name",
    "short_name",
    "types"
})
public class AddressComponent implements Serializable
{

    @JsonProperty("long_name")
    private String longName;
    @JsonProperty("short_name")
    private String shortName;
    @JsonProperty("types")
    @Valid
    private List<String> types = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6154906758859301281L;

    @JsonProperty("long_name")
    public String getLongName() {
        return longName;
    }

    @JsonProperty("long_name")
    public void setLongName(String longName) {
        this.longName = longName;
    }

    @JsonProperty("short_name")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("short_name")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonProperty("types")
    public List<String> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(List<String> types) {
        this.types = types;
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
        return new ToStringBuilder(this).append("longName", longName).append("shortName", shortName).append("types", types).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(longName).append(types).append(shortName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddressComponent) == false) {
            return false;
        }
        AddressComponent rhs = ((AddressComponent) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(longName, rhs.longName).append(types, rhs.types).append(shortName, rhs.shortName).isEquals();
    }

}
