
package com.map.json.model.google.placedetails;

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
    "compound_code",
    "global_code"
})
public class PlusCode implements Serializable
{

    @JsonProperty("compound_code")
    private String compoundCode;
    @JsonProperty("global_code")
    private String globalCode;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6200259294139356589L;

    @JsonProperty("compound_code")
    public String getCompoundCode() {
        return compoundCode;
    }

    @JsonProperty("compound_code")
    public void setCompoundCode(String compoundCode) {
        this.compoundCode = compoundCode;
    }

    @JsonProperty("global_code")
    public String getGlobalCode() {
        return globalCode;
    }

    @JsonProperty("global_code")
    public void setGlobalCode(String globalCode) {
        this.globalCode = globalCode;
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
        return new ToStringBuilder(this).append("compoundCode", compoundCode).append("globalCode", globalCode).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(compoundCode).append(additionalProperties).append(globalCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PlusCode) == false) {
            return false;
        }
        PlusCode rhs = ((PlusCode) other);
        return new EqualsBuilder().append(compoundCode, rhs.compoundCode).append(additionalProperties, rhs.additionalProperties).append(globalCode, rhs.globalCode).isEquals();
    }

}
