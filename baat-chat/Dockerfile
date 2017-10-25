FROM java:8

# Dockerfile author / maintainer
MAINTAINER Sachin Goyal <sachin.goyal.se@gmail.com>

VOLUME /opt/baat

ADD target/baat-chat*.jar /opt/baat/baat-chat.jar

EXPOSE 8084

ENTRYPOINT ["java","-Dserver.port=8084","-Dspring.rabbitmq.host=rabbitmq","-jar","/opt/baat/baat-chat.jar"]
