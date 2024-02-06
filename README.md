# userspringBoot

USE keyspacename
CREATE TABLE useryable (ID UUID,lastname text,firstname text,email text PRIMARY KEY,hide boolean );

drop table tablename

This is currently using the https://astra.datastax.com/ DB
As of January 2024 
    This spring rest API it is using the cassandra for DB
    This give the APIs to reactnative web app
    From the Web app I will allow only "http://localhost:8080","http://localhost:3000","http://localhost:3001" from other application it wont allow


On Feb 3 2024
    
    Adding headers 
            1. if it is localhost post man header must be X-origin-app = test-call
            2. if it is web app header must be mywebapp X-origin-app = syamapp
    this can be achieved using HandlerInterceptor
    
KAFKA in local

refer https://kafka.apache.org/quickstart 

    1. Download kafka https://www.apache.org/dyn/closer.cgi?path=/kafka/3.6.1/kafka_2.13-3.6.1.tgz
    2. Kafka with ZooKeeper
            bin/zookeeper-server-start.sh config/zookeeper.properties
            bin/kafka-server-start.sh config/server.properties
    3. Create Topic 
        we can create topic in 2 wiays one is using command like belo and other is using code bean
        bin/kafka-topics.sh --create --topic <topicname> --bootstrap-server localhost:9092
        ex: bin/kafka-topics.sh --create --topic userinsert-events --bootstrap-server localhost:9092

bin/kafka-console-consumer.sh --topic userinsert-events --from-beginning --bootstrap-server localhost:9092


This Application is modified as below
    
    1. API will do reading from DB only
    2. Kafk Consumers will do insert update and delete users from DB

1. API

   -> Get All records

   -> When we call Add user it will call kafka producer and write message to insert topic

   -> When we call Update user it will call kafka producer and write message to update topic

   -> When we call Delete user it will call kafka producer and write message to Delete topic

2. Kafka

   -> Kafka configurations are managed using application.yml

   -> Kafka topic are created using the kafkaConfig class
   
   -> Kafka producer will publish a  message for the api put,post or delete call into different topics

   -> Kafka consumer also configured with spring boot

   -> Kafka each consumer is currently read string message and do the DB insert update and delete
