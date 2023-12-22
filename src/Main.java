import Actors.Actor;
import Actors.Humanes.Humane;
import Actors.Humanes.Person.HAnimal;
import Actors.Humanes.Person.Human;
import Actors.InfoHumane;
import Exeptions.InvalidPlaceExceptoin;
import Scene.*;
import Things.Cloth;
import Things.Clothes.Colors.*;
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
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Human Alisa = new Human("Alisa", Humane.Rank.NORMAL, HairStyle.ANY,
                new HashMap<>(){{
                    put(TypeOuterwearCloth.FORTHEWHOLEBODY, new Cloth("платье", null, new RedDecorator(new Dress())));
                }},
                12, Actor.Gender.FEMALE, 80);
        Human Doorman = new Human("Швейцар", Humane.Rank.DOORMAN, HairStyle.BUCCULA,
                new HashMap<>(){{
                    put(TypeOuterwearCloth.FORTHEWHOLEBODY, new Cloth("ливрея", null, new RedDecorator(new Livery())));
                }}, 20, Actor.Gender.MALE, 50);
        HAnimal Karas = new HAnimal("Лакей", Humane.Rank.FOOTMAN, HairStyle.BUCCULA,
                new HashMap<>(){{
                    put(TypeOuterwearCloth.FORTHEWHOLEBODY, new Cloth("ливрея", null, new BlueDecorator(new Livery())));
                }}, 20, Actor.Gender.MALE, 80);
//        Thing letter = new Thing("письмо", Karas, new Letter("Чудо письмо"));
//        letter.toLetter().setText("Герцогине от королевы. Приглашение на вечерний крокет.");
//        Karas.setThings("Письмо", letter);
        Scene scene = new Scene();
        scene.addPerson(Alisa.getName(), Alisa);
        scene.addPerson(Doorman.getName(), Doorman);
//        scene.addPerson(Karas.getName(), Karas);
        scene.startScene();
    }
}
