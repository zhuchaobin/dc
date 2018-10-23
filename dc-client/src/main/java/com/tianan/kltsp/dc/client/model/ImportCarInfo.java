package com.tianan.kltsp.dc.client.model;

import java.io.Serializable;

public class ImportCarInfo implements Serializable {
	
	public String vin;
	public String licensePlate;
	public String motoNo;
	public String tboxNo;
	public String modelType;
	public String factoryCode;
	public String companyCode;
	public String dealerCode;
	public String modelName;
	public int factoryId;
	public int companyId;
	public int dealerId;
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getMotoNo() {
		return motoNo;
	}
	public void setMotoNo(String motoNo) {
		this.motoNo = motoNo;
	}
	public String getTboxNo() {
		return tboxNo;
	}
	public void setTboxNo(String tboxNo) {
		this.tboxNo = tboxNo;
	}
	public String getModelType() {
		return modelType;
	}
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	public String getFactoryCode() {
		return factoryCode;
	}
	public void setFactoryCode(String factoryCode) {
		this.factoryCode = factoryCode;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getDealerCode() {
		return dealerCode;
	}
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(int factoryId) {
		this.factoryId = factoryId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	@Override
	public String toString() {
		return "ImportCarInfo{" +
				"vin='" + vin + '\'' +
				", licensePlate='" + licensePlate + '\'' +
				", motoNo='" + motoNo + '\'' +
				", tboxNo='" + tboxNo + '\'' +
				", modelType='" + modelType + '\'' +
				", factoryCode='" + factoryCode + '\'' +
				", companyCode='" + companyCode + '\'' +
				", dealerCode='" + dealerCode + '\'' +
				", modelName='" + modelName + '\'' +
				", factoryId=" + factoryId +
				", companyId=" + companyId +
				", dealerId=" + dealerId +
				'}';
	}
}
