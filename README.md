### Requirements

- Java 
- Maven
- Docker
- Docker-compose

### Compile
```
mvn clean package
```

### Run

Mount the jar file to kafka connect cluster.

```
volumes:
    - "./plugin/:/usr/share/java/kafka/kafka-connect-source-meetup"
```        

Start the cluster:

```
docker-compose up -d
```

Register the connector
```
curl -X POST \
     -H "Content-Type: application/json" \
     -H 'Accept: application/json' \
     -d '{"name": "meetup", "config": {"connector.class":"com.adilhoumadi.MeetupSourceConnector", "topic":"meetup" }}' \
     http://localhost:8083/connectors
```

Consume your topic, and you will have the data on it!