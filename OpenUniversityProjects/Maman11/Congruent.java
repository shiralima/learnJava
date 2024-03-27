package Maman11; //todo sh - remove this line before add this task to Zip file and send it

// This program is for checking the 2 triangle is congruent.
// The program check it by the 3 vertex of each triangle and by the congruent sentence of line-line-line. 

import java.util.Scanner;

public class Congruent {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // First triangle inputs:
        System.out.println("Please enter the coordinates of the 3 vertices of the first triangle:");

        // Get user input for the coordinates of the first vertex and assign them to
        // variables 'x11' and 'y11'.
        System.out.println("Enter the first vertex (2 real numbers)");
        double x11 = scan.nextDouble();
        double y11 = scan.nextDouble();

        // Get user input for the coordinates of the first vertex and assign them to
        // variables 'x12' and 'y12'.
        System.out.println("Enter the second vertex (2 real numbers)");
        double x12 = scan.nextDouble();
        double y12 = scan.nextDouble();

        // Get user input for the coordinates of the first vertex and assign them to
        // variables 'x13' and 'y13'.
        System.out.println("Enter the third vertex (2 real numbers)");
        double x13 = scan.nextDouble();
        double y13 = scan.nextDouble();

        // Second triangle inputs:
        System.out.println("Please enter the coordinates of the 3 vertices of the second triangle:");

        // Get user input for the coordinates of the first vertex and assign them to
        // variables 'x21' and 'y21'.
        System.out.println("Enter the first vertex (2 real numbers)");
        double x21 = scan.nextDouble();

        double y21 = scan.nextDouble();

        // Get user input for the coordinates of the second vertex and assign them to
        // variables 'x22' and 'y22'.
        System.out.println("Enter the second vertex (2 real numbers)");
        double x22 = scan.nextDouble();
        double y22 = scan.nextDouble();

        // Get user input for the coordinates of the third vertex and assign them to
        // variables 'x23' and 'y23'.
        System.out.println("Enter the third vertex (2 real numbers)");
        double x23 = scan.nextDouble();
        double y23 = scan.nextDouble();

        // Calculate the length of each side of the second triangle.
        // Using the formula: sqrt((x1 - x2)^2 + (y1 - y2)^2)

        double a1 = Math.sqrt((Math.pow((x11 - x12), 2)) + (Math.pow((y11 - y12), 2)));

        double b1 = Math.sqrt((Math.pow((x12 - x13), 2)) + (Math.pow((y12 - y13), 2)));

        double c1 = Math.sqrt((Math.pow((x13 - x11), 2)) + (Math.pow((y13 - y11), 2)));

        double a2 = Math.sqrt((Math.pow((x21 - x22), 2)) + (Math.pow((y21 - y22), 2)));

        double b2 = Math.sqrt((Math.pow((x22 - x23), 2)) + (Math.pow((y22 - y23), 2)));

        double c2 = Math.sqrt((Math.pow((x23 - x21), 2)) + (Math.pow((y23 - y21), 2)));

        System.out.println("The first triangle is " +
                "(" + x11 + ", " + y11 + ")" +
                "(" + x12 + ", " + y12 + ")" +
                "(" + x13 + ", " + y13 + ")");
        System.out.println("Its lengths are " + a1 + ", " + b1 + ", " + c1);

        System.out.println("The second triangle is " +
                "(" + x21 + ", " + y21 + ")" +
                "(" + x22 + ", " + y22 + ")" +
                "(" + x23 + ", " + y23 + ")");
        System.out.println("Its lengths are " + a2 + ", " + b2 + ", " + c2);

        // Check all combinations of corresponding sides from both triangles for congruence.
        if (((a1 == a2) && (b1 == b2) && (c1 == c2)) ||
                ((a1 == a2) && (b1 == c2) && (c1 == b2)) ||
                ((a1 == b2) && (b1 == a2) && (c1 == c2)) ||
                ((a1 == b2) && (b1 == c2) && (c1 == a2)) ||
                ((a1 == c2) && (b1 == a2) && (c1 == c2)) ||
                ((a1 == c2) && (b1 == b2) && (c1 == a2))) {
            System.out.println("The triangles are congruent.");
        } else { // If the triangles are not congruent.
            System.out.println("The triangles are not congruent.");
        }

    } // End of method main
} // End of class Congruent
