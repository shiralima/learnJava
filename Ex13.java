public class Ex13 {

    // EX 1 - check time complexity O(n)
    public static int findSingle(int[] a) {
        for (int i = 0; i < a.length - 1; i += 2) {
            if (a[i] != a[i + 1]) {
                return a[i];
            }
        }
        return a[a.length - 1];
    }

    // EX 3
    public static String findPassword(Password p, int length) {
        String guess = "a".repeat(length); // initialize guess with 'a' repeated length times
        return findPassword(p, guess, length);
    }

    public static String findPassword(Password p, String guess, int length) {
        if (p.isPassword(guess)) {
            return guess;
        }
        guess = advanceOnePlace(guess, length - 1);
        return findPassword(p, guess, length);
    }

    private static String advanceOnePlace(String guess, int i) {
        if (guess.charAt(i) == 'z') {
            if (i == 0) {
                return advanceOnePlace("a" + guess.substring(1), guess.length() - 1);
            }
            return advanceOnePlace(guess.substring(0, i) + "a" + guess.substring(i + 1), i - 1);
        }
        return guess.substring(0, i) + (char) (guess.charAt(i) + 1) + guess.substring(i + 1);
    }

    /**
	 * calculate and return how much water units can be saved in a given water tool.
	 * the time efficiency is O(n). the space efficiency is O(1).
	 * @param heights array of type int that represents a tool for the accumulation of rainwater. 
	 * @return how much water can be saved in that tool.
	 */
	public static int waterVolume(int[] heights) {
		
		// leftMax will have the max height to the left.
		// rigthMax will have the max height to the rigth.
        int result = 0;
        int leftMax = 0;
        int rightMax = 0; 
           
        //Indexes to run on the array
        int leftIndex = 0;
        int rightIndex = heights.length - 1; 
           
        while(leftIndex <= rightIndex) {
        	//check which is higher to know the max height that can be save in this spot. 
            if(heights[leftIndex] < heights[rightIndex]) {
            	//update max
                if(heights[leftIndex] > leftMax) {
                    leftMax = heights[leftIndex]; 
                }
                else {
                	//update result
                    result += leftMax - heights[leftIndex]; 
                }
                leftIndex++; 
                break;
            } 
            //update max
            if(heights[rightIndex] > rightMax) {
                rightMax = heights[rightIndex]; 
            }

            else {
                //update result
                result += rightMax - heights[rightIndex]; 
            }
            rightIndex--; 
        } 

        return result; 
	}

    public static void main(String[] args) {
        // Example usage for EX 1
        int[] array = {2, 1, 1, 4, 1, 1, 2, 3} ;
        // System.out.println(findSingle(array)); 

        // Example usage for EX 3
        // Password p = new Password(3); 
        System.out.println(waterVolume(array)); 
    }
}

