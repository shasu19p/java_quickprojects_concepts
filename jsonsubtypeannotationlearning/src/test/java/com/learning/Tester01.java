package com.learning;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.AutoMobile;
import com.learning.Bike;
import com.learning.Bus;
import com.learning.Car;
import com.learning.Vehicle;

public class Tester01 {
	private final String filename = "mappingdata.json";

	@Test
	public void test() throws Exception {
		URL url = this.getClass().getResource(filename);

		if (url == null) {
			System.out.println(String.format(
					"File (%s) not found in path.", filename));
			url = this.getClass().getClassLoader().getResource(filename);
		}

		if (url == null) {
			System.out.println(String.format(
			  "File {} not found in path.", filename));
		}

		String content = Files.readString(Path.of(url.getFile()));
		System.out.println(content);
		
	 ObjectMapper mapper = new ObjectMapper();
	 AutoMobile autoMobile = mapper.readValue(content, AutoMobile.class);
	 
	 System.out.println(autoMobile.getVehicle() instanceof Vehicle);
	 System.out.println(autoMobile.getVehicle() instanceof Car);
	 System.out.println(autoMobile.getVehicle() instanceof Bus);
	 System.out.println(autoMobile.getVehicle() instanceof Bike);
	 
	 String stringData = mapper.writeValueAsString(autoMobile);
	 System.out.println(stringData);
	}
}
