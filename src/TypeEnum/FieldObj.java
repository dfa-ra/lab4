package TypeEnum;

public enum FieldObj {
    TREE(1),
    TABLE(2),
    BED(3),
    HOUSE(4),
    SHRUB(5);

    FieldObj(int n) { value = n; }
    public final int value;
}
