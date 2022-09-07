FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/spring-data-jpa-mysql-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app
#RUN pwd
#RUN ls

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]