FROM tomcat:9.0.40-jdk11-corretto
ADD target/demoapplication-0.0.1-SNAPSHOT.war demoapplication-0.0.1-SNAPSHOT.war
EXPOSE 8084
ENTRYPOINT [ "java" , "-jar" , "demoapplication-0.0.1-SNAPSHOT" ]
