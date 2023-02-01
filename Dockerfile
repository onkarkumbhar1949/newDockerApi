FROM openjdk:11-jdk-alpine
ADD target/demo.springboot-1.0.0 jar demo.springboot-1.0.0.jar
ENTRYPOINT ["java","jar","demo.springboot-1.0.0.jar"]
EXPOSE 9090