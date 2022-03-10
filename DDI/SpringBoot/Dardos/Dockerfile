FROM tomcat:jre11-temurin-focal
COPY ./target/*.war /usr/local/tomcat/webapps/
RUN mv /usr/local/tomcat/webapps/Dardos-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/dardos.war
EXPOSE 8080
CMD ["catalina.sh", "run"]