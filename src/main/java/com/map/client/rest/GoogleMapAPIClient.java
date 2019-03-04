package com.map.client.rest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.map.controller.MapController;
import com.map.json.model.google.directions.DirectionResponse;
import com.map.json.model.google.nearby.NearByResponse;
import com.map.json.model.google.placedetails.PlaceDetailsResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GoogleMapAPIClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GoogleMapAPIClient.class);
	
	@Value("${com.map.google.apikey}")
	private String apiKey;
	
	@Value("${com.map.google.places.nearby.api.baseurl}")
	private String placesAPIBaseURL;
	
	@Value("${com.map.google.placedetails.api.baseurl}")
	private String placeDetailsAPIBaseURL;
	
	@Value("${com.map.google.directions.api.baseurl}")
	private String directionsAPIBaseURL;
	
	@Value("${com.map.google.places.search.radius}")
	private int defaultSearchRadius; 
	
	
	
	
	public ResponseEntity<NearByResponse> getPlaceMarksFromGoogleMaps(String location, String type, int radius) {
		ResponseEntity<NearByResponse> response = null;
		try {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		headers.setContentType(MediaType.APPLICATION_JSON);
		if(radius == 0)
			radius = defaultSearchRadius;
		response = restTemplate.exchange(placesAPIBaseURL + "location=" +location + "type=" + type + "radius=" + radius + "key=" + apiKey,
				HttpMethod.GET, entity, NearByResponse.class);
		
		}catch (HttpClientErrorException e) {
			LOGGER.error("Exception while fetching data from Google MAps Places API:{}", e.getMessage());
			
		}catch(Exception e) {
			LOGGER.error("Exception while fetching data from Google MAps Places API:{}", e.getMessage());
		}
		return response;
	}
	
	public ResponseEntity<PlaceDetailsResponse> getPlaceDetails(String placeID) {
		ResponseEntity<PlaceDetailsResponse> response = null;
		try {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		response = restTemplate.exchange(placeDetailsAPIBaseURL + "placeid=" +placeID + "key=" + apiKey,
				HttpMethod.GET, entity, PlaceDetailsResponse.class);
		
		}catch (HttpClientErrorException e) {
			LOGGER.error("Exception while fetching data from Google MAps Place Details API:{}", e.getMessage());
			
		}catch(Exception e) {
			LOGGER.error("Exception while fetching data from Google MAps Place Details API:{}", e.getMessage());
		}
		return response;
	}
	public ResponseEntity<DirectionResponse> getDirections(String origin, String wayPoints, String destination) {
		ResponseEntity<DirectionResponse> response = null;
		try {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		headers.setContentType(MediaType.APPLICATION_JSON);
		if (!wayPoints.isEmpty())
			directionsAPIBaseURL += "origin=" + origin + "waypoints=" + wayPoints + "destination=" + destination + "key=" + apiKey;
		else
			directionsAPIBaseURL += "origin=" + origin + "destination=" + destination + "key=" + apiKey;
		
		response = restTemplate.exchange(directionsAPIBaseURL,
				HttpMethod.GET, entity, DirectionResponse.class);
		
		}catch (HttpClientErrorException e) {
			LOGGER.error("Exception while fetching data from Google Maps Directions API:{}", e.getMessage());
			
		}catch(Exception e) {
			LOGGER.error("Exception while fetching data from Google Maps Directions API:{}", e.getMessage());
		}
		return response;
	}
}
