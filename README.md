# Kafka Producer Implementation

## Description

This project is focused on the implementation of a Kafka producer. It utilizes Java 17 for development and leverages the Spring Kafka library for Kafka integration.

## Dependencies

- **spring-kafka**: This dependency provides the necessary components for integrating Kafka with Spring applications.

## Kafka Topic Configuration

A topic configuration bean is added to the project to define a new Kafka topic. Below is the configuration class:

```java
@Configuration
public class KafkaTopicConfig {

    @Bean
    NewTopic createNewTopic() {
		return new NewTopic("kafka-auto-topic", 3, (short) 1);
	}
}
```

## Application Properties
The project includes the following properties configuration in the ```application.yml``` file:

```yml
server:
  port: 9191
  
spring:
  kafka:
    producer:
      bootstrap-servers: localhost:9092 //This configuration specifies the Kafka server's bootstrap servers for the producer.
```

