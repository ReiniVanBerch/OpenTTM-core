package tech.morbit.Quality;

import tech.morbit.Tag.FunctionalTag;
import tech.morbit.Tag.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Quality {

    protected String name;
    protected ArrayList<Object> values;
    protected Set<Tag> tags = new HashSet<>();
    protected Set<FunctionalTag> functionalsTags = new HashSet<>();

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
}
