## Environment set up

```
1. Install Java
2. Set up Maven
```

## Run and Test

To run the application type

```
mvn spring-boot:run
```

To execute unit and acceptance tests


```
mvn test
```

## Endpoints

**Important:** `Content-Type: application/json` header must be present to use API.


### Change Password API

```
PUT http://localhost:8080/agodaservice/changepassword

Content-Type: application/json

{
    "old_password": "AgodaService2!@1TestData",
    "new_password": "AgodaService2!@132"
}
```

## Note

```
Old Password must be: AgodaService2!@1TestData
```

## Dockerimage URL

```
https://cloud.docker.com/u/vuongvvv/repository/docker/vuongvvv/agodaservice_image
```