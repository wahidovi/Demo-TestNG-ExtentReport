Feature: User add product to add to cart 
					and cart page shows correct price
	@test1
	Scenario Outline: Select product and add to cart
		Given user have access to apple homepage
		When user search for "<product>" 
		And user select the product 
		And choose "<Keyboad-type>" keyboard and add to cart
		Then user see the correct "<price>" on page
	Examples:
		| product | Keyboad-type | price |
		| MacBook Pro | Arabic	| 12190.41 |


#	@test2	
#	Scenario Outline: Select product and add to cart
#		Given user have access to apple homepage
#		When user search for "<product>" 
#		And user select the product 
#		And choose "<Keyboad-type>" keyboard and add to cart
#		Then user see the correct price on page
#	Examples:
#		| product | Keyboard-type |
#		| MacBook Pro | Arabic	|
#		| MacBook     | British |