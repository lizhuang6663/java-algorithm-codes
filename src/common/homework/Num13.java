package common.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//射线相交
//码蹄集： https://www.matiji.net/exam/brushquestion/48/4009/C448715ED43BEA9D2D47CED523050945
public class Num13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Position> uu = new ArrayList<>();
        List<Position> dd = new ArrayList<>();
        List<Position> ll = new ArrayList<>();
        List<Position> rr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char ch = scanner.next().charAt(0);

            Position position = new Position(x,y);
            switch (ch) {
                case 'U':
                    uu.add(position);
                    break;
                case 'D' :
                    dd.add(position);
                    break;
                case 'L' :
                    ll.add(position);
                    break;
                case 'R':
                    rr.add(position);
                    break;
            }
        }

        int result = 0;
        //判断向上和向左右是否可以交叉
        for (int i = 0; i < uu.size(); i++) {
            for (int j = 0; j < ll.size(); j++) {
                if (uu.get(i).getX() <= ll.get(j).getX() && uu.get(i).getY() <= ll.get(j).getY()) result++;
            }

            for (int j = 0; j < rr.size(); j++) {
                if (uu.get(i).getX() >= rr.get(j).getX() && uu.get(i).getY() <= rr.get(j).getY()) result++;
            }
        }

        //判断向下和向左右是否可以交叉
        for (int i = 0; i < dd.size(); i++) {
            for (int j = 0; j < ll.size(); j++) {
                if (dd.get(i).getX() <= ll.get(j).getX() && dd.get(i).getY() >= ll.get(j).getY()) result++;
            }

            for (int j = 0; j < rr.size(); j++) {
                if (dd.get(i).getX() >= rr.get(j).getX() && dd.get(i).getY() >= rr.get(j).getY()) result++;
            }
        }

        System.out.println(result);
    }
}



class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}




/*


5
2 1 U
4 3 U
3 4 R
6 5 L
6 6 D

输出：5
 */