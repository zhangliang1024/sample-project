FROM docker.liangzixin.top/library/mysql:5.7.25

LABEL maintainer="liangzixin.top"

ENV INIT_DB_PATH /docker-entrypoint-initdb.d/

#把数据库初始化数据的文件复制到工作目录下
COPY docker/*.sql $INIT_DB_PATH/

USER root
RUN mkdir -p /logRoot/mysql
RUN touch /logRoot/mysql/mysql-slow.log /logRoot/mysql/mysql-error.log
RUN chown -R mysql:mysql /logRoot
RUN echo "Asia/Shanghai" > /etc/timezone
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

USER mysql
COPY docker/my.cnf /etc/my.cnf

EXPOSE 3306
