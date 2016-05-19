FROM java:8
VOLUME /tmp
ADD target/mserv-1.0.1.war mserv.war
EXPOSE 8080
RUN bash -c 'touch /mserv.war'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "spring-boot:run", "-jar", "/mserv.war"]
