package com.learning;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(value = {
  @Type(name = "car", value = Car.class),
  @Type(name = "bike", value = Bike.class),
  @Type(name = "bus", value = Bus.class)})
public abstract class Vehicle {
	private String name;
	private String modelYear;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

}

@JsonTypeName(value = "bus")
class Bus extends Vehicle {
}

@JsonTypeName(value = "bike")
class Bike extends Vehicle {
}

@JsonTypeName(value = "car")
class Car extends Vehicle {
}
