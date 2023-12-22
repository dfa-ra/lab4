package Things.Clothes.TypeClothes;


import Things.Clothes.BufCloth;

public class Shorts implements BufCloth {
    protected String name = "Шорты";

    @Override
    public String getName() {
        return name;
    }
}
