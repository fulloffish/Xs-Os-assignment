package io;

public class UserInput {

    public Integer getCoordinate(InputAsker asker, Integer maximum) {
        Integer coordinate = asker.askForInteger("Enter a number: ");
        while (!this.isInputValid(maximum, coordinate)) {
            coordinate = asker.askForInteger("Not valid, try again");
        }
        return coordinate;
    }

    private boolean isInputValid(Integer maximum, Integer coordinate) {
        if (coordinate < 1 || coordinate > maximum) {
            return false;
        }
        return true;
    }

    public Character getInputYesOrNo(InputAsker asker) {
        return asker.askForCharacter("Do you want to play again? Y or N");
    }
}

