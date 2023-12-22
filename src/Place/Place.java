package Place;

import Actors.Actor;
import Actors.InfoHumane;
import Exeptions.InvalidPlaceExceptoin;
import Exeptions.InvalidPositionException;
import Things.*;
import TypeEnum.FieldObj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Place {

    protected List<InfoHumane> actorsInside = new ArrayList<>();
    protected List<FieldObjects> fieldObjects = new ArrayList<>();
    protected HashMap<String, Place> placeInside = new HashMap<>();
    protected List<Thing> thingsInside = new ArrayList<>();
    private Place parent;
    private int [] position = new int[2];
    String name;
    //String [][] field;

    public Place (String name, int x, int y){
        this.name = name;
//        field = new String[x][y];
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }

    public void addPlace(String name, Place place){
        placeInside.putIfAbsent(name, place);
    }
    public Place goPlace(String name){
        try {
            isPlaceHere(name);
            return placeInside.get(name);
        }catch (InvalidPlaceExceptoin e){
            System.out.println("Ошибка: " + e.getMessage());
            return null;
        }
    }

    public HashMap<String, Place> getPlaceInside() {
        return placeInside;
    }

    public void isPlaceHere(String name) throws InvalidPlaceExceptoin{
        if (placeInside.get(name) == null)
            throw new InvalidPlaceExceptoin("Такого пространства в данном месте не сущесттвует");
    }
    public void addActor(InfoHumane actor, int x, int y){
        if (!actorsInside.contains(actor)) {
            actorsInside.add(actor);
            actor.setPositionInPlace(new int[]{x, y});
            actor.setPlace(this);
        }
    }
    public void delActor(InfoHumane actor){
        actorsInside.remove(actor);
    }
    public void setParent(Place parent) {
        this.parent = parent;
    }
    public Place getParent() {
        return parent;
    }

    public List<Thing> getThingsInside() {
        return thingsInside;
    }

    public void addThingsInside(Thing thingsInside) {
        this.thingsInside.add(thingsInside);
        thingsInside.setPlace(this);
    }

    private void setFieldObjects(FieldObjects fieldObjects) {
        this.fieldObjects.add(fieldObjects);
//        field[fieldObjects.position[0]][fieldObjects.position[1]] = String.valueOf(fieldObjects.fieldObj.value);
    }

    public void DrawPlace(){
        System.out.println("------------------------");
        System.out.println("Место под названием " + name);
        System.out.println("В данный момент в этом месте находятся: ");
        System.out.println("\t объекты: "+ String.valueOf(fieldObjects));
        System.out.println("\t вещи: "+ String.valueOf(fieldObjects));
        System.out.println("\t атёры: "+ String.valueOf(actorsInside));
        System.out.println("\t входы в другие места: "+ String.valueOf(placeInside));
        System.out.println("------------------------");
    }
    public class FieldObjects{
        FieldObj fieldObj;
        int [] position = new int[2];
        public FieldObjects(FieldObj fieldObj, int x, int y){
            this.fieldObj = fieldObj;
            position[0] = x-1;
            position[1] = y-1;
            try {
                IsOccupied();
            }catch (InvalidPositionException e){
                System.out.println("Ошибка " + e.getMessage());
            }
        }
        private void IsOccupied() throws InvalidPositionException {
            for (FieldObjects fieldObject : fieldObjects) {
                if (fieldObject.fieldObj == this.fieldObj && fieldObject.position[0] == this.position[0]
                        && fieldObject.position[1] == this.position[1])
                    throw new InvalidPositionException("Это место (" + String.valueOf(this.position[0]) +
                            String.valueOf(this.position[1]) + ") уже занято другим объектом");
            }
            setFieldObjects(this);
        }

        @Override
        public String toString() {
            return "FieldObjects{" +
                    "fieldObj=" + fieldObj +
                    ", position=" + Arrays.toString(position) +
                    '}';
        }
    }
}


//    public void FieldApdate(){
//        ZeroField(field.length, field[0].length);
//        for (int i = 0; i < actorsInside.size(); i++) {
//            field[actorsInside.get(i).getPositionInPlace()[0]][actorsInside.get(i).getPositionInPlace()[1]] = "A";
//        }
//        for (int i = 0; i < fieldObjects.size(); i++) {
//            field[fieldObjects.get(i).position[0]][fieldObjects.get(i).position[1]]  = String.valueOf(fieldObjects.get(i).fieldObj.value);
//        }
//        for (Place value : placeInside.values()) {
//            if (value.getPosition() != null)
//                field[value.getPosition()[0]][value.getPosition()[1]] = value.name;
//        }
//    }
//    private void ZeroField(int x, int y){
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < y; j++) {
//                field[i][j] = "0";
//            }
//        }
//    }
//    public void DrawPlace(){
//        FieldApdate();
//        System.out.println("-----------");
//        System.out.println("Place - "+ name);
//        for (int i = 0; i < field.length; i++) {
//            for (int j = 0; j < field[i].length; j++) {
//                System.out.print(field[i][j] + "        ");
//            }
//            System.out.println();
//        }
//        System.out.println("-----------");
//    }
