package tech.morbit.Tag;

import tech.morbit.Quality.Quality;

import java.util.Set;

public class FunctionalTag extends Tag {
    private String description;;

    /**
     * FunctionalTags will have the oppurtunity to assign this a value or doing.
     * Some are going to be predefined.
     * They will only work, given the right types in both Quality and typing.
     * Some may take on multiple Types.
     * E.g. "HP" marks an Quality as the life of the character, takes in range, but can handle both int and double.
     */

    private final Set<Class<?>> VALID_TYPES = Set.of(
            Boolean.class,
            Integer.class,
            Double.class,
            String.class,
            Quality.class
    );

    public FunctionalTag(String description){
        super(description);
    }


}
