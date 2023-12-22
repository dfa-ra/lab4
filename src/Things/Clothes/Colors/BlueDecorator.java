package Things.Clothes.Colors;


import Things.Clothes.BufCloth;
import Things.Clothes.ClothesDecorate;


public class BlueDecorator extends ClothesDecorate {
    public BlueDecorator(BufCloth clothes) {
        super(clothes);
    }
    @Override
    public String getName() {
        return "Синие " + super.getName();
    }
}
