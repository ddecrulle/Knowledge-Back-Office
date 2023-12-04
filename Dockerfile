FROM eclipse-temurin:11-jre-focal
COPY ./target/*.jar /usr/local/app.jar

EXPOSE 8080
RUN adduser knowledge-api
USER knowledge-api

CMD ["java","-jar","/usr/local/app.jar"]
