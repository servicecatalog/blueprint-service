FROM openjdk:jre
VOLUME /tmp
ADD target/oscm-blueprint-mock-0.1.0.jar mockapp.jar
RUN sh -c 'touch /mockapp.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /mockapp.jar" ]