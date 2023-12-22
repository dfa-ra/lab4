package Things.Clothes.State;

import Things.Clothes.BufCloth;
import Things.Clothes.ClothesDecorate;

public class DirtyDecorator extends ClothesDecorate {

    public DirtyDecorator(BufCloth clothes) {
        super(clothes);
    }

    @Override
    public String getName() {
        return " грязные " + super.getName();
    }
}
