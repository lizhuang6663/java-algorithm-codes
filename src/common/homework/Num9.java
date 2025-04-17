package common.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//文章压缩
//https://www.matiji.net/exam/brushquestion/22/4446/16A92C42378232DEB56179D9C70DC45C
public class Num9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<String> nameList = new ArrayList<>();//存放单词，而且里面的单词不重复
        List<String> resultList = new ArrayList<>(); //每个单词出现的位置  所组成的字符串，字符串 和 nameList中存放单词的位置对应

        for (int i = 0; i < n; i++) {
            String str = scanner.next();

            //如果这个单词已经出现了
            if (nameList.contains(str)) {
                //获取这个单词第一次在 nameList 中出现的索引
                int index = nameList.indexOf(str);
                //通过这个单词第一次在 nameList 中出现的索引 来获取 resultList中的字符串
                String result = resultList.get(index);
                //更新 resultList中存放位置的字符串
                resultList.set(index, result + "," + (i + 1));

            }else {  //如果输入单词是一个新单词，添加到list中
                nameList.add(str);
                resultList.add(String.valueOf(i + 1));
            }
        }

        for (int i = 0; i < nameList.size(); i++) {
            System.out.print(nameList.get(i) + "(" + resultList.get(i) + ")");
        }

    }
}


/*


输入：
4
summer
spring
summer
spring

输出：
summer(1,3)spring(2,4)


 */