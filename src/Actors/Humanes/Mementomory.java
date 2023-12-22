package Actors.Humanes;

import Scene.*;

import java.util.*;


public interface Mementomory {
    default void AddMemory(String oldText, Humane.TypeMemory typeMemory, HashMap<Integer, HashMap<Humane.TypeMemory, List<String>>> memory, String names, int time, int IQ){
        String text;
        Convert convert = x -> {
            if (x >= 60)
                return 0;
            else if (x > 40 && x < 60)
                return 1;
            else if (x > 20 && x <= 40)
                return 2;
            else
                return 3;
        };

        text = shaffleText(oldText, convert.convert(IQ));
        if (memory.get(time) == null)
            memory.put(time, new HashMap<>() {{
                put(typeMemory, new ArrayList<>(){{
                    add(text);
                    add(names);
                }});
            }});
        else if (memory.get(time).get(typeMemory) == null) {
            memory.get(time).put(typeMemory, new ArrayList<>(){{
                add(text);
                add(names);
            }});
        } else {
            memory.get((int) System.currentTimeMillis()).get(typeMemory).add(text);
            memory.get((int) System.currentTimeMillis()).get(typeMemory).add(names);
        }
    }
    private String shaffleText(String oldText, int x){
        List<String> myList = new ArrayList<String>(Arrays.asList(oldText.split(" ")));
        String text = "";
        for (int i = 0; i < x; i++) {
            int id1 = (new Random()).nextInt(myList.size());
            int id2 = (new Random()).nextInt(myList.size());
            String tmp;
            tmp = myList.get(id1);
            myList.set(id1, myList.get(id2));
            myList.set(id2, tmp);
        }
        for (String s : myList) {
            text = text + s + " ";
        }
        return text;
    }
    @FunctionalInterface
    public interface Convert{
        int convert(int x);
    }
}
