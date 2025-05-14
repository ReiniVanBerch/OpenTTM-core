package tech.morbit.Quality;

import tech.morbit.Exception.InvalidInputException;
import tech.morbit.Tag.FunctionalTag;
import tech.morbit.Tag.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Morbit
 * @version 0.1.9
 *
 * RECENTLY:
 * Added an toString
 *
 * PURPOSE:
 * Mother of the other qualities and helps regulate the handling of these
 * via defining things for the rest, while the rest gain extra handlers, as the data
 * of the different qualities is stored twice, once in the values list as in here
 * as well as there respective properties in their own classes.
 *
 */


public abstract class QualityBase extends Quality {

    static final protected int valueCount = 0;

    protected static final Set<Class> VALID_TYPES = Set.of(
            Boolean.class,
            Integer.class,
            Double.class,
            String.class,
            QualityBase.class
    );

    protected static final Set<Class<? extends QualityBase>> CLASS_AND_CHILDREN = Set.of(
        QualityBase.class,
        QualityBaseRangeValue.class,
        QualityBaseRange.class,
        QualityBaseValueChanging.class,
        QualityBaseValueFixed.class,
        QualityBaseList.class
    );

    protected String name;
    protected ArrayList<Object> values;
    protected Set<Tag> tags = new HashSet<>();
    protected Set<FunctionalTag> functionalsTags = new HashSet<>();



    public QualityBase(String name)  {
        this.name = name;
    }

    public QualityBase(
        String name,
        ArrayList<Object> values,
        ArrayList<Tag> tags) throws InvalidInputException {
            this(name);
            this.tags.addAll(tags);

            Class clazz = values.getClass();
            if (!VALID_TYPES.contains(clazz)) {
                throw new InvalidInputException("Invalid type: " + clazz.getSimpleName());
            } else {
                this.setValues(values);
            }
    }

    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}

    static public int getValueCount(){return valueCount;}


    public Class<? extends QualityBase> getQuality(){return this.getClass();}

    public ArrayList<Object> getValues(){return this.values;}
    public Class getTypeOfValues(){
        return this.getValues().get(0).getClass();
    }
    public <T> void setValues(ArrayList<T> values) throws InvalidInputException {
        if(values.size() == valueCount){
            this.values = (ArrayList<Object>) values;
        } else{ throw new InvalidInputException("Invalid number of values"); }
    }

    //Tagging




    //Strings
    public String getValuesAsString(){
        String output = "";
        for(Object value : this.values){
            output += value.toString() +"; ";
        }
        output = output.substring(0,output.length()-1);
        return output;
    }
    @Override
    public String toString()
    {
        return this.name+ ": " + getValuesAsString();
    }

    public static <T extends QualityBase> Set<Class<? extends QualityBase>> getClassAndChildren(){
        return CLASS_AND_CHILDREN;
    }

    public static <T extends QualityBase> Set<Class> getValidTypes(){
        return  VALID_TYPES;
    }
}
