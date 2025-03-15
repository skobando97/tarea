FROM openjdk:17-jdk-slim
WORKDIR /app
RUN mkdir ./logs
COPY ./target/EjemploClase4-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","EjemploClase4-0.0.1-SNAPSHOT.jar"]