package tech.morbit.Tag;

public class Tag {
    protected String name;
    protected String icon;

    public Tag(String name){
        icon = "";
        if(!name.trim().isEmpty()){
            this.name = name.trim();
        } else{
            throw new NullPointerException("Text is empty");
        }
    }


    public String getName() {return this.name;}

    public String getIcon() {return this.icon;}
    public void setIcon(String icon) {this.icon = icon;}
}
