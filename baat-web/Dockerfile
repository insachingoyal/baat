FROM java:8

# Dockerfile author / maintainer
MAINTAINER Sachin Goyal <sachin.goyal.se@gmail.com>

VOLUME /opt/baat

ADD target/baat-web*.jar /opt/baat/baat-web.jar

EXPOSE 8082

ENTRYPOINT ["java","-Dserver.port=8082","-jar","/opt/baat/baat-web.jar"]
