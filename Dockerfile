FROM openjdk:13.0.2-jdk-slim-buster

ADD ./build/libs/kotlin-spring-demo-*.jar /opt/service/kotlin-spring-demo.jar

CMD java -jar /opt/service/kotlin-spring-demo.jar
