package 校队.校队题库;

import java.util.*;


// http://152.136.48.159/contest/65e152e395b0ee1bcc9153d6/problems

public class P1024孤独的数EasyVersion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();

            if (list.contains(temp)) {

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == temp) {
                        list.remove(j);
                    }
                }

            } else {
                list.add(temp);
            }
        }

        System.out.println(list.get(0));

    }
}

