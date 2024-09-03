FROM maven:3.9.6 as jarnik
WORKDIR /opt/app
COPY pom.xml ./
COPY ./src ./src
RUN mvn clean package

FROM eclipse-temurin:21-jre-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=jarnik /opt/app/target/*.jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","/opt/app/app.jar"]