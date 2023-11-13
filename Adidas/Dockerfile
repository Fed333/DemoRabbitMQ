FROM openjdk:11

LABEL microservice="Adidas"
LABEL description="Manufacturer microservice of shoes and pants"

COPY ./build/libs/Adidas-1.0-SNAPSHOT.jar /Adidas-1.0-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/Adidas-1.0-SNAPSHOT.jar"]