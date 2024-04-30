public class Value {
    private int _i;

    public Value() {
        _i = 15;
    }

    public int getI() {
        return _i;
    }

    public void setI(int i) {
        _i = i;
    }

    public static void main(String[] args) {
        int i = 5;
        Value v = new Value();
        v.setI(10);
        foo2(v, i);
        System.out.println(v.getI() + " ");
        System.out.println(i + " ");
    }

    public static void foo2(Value v, int i) {
        v.setI(30);
        i = 10;
        Value val = new Value();
        v = val;
        System.out.println(v.getI() + " ");
    }
}
