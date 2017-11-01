FROM java:8

# Dockerfile author / maintainer
MAINTAINER Sachin Goyal <sachin.goyal.se@gmail.com>

VOLUME /opt/baat

ADD target/baat-web*.jar /opt/baat/baat-web.jar

ENTRYPOINT ["java","-jar","/opt/baat/baat-web.jar"]
