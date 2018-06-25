FROM maven:latest
ADD . /code
WORKDIR /code
RUN mvn clean install -Dmaven.test.skip=true
CMD mvn spring-boot:run
