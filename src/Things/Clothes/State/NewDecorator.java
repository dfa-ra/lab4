package Things.Clothes.State;

import Things.Clothes.BufCloth;
import Things.Clothes.ClothesDecorate;

public class NewDecorator extends ClothesDecorate {
    public NewDecorator(BufCloth clothes) {
        super(clothes);
    }

    @Override
    public String getName() {
        return " новые " + super.getName();
    }
}
