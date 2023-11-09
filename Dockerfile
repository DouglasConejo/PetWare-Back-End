FROM amazoncorretto:21-alpine-jdk
WORKDIR /app
COPY target/PETWARE-0.0.1-SNAPSHOT.jar PETWARE-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD [ "java", "-jar", "PETWARE-0.0.1-SNAPSHOT.jar" ]