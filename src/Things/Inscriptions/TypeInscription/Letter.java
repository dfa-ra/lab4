package Things.Inscriptions.TypeInscription;

import Exeptions.InvalidIndexWordException;
import Things.Inscriptions.Inscription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void delText(int hmWords){
        class Eraser{
            public void delText(int hmWords){

                List<String> myList = new ArrayList<String>(Arrays.asList(text.split(" ")));
                System.out.println(myList);
                if (hmWords > myList.size())
                    throw new InvalidIndexWordException("вы хотите стереть больше чем это возможно");
                for (int i = 0; i < hmWords; i++) {

                    if (myList.isEmpty()) {

                    }
                    else {
                        System.out.println(myList);
                        System.out.println(i);
                        myList.removeLast();
                    }
                }
                text = "";
                for (String s : myList) {
                    text = text + s + " ";
                }
            }
        }

        Eraser eraser = new Eraser();

        eraser.delText(hmWords);
    }
}
