# Java SOA REST Service with Docker Compose

A small Service-Oriented Architecture (SOA) demonstration built with Java 17 and Spring Boot. It exposes REST endpoints and runs in Docker. No database is required.

## Architecture

```text
Client (browser / curl)
        |
        | HTTP :8080
        v
Spring Boot REST Controller
        |
        v
Greeting Service
        |
        v
JSON response
```

The controller and service are separate layers to demonstrate service-oriented separation of responsibilities. Docker Compose builds and starts the application as a container.

## Requirements

- Docker Desktop (with Docker Compose v2)
- Internet access for the first image build

Java and Maven do not need to be installed on the host because the Dockerfile uses a Maven/Java build image.

## Run with Docker Compose

From the repository root:

```bash
docker compose up --build -d
```

Check container status:

```bash
docker compose ps
```

Follow application logs:

```bash
docker compose logs -f soa-rest-service
```

## Test the REST API

Open these URLs in a browser:

- http://localhost:8080/api/hello
- http://localhost:8080/api/hello?name=Bhuvanesh
- http://localhost:8080/api/info
- http://localhost:8080/actuator/health

Or test with curl:

```bash
curl http://localhost:8080/api/hello
curl "http://localhost:8080/api/hello?name=Bhuvanesh"
curl http://localhost:8080/api/info
curl http://localhost:8080/actuator/health
```

Expected health response:

```json
{"status":"UP"}
```

## Stop the application

```bash
docker compose down
```

Rebuild from scratch:

```bash
docker compose down
docker compose build --no-cache
docker compose up -d
```

## Project structure

```text
.
├── src/main/java/com/example/soa/
│   ├── SoaApplication.java
│   ├── controller/GreetingController.java
│   └── service/GreetingService.java
├── src/main/resources/application.properties
├── Dockerfile
├── docker-compose.yml
├── .dockerignore
├── .gitignore
└── pom.xml
```

## Notes

- The application listens on port 8080.
- No database or external infrastructure is needed.
- The container runs as a non-root user.
- Docker health checks use Spring Boot Actuator.
