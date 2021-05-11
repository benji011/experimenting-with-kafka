package producers;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import static constants.Constants.BOOTSTRAP_SERVER;
import static constants.Constants.TOPIC;

public class ProducerDemoWithCallback {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(ProducerDemoWithCallback.class);

        // Create producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // Create producer record
        for (int i = 0; i <=10; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC, "hello world " + Integer.toString(i));

            // Send data with callback to execute everytime a record is sent successfully
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e != null) {
                        logger.error("Error while producing: ", e);
                    } else {
                        logger.info("Metadata received: \n"
                                + "Topic: " + recordMetadata.topic()  + "\n"
                                + "Partition: " + recordMetadata.partition() + "\n"
                                + "Offset: " + recordMetadata.offset() + "\n"
                                + "Timestamp: " + recordMetadata.timestamp()
                        );
                    }
                }
            });
        }

        // Flush & close
        producer.flush();
    }
}
