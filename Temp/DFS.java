package three;

import java.util.Arrays;
import java.util.Random;

public class DFS {


    public static int n = 9;
    public static int[][] map = new int[n][n];
    public static int[][] book = new int[n][n];
    public static int[][] trace = new int[n][n];;
    public static final int STONE = 1;
    public static final int YOU = 2;
    public static final int ME = 3;
    public static final int EMPTY = 0;

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
        dfs();
    }

    public static int minStep = Integer.MAX_VALUE;

    private static void dfs() {
        dfs(1,1,0);
        System.out.println("Success Find" + " Min Step is " + minStep);
        book[0][0] = 1000;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(trace[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void dfs(int x, int y, int step) {
        if (map[x][y] == YOU) {
            if (step < minStep) {
                minStep = step;
                //二维数组无法通过此方式拷贝
//                trace = Arrays.copyOf(book, book.length);
                for(int i = 0; i < book.length; i++ ) {
                    trace[i] = Arrays.copyOf(book[i], book.length);
                }
            }
            return;
        } else {
            int nextX;
            int nextY;
            //按照顺时针方向探索
            for(int i = 0; i < 4; i++) {
                nextX = x + next[i][0];
                nextY = y + next[i][1];
                if (map[nextX][nextY] != STONE && book[nextX][nextY] == 0) {
//					System.out.println("I'm in(" + x + "," + y + ")");

                    book[nextX][nextY] = 1;
                    dfs(nextX,nextY, step + 1);
//                   回溯
                    book[nextX][nextY] = 0;
                }
            }
        }
    }





}
