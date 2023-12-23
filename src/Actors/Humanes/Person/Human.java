package Actors.Humanes.Person;

import Actors.Humanes.Humane;
import Actors.InfoHumane;
import Things.Cloth;
import TypeEnum.Cloth.Outerwear.TypeOuterwearCloth;
import TypeEnum.HairStyle.HairStyle;

import java.util.HashMap;
import java.util.List;

public class Human extends Humane implements InfoHumane {


    public Human(String name, Rank rank, HairStyle hairStyle, HashMap<TypeOuterwearCloth, Cloth> cloth, int age, Gender gender, int startIQ) {
        super(name, rank, hairStyle, cloth, age, gender, startIQ);
    }

    @Override
    public String toString() {
        return "Human{" +
                "hairStyle=" + hairStyle +
                ", cloth=" + cloth +
                ", emotions=" + emotions +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                ", invite=" + invite +
                ", actionRightNow=" + actionRightNow +
                ", gender=" + gender +
                ", things=" + things +
                ", age=" + age +
                '}';
    }
    

    @Override
    public void AddMemory(String text, TypeMemory typeMemory, HashMap<Integer, HashMap<TypeMemory, List<String>>> memory, String names, int time, int IQ) {
        super.AddMemory(text, typeMemory, memory, names, time, IQ);
    }
}