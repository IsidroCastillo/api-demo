package com.iscastillo.apidemo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(length = 20)
	private String names;
	
	@Column(name = "first_last_name", length = 30)
	private String firstLastName;
	
	@Column(name = "second_last_name",  length = 30)
	private String secondLastName;
	
	private String email;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	

}
