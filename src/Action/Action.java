package Action;

import Actors.Actor;
import Actors.InfoHumane;
import LogHistory.FileLog;

import java.util.ArrayList;
import java.util.List;

public class Action {
    protected String nameAction;
    protected String descriptionAction; //описание действия
    protected int maxActors;
    protected List<InfoHumane> actorsInAction = new ArrayList<>();

    public Action(String nameAction, String descriptionActoion, int maxActors){
        this.nameAction = nameAction;
        this.descriptionAction=descriptionActoion;
        this.maxActors = maxActors;
    }

    public void addActorsInAction(InfoHumane actor) {
        if (!actorsInAction.contains(actor))
            actorsInAction.add(actor);
    }

    public void startAction(){
        System.out.println("-----------");
        System.out.println("Происходит действие " + nameAction + ": ");
        System.out.println("Участники " + String.valueOf(actorsInAction));
        FileLog.writeLog("Началось действие " + nameAction + "\n\t Участники: " + String.valueOf(actorsInAction));
    }

    public void endAction(){
        System.out.println("Действие " + nameAction + " завершилось");
        System.out.println("-----------");
        FileLog.writeLog("Действие " + nameAction + " завершилось");
    }

    public List<InfoHumane> getActorsInAction() {
        return actorsInAction;
    }
}

