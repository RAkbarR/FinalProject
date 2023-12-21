Berikut merupakan hasil testing yang telah saya buat

Scenario yang digunakan : Login dan search username admin

Sumber yang saya gunakan yaitu contoh code dari mentor di discord

Berikut Dependecies yang saya gunakan :

dependencies {
    testImplementation platform('org.junit:junit-bom:5.9.1')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.10.1'
    testImplementation 'org.junit.vintage:junit-vintage-engine:5.10.1'

    implementation 'io.cucumber:cucumber-java:7.14.0'
    testImplementation 'io.cucumber:cucumber-junit:7.14.0'

    testImplementation 'io.rest-assured:rest-assured:5.3.0'
    implementation 'org.json:json:20220924'
    testImplementation 'io.rest-assured:json-path:5.3.0'
    implementation 'io.rest-assured:json-schema-validator:5.3.0'
    testImplementation 'org.assertj:assertj-core:3.24.0'

    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.16.1'
    implementation 'io.github.bonigarcia:webdrivermanager:5.6.2'
}


Untuk Gherkin saya membuat satu file baru di package feature yaitu web.feature isinya sebagai berikut :
Feature: Test Automation API

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
    Then user can see validation on side nav

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
    Then user will see admin records

Berikut merupakan hasilnya :

Scenario: Test Web Login

<img width="926" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/9e2b36bc-58f1-4597-a64c-1efddf9e90d5">



Scenario: Negative Test Web Login 

<img width="876" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/113f2a45-36cd-432d-bd13-37bde1a8e985">


Scenario: Test Search Admin Username

<img width="926" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/51a36d1c-1b23-4b84-b8dc-ab6c9b5f40b0">


#negative admin search by username (wrong username)

<img width="921" alt="image" src="https://github.com/RAkbarR/FinalProject/assets/149433996/11b07917-4109-4102-9877-a832e50756d8">


Catatan : untuk scenario negative admin search kenapa pass semua, karena tidak adanya credential seperti login, hanya ada pemberitahuan kalau record dari username admin tersebut tidak ada dan sudah saya testing lewat selenium sebelumnya
