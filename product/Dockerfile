FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar product-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","product-0.0.1-SNAPSHOT.jar"]