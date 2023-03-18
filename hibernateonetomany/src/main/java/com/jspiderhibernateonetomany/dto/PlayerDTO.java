package com.jspiderhibernateonetomany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PlayerDTO {
   @Id
	private int id;
	private String name;
	private String role;
	private int jersy_no;
}
