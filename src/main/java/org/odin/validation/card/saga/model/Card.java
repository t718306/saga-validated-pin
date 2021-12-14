package org.odin.validation.card.saga.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card {
    public String idCard;
    public double balance;
    public String pin;

    public Card(String idCard, double balance, String pin) {
        this.idCard = idCard;
        this.balance = balance;
        this.pin = pin;
    }

    public Card() { }

    @Override
    public String toString() {
        return "Card{" +
                "idCard='" + idCard + '\'' +
                ", balance='" + balance + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }

    public boolean ValidatePin(String pin) {

        if(pin.equals("4444")){
            return false;
        }
        else {
            return true;
        }
    }
}
