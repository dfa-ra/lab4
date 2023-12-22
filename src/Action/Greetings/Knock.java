package Action.Greetings;

import Action.Action;

public class Knock extends Action {


    public Knock(String nameAction, String descriptionActoion, int maxActors) {
        super(nameAction, descriptionActoion, maxActors);
    }

    public void Knocking(){
        System.out.println("'Стук стук'");
    }
}