
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
    "html_attributions",
    "result",
    "status"
})
public class PlaceDetailsResponse implements Serializable
{

    @JsonProperty("html_attributions")
    @Valid
    private List<Object> htmlAttributions = null;
    @JsonProperty("result")
    @Valid
    private Result result;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1535644641902607882L;

    @JsonProperty("html_attributions")
    public List<Object> getHtmlAttributions() {
        return htmlAttributions;
    }

    @JsonProperty("html_attributions")
    public void setHtmlAttributions(List<Object> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    @JsonProperty("result")
    public Result getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Result result) {
        this.result = result;
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
        return new ToStringBuilder(this).append("htmlAttributions", htmlAttributions).append("result", result).append("status", status).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(result).append(status).append(additionalProperties).append(htmlAttributions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PlaceDetailsResponse) == false) {
            return false;
        }
        PlaceDetailsResponse rhs = ((PlaceDetailsResponse) other);
        return new EqualsBuilder().append(result, rhs.result).append(status, rhs.status).append(additionalProperties, rhs.additionalProperties).append(htmlAttributions, rhs.htmlAttributions).isEquals();
    }

}
