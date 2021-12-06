package org.odin.validation.card.saga;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.odin.validation.card.saga.model.Payload;

import javax.inject.Inject;

@QuarkusTest
public class ValidatePinTest {



    @Test
    public void testValidPin() {
        Payload payload = new Payload();

        Assertions.assertEquals(false, payload.ValidatePin("4444"));
    }
}
