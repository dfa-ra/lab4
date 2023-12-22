package Scene;

import Actors.InfoHumane;
import LogHistory.FileLog;
import Place.Place;
import Things.Inscriptions.TypeInscription.Letter;
import Things.Phone.Phone;
import Things.Phone.TypePhone.PhoneOS;
import Things.Thing;
import TypeEnum.FieldObj;

import java.util.ArrayList;
import java.util.HashMap;


public class Scene{

    public Place nowScene;
    protected HashMap<String, InfoHumane> Characters = new HashMap<>();
    public void addPerson(String name, InfoHumane pers){ // <? extends Actor> WildCards
        Characters.put(name, pers);
    }

    public void CreateScene(){
        Place world = new Place("Мир", 100, 100);
        world.new FieldObjects(FieldObj.TREE, 2, 4);
        world.new FieldObjects(FieldObj.SHRUB, 2, 11);
        world.new FieldObjects(FieldObj.SHRUB, 2, 12);
        world.new FieldObjects(FieldObj.SHRUB, 2, 13);

        world.addActor(Characters.get("Alisa"), 20, 20);
        world.addActor(Characters.get("Лакей"), 1, 9);

        Place house = new Place("Дом", 10, 10);
        house.new FieldObjects(FieldObj.TABLE, 3, 1);
        house.setPosition(1, 10);
        house.addActor(Characters.get("Швейцар"), 4, 2);
        house.setParent(world);
        world.addPlace("Дом",house);

        Place forest = new Place("Лес", 100, 100);
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (Math.random()*100 < 50){
                    forest.new FieldObjects(FieldObj.TREE, i, j);
                }
            }
        }
        forest.setPosition(50, 50);
        forest.setParent(world);
        world.addPlace("Лес" ,forest);
        nowScene = world;
    }
    public void GoToPlace(String name){
        nowScene = nowScene.goPlace(name);
    }
    public void GoBack(){
        nowScene = nowScene.getParent();
    }

    public void startScene() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Characters.get("Alisa").getIQ();
        Characters.get("Швейцар").getIQ();
        Characters.get("Alisa").Speak("Привет меня зовут Алиса я очень хорошая девочка", Characters.get("Швейцар"), 3);
        Characters.get("Alisa").tryUpIQ();
        FileLog.closeLog();
        //        Thing thing = new Thing("IPhone", null, new PhoneOS("13 pro"));

//        Thing thing2 = new Thing("Letter", null, new Letter("Pis'mo"));
//
//        thing.toPhone().Call();
//        System.out.println(thing2.isPhone());





//        CreateScene();
//        Characters.get("Швейцар").goBackPlace(1, 11);
//        Characters.get("Alisa").setEmotions(Humane.Emotions.INTEREST);
//        Characters.get("Alisa").Move(3, 11);
//        int time = (int) ((System.currentTimeMillis()));
//        Characters.get("Лакей").Speak( Characters.get("Лакей").getAllThings().get("Письмо").toLetter().getText(), Characters.get("Швейцар"), time);
//        Characters.get("Швейцар").Speak(Characters.get("Швейцар").getMemory().get(time).get(Humane.TypeMemory.WHATWASSAID).getFirst());
//        Bow bow = new Bow("Поклон", "Поклон нескольких человек", 2);
//        bow.addActorsInAction(Characters.get("Лакей"));
//        bow.addActorsInAction(Characters.get("Швейцар"));
//        bow.startAction();
//        bow.Bowing();
//        Characters.get("Alisa").goNextPlace("Лес", 10, 10);
//        Characters.get("Alisa").setEmotions(Humane.Emotions.LOUD_LAUGHTER);
//        bow.endAction();
//        Characters.get("Лакей").goNextPlace("Дом", 1, 1);
//        Characters.get("Alisa").setEmotions(Humane.Emotions.WITHOUT_EMOTIONS);
//        Characters.get("Alisa").goBackPlace(3, 11);
//        Characters.get("Alisa").Move(2, 10);
//        Knock knock = new Knock("Стук в дверь", "Постучать в дверь", 1);
//        knock.addActorsInAction(Characters.get("Alisa"));
//        knock.startAction();
//        knock.Knocking();
//
//
//        Characters.get("Швейцар").Speak("Стучать нет никакого смысла, барышня, по двум существенным причинам. \n" +
//                "Первое: я за дверью и вы за дверью, и вдобавок мы оба снаружи. \n" +
//                "Второе: они там так шумят, что никто вашего стука не слышит. Не так ли?", Characters.get("Alisa"), (int) ((System.currentTimeMillis())));
//        knock.endAction();
//        Characters.get("Alisa").Speak("Извините, а как же мне тогда попасть в дом?", Characters.get("Швейцар"), (int) ((System.currentTimeMillis())));
//        Characters.get("Швейцар").Speak("Кое-какой смысл стучать мог бы еще быть если бы эта дверь нас разделяла. Пример. Вы, барышня, находитесь в доме. Я нахожусь здесь. Вы стучите. Я отворяю вам дверь. Вы выходите. И вот вы тоже снаружи. Не так ли?");
//        FileLog.closeLog();
    }
}
