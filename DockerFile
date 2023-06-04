
    FROM openjdk:11

    WORKDIR /app

    COPY MvAcronymQuizz2-0.0.1-SNAPSHOT.jar /app/MvAcronymQuizz2-0.0.1-SNAPSHOT.jar

    CMD ["java", "-jar", "MvAcronymQuizz2-0.0.1-SNAPSHOT.jar"]


