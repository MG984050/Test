Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account Page
When User enters the details into below fields
|First Name|Tanish|
|Last Name|M|
|E-Mail|Tanish3@gmail.com|
|Telephone|9867876543|
|Password|Tanish@1989|
And User select the privacy policy
And User click on Continue button
Then User account should be created successfully

Scenario: User creates an account all fields
Given User navigates to Register Account Page
When User enters the details into below fields
|First Name|Suba|
|Last Name|M|
|E-Mail|Suba3@gmail.com|
|Telephone|98678765441|
|Password|Suba@1989|
And User select Yes for newsletter
And User select the privacy policy
And User click on Continue button
Then User account should be created successfully

Scenario: User creates a duplicate account
Given User navigates to Register Account Page
When User enters the details into below fields
|First Name|Suba|
|Last Name|M|
|E-Mail|Suba2@gmail.com|
|Telephone|98678765441|
|Password|Suba@1989|
And User select Yes for newsletter
And User select the privacy policy
And User click on Continue button
Then User should get a proper warning about duplicate email

Scenario: User creates an account without filling any details
Given User navigates to Register Account Page
When User dont enters any details to the below fields
And User click on Continue button
Then User should get a proper warning message for every fields