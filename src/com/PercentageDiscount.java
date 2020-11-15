package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


public class PercentageDiscount implements Discount {

	@Override
	public Double calculateDiscount(Double amt, Map<String,String> config) {
		
		String discountPer="";
		Date regDate;
		try {
			regDate = new SimpleDateFormat("yyyy-MM-dd").parse(config.get("registeredDate"));	
		    
		if(constants.CUSTOMER.equalsIgnoreCase(config.get("userCategory")) ) {
			if(checkRegisteredDate(regDate)) {			
				discountPer =config.get("percentDiscount");
			}else
				return 0.0;
		}else {
			discountPer =config.get("percentDiscount");
		}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return ((amt*Double.valueOf(discountPer))/100);
	}
	

	public static boolean checkRegisteredDate(Date regDate) {
		
		LocalDate twoYearsAgo = LocalDate.now().plusMonths(-24); 
	
        Calendar cal = Calendar.getInstance();
        cal.setTime(regDate);
        LocalDate regDate1 = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
        
        if (regDate1.isBefore(twoYearsAgo)) {
            return true;
        }
		
        return false;
		
	}
	
}
