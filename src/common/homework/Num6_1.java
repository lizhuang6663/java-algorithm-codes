package common.homework;

import java.util.Arrays;
import java.util.Scanner;

//浇水流动（这种方法还没看懂）
//https://www.matiji.net/exam/brushquestion/16/4009/C448715ED43BEA9D2D47CED523050945

public class Num6_1 {
    static int[][] vis = new int[2001][2001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n+1][n+1];
        Data[] datas = new Data[n*n];

        int count =0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                nums[i][j] = sc.nextInt();
                datas[count] = new Data(i,j,nums[i][j]);
                count++;
            }
        }

        Arrays.sort(datas, (o1,o2) -> o2.h - o1.h);//这里要注意对象类型数组的空指针问题

        int ans =0;

        for (int i = 0;i < count; i++){
            if (vis[datas[i].x][datas[i].y] == 1) continue;
            ans++;
            dfs(nums, datas[i].x, datas[i].y, datas[i].h);
        }

        System.out.println(ans);
    }

    private static void dfs(int[][] nums,int x,int y,int h){
        vis[x][y] =1;
        if(x + 1 <= nums.length - 1 && h > nums[x+1][y] && vis[x+1][y] == 0) dfs(nums, x+1, y, nums[x+1][y]);
        if(x - 1 >= 1 && h > nums[x-1][y] && vis[x-1][y] == 0) dfs(nums, x-1, y, nums[x-1][y]);
        if(y + 1 <= nums.length-1 && h > nums[x][y+1] && vis[x][y+1]==0) dfs(nums, x, y+1, nums[x][y+1]);
        if(y - 1 >= 1 && h > nums[x][y-1] && vis[x][y-1] == 0) dfs(nums, x, y-1, nums[x][y-1]);
    }
}


class Data{
    int x;
    int y;
    int h;
    public Data(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}