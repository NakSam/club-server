FROM openjdk:1.8

EXPOSE 8080

ADD build/libs/BarkingCat-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]