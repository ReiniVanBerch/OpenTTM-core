package tech.morbit.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalTagsPredifined {
    static ArrayList<FunctionalTag> functionalTags = new ArrayList<>();

    public static ArrayList<FunctionalTag> getFunctionalTagsPredifined() {
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

    public static void functionalTagsPredifinedDefine(){
        ArrayList<String> preset = new ArrayList<>(
            Arrays.asList(
                    "HP"
                    )


                );
    }
}
