package org.odin.validation.card.saga.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.ApplicationScoped;

@Getter
@Setter
@ToString
@ApplicationScoped
@NoArgsConstructor
public class Payload {
    public int idCard;
    public double value;
    public int pin;

    public boolean ValidatePin(String pin) {

        if(pin.equals("4444")){
            return false;
        }
        else {
            return true;
        }
    }
}


