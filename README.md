# **Java API Assessment**

## **Introduction Flowershop Api Magagement**# : FlowerShop 
  this is flowershop api specifically dealing with querying and sorting data from a flower shop database. This repository uses JPA Criteria API to build and execute dynamic queries based on the provided filters and sorting options
## Description

The api allows users to `create`, `read`, `update`, and `delete` it also `fillters`  data using name or type and `sorts` the results i also added pageing just to controll the page size

### implementing  Data structure algorithams DSA using apring Data JPA
 I have two Repisitory one for adding data and one for the writing JPA Query Language
in  my criteria Repository i used the The Java Persistence Criteria API to be able to use things like EntityManager,criteriaBuilder and to be able to count aswell   so the main point of this is  to sort, search  and filter data 
i have to more classes for the this one for search criteria and for pageing 
then its my servise which also implements an interface i made for the search api when i wanted to use  native sql queries but later when i changed my mind to use jpql i decided to keep it aswell
and then i have  my controller 
this is how the endpoint  look like 
| -------- | ---------------- | -------------------- |
1. `GET`    | `API/flowershops`      | Get all flowers         |
2. `GET`    | `API/flowershops/{id}` | Get a flower by id     |
3. `POST`   | `API/flowershops`      | Add a Iflower          |
4. `PUT`    | `API/flowershops/{id}` | Replace a flower by Id |
5. `DELETE` | `API/flowershops/{id}` | Delete a flower by id  |
6. `search` | `API/flowershops/{name or type}` | search a flower by name or type  |
7. `filtter` | `API/flowershops/{fillter }` | filtter,and sorts  flowers by name or type and set them a page size  |

To start the API from the terminal, run the following command:

```sh
./mvnw spring-boot:run
```

Or on Windows:

```cmd
mvnw spring-boot:run
```

I used mysql workbench for my data Storage but fell free to use what u want

### Testing the Application

You can test your endpoints using [Postman][5] or your preferred REST client.

For `POST` and `PUT` requests, you'll need to provide a request body in JSON format, e.g.:

```json
{
  "name": "blueRose",
  "type": "Rose",
  "place": "shop5",
  "DateCreated": ,
  "DateUpdated": 
}
```
**note: you dont need to add ID,DateUpdated or DateCreated becouse those will be created for you Automatically  thas why i have them null**

[1]: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Repository.html
[2]: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html
[3]: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html
[4]: https://www.postman.com