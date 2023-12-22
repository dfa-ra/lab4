package Things.Phone.TypePhone;

import Things.BufThing;
import Things.Phone.Phone;

import java.util.concurrent.Phaser;

public class PhoneOS implements Phone {
    protected String name;

    public PhoneOS(String name){
        this.name = name;
    }
    @Override
    public void Call() {
        System.out.println("Звонит");
    }

    @Override
    public String getName() {
        return null;
    }

}
