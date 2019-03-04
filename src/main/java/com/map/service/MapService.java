package com.map.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.map.client.rest.GoogleMapAPIClient;
import com.map.constants.ApplicationConstants;
import com.map.json.model.Address;
import com.map.json.model.Category;
import com.map.json.model.Navigation;
import com.map.json.model.PlaceMark;
import com.map.json.model.PlaceMarksResponse;
import com.map.json.model.google.directions.DirectionResponse;
import com.map.json.model.google.nearby.NearByResponse;
import com.map.json.model.google.placedetails.PlaceDetailsResponse;
import com.map.json.model.google.nearby.Result;



@Service
public class MapService {
	
	@Autowired
	private CategoryFactory categoryFactory;
	
	@Autowired
	GoogleMapAPIClient googleMapAPIClient;
	
	public ResponseEntity<List<Category>> getAllCategories(){
		return new ResponseEntity<List<Category>>(categoryFactory.getCategoryList(), HttpStatus.OK);
		
	}
	
	public ResponseEntity<List<PlaceMarksResponse>> getPlaceMArksByCategoryAndLocation(List<Category> categories, String location) {
		List<PlaceMarksResponse> placeMarksResponseList = new ArrayList<>();
		 
	
		for (Category category : categories) {
			ResponseEntity<NearByResponse> response = googleMapAPIClient.getPlaceMarksFromGoogleMaps(location, category.getKey(), 0);
			if (response.getBody() instanceof NearByResponse) {
				NearByResponse nearByResponse = (NearByResponse) response.getBody();
				for (Result result : nearByResponse.getResults()) {
					ResponseEntity<PlaceDetailsResponse> placeDetailsResponse = googleMapAPIClient.getPlaceDetails(result.getPlaceId());
					PlaceMarksResponse placeMarksResponse = new PlaceMarksResponse();
					Address address = new Address();
					if(placeDetailsResponse.getBody().getResult().getAddressComponents() != null) {
						placeDetailsResponse.getBody().getResult().getAddressComponents().forEach(addressComponent -> {
							if(ApplicationConstants.STREET.equals(addressComponent.getTypes().get(0))) {
								address.setStreet(addressComponent.getLongName());
							}else if(ApplicationConstants.POSTAL_CODE.equals(addressComponent.getTypes().get(0))) {
								address.setPostalCode(addressComponent.getLongName());
							}else if(ApplicationConstants.CITY.equals(addressComponent.getTypes().get(0))) {
								address.setCity(addressComponent.getLongName());
							}
							
						});
					}
					placeMarksResponse.setAddress(address);
					placeMarksResponse.setRating(result.getRating().toString());
					placeMarksResponse.setName(result.getName());
					placeMarksResponse.setLatitude(result.getGeometry().getLocation().getLat());
					placeMarksResponse.setLongitude(result.getGeometry().getLocation().getLng());
					List<Category> categoryList = new ArrayList<>();
					result.getTypes().forEach(categoryKey -> {
						categoryList.add(categoryFactory.getCategoryByKey(categoryKey));
					});
					placeMarksResponse.setCategories(categoryList);
					placeMarksResponseList.add(placeMarksResponse);
				}
				
				
				
		}
	}
	return new ResponseEntity<List<PlaceMarksResponse>>(placeMarksResponseList, HttpStatus.OK);	
	
	}	
	
	public ResponseEntity<DirectionResponse> getNavigation(Navigation navigation) {
		String wayPoints ="";
		int i=0;
		String origin = navigation.getPlacemarks().get(0).getLocation().getLatitude() + "," + navigation.getPlacemarks().get(0).getLocation().getLongitude();
		String destination = navigation.getPlacemarks().get(navigation.getPlacemarks().size() - 1).getLocation().getLatitude() + "," + navigation.getPlacemarks().get(navigation.getPlacemarks().size() - 1).getLocation().getLongitude();
		for (PlaceMark placeMark : navigation.getPlacemarks()) {
			if(i != 0 && i != (navigation.getPlacemarks().size() - 1)) {
				 
				wayPoints = placeMark.getLocation().getLatitude() + "," + placeMark.getLocation().getLongitude() + "|";
			}	
			i++;
		}
		
		return googleMapAPIClient.getDirections(origin, wayPoints, destination);
		
			
	}
	
}
