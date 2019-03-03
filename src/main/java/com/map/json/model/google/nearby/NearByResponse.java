
package com.map.json.model.google.nearby;

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
    "next_page_token",
    "results",
    "status"
})
public class NearByResponse implements Serializable
{

    @JsonProperty("html_attributions")
    @Valid
    private List<Object> htmlAttributions = null;
    @JsonProperty("next_page_token")
    private String nextPageToken;
    @JsonProperty("results")
    @Valid
    private List<Result> results = null;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6486945552710694559L;

    @JsonProperty("html_attributions")
    public List<Object> getHtmlAttributions() {
        return htmlAttributions;
    }

    @JsonProperty("html_attributions")
    public void setHtmlAttributions(List<Object> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    @JsonProperty("next_page_token")
    public String getNextPageToken() {
        return nextPageToken;
    }

    @JsonProperty("next_page_token")
    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
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
        return new ToStringBuilder(this).append("htmlAttributions", htmlAttributions).append("nextPageToken", nextPageToken).append("results", results).append("status", status).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(results).append(status).append(additionalProperties).append(nextPageToken).append(htmlAttributions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NearByResponse) == false) {
            return false;
        }
        NearByResponse rhs = ((NearByResponse) other);
        return new EqualsBuilder().append(results, rhs.results).append(status, rhs.status).append(additionalProperties, rhs.additionalProperties).append(nextPageToken, rhs.nextPageToken).append(htmlAttributions, rhs.htmlAttributions).isEquals();
    }

}
