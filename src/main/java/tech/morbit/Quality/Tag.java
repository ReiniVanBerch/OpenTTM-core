package tech.morbit.Quality;

public class Tag {
    private String text;
    private boolean functional = false;

    public Tag(String text){
        this.text = text;
    }

    public Tag(String text, boolean functional){
        this(text);
        this.functional = functional;
    }

    public String getText() {return this.text;}
    public boolean getFunctional() {return this.functional;}
}
