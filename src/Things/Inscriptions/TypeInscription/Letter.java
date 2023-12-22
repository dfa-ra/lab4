package Things.Inscriptions.TypeInscription;

import Things.BufThing;
import Things.Inscriptions.Inscription;

public class Letter implements Inscription {

    protected String text;
    protected String name;
    public Letter(String name){
        this.name = name;
    }
    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getName() {
        return name;
    }
}
