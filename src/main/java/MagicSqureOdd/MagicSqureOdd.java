package MagicSqureOdd;

/**
 * Copyright: Property of Singapore Prison Service. The contents shall not be reproduced,
 * republished, uploaded, posted, transmitted * or otherwise distributed in any way,
 * without the prior permission of Singapore Prison Service
 *
 * @author chengangw
 * @version 0.0.1
 * @date 26/9/2016 2:53 PM
 */
public class MagicSqureOdd {
    static int[][] matrix;
    static int n;

    public static void magic_squre_odd_generate() {
        matrix = new int[n][n];
        //????????0

        matrix[0][(n - 1) / 2] = 1;
        int x = 0, y = (n - 1) / 2;

        //count:?????????
        for (int count = 2; count <= n * n; count++)
            while (true) {
                //?x-1 y+1
                x--;
                y++;

                //????????
                while (true) {//????????????????????
                    //???????
                    //???x<0???????x=x+n?y??; continue
                    if (x < 0) {
                        x += n;
                        continue;
                    }

                    //???y>=n??y=y-n?x??;continue
                    if (y >= n) {
                        y -= n;
                        continue;
                    }

                    //???????????????????????
                    //?????????x = x + 2;y = y - 1; continue
                    if (y < 0) {
                        y += n;
                        continue;
                    }
                    if (matrix[x][y] != 0) {
                        x += 2;
                        y -= 1;
                        if (x >= n) {
                            x -= n;
                            continue;
                        }
                        if (y < 0) {
                            y += n;
                            continue;
                        }
                        continue;
                    }
                    break;
                }

                //????count????????
                matrix[x][y] = count;
                break;
            }
    }

    public static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.println(matrix[i][j]);
                System.out.print(matrix[i][j]);
                System.out.print("_");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {   //????n?????????
        n = 5;
        magic_squre_odd_generate();
        print();
    }
}
