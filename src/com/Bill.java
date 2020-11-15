package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.dao.DiscountDAO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Bill {
	private static Discount perDiscount;

public static void main(String[] args) {
	
	calculateNetPayableAmt(args);
}


private static void calculateNetPayableAmt(String[] input) {
	
	Map<String,String> configValues = new HashMap<String,String>();
	Double netAmt =0.0;	
	ObjectMapper mapper = new ObjectMapper(); 
	try {
	File file = new File(input[0]);
	FileReader fr=new FileReader(file);
	BufferedReader br=new BufferedReader(fr);  
	
		Customer cust = mapper.readValue(br.readLine(), Customer.class);
		List itemsList = mapper.readValue(br.readLine(), new TypeReference<List>() {});
		cust.setItems(itemsList);
				
	DiscountDAO dao = new DiscountDAO();
	
	configValues = dao.getDiscountConfiguredValues(cust.getCustName(),cust.getMobileNo());
	
	cust.setPercentDiscEligAmt(calculatePercentEligAmt(cust.getItems()));
	cust.setTotalAmt(calculateTotalAmt(cust.getItems()));
	
	System.out.println(cust.getPercentDiscEligAmt());
	System.out.println(cust.getTotalAmt());
			
	perDiscount = new PercentageDiscount();
	Double amt1 = performDiscount(cust.getPercentDiscEligAmt(),configValues);
	
	perDiscount = new PriceDiscount();
	Double amt2 = performDiscount(cust.getTotalAmt(),configValues);
	System.out.println(amt1);
	System.out.println(amt2);
	netAmt = cust.getTotalAmt()-(amt1+amt2);
	System.out.println("net payable amount::"+ netAmt);

}catch(IOException | SQLException e) {
	e.printStackTrace();
}
	
}

private static Double performDiscount(Double amt,Map<String,String> config) {
	return perDiscount.calculateDiscount(amt, config);
}
private static Double calculatePercentEligAmt(List<LinkedHashMap<String,String>> items) {
	Double percentDiscEligAmt[]= {0.0};	
	
	items.forEach(item -> {
		if(!constants.GROC_CATEGORY.equalsIgnoreCase(item.get("itemCategory"))) {
		percentDiscEligAmt[0] = percentDiscEligAmt[0]+Double.valueOf(item.get("amt")) ;
		}
	});	
	return percentDiscEligAmt[0];
}


private static Double calculateTotalAmt(List<LinkedHashMap<String,String>> items) {
	
	Double[] totalAmt= {0.0};
	items.forEach(item -> {
		totalAmt[0] = totalAmt[0]+Double.valueOf(item.get("amt"));
	});		
	return totalAmt[0];
}
}
