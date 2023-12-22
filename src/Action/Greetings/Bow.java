package Action.Greetings;

import Action.Action;

public class Bow extends Action {
    public Bow(String nameAction, String descriptionAction, int maxActors) {
        super(nameAction, descriptionAction, maxActors);
    }
    public void Bowing(){
        System.out.println("Совершён поклон");
    }
}
