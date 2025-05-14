package tech.morbit.Presets;

import tech.morbit.Quality.QualityBaseValueChanging;
import tech.morbit.Quality.QualityBaseList;
import tech.morbit.Quality.QualityBaseRange;
import tech.morbit.Quality.QualityBaseRangeValue;
import tech.morbit.Tag.FunctionalTag;

import java.util.*;

public class FunctionalTagsPresets {
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
                new FunctionalTag("Health", Set.of(int.class, double.class), Set.of(QualityBaseRangeValue.class)),
                new FunctionalTag("Experience" , Set.of(int.class, double.class), Set.of(QualityBaseRangeValue.class)),
                new FunctionalTag("Stamina" , Set.of(int.class, double.class), Set.of(QualityBaseRangeValue.class)),
                new FunctionalTag("Mana" , Set.of(int.class, double.class), Set.of(QualityBaseRangeValue.class)),
                new FunctionalTag("Sanity" , Set.of(int.class, double.class), Set.of(QualityBaseRangeValue.class)),
                new FunctionalTag("Money" , Set.of(int.class, double.class), Set.of(QualityBaseValueChanging.class)),
                new FunctionalTag("StatusEffects", Set.of(QualityBaseList.class)),
                new FunctionalTag("AttackRange", Set.of(int.class, double.class, boolean.class), Set.of(QualityBaseRange.class)),
                new FunctionalTag("Inventory", Set.of(QualityBaseList.class))
        );
    }
}
