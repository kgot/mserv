FROM frolvlad/alpine-oraclejdk8:slim

VOLUME /tmp

ADD mserv.war mserv.war

RUN sh -c 'touch /mserv.war; mvn package docker:build'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mserv.war"]
