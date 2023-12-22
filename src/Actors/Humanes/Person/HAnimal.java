package Actors.Humanes.Person;

import Actors.Humanes.Humane;
import Actors.InfoHumane;
import Things.Cloth;
import TypeEnum.Cloth.Outerwear.TypeOuterwearCloth;
import TypeEnum.HairStyle.HairStyle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HAnimal extends Humane implements InfoHumane {


    public HAnimal(String name, Rank rank, HairStyle hairStyle, HashMap<TypeOuterwearCloth, Cloth> cloth, int age, Gender gender, int startIQ) {
        super(name, rank, hairStyle, cloth, age, gender, startIQ);
    }

    @Override
    public void AddMemory(String text, TypeMemory typeMemory, HashMap<Integer, HashMap<TypeMemory, List<String>>> memory, String names, int time, int IQ) {
        super.AddMemory(text, typeMemory, memory, names, time, IQ);
    }

    @Override
    public String toString() {
        return "HAnimal{" +
                "hairStyle=" + hairStyle +
                ", cloth=" + cloth +
                ", emotions=" + emotions +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                ", invite=" + invite +
                ", memory=" + memory +
                ", actionRightNow=" + actionRightNow +
                ", place=" + place +
                ", positionInPlace=" + Arrays.toString(positionInPlace) +
                ", gender=" + gender +
                ", things=" + things +
                ", age=" + age +
                '}';
    }
}
