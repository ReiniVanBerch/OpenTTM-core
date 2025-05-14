package tech.morbit.Quality;

import tech.morbit.Exception.InvalidInputException;

import java.util.ArrayList;


/**
 * @author V. Berchtold
 * @version 0.1.1
 *
 *
 * The purpose of this is to handle a Value in a range, including both bounds.
 * As the value needs between the two, all three values need to be comparable.
 *
 * TODO:
 * The errors need to be displayed somewhere, where? idk, please help.
 *
 */

public class QualityBaseRangeValue extends QualityBase {

    final public int valueCount = 3;

    private Object lowerBound, upperBound, value;

    public <T> QualityBaseRangeValue(String name, ArrayList<T> rangedValue) throws InvalidInputException {
        super(name);

        if(rangedValue.size() == this.valueCount &&
            (VALID_TYPES.contains(rangedValue.getFirst().getClass()) ||
                QualityBase.class.isAssignableFrom(rangedValue.getFirst().getClass())))
        {
            this.values = (ArrayList<Object>) rangedValue;
            this.lowerBound = rangedValue.get(0);
            this.upperBound = rangedValue.get(1);
            this.value = rangedValue.get(2);
        } else{
            System.out.println(name + ": " + rangedValue.getFirst().getClass() + " " + valueCount);
            throw new InvalidInputException();
        }

    }

    public boolean checkValues(Object lowerBound, Object upperBound, Object value){

        if( lowerBound instanceof Comparable &&
            upperBound instanceof Comparable &&
            value instanceof Comparable<?>
        ) {
            Comparable lb = (Comparable) lowerBound;
            Comparable ub = (Comparable) upperBound;
            Comparable vl = (Comparable) value;

            if(lb.compareTo(ub) >= 0 ){

                if(vl.compareTo(lb) >= 0 && vl.compareTo(ub) <= 0){
                    return true;
                }
            }
        }

        return false;
    }


    public boolean checkValues(){
        return  checkValues(this.lowerBound, this.upperBound, this.value);
    }

    public boolean checkAndSafeValues(Object lowerBound, Object upperBound, Object value){
        boolean check = checkValues(lowerBound, upperBound, value);
        if(check){
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.value = value;
        }
        return check;
    }

    public Object getLowerBound(){return this.lowerBound;}
    public Object getUpperBound(){return this.upperBound;}
    public Object getValue(){return this.value;}

    public void setLowerBound(Object lowerBound){
        if(checkValues(lowerBound, this.upperBound, this.value)){
            this.lowerBound = lowerBound;
        }
    }

    public void setUpperBound(Object upperBound){
        if(checkValues(this.lowerBound, upperBound, this.value)){
            this.upperBound = upperBound;
        }
    }

    public void setValue(Object value){
        if(checkValues(this.lowerBound, this.upperBound, value)){
            this.value = value;
        }
    }

}
