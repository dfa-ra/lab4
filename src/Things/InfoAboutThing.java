package Things;

import Actors.Actor;
import Place.Place;

public abstract class InfoAboutThing {
    protected Place place;
    protected String name;
    protected Actor owner;
    public InfoAboutThing(String name, Actor actor){
        this.owner = actor;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPlace(Place place) {
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

    public Actor getOwner() {
        return owner;
    }

}
