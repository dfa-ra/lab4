package Things.Clothes.State;

import Things.Clothes.BufCloth;
import Things.Clothes.ClothesDecorate;

public class ClearDecorator extends ClothesDecorate {

    public ClearDecorator(BufCloth clothes) {
        super(clothes);
    }

    @Override
    public String getName() {
        return " чистые " + super.getName();
    }
}