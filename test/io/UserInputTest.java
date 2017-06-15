package io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


class UserInputTest {
    UserInput input;
    InputAsker asker;

    @BeforeEach
    public void createUserInputInstance() {
        input = new UserInput();
    }

    @BeforeEach
    public void mockInputAskerInstance() {
        asker = mock(InputAsker.class);
    }

    @Test
    @DisplayName("GetCoordinate() returns integer when within bounds")
    public void testGetCoordinateReturnsIntegerWhenWithinBounds() {
        Integer maximum = 3;
        Integer integerWithinBounds = 3;
        when(asker.askForInteger(anyString())).thenReturn(integerWithinBounds);
        assertEquals(integerWithinBounds, input.getCoordinate(asker, maximum));
    }

    @Test
    @DisplayName("GetCoordinate() does not accept invalid number")
    public void testGetCoordinateDoesNotAcceptInvalidNumber() {
       Integer maximum = 5;
       Integer integerOverMaximum = 6;
       Integer validInteger = 1;
       when(asker.askForInteger("Enter a number")).thenReturn(integerOverMaximum);
       when(asker.askForInteger("Not valid, try again")).thenReturn(validInteger);
       input.getCoordinate(asker, maximum);
       verify(asker).askForInteger("Not valid, try again");
   }

    @Test
    @DisplayName("GetInputYesOrNo() returns proper value of one character")
    public void testGetInputYesOrNoReturnsCharacter() {
        Character characterInput = 'L';
        when(asker.askForCharacter("Do you want to play again? Y or N")).thenReturn(characterInput);
        assertEquals('L', (char)input.getInputYesOrNo(asker));
    }

}