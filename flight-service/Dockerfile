FROM openjdk
MAINTAINER Piotr Minkowski <piotr.minkowski@gmail.com>
ADD target/flight-service.jar flight-service.jar
ENTRYPOINT ["java", "-jar", "/flight-service.jar"]
EXPOSE 9999