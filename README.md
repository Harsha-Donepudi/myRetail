# MyRetail - Target case study

Creating the image.
./gradlew build .
docker build --build-arg JAR_FILE=build/libs/*.jar -t myretail/myretail-docker .

Running the Image.
docker run -p 8080:8080 myretail/myretail-docker
