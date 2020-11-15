package com;

import java.util.Map;

public class PriceDiscount implements Discount {
	
	@Override
	public Double calculateDiscount(Double amt, Map<String,String> config) {
		
		return (Math.floor(amt/Double.valueOf(config.get("cutOffAmt")))*Double.valueOf(config.get("priceDiscount")));
		
	}

}
