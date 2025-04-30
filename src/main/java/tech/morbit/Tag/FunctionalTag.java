package tech.morbit.Tag;

import tech.morbit.Quality.Quality;

import java.util.Set;

public class FunctionalTag extends Tag {
    private Set<Class> validTypes;
    private Set<Class<? extends Quality>> validQualities;

    /**
     * FunctionalTags will have the oppurtunity to assign this a value or doing.
     * Some are going to be predefined.
     * They will only work, given the right types in both Quality and typing.
     * Some may take on multiple Types.
     * E.g. "HP" marks an Quality as the life of the character, takes in range, but can handle both int and double.
     */


    public FunctionalTag(String description){
        super(description);
        this.validTypes = Quality.getValidTypes();
        this.validQualities = Quality.getClassAndChildren();
    }

    public FunctionalTag(String description, Set<Class<? extends Quality>> validQualities){
        super(description);
        this.validTypes = Quality.getValidTypes();
        this.validQualities = validQualities;
    }

    public FunctionalTag(String description, Set<Class> validTypes, Set<Class<? extends Quality>> validQualities){
        super(description);
        this.validTypes = validTypes;
        this.validQualities = validQualities;
    }

    public Set<Class> getValidTypes() {return validTypes;}
    public void setValidTypes(Set<Class> validTypes) {this.validTypes = validTypes;}

    public Set<Class<? extends Quality>> getValidQualities() {return validQualities;}
    public void setValidQualities(Set<Class<? extends Quality>> validQualities) {this.validQualities = validQualities;}
}
