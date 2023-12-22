package Things.Clothes.Colors;

import Things.Clothes.BufCloth;
import Things.Clothes.ClothesDecorate;

public class RedDecorator extends ClothesDecorate {

    public RedDecorator(BufCloth clothes) {
        super(clothes);
    }

    @Override
    public String getName() {
        return "Красные " + super.getName();
    }
}
