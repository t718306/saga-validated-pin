package org.odin.validation.card.saga.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.reactive.messaging.kafka.Record;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;
import org.odin.validation.card.saga.model.Transaction;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class TransactionConsumer {

    private final Logger logger = Logger.getLogger(TransactionConsumer.class);
    private final TransactionProducer producer;

    @Incoming("process-transaction-in")
    public void process(Transaction transaction) throws InterruptedException {
        producer.InProcessing(transaction);
        
        producer.Processed(transaction);
    }
}
