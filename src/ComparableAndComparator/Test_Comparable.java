package ComparableAndComparator;

//public class Test_Comparable {
//    public static void P24多路归并Ⅱ(String[] args) {
//        Person p1 = new Person("liz", 19);
//        Person p2 = new Person("bfe", 20);
//        Person p3 = new Person("zxe", 9);
//        Person p4 = new Person("aabc", 40);
//        Person p5 = new Person("aaa", 12);
//
//        List<Person> list = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
//
//        Collections.sort(list); // 排序
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).name + " " + list.get(i).age);
//        }
//        // 也可以直接调用List的方法来遍历list
////        list.forEach(p -> System.out.println(p.name + "：" + p.age));
//
//    }
//}
//
//class Person implements Comparable<Person> {
//    public String name;
//    public int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public int compareTo(Person p) {
//        // 根据姓名大小排序
//        return this.name.compareTo(p.name); // 升序
////        return p.name.compareTo(this.name); // 降序
//
//
//        // 根据年龄排序
////        return this.age - p.age; // 升序
////        return p.age - this.age; // 降序
//    }
//
//}
////aaa 12
////aabc 40
////bfe 20
////liz 19
////zxe 9