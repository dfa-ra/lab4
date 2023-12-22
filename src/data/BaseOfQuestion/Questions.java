package data.BaseOfQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Questions {
    private static List<String []> base = new ArrayList<>(){{
        add(new String[]{"Что было раньше курица или яйцо?", "Круг не имеет начала"});
        add(new String[]{"чему равно 5! ?", "120"});
        add(new String[]{"Сколько корней имеет уравнение x^4 + 20 = 101 в F_101?", "4"});
    }};

    public static String[] getQuestion(){
        return base.get((new Random()).nextInt(base.size()));
    }
}
