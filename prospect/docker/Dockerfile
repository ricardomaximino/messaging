# This is the Dockerfile reference for Spring based microservices
# 
# REQUIRED FILES TO BUILD THIS IMAGE
# ----------------------------------
# (1) JAR file containing the microservice compiled code.
#
# Pull base image
FROM faas.securitasdirect.local:1443/openjdk:8-jre-alpine

# Maintainer
# ----------
LABEL maintainer="FaaS <faas@securitasdirect.es>"

VOLUME /tmp


# Create verisure group and user and give permissions over logs folder.
RUN addgroup verisure \
    && adduser -s /bin/sh -D -G verisure verisure \
    && mkdir /logs \
    && chown verisure:verisure /logs \
    && chmod a+rw /logs
USER verisure

# Required build arguments
ARG NAME
ARG VERSION

# Set environment variables
ENV ARTIFACT_NAME=$NAME \
    SERVER_PORT=8080 \
    SPRING_PROFILES_ACTIVE=cloud \
    JAVA_TOOL_OPTIONS=-Duser.timezone="Europe/Madrid" \
    TZ=CET-1CEST,M3.5.0,M10.5.0/3


EXPOSE ${SERVER_PORT} ${MANAGEMENT_PORT}

#Add EXECUTABLE JAR
COPY docker/$NAME-$VERSION.jar $NAME.jar

#Add external file
#ADD path/file file


ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -Xms64m -Xmx512m -jar /$ARTIFACT_NAME.jar -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE