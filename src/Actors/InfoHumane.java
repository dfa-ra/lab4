package Actors;

import Action.Action;
import Actors.Humanes.Humane;
import Exeptions.InvalidPlaceExceptoin;
import LogHistory.FileLog;
import Place.Place;
import Things.Cloth;
import Things.Thing;
import TypeEnum.Cloth.Outerwear.TypeOuterwearCloth;

import java.util.HashMap;
import java.util.List;

public interface InfoHumane  {
    void setThings(String things, Thing thing);
    HashMap<String, Thing> getAllThings();
    Thing takeThing (String things);
    Thing getThing(String name);
    void nextAge();
    int getAge();
    void setActionRightNow(Actor.ActionRightNow actionRightNow);
    Actor.ActionRightNow getActionRightNow();
    Actor.Gender getGender();
    Place getPlace();
    void goBackPlace(int x, int y);
    void setPlace(Place place);
    void goNextPlace(String name, int x, int y) throws InvalidPlaceExceptoin;
    void Move(int x, int y);
    void setPositionInPlace(int[] positionInPlace);
    int[] getPositionInPlace();

    String getName();
    void setRank(Humane.Rank rank);

    Humane.Rank getRank();
    void tryUpIQ();
    int getIQ();

    void addInvite(String time, Action action);
    HashMap<String, Action> getInvite();

    void setEmotions(Humane.Emotions emotions);
    HashMap<TypeOuterwearCloth, Cloth> getCloth();

    void Speak(String text);
    void Speak(String text, InfoHumane companion, int time);
    void Sneeze();
    HashMap<Integer, HashMap<Humane.TypeMemory, List<String>>> getMemory();
    void AddMemory(String text, Humane.TypeMemory typeMemory, HashMap<Integer, HashMap<Humane.TypeMemory, List<String>>> memory, String names, int time, int IQ);
}
