FROM openjdk:17
COPY target/policy-0.0.1.jar policy-0.0.1.jar
ENTRYPOINT ["java","-jar","/policy-0.0.1.jar"]