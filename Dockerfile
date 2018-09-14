# build the artifact
FROM openjdk:10 AS builder
ADD . /app
WORKDIR /app
RUN ./gradlew build

# run the artifact
FROM openjdk:10-jre
COPY --from=builder /app/build/libs/spotidentity*.jar ./spotidentity.jar
EXPOSE 8080
CMD ["java", "-jar", "spotidentity.jar"]
