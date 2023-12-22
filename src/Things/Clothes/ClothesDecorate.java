package Things.Clothes;

import Things.Cloth;

public abstract class ClothesDecorate implements BufCloth {

    protected BufCloth clothes;
    public ClothesDecorate(BufCloth clothes){
        this.clothes = clothes;
    }
    @Override
    public String getName(){
        return clothes.getName();
    }
}
