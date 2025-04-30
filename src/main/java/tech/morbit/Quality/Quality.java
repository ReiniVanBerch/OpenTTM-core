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


public abstract class Quality {

    static final protected int valueCount = 0;

    protected static final Set<Class> VALID_TYPES = Set.of(
            Boolean.class,
            Integer.class,
            Double.class,
            String.class,
            Quality.class
    );

    protected static final Set<Class<? extends Quality>> CLASS_AND_CHILDREN = Set.of(
        Quality.class,
        RangedValue.class,
        Range.class,
        ChangingValue.class,
        FixedValue.class,
        ListValue.class
    );

    protected String name;
    protected ArrayList<Object> values;
    protected Set<Tag> tags = new HashSet<>();
    protected Set<FunctionalTag> functionalsTags = new HashSet<>();



    public Quality(String name)  {
        this.name = name;
    }

    public Quality(
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


    public Class<? extends Quality> getQuality(){return this.getClass();}

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
    public Set<Tag> getTags(){return this.tags;}
    public void setTags(Set<Tag> tags){this.tags = tags;}
    public void addTag(Tag tag){this.tags.add(tag);}
    public void addTags(ArrayList<Tag> tags){this.tags.addAll(tags);}
    public void removeTag(Tag tag){this.tags.remove(tag);}
    public void removeTags(ArrayList<Tag> tags){
        for(Tag tag : tags){this.tags.remove(tag);}
    }

    public Set<FunctionalTag> getFunctionalTags(){return this.functionalsTags;}
    public void setFunctionalsTags(Set<FunctionalTag> functionalTags){this.functionalsTags = functionalsTags;}
    public void addFunctionalTag(FunctionalTag functionalTag){functionalsTags.add(functionalTag);}
    public void addFunctionalTAgs(ArrayList<FunctionalTag> functionalTags){this.functionalsTags.addAll(functionalTags);}
    public void removeFunctionalTag(FunctionalTag functionalTag){functionalsTags.remove(functionalTag);}
    public void removeFunctionalTags(ArrayList<FunctionalTag> functionalTags){
        for(FunctionalTag functionalTag : functionalTags){this.functionalsTags.remove(functionalTag);}
    }

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

    public static <T extends Quality> Set<Class<? extends Quality>> getClassAndChildren(){
        return CLASS_AND_CHILDREN;
    }

    public static <T extends Quality> Set<Class> getValidTypes(){
        return  VALID_TYPES;
    }
}
