package com.map.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.map.json.model.Category;
import com.map.json.model.Navigation;
import com.map.json.model.NavigationResponse;
import com.map.json.model.PlaceMark;
import com.map.json.model.PlaceMarksResponse;
import com.map.json.model.error.BadRequest;
import com.map.json.model.error.InternalServerErrorRequest;
import com.map.json.model.error.NotFoundRequest;
import com.map.json.model.error.UnauthorizedRequest;
import com.map.service.MapService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//import com.telia.oracle.aq.listener.QueueReceive;

@RestController

@RequestMapping("/map")
public class MapController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MapController.class);
	
	@Autowired
	private MapService mapService;

	/*
	 * @Autowired
	 * 
	 * @Qualifier("AddressNameLinkListener") QueueReceive addressNameLinkListener;
	 * 
	 * @Autowired
	 * 
	 * @Qualifier("NameDataListener") QueueReceive nameDataListener;
	 * 
	 * @Autowired
	 * 
	 * @Qualifier("AddressDataListener") QueueReceive addressDataListener;
	 * 
	 * @Autowired
	 * 
	 * @Qualifier("CustomerListener") QueueReceive customerListener;
	 * 
	 * @Autowired
	 * 
	 * @Qualifier("BillingAccountListener") QueueReceive billingAccountListener;
	 *//**
		 * This is controller method, will be invoked manually by Operations Team in
		 * case of Oracle AQ Listener is down/stopped. This method will invoke
		 * {@link initReceiver()} method of class
		 * <code>com.telia.oracle.aq.listener.QueueReceive<code>
		 * 
		 * @return the action performed for restarting AQ Listener
		 * @see com.telia.oracle.aq.listener.QueueReceive#initReceiver()
		 *//*
			 * @RequestMapping(value = { "/restartlistener/{queueName}" }, method = {
			 * RequestMethod.GET }) public ResponseEntity<?>
			 * createAQListenr(@PathVariable("queueName") String queueName) {
			 * LOGGER.info("Restarting Oracle AQ Listener.."); switch (queueName) {
			 * 
			 * case Constants.addressNameLinkQueueName:
			 * addressNameLinkListener.initReceiver(); break; case
			 * Constants.nameDataQueueName: nameDataListener.initReceiver(); break; case
			 * Constants.addressDataQueueName: addressDataListener.initReceiver(); break;
			 * case Constants.customerQueueName: customerListener.initReceiver(); break;
			 * case Constants.billingAccountQueueName:
			 * billingAccountListener.initReceiver(); break; }
			 * 
			 * return (new ResponseEntity<String>(
			 * "Application has restarted Oracle AQ Listener, please see logs for more details."
			 * , HttpStatus.OK)); }
			 */
	@ApiOperation(value = "Get List of Categories", notes = "Get list of categories")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful Operation", response = Category.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = UnauthorizedRequest.class),
			@ApiResponse(code = 404, message = "Not Found", response = NotFoundRequest.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerErrorRequest.class) })
	@RequestMapping(value = { "/categories" }, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getCategories() {
		LOGGER.info("Returning list of all possible categories");
		return mapService.getAllCategories();

	}
	
	@ApiOperation(value = "Get Nearby Placemarks", notes = "Get Nearby PlaceMarks based on categories and location")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful Operation", response = PlaceMarksResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = UnauthorizedRequest.class),
			@ApiResponse(code = 404, message = "Not Found", response = NotFoundRequest.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerErrorRequest.class) })
	@RequestMapping(value = { "/placemarks" }, method = { RequestMethod.PUT }, produces = {
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getPlaceMarks(@RequestBody PlaceMark placeMark) {
		String location = placeMark.getLocation().getLatitude() + "," + placeMark.getLocation().getLongitude(); 
		return mapService.getPlaceMArksByCategoryAndLocation(placeMark.getCategories(), location);
		
	}

	@ApiOperation(value = "Get Navigation for multiple places", notes = "Get Navigation from provided location to multiple locations")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful Operation", response = NavigationResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = BadRequest.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = UnauthorizedRequest.class),
			@ApiResponse(code = 404, message = "Not Found", response = NotFoundRequest.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerErrorRequest.class) })
	@RequestMapping(value = { "/navigation" }, method = { RequestMethod.POST }, produces = {
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getNavigation(@RequestBody Navigation navigation) {
		Properties prop = new Properties();
		
		return null;
	}	
}
