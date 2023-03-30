package com.wittybrains.busbookingsystem.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="driver")
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    @NotBlank
    @Size(max = 30)
    private String name;

    @NotBlank
    @Pattern(regexp = "^[A-Z]{2}-\\d{2}-[A-Z]{2}-\\d{4}$")
    private String licenseNumber;
    
    @OneToOne
    private User user;
    
    @CreationTimestamp
	private LocalDateTime createdOn;

	@UpdateTimestamp
	private LocalDateTime updatedOn;

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	 @PrePersist
     void prePersist() {
    	 this.createdOn=LocalDateTime.now();
    	
     }
    @PreUpdate
	void preUpdateDateTime() {
		this.updatedOn = LocalDateTime.now();
	}

}
