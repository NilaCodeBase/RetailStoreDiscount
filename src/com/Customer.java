package com;

import java.util.LinkedHashMap;
import java.util.List;

public class Customer {
	private String billNo="";
	private String custName="";
	private String mobileNo ="";	
	private List<LinkedHashMap<String, String>> items =null;
	private static Double totalAmt;
	private static Double percentDiscEligAmt;
	
	
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
		
	public List<LinkedHashMap<String, String>> getItems() {
		return items;
	}
	public void setItems(List<LinkedHashMap<String, String>> items) {
		this.items = items;
	}
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public Double getPercentDiscEligAmt() {
		return percentDiscEligAmt;
	}
	public void setPercentDiscEligAmt(Double percentDiscEligAmt) {
		this.percentDiscEligAmt = percentDiscEligAmt;
	}

}
