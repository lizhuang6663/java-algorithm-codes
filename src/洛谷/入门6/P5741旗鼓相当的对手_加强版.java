package 洛谷.入门6;

import java.util.*;

// 使用到了：String 的 compareTo() 方法

public class P5741旗鼓相当的对手_加强版 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        List<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Student(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }

        List<Student[]> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {

                if (Math.abs(list.get(i).Chinese - list.get(j).Chinese) <= 5 && Math.abs(list.get(i).Math - list.get(j).Math) <= 5 && Math.abs(list.get(i).English - list.get(j).English) <= 5 &&
                        Math.abs(list.get(i).Chinese + list.get(i).Math + list.get(i).English - list.get(j).Chinese - list.get(j).Math - list.get(j).English) <= 10) {
                    if (list.get(i).name.compareTo(list.get(j).name) <= 0) {
                        result.add(new Student[]{list.get(i), list.get(j)});
                    } else {
                        result.add(new Student[]{list.get(j), list.get(i)});
                    }
                }

            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i)[0].name + " " + result.get(i)[1].name);
        }

    }
}

class Student {
    String name;
    int Chinese;
    int Math;
    int English;

    public Student(String name, int chinese, int math, int english) {
        this.name = name;
        Chinese = chinese;
        Math = math;
        English = english;
    }
}


/*

3
fafa 90 90 90
senpai 100 80 91
lxl 95 85 90




3
senpai 100 80 91
aac 95 85 90
aab 90 90 90

 */