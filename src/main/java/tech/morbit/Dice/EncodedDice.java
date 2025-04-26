package tech.morbit.Dice;

import java.util.ArrayList;

public class EncodedDice extends Dice{

    ArrayList<String> names = new ArrayList<>();


    public EncodedDice(int numDice, int sides, ArrayList<String> names) {
        super(numDice, sides);
        this.names = names;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public String singleRollName(){
        int res = singleRoll();
        try{
            return names.get(res);
        }
        catch(IndexOutOfBoundsException e){
            return "";
        }
    }
}
