package com;

import java.util.Map;

public class PriceDiscount implements Discount {
	
	@Override
	public Double calculateDiscount(Double amt, Map<String,String> config) {		
		Double discountval ;
		try{
		discountval= (Math.floor(amt/Double.valueOf(config.get("cutOffAmt")))*Double.valueOf(config.get("priceDiscount")));
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		return discountval;
	}

}
