
package com.map.json.model.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "error_code", "error_message", "error_parameters" })
public class InternalServerErrorRequest {

	@JsonProperty("error_code")
	private Integer errorCode;
	@JsonProperty("error_message")
	private String errorMessage;
	@JsonProperty("error_parameters")
	private List<ErrorParameter> errorParameters = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("error_code")
	public Integer getErrorCode() {
		return errorCode;
	}

	@JsonProperty("error_code")
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	@JsonProperty("error_message")
	public String getErrorMessage() {
		return errorMessage;
	}

	@JsonProperty("error_message")
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@JsonProperty("error_parameters")
	public List<ErrorParameter> getErrorParameters() {
		return errorParameters;
	}

	@JsonProperty("error_parameters")
	public void setErrorParameters(List<ErrorParameter> errorParameters) {
		this.errorParameters = errorParameters;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
