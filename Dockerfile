FROM open jdk:11
ADD target/demo_cpgspringboot-1.0.0.jar demo_cpgspringboot-1.0.0.jar
ENTRYPOINT ["java","jar","demo.cpgspringboot-1.0.0.jar"]
EXPOSE 9090