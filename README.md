# jewelry-platform

Backend services for the jewelry blockchain tracking system.

## Architecture Boundary

This repository owns backend business services and workers. It does not own React frontends, chaincode implementation, cloud infrastructure, or cross-repository architecture documents.

## Modules

| Module | Purpose | Deployable |
| --- | --- | --- |
| `apps/business-api` | Partner and operator business API | Yes |
| `apps/verify-api` | Consumer verification API | Yes |
| `apps/chain-writer` | Asynchronous chain writer | Yes |
| `apps/integration-worker` | External event integration worker | Yes |
| `apps/scheduler` | Compensation and maintenance jobs | Yes |
| `modules/jewelry-domain` | Domain model and state rules | No |
| `packages/platform-common` | Shared response and error types | No |

## Local Development

Requirements:

- JDK 21
- Maven 3.9+ recommended. Maven 3.6+ is sufficient for the current skeleton.

Commands:

```bash
mvn test
mvn package
mvn -pl apps/business-api -am spring-boot:run
mvn -pl apps/verify-api -am spring-boot:run
```

## Deployment Artifact

Each app module produces a Spring Boot jar under `target/`. The root `Dockerfile` can build one deployable by selecting a Maven module path.

```bash
docker build --build-arg MODULE_PATH=apps/business-api --build-arg APP_NAME=business-api -t jewelry/business-api:local .
```

## License

No license has been specified yet. Do not assume reuse rights until the repository owner adds one.
