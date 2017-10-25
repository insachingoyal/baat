FROM java:8

# Dockerfile author / maintainer
MAINTAINER Sachin Goyal <sachin.goyal.se@gmail.com>

VOLUME /opt/baat

ADD target/baat-ws*.jar /opt/baat/baat-ws.jar

EXPOSE 8083

ENTRYPOINT ["java","-Dserver.port=8083","-Dspring.rabbitmq.host=rabbitmq", "-jar","/opt/baat/baat-ws.jar"]
