FROM java:8

# Dockerfile author / maintainer
MAINTAINER Sachin Goyal <sachin.goyal.se@gmail.com>

VOLUME /opt/baat

ADD target/baat-user*.jar /opt/baat/baat-user.jar

EXPOSE 8081

ENTRYPOINT ["java","-Dserver.port=8081","-jar","/opt/baat/baat-user.jar"]
