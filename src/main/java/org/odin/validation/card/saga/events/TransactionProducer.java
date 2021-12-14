package org.odin.validation.card.saga.events;

import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;
import org.odin.validation.card.saga.model.Payload;
import org.odin.validation.card.saga.model.Transaction;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

@ApplicationScoped
@RequiredArgsConstructor
public class TransactionProducer {

    @Inject @Channel("process-transaction-out")
    Emitter<Transaction> emitter;

    private static final Jsonb JSONB = JsonbBuilder.create();
    private final Logger logger = Logger.getLogger(Transaction.class);

    public void InProcessing(Transaction transaction) throws InterruptedException {

        transaction.sagaStatus = "STARTED";
        transaction.currentStep = "VALIDATION_PIN";

        emitter.send(transaction);
    }

    public void Processed(Transaction transaction) throws InterruptedException {

        Thread.sleep(200);
        

        Payload payload = JSONB.fromJson(transaction.getPayload(), Payload.class);

        if(payload.ValidatePin(String.valueOf(payload.pin)) == false) {
            transaction.sagaStatus = "ABORTED";
        }
        else {
            transaction.sagaStatus = "SUCCEEDED";
        }

        transaction.currentStep = "VALIDATION_PIN";

        emitter.send(transaction);
    }
}
