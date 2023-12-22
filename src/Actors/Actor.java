package Actors;

import Exeptions.InvalidPlaceExceptoin;
import LogHistory.FileLog;
import Place.Place;
import Things.*;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;

public abstract class Actor {
    protected ActionRightNow actionRightNow = ActionRightNow.STAY;
    protected Place place;
    protected int[] positionInPlace;
    protected Gender gender;
    protected HashMap<String, Thing> things = new HashMap<>();
    protected int age;

    public Actor(int age, Gender gender){
        this.age = age;
        this.gender = gender;
    }

    public void setThings(String things, Thing thing){
        this.things.put(things, thing);
    }
    public HashMap<String, Thing>  getAllThings(){
        return things;
    }
    public Thing takeThing (String things){
        Thing tmp = this.things.get(things);
        this.things.remove(things);
        return tmp;
    }
    public void nextAge() {
        this.age += 1;
    }

    public void setActionRightNow(ActionRightNow actionRightNow) {
        this.actionRightNow = actionRightNow;
    }
    public ActionRightNow getActionRightNow() {
        return actionRightNow;
    }
    public int getAge() {
        return age;
    }
    public Gender getGender() {
        return gender;
    }

    public Place getPlace() {
        return place;
    }


    public void setPlace(Place place) {
        this.place = place;
    }

    public void goNextPlace(String name, int x, int y) throws InvalidPlaceExceptoin{
        place.delActor((InfoHumane) this);
        place = place.goPlace(name);
        place.addActor((InfoHumane) this, x, y);
        FileLog.writeLog(this + " переместился в место под названием  '" + name + "' в координаты x=" + String.valueOf(x) +
                "y=" + String.valueOf(y));
    }
    public void goBackPlace(int x, int y){
        place.delActor((InfoHumane) this);
        place = place.getParent();
        place.addActor((InfoHumane) this, x, y);
        FileLog.writeLog(this + "  вышел из этого места в координаты x=" + String.valueOf(x) +
                "y=" + String.valueOf(y));
    }
    public void Move(int x, int y){
        positionInPlace[0]=x;
        positionInPlace[1]=y;
        FileLog.writeLog(this + " переместился в координаты x=" + String.valueOf(x) +
                "y=" + String.valueOf(y));
    }

    public void setPositionInPlace(int[] positionInPlace) {
        this.positionInPlace = positionInPlace;
    }

    public int[] getPositionInPlace() {
        return positionInPlace;
    }


    public enum Gender {
        FEMALE,
        MALE
    }
    public enum ActionRightNow {
        STAY,
        RUN,
        BOW,
        WALK,
        SWIMM
    }
}
