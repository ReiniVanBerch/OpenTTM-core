package tech.morbit.Features;

import java.util.ArrayList;

public class TurnTracker {
    /**The turntracker tries to implement a structure wher it can be noted whose turn it currently is.
     * This might be useful for dnd combat, or a simple round of catan.
     *
     */

    private ArrayList<Object> entities;

    public TurnTracker() {
        entities = new ArrayList<>();
    }

    public TurnTracker(ArrayList<Object> entities) {
        this.entities = entities;
    }

    public ArrayList<Object> getEntities() {return entities;}
    public Object getEntity(int index) {return entities.get(index);}
    public Object getcurrent(){return entities.getFirst();}

    public void setEntities(ArrayList<Object> entities) {this.entities = entities;}

    public void add(Object entity) {entities.add(entity);}

    public void remove(Object entity) {entities.remove(entity);}
    public void remove(int index) {entities.remove(index);}
    public void removeAll(ArrayList<Object> entities) {this.entities.removeAll(entities);}
    public void clear() {entities.clear();}


    public void takeTurn(){
        Object entity = entities.getFirst();
        entities.remove(0);
        entities.add(entity);
    }

    public void undoTurn(){
        Object entity = entities.getLast();
        entities.remove(entity);
        entities.add(0, entity);
    }

    public void switchTurn(Object a, Object b){
        int indexA = entities.indexOf(a);
        int indexB = entities.indexOf(b);


        if(indexA != -1 && indexB != -1){
            entities.remove(indexA);
            entities.remove(indexB-1);
            if(indexA < indexB){
                entities.add(indexA, b);
                entities.add(indexB, a);
            }
            else{
                entities.add(indexB, a);
                entities.add(indexA, b);
            }
        }
    }
}
