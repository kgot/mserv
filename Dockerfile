FROM resin/rpi-raspbian:jessie

VOLUME /tmp

ADD target/mserv.war mserv.war

EXPOSE 8080

RUN apt-get update && apt-get install -y \
	openjdk-8-jdk \
	--no-install-recommends && \
	rm -rf /var/lib/apt/lists/* && \
	bash -c 'touch /mserv.war ;\
	java -version ;\
	javac -version'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mserv.war"]
