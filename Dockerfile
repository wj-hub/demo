FROM java:8
ADD demo.jar demo.jar
RUN bash -c 'touch /demo.jar'
ENTRYPOINT ["java","-jar","/demo.jar"]
