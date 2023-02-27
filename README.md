# 👀 CRUD - Quarkus

## 🎮️ Sobre
Este projeto visa estudar a observabilidade de uma aplicação rest.

## 👨‍💻️ Tecnogias utilizadas
O projeto foi desenvolvido utilizando as seguintes tecnologias:

💻️ Spring 3.0.1

    Api (JDK: 17)

💻️ Prometheus

    Monitoramento e alertas

💻️ Grafana

    Análise e Monitoramento

💻️ Loki 

    Agregação de Registros (logs)

💻️ K6
    
    Teste de performance

💻️ ZipKin

    Trace das transações

💻️ Docker
    
    Virtualizador de aplicações

---------------------------------

## Referências de estudo:

[How To Monitor a Spring Boot App With Prometheus and Grafana](https://betterprogramming.pub/how-to-monitor-a-spring-boot-app-with-prometheus-and-grafana-22e2338f97fc)

[Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker/)

[Dashboard de métricas com Spring Boot Actuator, Prometheus e Grafana](https://www.youtube.com/watch?v=K_EI1SxVQ5Q)

[Ferramentas de Observabilidade](https://github.com/liliannss/observabilidade)

[Zipkin](https://springbootlearning.medium.com/using-micrometer-to-trace-your-spring-boot-app-1fe6ff9982ae)

----------------------------------
### Comandos:

<b>Gerar container spring:<b> 

1 - ``mvn install ``

2 - ``docker build -t springio/gs-spring-boot-docker .`` (deprecated)

OU

    mvn spring-boot:build-image
    docker tag observability-api:0.0.1-SNAPSHOT rhdesouza/observability-api:0.0.1-SNAPSHOT
    docker push rhdesouza/observability-api:0.0.1-SNAPSHOT

----------------------------------

# Sobre a cofiguração:


# teste-crud-quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/teste-crud-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- REST resources for Hibernate ORM with Panache ([guide](https://quarkus.io/guides/rest-data-panache)): Generate JAX-RS resources for your Hibernate Panache entities and repositories
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
