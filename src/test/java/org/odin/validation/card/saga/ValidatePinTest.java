package org.odin.validation.card.saga;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.odin.validation.card.saga.model.Card;

@QuarkusTest
public class ValidatePinTest {



    @Test
    public void testValidPin() {
        Card card = new Card();

        Assertions.assertEquals(false, card.ValidatePin("4444"));
    }
}
