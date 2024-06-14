package OpenUniversityProjects.ClassesForMmn14;

public class MainTester {

    public static void main(String[] args) {

        IntListTwo l1 = new IntListTwo();

        l1.addToEnd(0);
        l1.addToEnd(0);
        l1.addToEnd(-1);
        l1.addToEnd(2);
        // {0, 0, 0, 0}

        IntListTwo l2 = new IntListTwo();

        l2.addToEnd(1);
        l2.addToEnd(0);
        l2.addToEnd(0);
        // {0, 0, 0}

        System.out.println("soluution: " + l1.longestCommonSublist(l1));
    }

}
