package tech.morbit.Quality;

/**
 * @author Morbit
 * @version 0.1.2
 *
 * PURPOSE:
 * This is meant for a fixed value, never meant to be changed.
 *
 * EXAMPLES:
 * Statistics in some TTRPG games as:
 * Netrunners Hacking in CyP Red
 * CoC statistics.
 *
 *
 */

import tech.morbit.Exception.InvalidInputException;

import java.util.ArrayList;

public class QualityBaseValueFixed extends QualityBase {

    final public int valueCount = 1;

    private Object fixedValue;

    public <T> QualityBaseValueFixed(String comment, ArrayList<T> fixedValue) throws InvalidInputException {
        super(comment);

        if(fixedValue.size() == this.valueCount &&
                (VALID_TYPES.contains(fixedValue.getFirst().getClass()) ||
                        QualityBase.class.isAssignableFrom(fixedValue.getFirst().getClass())))
        {
            this.values = (ArrayList<Object>) fixedValue;
            this.fixedValue = fixedValue.get(0);
        } else{
            System.out.println("ERROR IN CONSTRUCTOR");
            System.out.println(name + ": " + fixedValue.getFirst().getClass() + " " + valueCount);
            throw new InvalidInputException();
        }
    }

    public Object getFixedValue(){
        return fixedValue;
    }

}
