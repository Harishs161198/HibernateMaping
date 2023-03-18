package com.jspider.HibernateOneToOne.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DriverDTO {
	@Id
private int id;
private String name;
private double contact;

}
