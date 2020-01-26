FROM openjdk:8-jre-alpine
WORKDIR /work/

COPY target/lib/* /work/lib
COPY target/*-runner.jar /work/app.jar

RUN chmod 775 /work
EXPOSE 8080
#RUN ls /work
CMD ["java", "-jar", "app.jar"]