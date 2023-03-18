package com.jspider.hibernateOneToOneBidirectional.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class CarDTO {
@Id
	private int id;
	private String brand;
	private String model;
	private String reg_no;
	
  @OneToOne
	private DriverDTO driver;
}
