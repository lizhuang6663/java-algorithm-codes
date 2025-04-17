package ComparableAndComparator;

import java.util.*;

public class Test_Comparator {
    public static void main(String[] args) {
        Person p1 = new Person("liz", 19);
        Person p2 = new Person("bfe", 20);
        Person p3 = new Person("zxe", 9);
        Person p4 = new Person("aabc", 40);
        Person p5 = new Person("aaa", 12);

        List<Person> list = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));

        Collections.sort(list, new MyComparator()); // 排序

        // 使用匿名类排序：
//        list.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person p1, Person p2) {
//                return p1.name.compareTo(p2.name); // 升序
//            }
//        });

        // 遍历
        list.forEach(p -> System.out.println(p.name + " " + p.age));
    }
}

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

class MyComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        // 根据姓名大小排序
        return p1.name.compareTo(p2.name); // 升序
//        return p2.name.compareTo(p1.name); // 降序

        // 根据年龄排序
//        return p1.age - p2.age; // 升序
//        return p2.age - p1.age; // 降序
    }
}

//结果：
//aaa 12
//aabc 40
//bfe 20
//liz 19
//zxe 9