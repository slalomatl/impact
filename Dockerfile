FROM alpine:3.3

# Largely taken from https://gist.github.com/rhuss/6d3c0c687fb4ec39c3e4
ENV JRE=jre1.8.0_60 \
    JAVA_HOME=/opt/jre \
    PORT=8080 \
    SPRING_PROFILES_ACTIVE=docker,production \
    IMPACT_HOME=/opt/impact

EXPOSE 8080

RUN apk add --update wget ca-certificates && \
    cd /tmp && \
    wget "https://circle-artifacts.com/gh/andyshinn/alpine-pkg-glibc/6/artifacts/0/home/ubuntu/alpine-pkg-glibc/packages/x86_64/glibc-2.21-r2.apk" \
         "https://circle-artifacts.com/gh/andyshinn/alpine-pkg-glibc/6/artifacts/0/home/ubuntu/alpine-pkg-glibc/packages/x86_64/glibc-bin-2.21-r2.apk" && \
    apk add --allow-untrusted glibc-2.21-r2.apk glibc-bin-2.21-r2.apk && \
    /usr/glibc/usr/bin/ldconfig /lib /usr/glibc/usr/lib && \
    echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf && \
    mkdir /opt && \
    wget http://www.java.net/download/jdk8u60/archive/b18/binaries/jre-8u60-ea-bin-b18-linux-x64-02_jun_2015.tar.gz -O /tmp/${JRE}.tgz && \
    cd /opt && tar zxvf /tmp/${JRE}.tgz && \
    ln -s /opt/${JRE} /opt/jre && \
    ln -s /opt/jre/bin/java /usr/bin/java && \
    apk del wget ca-certificates && \
    cd /opt/jre/lib/amd64 && rm libjavafx_* libjfx* libfx* && \
    cd /opt/jre/lib/ && rm -rf ext/jfxrt.jar jfxswt.jar javafx.properties font* && \
    rm /tmp/* /var/cache/apk/*

COPY Dockerfile $IMPACT_HOME/
COPY build/libs/impact*.jar $IMPACT_HOME/impact.jar

CMD ["java", "-jar", "/opt/impact/impact.jar"]
