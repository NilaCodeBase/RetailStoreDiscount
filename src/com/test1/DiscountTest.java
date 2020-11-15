package com.test1;

import static org.junit.Assert.*;
import org.junit.Test;

import com.Bill;

public class DiscountTest {

	@Test
	public void testRetailDiscount() {
		//TestCase1
		String[] input ={"D:\\Vennila\\TestScenarios\\Testcase1.txt"};
		Double output = Bill.calculateNetPayableAmt(input);		
		assertEquals(output,Double.valueOf(219));
	}
	
	@Test
	public void testRetailDiscount2() {
		//TestCase2
		String[] input2 ={"D:\\Vennila\\TestScenarios\\Testcase2.txt"};
		Double output2 = Bill.calculateNetPayableAmt(input2);		
		assertEquals(output2,Double.valueOf(241));
		
}
	
	@Test
	public void testRetailDiscount3() {
		//TestCase3
		String[] input3 ={"D:\\Vennila\\TestScenarios\\Testcase3.txt"};
		Double output3 = Bill.calculateNetPayableAmt(input3);		
		assertEquals(output3,Double.valueOf(246.5));
	}	
	
	@Test
	public void testRetailDiscount4() {	
		//TestCase4
		String[] input4 ={"D:\\Vennila\\TestScenarios\\Testcase4.txt"};
		Double output4 = Bill.calculateNetPayableAmt(input4);		
		assertEquals(output4,Double.valueOf(252));
	}	
	
	@Test
	public void testRetailDiscount5() {		
		//TestCase5
		String[] input5 ={"D:\\Vennila\\TestScenarios\\Testcase5.txt"};
		Double output5 = Bill.calculateNetPayableAmt(input5);		
		assertEquals(output5,Double.valueOf(147));	
	}	
	
	@Test
	public void testRetailDiscount6() {	
		//TestCase6
		String[] input6 ={"D:\\Vennila\\TestScenarios\\Testcase6.txt"};
		Double output6 = Bill.calculateNetPayableAmt(input6);		
		assertEquals(output6,Double.valueOf(72));
	}	
	
	@Test
	public void testRetailDiscount7() {		
		//TestCase1
		String[] input7 ={"D:\\Vennila\\TestScenarios\\Testcase7.txt"};
		Double output7 = Bill.calculateNetPayableAmt(input7);		
		assertEquals(output7,Double.valueOf(94));
	}	
	
	@Test
	public void testRetailDiscount8() {	
		//TestCase1
		String[] input8 ={"D:\\Vennila\\TestScenarios\\Testcase8.txt"};
		Double output8 = Bill.calculateNetPayableAmt(input8);		
		assertEquals(output8,Double.valueOf(99.5));	
	}	
	
	@Test
	public void testRetailDiscount9() {	
		//TestCase1
		String[] input9 ={"D:\\Vennila\\TestScenarios\\Testcase9.txt"};
		Double output9 = Bill.calculateNetPayableAmt(input9);		
		assertEquals(output9,Double.valueOf(105));
		
	}

}
