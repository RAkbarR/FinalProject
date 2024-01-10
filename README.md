# FINAL PROJECT
Berikut merupakan hasil testing yang telah saya buat

Jenis automation test yang dilakukan :
1. API Test --> https://gorest.co.in/public/v2/
2. Web automation test --> https://opensource-demo.orangehrmlive.com/


Berikut merupakan dependencies yang saya gunakan :

<img width="590" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/472f8075-7599-456e-8545-4a8528b36143">

<img width="701" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/82404602-7920-4d51-8757-c16634ed2eb4">

<img width="672" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/1a72e81f-ed12-4dee-b069-02e92f9318dd">



Berikut scenario API test (@api) yang ditulis menggunakan aturan tata bahasa Gherkin (Cucumber) :

Positive Test Case :


Feature: Test Automation Rest API

  @api
  Scenario: Test Get List Data
  
    
    Given prepare valid url "GET_LIST_USER"
    And hit API to get list data
    Then verification status code must be 200
    Then verification data should not be null
    Then validate response JSON with JSONSchema "get_list_users_normal.json"



  @api
  
  Scenario: Create a new User
  
    Given prepare valid url "CREATE_NEW_USER"
    And input bearer token
    And select RAW on menu body
    And select JSON
    And hit API to post create user
    Then verification status code must be 201
    Then validate response body to post new user
    Then validate response JSON with JSONSchema "post_create_new_user.json"


  
  @api
  
  Scenario: Delete User Data
  
    Given prepare valid url "CREATE_NEW_USER"
    And hit API to post create user
    Then verification status code must be 201
    Then validate response body to post new user
    And input bearer token
    And select RAW on menu body
    And select JSON
    And hit API to delete user
    Then verification status code must be 204

  @api
  
  Scenario: Update user data
  
    Given prepare valid url "CREATE_NEW_USER"
    And hit API to post create user
    Then verification status code must be 201
    Then validate response body to post new user
    And input bearer token
    And select RAW on menu body
    And select JSON
    And hit API to update data
    Then verification status code must be 200
    Then validate response body to update user


Negative Test Case :


@api


  Scenario: Test Get List Data
  
    Given prepare valid url "GET_LIST_USERS"
    And hit API to get list data
    Then verification status code must be 200
    Then verification data should not be null
    Then validate response JSON with JSONSchema "get_list_users_normal.json"



@api

  Scenario: Create a new User
  
    Given prepare valid url ""
    And input bearer token
    And select RAW on menu body
    And select JSON
    And hit API to post create user
    Then verification status code must be 201
    Then validate response body to post new user
    Then validate response JSON with JSONSchema "post_create_new_user.json"


 @api
    
  Scenario: Delete User Data
  
    Given prepare valid url "CREATE_NEW_USER"
    And hit API to post create user
    Then verification status code must be 201
    Then validate response body to post new user
    And input bearer token
    And select RAW on menu body
    And select JSON
    And hit API to delete user
    Then verification status code must be 201


@api

  Scenario: Update user data
  
    Given prepare valid url "CREATE_NEW_USER"
    And hit API to post create user
    Then verification status code must be 201
    Then validate response body to post new user
    And input bearer token
    And select RAW on menu body
    And select JSON
    And hit API to update data
    Then verification status code must be 201
    Then validate response body to update user


    
Berikut merupakan SS hasil positif dan negatif dari dari request GET all data user :

Positif : 


<img width="846" alt="image" src="https://github.com/RAkbarR/Modul20/assets/149433996/ded9e185-d9d2-43f9-bcb4-789118212c35">


Negatif (salah endpoint) :


<img width="845" alt="image" src="https://github.com/RAkbarR/Modul20/assets/149433996/62310beb-acbe-4c09-8fef-d744f2d07ff2">

Berikut merupakan SS hasil positif dan negatif dari dari request POST data user :

Positif :


<img width="646" alt="image" src="https://github.com/RAkbarR/Modul20/assets/149433996/bec6d826-1017-4b24-a0b0-bba4457799ca">


Negatif(endpoint kosong) :


