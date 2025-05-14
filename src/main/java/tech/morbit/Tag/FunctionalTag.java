package tech.morbit.Tag;

import tech.morbit.Quality.QualityBase;

import java.util.Set;

public class FunctionalTag extends Tag {
    private Set<Class> validTypes;
    private Set<Class<? extends QualityBase>> validQualities;

    /**
     * FunctionalTags will have the oppurtunity to assign this a value or doing.
     * Some are going to be predefined.
     * They will only work, given the right types in both Quality and typing.
     * Some may take on multiple Types.
     * E.g. "HP" marks an Quality as the life of the character, takes in range, but can handle both int and double.
     */


    public FunctionalTag(String description){
        super(description);
        this.validTypes = QualityBase.getValidTypes();
        this.validQualities = QualityBase.getClassAndChildren();
    }

    public FunctionalTag(String description, Set<Class<? extends QualityBase>> validQualities){
        super(description);
        this.validTypes = QualityBase.getValidTypes();
        this.validQualities = validQualities;
    }

    public FunctionalTag(String description, Set<Class> validTypes, Set<Class<? extends QualityBase>> validQualities){
        super(description);
        this.validTypes = validTypes;
        this.validQualities = validQualities;
    }

    public Set<Class> getValidTypes() {return validTypes;}
    public void setValidTypes(Set<Class> validTypes) {this.validTypes = validTypes;}

    public Set<Class<? extends QualityBase>> getValidQualities() {return validQualities;}
    public void setValidQualities(Set<Class<? extends QualityBase>> validQualities) {this.validQualities = validQualities;}
}
