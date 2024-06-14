public class Ex13 {
    /**
     * EX 1
     * Finds the single non-duplicate element in a sorted array where every other
     * element appears twice.
     * 
     * Time Complexity: O(n) - loop over one array.
     * Space Complexity: O(1) - constant.
     *
     * @param a the input array
     * @return the single non-duplicate element
     *
     * 
     */
    public static int findSingle(int[] a) {
        for (int i = 0; i < a.length - 1; i += 2) {
            if (a[i] != a[i + 1]) {
                return a[i];
            }
        }
        return a[a.length - 1];
    }

    /**
     * EX 2
     * Calculate how much water units can be saved in a given water tool.
     * 
     * Time complexity: O(n) - loop over one array.
     * Space complexity: O(1) - constant.
     * 
     * @param heights array of integers that represents a water tool.
     * @return how much water can be saved in a given tool.
     */
    public static int waterVolume(int[] heights) {
        // Initialize variables to store the water units, left max height, and right max
        // height
        int waterUnitsSum = 0;
        int leftMax = 0;
        int rightMax = 0;

        // Initialize pointers for the left and right sides of the array
        int leftIndex = 0;
        int rightIndex = heights.length - 1;

        // Iterate until the left index get to the right index
        while (leftIndex <= rightIndex) {
            // Check which side has the lower height to determine the max height for the
            // current position
            if (heights[leftIndex] < heights[rightIndex]) {
                // If the current height on the left is greater than the left max, update left
                // max
                if (heights[leftIndex] > leftMax) {
                    leftMax = heights[leftIndex];
                } else {
                    // Otherwise, add the difference between left max and current height to the
                    // waterUnitsSum
                    waterUnitsSum += leftMax - heights[leftIndex];
                }
                // Move the left index to the right
                leftIndex++;
            } else {
                // If the current height on the right is greater than the right max, update
                // right max
                if (heights[rightIndex] > rightMax) {
                    rightMax = heights[rightIndex];
                } else {
                    // Otherwise, add the difference between right max and current height to the
                    // waterUnitsSum
                    waterUnitsSum += rightMax - heights[rightIndex];
                }
                // Move the right index to the left
                rightIndex--;
            }
        }

        // Return the total amount of water that can be saved
        return waterUnitsSum;
    }

    /**
     * EX 3
     * Finds the password of the given length by trying all possible combinations.
     *
     * @param p      the password object to check the password against
     * @param length the length of the password to find
     * @return the found password
     */
    public static String findPassword(Password p, int length) {
        // initialize guess with 'a' repeated length times
        String guess = createRepeatedString("a", length);
        return findPassword(p, guess, length);
    }

    /**
     * Recursively find the correct password by incrementing the guess.
     *
     * @param p      the password object to check the password against
     * @param guess  the current guess of the password
     * @param length the length of the password
     * @return the found password
     */
    private static String findPassword(Password p, String guess, int length) {
        if (p.isPassword(guess)) {
            return guess;
        }
        guess = advanceOnePlace(guess, length - 1);
        return findPassword(p, guess, length);
    }

    /**
     * Advances the current guess by incrementing the character at the specified
     * index.
     * If the character is 'z', it wraps around to 'a' and carries over to the
     * previous index.
     *
     * @param guess the current guess of the password
     * @param i     the index to increment
     * @return the new guess after incrementing
     */
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
     * Creates a string of the given length by repeating string.
     *
     * @param string       the string to repeat
     * @param stringLength the length of the resulting repeated string
     * @return the repeated string
     */
    private static String createRepeatedString(String string, int stringLength) {
        if (stringLength == 0) {
            return "";
        }
        return string + createRepeatedString(string, stringLength - 1);
    }

    /**
     * EX 4
     * Counts the number of contiguous true regions in the given boolean matrix.
     * 
     * @param mat The boolean matrix.
     * @return The number of contiguous true regions.
     */
    public static int cntTrueReg(boolean[][] mat) {
        if (mat == null || mat.length == 0) {
            return 0; // Return 0 if the matrix is null or empty
        }

        int size = mat.length;
        int regionCount = 0;

        // Initialize the visit matrix with the same size of the given matrix
        boolean[][] visited = new boolean[size][size];

        // Traverse each cell in the matrix
        return cntTrueReg(mat, visited, size, 0, 0, regionCount);
    }

    /**
     * Recursively traverses the matrix to count the number of true regions.
     * 
     * @param matrix      The boolean matrix to be processed.
     * @param visited     The matrix to track visited cells.
     * @param size        The size of the matrix (number of rows and columns).
     * @param r           The current row index.
     * @param c           The current column index.
     * @param regionCount The current count of true regions.
     * @return The updated count of true regions.
     */
    private static int cntTrueReg(boolean[][] matrix, boolean[][] visited, int size, int r, int c,
            int regionCount) {
        // If we reached the end of the columns, move to the next row
        if (c >= size) {
            c = 0;
            r++;
        }

        // If we traversed all rows, return the region count
        if (r >= size) {
            return regionCount;
        }

        // If the current cell is true and not visit yet, it's the start of a new region
        if (matrix[r][c] && !visited[r][c]) {
            regionCount++;
            // Perform DFS to mark all connected true cells
            initializeAllTrueAround(matrix, visited, r, c, size);
        }

        // Recursively move to the next cell
        return cntTrueReg(matrix, visited, size, r, ++c, regionCount);
    }

    /**
     * Performs a Depth-First Search (DFS) to mark all contiguous true cells as
     * visited.
     * 
     * @param matrix  The boolean matrix to be processed.
     * @param visited The matrix to track visited cells.
     * @param r       The current row index.
     * @param c       The current column index.
     * @param size    The size of the matrix (number of rows and columns).
     */
    private static void initializeAllTrueAround(boolean[][] matrix, boolean[][] visited, int r, int c, int size) {
        // If the cell is out of bounds or already visited or false, return
        if (r < 0 || r >= size || c < 0 || c >= size || !matrix[r][c] || visited[r][c]) {
            return;
        }

        // Change the cell to visited
        visited[r][c] = true;

        // Recursively visit all adjacent cells (up, down, left, right)
        initializeAllTrueAround(matrix, visited, r - 1, c, size); // Up
        initializeAllTrueAround(matrix, visited, r + 1, c, size); // Down
        initializeAllTrueAround(matrix, visited, r, c - 1, size); // Left
        initializeAllTrueAround(matrix, visited, r, c + 1, size); // Right
    }
}
