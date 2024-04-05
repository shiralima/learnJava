/**
 * The Triangle class calculates area and perimeter.
 */
 
import java.util.Scanner;

public class Triangle {

    /** 
     * This program takes three side lengths of a triangle as input from the user,
     * verifies if they can form a triangle, and then calculates its area and perimeter. 
     */
     
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("This program calculates the area "
                + "and the perimeter of a given triangle. ");
        System.out.println("Please enter the three lengths"
                + " of the triangle's sides");

        // Get 3 integer inputs to try to represent the sides of a triangle.
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        System.out.println("The lengths of the triangle sides are: " + a + ", " + b + ", " + c);

	// Check if the integers can form a triangle.
	// In a triangle, each side must be shorter than the sum of the other two sides.
        if (a + b <= c || a + c <= b || b + c <= a ||
        	 a <= 0 || b <= 0 || c <= 0) {
            System.out.println("The given three sides don't represent a triangle");

        } else { // If the user input lengths can form a triangle.

	    // Calculate the perimeter and area of the triangle using Heron's formula.
            double p = (a + b + c) / 2.0;
            double s = Math.sqrt(p * ((p - a) * (p - b) * (p - c)));

            System.out.println("The perimeter of the triangle is: " + p);
            System.out.println("The area of the triangle is: " + s);

        }
    } // End of method main
} // End of class Triangle
