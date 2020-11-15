# RetailStoreDiscount
This project calculates net payable amount based on user category, discount percentage and other criteria.

## Description
On a retail website, the following discounts apply,
1.	If the user is an employee of the store, he gets a 30% discount.
2.	If the user is an affiliate of the store, he gets a 10% discount.
3.	If the user has been a customer for over two years, he gets a 5% discount.
4.	For every $100 on the bill there would be a 5$ discount.
5.	The percentage based discount do not apply on Groceries
6.	An user can get only one of the percentage based discounts on the bill.
## High-Level Design: 
### Database Tables: 
1.	UserMaster : User master it holds the retail master customer data.
Fields :
userName, 
mobileNo,
registerDate, 
userCategory – Will hold the information of user category such as E(Employee),A(Affiliate) and C(Default customer)

2.	PercentageDiscount : It holds the discount percentage based on the userCategory.
Fields :
userCategory, 
DiscountPercent 

3.	priceDiscount : we are maintaining separate table to hold the cutoff amount and discount value.
Fields :
cutOffAmt,
discount

### Class and Methods:
Code is developed as generic and simple.
#### Class: Bill.java


##### Methods:
calculateNetPayableAmt(): This method will calculate the final net payable amount based on customer category and various other criteria.
performDiscount(): It is used to call the interface implementation at runtime.
calculatePercentEligAmt(): This method calculates the amount eligible for percentage discount (non-grocery items).
calculateTotalAmt(): This method gives you the total purchased amount of all items before applying discount.

#### Customer.java
It is POJO class which contain the retail store customer fields such as username, mobile no, etc.,

#### Discount.java – Interface
##### Method:
calculateDiscount() – This method is used to calculate discount for different criteria.
##### Implementation Classes:
###### PercentageDiscount.java
This class overrides calculateDiscount method to calculate the percentage discount amount based on user Category such as Employee, affiliate and customer over 2years for non-grocery items.

###### PriceDiscount.java
This class overrides calculateDiscount method to calculate the price discount amount of 5$ for every 100$.

### Test cases:
#### Case1:
Mix of Grocery and Non- Grocery
User Category : Employee
		
#### Case2:
Mix of Grocery and Non- Grocery
User Category : Affliate	
	
#### Case3:
Mix of Grocery and Non- Grocery
User Category : Customer(More than 2yrs)	
		
#### Case4:
Mix of Grocery and Non- Grocery
User Category : Customer(Less than 2yrs)	
	
#### Case5:
Only Grocery
User Category : E/A/C	
		
#### Case6:
Only Non-Grocery
User Category : Employee	
		
#### Case7:
Only Non-Grocery
User Category : Affliate	
		
#### Case8:
Only Non-Grocery
User Category : Customer(More than 2yrs)	
		
#### Case9:
Only Non-Grocery
User Category : Customer(Less than 2yrs)	
	
### Running and testing the code:
Bill.java class contains main method and calculateNetPayableAmt which takes the input as txt file which contains json structure which holds the customer details and order items.
Junit Test class is written for calculateNetPayableAmt() which takes input as txt file and output as net payable amount by customer.
#### Sample:
{"billNo":"1234","custName": "Nila", "mobileNo": "1234123412"}
[{"itemId":"cabb1","itemName":"cab","itemCategory":"Grocery","amt":"78"},{"itemId":"ironB1","itemName":"ironBox","itemCategory":"electronics","amt":"38"},{"itemId":"cabb1","itemName":"cab","itemCategory":"Grocery","amt":"74"},{"itemId":"ironB1","itemName":"ironBox","itemCategory":"electronics","amt":"72"}]
