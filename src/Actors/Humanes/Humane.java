package Actors.Humanes;

import Action.Action;
import Actors.Actor;
import Actors.InfoHumane;
import LogHistory.FileLog;
import Things.Cloth;
import TypeEnum.Cloth.Outerwear.TypeOuterwearCloth;
import TypeEnum.HairStyle.HairStyle;
import data.BaseOfQuestion.Questions;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public abstract class Humane extends Actor implements Mementomory {
    protected HairStyle hairStyle;
    protected HashMap<TypeOuterwearCloth, Cloth> cloth = new HashMap<>();
    protected Emotions emotions;


    protected Rank rank;
    protected int IQ;
    protected HashMap<String, Action> invite = new HashMap<>();
    protected HashMap<Integer, HashMap<TypeMemory, List<String>>>  memory = new HashMap<>();
    public Humane(String name, Rank rank, HairStyle hairStyle, HashMap<TypeOuterwearCloth, Cloth> cloth, int age, Gender gender, int startIQ) {
        super(age, gender);
        this.name = name;
        this.rank = rank;
        this.hairStyle=hairStyle;
        this.cloth = cloth;
        this.IQ = startIQ;
    }

    public String getName() {
        return name;
    }

    public void tryUpIQ(){
        String q = Questions.getQuestion()[0];
        String a = Questions.getQuestion()[1];
        Scanner input = new Scanner(System.in);
        System.out.println("=========");
        System.out.println("Ваш IQ до вопроса " + String.valueOf(IQ));
        System.out.println("---------");
        System.out.println(q);
        if (Objects.equals(input.nextLine(), a)) {
            IQ += 10;
            System.out.println("Ответ правильный.");
            FileLog.writeLog(name + " пытается поднять свой IQ. Успешно!");
        }
        else {
            IQ -= 1;
            System.out.println("Ответ не правильный.");
            FileLog.writeLog(name + " пытается поднять свой IQ. Не успешно!");
        }
        System.out.println("---------");
        System.out.println("Ваш IQ после ответа на вопрос " + String.valueOf(IQ));
        System.out.println("=========");
    };

    public int getIQ(){
        return IQ;
    }
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public void addInvite(String time, Action action) {
        if (invite.get(time) == null)
            invite.put(name, action);
        else
            System.out.println("на это время уже есть какое-то мероприятие");
    }

    public HashMap<String, Action> getInvite() {
        return invite;
    }

    public void setEmotions(Emotions emotions) {
        this.emotions = emotions;
        System.out.println(place.getName() + ": " + name + " состояние - " + emotions.getTitle());
        FileLog.writeLog(name + " новая эмоция " + emotions);
    }

    public HashMap<TypeOuterwearCloth, Cloth> getCloth() {
        return cloth;
    }

    public void Speak(String text){
        System.out.println(place.getName()+": "+ name + " -");
        System.out.println("\t'" + text + "'");
        FileLog.writeLog( this + "говорит: " + text);
    }
    public void Speak(String text, InfoHumane companion, int time){
        System.out.println(place.getName()+": "+ name + " обращаясь к " + companion.getName());
        System.out.println("\t'" + text + "'");
        AddMemory(text, TypeMemory.WHATWAS_I_SAID, memory, companion.getName(), time, IQ);
        AddMemory(text, TypeMemory.WHATWASSAID, companion.getMemory(), name, time, companion.getIQ());
        FileLog.writeLog(this + "говорит " + companion + ": " + text);
    }

    public void Sneeze(){
        System.out.println(place.getName()+": "+ name + " чихнул");
    }

    public HashMap<Integer, HashMap<TypeMemory, List<String>>> getMemory() {
        return memory;
    }

    public enum Emotions {
        WITHOUT_EMOTIONS("без эмоций"),
        QUIET_LAUGHTER("тихий смех"),
        LAUGHTER("смех"),
        LOUD_LAUGHTER("громкий смех"),
        INTEREST("заинтересованность"),
        SAD("грусть"),
        SADNESS("печаль"),
        FUN("радость"),
        CRY("плачь"),
        CRYHARD("истерика");
        private final String title;

        Emotions(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
    public enum Rank {
        QUEEN,
        KING,
        DUCHEES,
        DOORMAN,
        FOOTMAN,
        DUKE,
        COUNTESS,
        EARL,
        NORMAL,
        ANY
    }
    public enum TypeMemory {
        WHATWASSAID,
        WHATWAS_I_SAID,
        ACTION,
        PAIN
    }
}
