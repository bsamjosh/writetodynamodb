# fetch basic image
FROM maven:3.6.3-jdk-11 as build
# application placed into /opt/app
WORKDIR /app
# selectively add the POM file and
# install dependencies
COPY pom.xml .
COPY src src
#RUN mkdir config

# rest of the project
RUN mvn clean install

FROM openjdk:11
VOLUME /tmp

ARG TARGET=/app/target/
ARG CONFIG=/app/config/
ARG JARNAME=writetodynamodb.jar

COPY --from=build /app/src/main/resources/application.properties $CONFIG
COPY --from=build /app/target/original-writetodynamodb-1.0-SNAPSHOT.jar $TARGET/writetodynamodb.jar

WORKDIR $TARGET

EXPOSE 8081
ENTRYPOINT ["java","-jar","writetodynamodb.jar","-Dspring.config.location=$CONFIG/application.properties"]