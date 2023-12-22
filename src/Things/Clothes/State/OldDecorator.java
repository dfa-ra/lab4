package Things.Clothes.State;

import Things.Clothes.BufCloth;
import Things.Clothes.ClothesDecorate;

public class OldDecorator extends ClothesDecorate {

    public OldDecorator(BufCloth clothes) {
        super(clothes);
    }

    @Override
    public String getName() {
        return " старые " + super.getName();
    }
}