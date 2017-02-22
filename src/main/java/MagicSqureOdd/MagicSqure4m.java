package MagicSqureOdd;

/**
 * Copyright: Property of Singapore Prison Service. The contents shall not be reproduced,
 * republished, uploaded, posted, transmitted * or otherwise distributed in any way,
 * without the prior permission of Singapore Prison Service
 *
 * @author chengangw
 * @version 0.0.1
 * @date 26/9/2016 3:00 PM
 */
public class MagicSqure4m {
    /**
     * @param args
     */
    static int  matrix[][];
    static int   n;

    static void magic_squre_4m_generate()
    {
        //初始化matrix
        matrix = new int[n][n];

        //将matrix裡的位置用数顺序排列
        int ini = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = ++ini;

        //打印对调前的样子
        System.out.println("Before **********");
        print();

        //然后对调（仅对右上方的数进行遍历）
        for(int i = 0; i < n; i++)
            for(int j = i + 1; j < n; j++)
            {
                if(( i != j) && (i + j) != (n -1) )
                {   //对不在主付对角线上的数关于中心对调
                    int temp;
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[n -1 - i][n - 1 - j];
                    matrix[n -1 - i][n - 1 - j] = temp;
                }
            }
    }

    public static void print()
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        //这里手动设置n的数值为4，这里只能设置为4，因为只求4阶幻方
        n = 4;
        magic_squre_4m_generate();
        System.out.println("After **********");
        print();
    }
}
