FROM openjdk:11

LABEL microservice="Intertop"
LABEL description="Distributor microservice of pants and outwears"

COPY build/libs/intertop-1.0-SNAPSHOT.jar /intertop-1.0-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/intertop-1.0-SNAPSHOT.jar"]