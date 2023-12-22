package Action.Greetings;

import Action.Action;
import Place.Place;

public class Bow extends Action {
    public Bow(String nameAction, String descriptionActoion, int maxActors, Place place) {
        super(nameAction, descriptionActoion, maxActors, place);
    }

    public void Bowing(){
        System.out.println("Совершён поклон");
    }
}
