package Things.Clothes.TypeClothes;

import Things.Clothes.BufCloth;

public class Dress implements BufCloth {

    protected String name = "Платье";

    @Override
    public String getName() {
        return name;
    }
}
