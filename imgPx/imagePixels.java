package imgPx;

class ImagePixels {

    private int size;
    private char firstColor;
    private char secondColor;
    private char img[][];

    /**
     * This Class get size (n X n) size for the img and also get the color/symbol to
     * drew the img by
     */
    public ImagePixels(int size, char firstColor, char secondColor) {
        this.size = size;
        this.firstColor = firstColor;
        this.secondColor = secondColor;
        this.img = new char[size][size];

        boolean isCurrColorFirst = true;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                this.img[row][col] = isCurrColorFirst ? this.firstColor : this.secondColor;
                isCurrColorFirst = !isCurrColorFirst;
            }
        }
    }

        public void DrewImage() {
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    System.out.print(this.img[row][col]);
                }
                System.out.println();
            }
        }

}
