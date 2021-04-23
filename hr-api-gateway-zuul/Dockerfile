FROM openjdk:11

EXPOSE 8765

VOLUME /tmp

ADD target/hr-api-gateway-zuul-0.0.1-SNAPSHOT.jar hr-api-gateway-zuul.jar 

ENTRYPOINT [ "java", "-jar", "hr-api-gateway-zuul.jar" ]