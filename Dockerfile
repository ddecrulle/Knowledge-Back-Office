FROM tomcat:9-jdk11-openjdk-slim

RUN rm -rf $CATALINA_HOME/webapps/*
ADD /target/*.war $CATALINA_HOME/webapps/ROOT.war