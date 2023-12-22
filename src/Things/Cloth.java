package Things;

import Actors.Actor;
import Things.Clothes.BufCloth;
import Things.InfoAboutThing;

public class  Cloth extends InfoAboutThing {
    protected BufCloth bufCloth;

    public Cloth(String name, Actor actor, BufCloth bufCloth) {
        super(name, actor);
        this.bufCloth = bufCloth;
    }

}
