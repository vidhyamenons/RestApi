Feature: Validating place APIs

Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with post http request
	Then the API call is successfull with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	
Examples: 
	|name	|language	|address	|
	|AHouse	|English	|CityCentre	|
	|BHouse	|Spanish	|Urban	|
