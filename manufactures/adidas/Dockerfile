FROM openjdk:11

LABEL microservice="Adidas"
LABEL description="Manufacturer microservice of shoes and pants"

COPY build/libs/adidas-1.0-SNAPSHOT.jar /adidas-1.0-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/adidas-1.0-SNAPSHOT.jar"]