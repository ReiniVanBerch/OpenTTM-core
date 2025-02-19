package tech.morbit.Quality;

import tech.morbit.Exception.InvalidInputException;

import java.util.ArrayList;

/**
 * @author V. Berchtold
 * @version 0.1.2
 *
 * PURPOSE:
 * The purpose of this is to handle a range.
 * As the upper bound needs to be larger than the lower.
 *
 * TODO:
 * The errors need to be displayed somewhere, where? idk, please help.
 *
 */

public class Range extends Quality {

    final public int valueCount = 2;

    private Object lowerBound, upperBound;

    public <T> Range(String comment, ArrayList<T> range) throws InvalidInputException {
        super(comment);

        if(range.size() == this.valueCount &&
                (VALID_TYPES.contains(range.getFirst().getClass()) ||
                    Quality.class.isAssignableFrom(range.getFirst().getClass())))
        {
            this.values = (ArrayList<Object>) range;
            this.lowerBound = range.get(0);
            this.upperBound = range.get(1);
        } else{
            System.out.println(name + ": " + values.getFirst().getClass() + " " + valueCount);
            throw new InvalidInputException();
        }

    }


/*
    public boolean checkValues(Comparable lowerBound, Comparable upperBound){
        try{
            if(lowerBound.compareTo(upperBound) >= 0 ){

                return true;
            }
            else{
                throw new InvalidInputException("The lower bound is not equal or greater than the upper bound.");
            }
        } catch (InvalidInputException e){

            //
            //INVALID INPUT FOR
            //

            return false;
        }
    }


    public Object getLowerBound(){return this.lowerBound;}
    public Object getUpperBound(){return this.upperBound;}

    public void setLowerBound(Comparable lowerBound){
        if(checkValues(lowerBound, this.upperBound)){
            this.lowerBound = lowerBound;
        }
    }

    public void setUpperBound(Comparable upperBound){
        if(checkValues(this.lowerBound, upperBound)){
            this.upperBound = upperBound;
        }
    }
    */
}
