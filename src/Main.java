import Actors.Actor;
import Actors.Humanes.Humane;
import Actors.Humanes.Person.HAnimal;
import Actors.Humanes.Person.Human;
import Actors.InfoHumane;
import Exeptions.InvalidPlaceExceptoin;
import Scene.*;
import Things.Cloth;
import Things.Clothes.Colors.*;
import Things.Clothes.State.ClearDecorator;
import Things.Clothes.State.DirtyDecorator;
import Things.Clothes.State.NewDecorator;
import Things.Clothes.State.OldDecorator;
import Things.Clothes.TypeClothes.*;
import Things.Inscriptions.Inscription;
import Things.Inscriptions.TypeInscription.Letter;
import Things.Thing;
import TypeEnum.Cloth.Outerwear.TypeOuterwearCloth;

import TypeEnum.HairStyle.HairStyle;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Main {
    public static void main(String[] args) throws InvalidPlaceExceptoin {
        Human Alisa = new Human("Alisa", Humane.Rank.NORMAL, HairStyle.ANY,
                new HashMap<>(){{
                    put(TypeOuterwearCloth.FORTHEWHOLEBODY, new Cloth("платье", null,
                            new RedDecorator(new NewDecorator(new Dress()))));
                }},
                12, Actor.Gender.FEMALE, 80);
        Human Doorman = new Human("Швейцар", Humane.Rank.DOORMAN, HairStyle.BUCCULA,
                new HashMap<>(){{
                    put(TypeOuterwearCloth.FORTHEWHOLEBODY, new Cloth("ливрея", null,
                            new RedDecorator(new OldDecorator( new ClearDecorator(new Livery())))));

                }}, 20, Actor.Gender.MALE, 50);
        HAnimal Karas = new HAnimal("Лакей", Humane.Rank.FOOTMAN, HairStyle.BUCCULA,
                new HashMap<>(){{
                    put(TypeOuterwearCloth.FORTHEWHOLEBODY, new Cloth("ливрея", null,
                            new BlueDecorator(new NewDecorator(new DirtyDecorator(new Livery())))));
                }}, 20, Actor.Gender.MALE, 80);
        Human supportActor1 = new Human("Роман", Humane.Rank.ANY, HairStyle.ANY,
                new HashMap<>(), 20, Actor.Gender.MALE, 130);
        Human supportActor2 = new Human("Дима", Humane.Rank.ANY, HairStyle.ANY,
                new HashMap<>(), 20, Actor.Gender.MALE, 100);
        Human supportActor3 = new Human("Кирилл", Humane.Rank.ANY, HairStyle.ANY,
                new HashMap<>(), 20, Actor.Gender.MALE, 110);
        Thing letter = new Thing("письмо", Karas, new Letter("Чудо письмо"));
        letter.toLetter().setText("Дорогая герцогиня!\n Приглашаю тебя на игру в крокет сегодня вечером в 19 часов утра. Захвати с собой нашего священного элексира 'Tundra'.\n Твоя Королева.");
        Karas.setThings("Письмо", letter);
        Scene scene = new Scene();
        scene.addPerson(Alisa.getName(), Alisa);
        scene.addPerson(Doorman.getName(), Doorman);
        scene.addPerson(supportActor1.getName(), supportActor1);
        scene.addPerson(supportActor2.getName(), supportActor2);
        scene.addPerson(supportActor3.getName(), supportActor3);

        scene.addPerson(Karas.getName(), Karas);
        scene.startScene();
    }
}
