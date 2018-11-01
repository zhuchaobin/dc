package com.xai.tt.dc.client.model;

import java.io.Serializable;

public class ImportCarSale implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Integer id;
	public String vin;
	public String usageSphere;
	public String carSaleDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getUsageSphere() {
		return usageSphere;
	}
	public void setUsageSphere(String usageSphere) {
		this.usageSphere = usageSphere;
	}
	public String getCarSaleDate() {
		return carSaleDate;
	}
	public void setCarSaleDate(String carSaleDate) {
		this.carSaleDate = carSaleDate;
	}
	
}