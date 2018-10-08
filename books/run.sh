mvn -DskipTests package
NAME=target/books-0.0.1-SNAPSHOT.jar
docker build --build-arg JAR_FILE=$NAME -t spring-app . && docker run -p 8000:8000 -p 8080:8080 -P spring-app