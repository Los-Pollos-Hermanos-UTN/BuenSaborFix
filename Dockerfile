FROM gradle:jdk17-alpine AS build

COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project

RUN gradle bootJar --no-daemon

FROM openjdk:17-alpine
EXPOSE 8080
COPY --from=build /home/gradle/project/build/libs/buensaboruno-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
