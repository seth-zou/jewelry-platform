FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY pom.xml ./
COPY apps ./apps
COPY modules ./modules
COPY packages ./packages
ARG MODULE_PATH=apps/business-api
RUN mvn -B -pl ${MODULE_PATH} -am package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
ARG MODULE_PATH=apps/business-api
ARG APP_NAME=business-api
COPY --from=build /workspace/${MODULE_PATH}/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
