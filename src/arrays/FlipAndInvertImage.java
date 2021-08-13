package arrays;

public class FlipAndInvertImage {
    public static int[][] flipAndInvertImage(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            for (int j = image[i].length - 1, index = 0; index < image[i].length / 2 && j >= image[i].length / 2; j--, index++) {
                int temp = image[i][index];
                image[i][index] = image[i][j];
                image[i][j] = temp;
            }

            for (int index = 0; index < image[i].length; index++) {
                image[i][index] = image[i][index] == 0 ? 1 : 0;
            }
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] image = new int[][] {{1,1,0,0}
        ,{1,0,0,1},{0,1,1,1},{1,0,1,0}};

        image = flipAndInvertImage(image);

        for (int i = 0; i<image.length; i++) {
            for (int j = 0; j<image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
