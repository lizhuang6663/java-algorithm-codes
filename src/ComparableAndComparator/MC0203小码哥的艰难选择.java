package ComparableAndComparator;

import java.util.*;


public class MC0203小码哥的艰难选择 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Flower> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            int speed = i;

            boolean b = false; // list中是否存在这个人
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).name.equals(name)) {
                    b = true;
                    list.get(j).score += score; // 重置分数
                    list.get(j).speed = speed; // 重置顺序
                    break;
                }
            }

            if (!b) {
                list.add(new Flower(name, score, speed));
            }

        }

        list.sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                if (o1.score != o2.score) {
                    return o1.score - o2.score; // 升序
                }

                return o1.speed - o2.speed;// 升序
            }
        });

        System.out.println(list.get(0).name);
        System.out.println(list.get(0).score);
    }
}


class Flower {
    public String name;
    public int score = 1000;
    public int speed; // 先后顺序

    public Flower(String name, int score, int speed) {
        this.name = name;
        this.score += score;
        this.speed = speed;
    }

}

