FROM openjdk:17
COPY target/presenca-client-0.0.1-SNAPSHOT.jar app/presenca-client.jar
ENTRYPOINT java -jar app/presenca-client.jar