<img width="853" alt="image" src="https://github.com/RAkbarR/Modul20/assets/149433996/83cc7722-55f7-421d-a612-2f6d410a7b2e">

Berikut merupakan SS hasil positif dan negatif dari dari request DELETE data user :


Positif :


<img width="847" alt="image" src="https://github.com/RAkbarR/Modul20/assets/149433996/26f6125b-64ec-4ad6-9442-e53c6f20684b">


Negatif(Salah status code) :


<img width="850" alt="image" src="https://github.com/RAkbarR/Modul20/assets/149433996/ae2f7425-6fce-4b0b-a2a8-fa6ab63e1ef6">



Berikut merupakan SS hasil positif dan negatif dari dari request PATCH (Update) data user :


Positif :


<img width="659" alt="image" src="https://github.com/RAkbarR/Modul20/assets/149433996/ed2efdcc-93ac-4e6a-8310-320448e6cc67">


Negatif(Salah Status Code):


<img width="843" alt="image" src="https://github.com/RAkbarR/Modul20/assets/149433996/ac47c05c-5851-4e2b-b580-79edf53d0b10">



Berikut scenario Web automation test (@web) yang ditulis menggunakan aturan tata bahasa Gherkin (Cucumber) :


Feature: Test Automation Web Selenium

  #Positive Login Test
  
  @web
  
  Scenario: Test Web Login
  
    Given User is on login page
    And User input username "Admin"
    And User Input Password "admin123"
    And User press button Login
    Then user can see validation on side nav

  #Negative Login Test
  
  @web
  
  Scenario: Negative Test Web Login
  
    Given User is on login page
    And User input username "min"
    And User Input Password "admin123"
    And User press button Login
    Then user can see info text err "Invalid credentials"

  #positive admin search by username
  
  @web
  
  Scenario: Test Search Admin Username
  
    Given User is on login page
    And User input username "Admin"
    And User Input Password "admin123"
    And User press button Login
    Then user can see validation on side nav
    And user click admin toogle menu
    And user input admin username "Admin"
    And user press search button
    Then user will see admin records

  #negative admin search by username (wrong username)
  
  @web
  
  Scenario: Negative Test Search Admin Username
  
    Given User is on login page
    And User input username "Admin"
    And User Input Password "admin123"
    And User press button Login
    Then user can see validation on side nav
    And user click admin toogle menu
    And user input admin username "Adi"
    And user press search button
    Then user will see no records

    #admin update name
    
  @web
  
  Scenario: Test Update Admin Name
  
    Given User is on login page
    And User input username "Admin"
    And User Input Password "admin123"
    And User press button Login
    Then user can see validation on side nav
    And user click admin toogle menu
    And user click icon update admin
    And user change admin name "Peter Mac Anderson"
    Then user click submit admin update

     #negative admin update name
     
  @web
  
  Scenario: Negative Test Update Admin Name
  
    Given User is on login page
    And User input username "Admin"
    And User Input Password "admin123"
    And User press button Login
    Then user can see validation on side nav
    And user click admin toogle menu
    And user click icon update admin
    And user change admin name ""
    Then user click submit admin update


Berikut merupakan hasil testing web automation : 
1. Test web login (positive test)

   <img width="536" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/febdcd50-5913-4191-b2b7-42f5ddfe72cc">

2. Negative test web login (negayive test)

   <img width="497" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/552e3e43-9183-4be4-b091-c1784ee24f3b">

3. Test search admin username (positive test)

   <img width="512" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/453374a9-6711-4c15-a830-3f6b87febd93">

4.Negative search admin username (negative test)

  <img width="491" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/8f926865-9c45-43f1-8730-9b9bb309de97">

5. Test admin update name (positive test)

   <img width="497" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/19cd487c-c897-44e0-8215-22f8fa7634f8">

6. Negative test admin update (negative test)

   <img width="497" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/8f8459c4-b172-40bf-aaa0-b26610885b6e">
 
Untuk workflow dan juga artifact nya sudah dapat ditemukan dengan mengakses .github/workflows

Terima kasih!
