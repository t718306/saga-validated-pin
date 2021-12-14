package org.odin.validation.card.saga.model;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class TransactionDeserializer extends ObjectMapperDeserializer<Transaction> {
    public TransactionDeserializer() {
        super(Transaction.class);
    }
}