FROM java:8-jdk-alpine

COPY ./target/spring-boot-h2-database-example-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch demo-docker-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","spring-boot-h2-database-example-0.0.1-SNAPSHOT.jar"]