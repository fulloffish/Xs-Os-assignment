package io;

public class UserInput {

    public Integer getCoordinate(IntegerAsker asker, Integer maximum) {
        Integer coordinate = asker.ask("Enter a number: ");
        while(!this.isInputValid(maximum, coordinate)) {
            coordinate = asker.ask("Not valid, try again");
        }
        return coordinate;
    }

    private boolean isInputValid(Integer maximum, Integer coordinate) {
        if(coordinate < 1 || coordinate > maximum) {
            return false;
        }
        return true;
    }

}
