FROM java:8

# Dockerfile author / maintainer
MAINTAINER Sachin Goyal <sachin.goyal.se@gmail.com>

VOLUME /opt/baat

ADD target/baat-chat*.jar /opt/baat/baat-chat.jar

ENTRYPOINT ["java","-jar","/opt/baat/baat-chat.jar"]
