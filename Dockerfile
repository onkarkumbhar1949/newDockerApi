FROM openjdk:13-jdk-alpine
ADD target/helloapp.jar helloapp.jar
ENTRYPOINT ["java","jar","helloapp.jar"]