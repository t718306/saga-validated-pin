package org.odin.validation.card.saga.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    public Card payload;
    public String sagaStatus;
    public String stepStatus;
    public String type;
    public String version;
    @JsonCreator
    public Transaction(
            @JsonProperty("id")String id,
            @JsonProperty("")String currentStep,
            @JsonProperty("payload")Card payload,
            @JsonProperty("sagaStatus")String sagaStatus,
            @JsonProperty("stepStatus")String stepStatus,
            @JsonProperty("type")String type,
            @JsonProperty("version")String version) {
        this.id = id;
        this.currentStep = currentStep;
        this.payload = payload;
        this.sagaStatus = sagaStatus;
        this.stepStatus = stepStatus;
        this.type = type;
        this.version = version;
    }
}
