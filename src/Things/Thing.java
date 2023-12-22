package Things;

import Actors.Actor;
import Things.Inscriptions.Inscription;
import Things.Inscriptions.TypeInscription.Letter;
import Things.Phone.Phone;

import java.util.Objects;

public class Thing extends InfoAboutThing{
    BufThing thing;
    public Thing(String name, Actor actor, BufThing thing) {
        super(name, actor);
        this.thing = thing;
    }

    public BufThing getThing() {
        return thing;
    }

    public Letter toLetter(){
        if (thing instanceof Letter)
            return (Letter) thing;
        else {
            System.out.println("Это не письмо");
            return null;
        }
    }

    public Phone toPhone(){
        if (thing instanceof Phone)
            return (Phone) thing;
        else {
            System.out.println("Это не телефон");
            return null;
        }
    }
}
