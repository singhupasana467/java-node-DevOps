FROM openjdk:17-alpine
WORKDIR /app
COPY Main.java .
RUN javac -d . Main.java
CMD ["java", "backend.Main"]