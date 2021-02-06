# if our service direct URI is hit it wont go throw Gateway API
# URL for Gateway is
localhost:port_Of_ZUUl/{ApplicationName}/{URI}
#Application nme is the Application name we configured and URI will be same

#git url for project
https://github.com/in28minutes/spring-microservices

#installing tools repo
https://github.com/in28minutes/spring-microservices#installing-tools

#rabbit MQ important commands
#zipkin Distributed serverr that will listen to Rabbit MQ
#make sure rabbit MQ server is UP
set RABBIT_URI=amqp://localhost
java -jar zipkin-server-version-exec.jar

#to reflect changes done in spring cloud config with out starting the server again
#service do need to have actuator installed
http://localhost:{serviceport}/actuator/refresh

# to over come the problem of hitting each instance indivdualy we can go forspring cloud bus
#we will use Rabbit mq here for it
#just add dependency for bus-amq in both pom of server config and service
http://localhost:{serviceport}/actuator/bus-refresh