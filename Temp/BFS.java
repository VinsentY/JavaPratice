package three;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BFS {

    class Note{
        int x;
        int y;
        int step;
        Note father;
    }

    public static int n = 9;
    public static int[][] map = new int[n][n];
    public static int[][] book = new int[n][n];
    public static final int STONE = 1;
    public static final int YOU = 2;
    public static final int ME = 3;
    public static final int EMPTY = 0;
    public static boolean hasFind = false;

    public static void initMap() {
        Random random = new Random();
        int x,y;
        int numStone = n*n/5;

        for(int i = 0; i < n;i ++) {
            map[0][i] = STONE;
            map[n - 1][i] = STONE;
            map[i][0] = STONE;
            map[i][n - 1] = STONE;
        }


        map[1][1] = ME;

        do {
            x = random.nextInt(n - 1) + 1;
            y = random.nextInt(n - 1) + 1;
        } while (map[x][y] != EMPTY);
        map[x][y] = YOU;

        for(int i = 0; i < numStone; ) {
            x = random.nextInt(n - 1) + 1;
            y = random.nextInt(n - 1) + 1;
            if (map[x][y] == EMPTY) {
                map[x][y] = STONE;
                i++;
            }
        }

        book[1][1] = 1;

    }

    public static void print() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                switch (map[i][j]) {
                    case EMPTY:
                        System.out.print(" ");
                        break;
                    case STONE:
                        System.out.print("#");
                        break;
                    case ME:
                        System.out.print("*");
                        break;
                    case YOU:
                        System.out.print("@");
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }
    }

    public static int[][] next = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void main(String[] args) {
        initMap();
        print();

    }


}
