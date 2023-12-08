# Modul20
Berikut merupakan hasil testing yang telah saya buat


Scenario yang digunakan : GET, POST, PATCH, DELETE


Sumber yang saya gunakan yaitu video final test 1-3


Catatan untuk beberapa langkah seperti input bearer token, Select RAW saya hanya memakai SOUT karena minim pengetahuan akan kode nya dan tidak dapat sumbernya.


Berikut merupakan dependencies yang saya gunakan :

<img width="611" alt="image" src="https://github.com/RAkbarR/Modul20/assets/149433996/9234d076-2287-4cd5-b456-b637123fc54f">


<img width="582" alt="image" src="https://github.com/RAkbarR/Modul20/assets/149433996/0cbb8d64-3335-44e0-b228-f7dae48aec22">





Berikut scenario yang ditulis menggunakan aturan tata bahasa Gherkin (Cucumber) :

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




Berikut merupakan Report dalam format HTML :


<img width="602" alt="image" src="https://github.com/RAkbarR/Modul20/assets/149433996/819495d7-5fa4-4440-9d20-3a1fa234d20e">


<img width="601" alt="image" src="https://github.com/RAkbarR/Modul20/assets/149433996/17fb34ce-7554-4147-a639-fd5d2a504cb1">




    
