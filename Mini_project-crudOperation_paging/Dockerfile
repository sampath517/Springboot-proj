FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/Mini_project-crudOperation-0.0.1-SNAPSHOT.war
COPY ${JAR_FILE} app.war
ENTRYPOINT ["java","-jar","/app.war"]
