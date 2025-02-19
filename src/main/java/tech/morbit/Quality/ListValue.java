package tech.morbit.Quality;

/**
 * @author Morbit
 * @version 0.1.1
 *
 * PURPOSE:
 * this is for lists of values. Via tba features this will be able to turned into a die.
 *
 * EXAMPLES:
 * Loot-pools, a simple inventory, languages spoken, damage poools, etc.
 */

import tech.morbit.Exception.InvalidInputException;

import java.util.ArrayList;

public class ListValue extends Quality{

    final public int valueCount = Integer.MAX_VALUE;

    private ArrayList list;

    public <T> ListValue(String comment, ArrayList<T> list) throws InvalidInputException {
        super(comment);

        if(VALID_TYPES.contains(list.getFirst().getClass()) ||
                Quality.class.isAssignableFrom(list.getFirst().getClass())){
            this.values = (ArrayList<Object>) list;
            this.list = list;
        } else{
            System.out.println(name + ": " + list.getFirst().getClass() + " " + valueCount);
            throw new InvalidInputException();
        }
    }

    public <T> ArrayList getList(){
        return list;
    }

    public <T> void setList(ArrayList<T> list){
        if(this.getClass().equals(list.getClass())){
            this.list = list;
        }
    }


}
