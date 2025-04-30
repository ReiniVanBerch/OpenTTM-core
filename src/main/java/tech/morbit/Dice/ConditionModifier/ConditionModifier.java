package tech.morbit.Dice.ConditionModifier;


public abstract class ConditionModifier<T extends Comparable<T>> implements Comparable<ConditionModifier<T>> {

    protected T target;
    public abstract boolean check(T roll);

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }

    @Override
    public int compareTo(ConditionModifier o) {
        return o.target.compareTo(this.target);
    }
}
