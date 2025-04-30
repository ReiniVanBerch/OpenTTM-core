package tech.morbit.Tag;

public class Tag {
    protected String description;;

    public Tag(String description){
        if(!description.trim().isEmpty()){
            this.description = description.trim();
        } else{
            throw new NullPointerException("Text is empty");
        }
    }


    public String getDescription() {return this.description;}

}
