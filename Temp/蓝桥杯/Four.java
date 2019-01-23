package one;

public class Four {
    public static boolean Find(int target, int[][] array) {
        try {
            if (array == null) {
                throw new NullPointerException();
            } else {
                int i = array.length - 1;
                int j = 0;

                while (true) {
                    if (array[i][j] == target) {
                        return true;
                    } else if (array[i][j] > target) {
                        i--;
                    } else {
                        j++;
                    }
                    if (i < 0 || j >= array.length) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }


    }

    public static void main(String[] args) {
        int[][] arr = null;
        System.out.println(Find(16, arr));
    }
}
