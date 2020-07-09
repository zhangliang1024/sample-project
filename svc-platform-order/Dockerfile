FROM docker.liangzixin.top/library/jdk:v1.1.0

ARG JAR_FILE_NAME=svc-platform-order-0.0.1-SNAPSHOT.jar
ARG PORT=9302
ARG MANAGEMENT_PORT=9602

COPY ./target/lib /lzx/lib
COPY ./target/$JAR_FILE_NAME.original /lzx/app.jar

ENV CLASSPATH=/lzx/lib

EXPOSE $PORT
EXPOSE $MANAGEMENT_PORT

WORKDIR /lzx

ENTRYPOINT ["java", "-jar", "/lzx/app.jar"]