package org.odin.validation.card.saga.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transaction {

    public String id;
    public String currentStep;
    public String payload;
    public String sagaStatus;
    public String stepStatus;
    public String type;
    public String version;


}
