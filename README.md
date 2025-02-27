[![Codacy Badge](https://app.codacy.com/project/badge/Grade/d5b37a53d2294c29b2cb8e3bcd22e185)](https://www.codacy.com/gh/robfrank/exercises/dashboard?utm_source=github.com&utm_medium=referral&utm_content=robfrank/exercises&utm_campaign=Badge_Grade)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/d5b37a53d2294c29b2cb8e3bcd22e185)](https://www.codacy.com/gh/robfrank/exercises/dashboard?utm_source=github.com&utm_medium=referral&utm_content=robfrank/exercises&utm_campaign=Badge_Coverage)
[![security status](https://www.meterian.io/badge/gh/robfrank/exercises/security)](https://www.meterian.io/report/gh/robfrank/exercises)
[![stability status](https://www.meterian.io/badge/gh/robfrank/exercises/stability)](https://www.meterian.io/report/gh/robfrank/exercises)
[![Mergify Status][mergify-status]][mergify]

[mergify]: https://mergify.com
[mergify-status]: https://img.shields.io/endpoint.svg?url=https://api.mergify.com/v1/badges/robfrank/exercises&style=flat

# Exercises!

This repository contains code exercises, it is a sort of my _code gym_

## Build Instructions

### Prerequisites

- JDK 23
- Maven 3.9+ (Wrapper included)

### Building the Project

To build the project, run:

```bash
./mvnw clean package
```

To skip tests during build:

```bash
./mvnw clean package -DskipTests
```

### Running Tests

```bash
./mvnw test
```

## Release Process

This project uses GitHub Actions for automated releases. To create a new release:

1. Tag the commit with a version number using the format `v*.*.*`:

   ```bash
   git tag v1.0.0
   git push origin v1.0.0
   ```

2. The tag push will trigger the automated release workflow, which:
   - Runs pre-commit checks
   - Builds the project
   - Creates a GitHub release with the built JAR files
   - Generates release notes automatically
