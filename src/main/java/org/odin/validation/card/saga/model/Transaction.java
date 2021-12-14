package org.odin.validation.card.saga.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transaction {
    public String id;
    public String currentStep;
    public Card payload;
    public String sagaStatus;
    public String stepStatus;
    public String type;
    public String version;
}
