FROM tomcat:9.0-jdk17

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Change Tomcat port from 8080 → 1122
RUN sed -i 's/port="8080"/port="1122"/' /usr/local/tomcat/conf/server.xml

# Copy WAR file
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 1122

CMD ["catalina.sh", "run"]
