package tech.morbit.Quality;

/**
 * @author Morbit
 * @version 0.1.2
 *
 * PURPOSE:
 * The changing value is for a not fixated value.
 * There is no real lower or upper bound to this value, just the idea, that it is not fixed.
 *
 * EXAMPLES:
 * A list of items, number of kills, total damage taken, other statistics.
 */

import tech.morbit.Exception.InvalidInputException;
import tech.morbit.Exception.InvalidTypeException;

import java.util.ArrayList;

public class ChangingValue extends Quality {

    static final public int valueCount = 1;

    private Object changingValue;

    public <T> ChangingValue(String comment, ArrayList<T> changingValue) throws InvalidInputException {
        super(comment);

        if(changingValue.size() == this.valueCount &&
                (VALID_TYPES.contains(changingValue.getFirst().getClass()) ||
                        Quality.class.isAssignableFrom(changingValue.getFirst().getClass())))
        {
            this.values = (ArrayList<Object>) changingValue;
            this.changingValue = changingValue.get(0);
        } else{
            System.out.println(name + ": " + changingValue.getFirst().getClass() + " " + valueCount);
            throw new InvalidInputException();
        }


    }

    public Object getChangingValue(){return changingValue;}

    public void setChangingValue(Object changingValue) throws InvalidTypeException {
        if(changingValue.getClass().equals(this.changingValue.getClass())){
            this.changingValue = changingValue;
        } else throw new InvalidTypeException();
    }
}
