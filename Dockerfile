FROM java:8
EXPOSE 8080
ADD target/agodaservice.jar agodaservice.jar
ENTRYPOINT ["java","-jar","agodaservice.jar"]