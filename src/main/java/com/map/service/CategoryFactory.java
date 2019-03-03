package com.map.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.map.constants.ApplicationConstants;
import com.map.controller.MapController;
import com.map.json.model.Category;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class CategoryFactory {

	
	@Value("${com.map.csv.categoriesfile}")
	private String csvFile ;
	
	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryFactory.class);
	
	private Map<String, Category> categoriesMap;
	
	private List<Category> categoryList;

	@PostConstruct
	public void readDataFromCategoriesCSV() {
		categoriesMap = new HashMap<>();
		categoryList = new ArrayList<>();
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFile));
				CSVParser csvParser = new CSVParser(reader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			for (CSVRecord csvRecord : csvRecords) {
				//categoriesMap.put(csvRecord.get(ApplicationConstants.CATEGORY_KEY), csvRecord.get(ApplicationConstants.CATEGORY_NAME));
				
				Category category = new Category();
				category.setKey(csvRecord.get(ApplicationConstants.CATEGORY_KEY));
				category.setName(csvRecord.get(ApplicationConstants.CATEGORY_KEY));
				//category.setName(ApplicationConstants.CATEGORY_NAME);
				categoriesMap.put(csvRecord.get(ApplicationConstants.CATEGORY_KEY), category);
				categoryList.add(category);
				
			}
		LOGGER.info("All Categories are loaded from CSV to Map");	
			
		} catch (IOException e) {
			LOGGER.error("Error while reading categories CSV file: {}", e.getMessage());
		}
		
		
	}
	
	public Category getCategoryByKey(String key) {
		return categoriesMap.get(key);
		
	}
	
	public List<Category> getCategoryList() {
		return categoryList;
	}
	
}
