FROM openjdk
ARG JAR_FILE=target/restaurantes-ms-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} restaurantes-ms.jar
ENTRYPOINT ["java","-jar","/restaurantes-ms.jar"]