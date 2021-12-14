package org.odin.validation.card.saga.events;

import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;
import org.odin.validation.card.saga.model.Card;
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

        transaction.stepStatus = "STARTED";
        transaction.currentStep = "VALIDATION_PIN";
        logger.info("Antes de enviar para o Confirmation");
        emitter.send(transaction);
        logger.info("Depois de enviar ao Confirmation!!!! = "+transaction.toString());
    }

    public void Processed(Transaction transaction) throws InterruptedException {

        Thread.sleep(200);

        //Card card = JSONB.fromJson(transaction.getPayload(), Card.class);

        if(transaction.payload.ValidatePin(String.valueOf(transaction.payload.pin)) == false) {
            transaction.stepStatus = "ABORTED";
        }
        else {
            transaction.stepStatus = "SUCCEEDED";
        }

        transaction.currentStep = "VALIDATION_PIN";

        emitter.send(transaction);
    }
}
