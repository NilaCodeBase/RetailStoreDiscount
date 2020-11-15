package com;

import java.util.Map;

public interface Discount {
	public Double calculateDiscount(Double totalAmt, Map<String,String> config);
}
