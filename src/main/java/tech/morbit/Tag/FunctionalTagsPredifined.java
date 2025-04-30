package tech.morbit.Tag;

import tech.morbit.Quality.ChangingValue;
import tech.morbit.Quality.ListValue;
import tech.morbit.Quality.Range;
import tech.morbit.Quality.RangedValue;

import java.util.*;

public class FunctionalTagsPredifined {
    static Set<FunctionalTag> functionalTags = new HashSet<>();

    public static Set<FunctionalTag> getFunctionalTagsPredifined() {
        if(functionalTags.isEmpty()){
            functionalTagsPredifinedDefine();
        }

        return functionalTags;
    }

    public static void addFunctionalTag(FunctionalTag tag) {
        functionalTags.add(tag);
    }
    public static void addFunctionalTags(List<FunctionalTag> tags) {
        functionalTags.addAll(tags);
    }

    public static void  functionalTagsPredifinedDefine(){
        functionalTags = Set.of(
                new FunctionalTag("Health", Set.of(int.class, double.class), Set.of(RangedValue.class)),
                new FunctionalTag("Experience" , Set.of(int.class, double.class), Set.of(RangedValue.class)),
                new FunctionalTag("Stamina" , Set.of(int.class, double.class), Set.of(RangedValue.class)),
                new FunctionalTag("Mana" , Set.of(int.class, double.class), Set.of(RangedValue.class)),
                new FunctionalTag("Sanity" , Set.of(int.class, double.class), Set.of(RangedValue.class)),
                new FunctionalTag("Money" , Set.of(int.class, double.class), Set.of(ChangingValue.class)),
                new FunctionalTag("StatusEffects", Set.of(ListValue.class)),
                new FunctionalTag("AttackRange", Set.of(int.class, double.class, boolean.class), Set.of(Range.class)),
                new FunctionalTag("Inventory", Set.of(ListValue.class))
        );
    }
}
