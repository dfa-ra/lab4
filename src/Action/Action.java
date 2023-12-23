package Action;

import Actors.Actor;
import Actors.InfoHumane;
import LogHistory.FileLog;
import Place.*;
import java.util.ArrayList;
import java.util.List;

public class Action {
    protected String nameAction;
    protected Place place;
    protected String descriptionAction; //описание действия
    protected int maxActors;
    protected List<InfoHumane> actorsInAction = new ArrayList<>();

    public Action(String nameAction, String descriptionActoion, int maxActors, Place place){
        this.nameAction = nameAction;
        this.descriptionAction=descriptionActoion;
        this.maxActors = maxActors;
        this.place = place;
    }

    public void addActorsInAction(InfoHumane actor) {
        if (!actorsInAction.contains(actor) && actor.getPlace() == place)
            actorsInAction.add(actor);
    }

    public void startAction(){
        System.out.println("___________");
        System.out.println(place.getName() + ": началось действие " + nameAction + ": ");
        System.out.print("Участники: ");
        for (InfoHumane actor : actorsInAction) {
            if (actor == actorsInAction.getLast())
                System.out.print(actor.getName() + ".\n");
            else
                System.out.print(actor.getName() + ", ");
        }
        FileLog.writeLog("Началось действие " + nameAction + "\n\t Участники: " + String.valueOf(actorsInAction));
    }
    public void action(){
        System.out.println("действие не прописано");
    }
    public void endAction(){
        System.out.println(place.getName() + ": действие " + nameAction + " завершилось");
        System.out.println("-----------");
        FileLog.writeLog("Действие " + nameAction + " завершилось");
    }

    public List<InfoHumane> getActorsInAction() {
        return actorsInAction;
    }
}

