package practiceToTest;

public class Prince {

    public static int prince(int[][] drm, int i, int j) {
        return prince(drm, i, j, 0);
    }

    public static int prince(int[][] drm, int r, int c, int minValue) {

        if (drm[r][c] == -1) {
            return prince(drm, r, c, minValue);
        }
        return -1;
    }

    private static int getMinPositiveNumber(int up, int down, int right, int left) {
        if(up == down && down == right && right == left) {
            return up;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
