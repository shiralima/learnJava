public class Var {
    public static void main(String[] args) {
        final int MIN = 1;
        System.out.println("MIN value:" + MIN);

        int x = 10;
        double d = 12.5;
        boolean b = true;

        d = x;
        int c = 10;

        System.out.print(" \n x value:" + x + "\td value:" + d + "\tb value:" + b + "\n" + "first c\t" + ++c + "\tsecond c\n" + c++);
    }
}