# userspringBoot

USE keyspacename
CREATE TABLE useryable (ID UUID,lastname text,firstname text,email text PRIMARY KEY,hide boolean );

drop table tablename

This is currently using the https://astra.datastax.com/ DB
As of January 2024 
    This spring rest API it is using the cassandra for DB
    This give the APIs to reactnative web app
    From the Web app I will allow only "http://localhost:8080","http://localhost:3000","http://localhost:3001" from other application it wont allow
    

