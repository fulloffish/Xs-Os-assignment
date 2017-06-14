package io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


class UserInputTest {
    UserInput input;

    @BeforeEach
    public void createUserInputInstance() {
        input = new UserInput();
    }

    @Test
    @DisplayName("GetCoordinate() returns integer when within bounds")
    public void testGetCoordinateReturnsIntegerWhenWithinBounds() {
        IntegerAsker asker = mock(IntegerAsker.class);
        when(asker.ask(anyString())).thenReturn(3);
        Integer maximum = 3;
        assertEquals(3, (int)input.getCoordinate(asker, maximum));
    }

   @Test
    @DisplayName("GetCoordinate() does not return accept invalid number")
    public void testGetCoordinateDoesNotAcceptInvalidNumber() {
       Integer maximum = 5;
       Integer integerOverMaximum = 6;
       Integer validInteger = 1;
       IntegerAsker asker = mock(IntegerAsker.class);
       when(asker.ask("Enter a number")).thenReturn(integerOverMaximum);
       when(asker.ask("Not valid, try again")).thenReturn(validInteger);
       input.getCoordinate(asker, maximum);
       verify(asker).ask("Not valid, try again");

   }

}