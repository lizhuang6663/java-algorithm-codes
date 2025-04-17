package common.homework;

import java.util.Scanner;

// 二进制转为十六进制
// 校队：https://ac.nowcoder.com/acm/contest/75588/B

public class Num18 {
//    public static void P24多路归并Ⅱ(String[] args) {
//        // 没有通过全部案例：不正确，可能是二进制字符串案例长度太长了
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        for (int i = 0; i < n; i++) {
//            String s = scanner.next();
//            // 二进制转为十进制
//            int result =  Integer.parseInt((String) s, 2);
//            System.out.println(result);
//            // 十进制转为十六进制
//            String r = Integer.toHexString(result);
//            System.out.println(r.toUpperCase());
//        }
//    }




    public static void main(String[] args) {
        Integer.parseInt("", 2);

        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        while (t-- > 0) {
            String binaryString = scanner.next();
            String hexString = binaryToHex(binaryString);
            System.out.println(hexString.toUpperCase());
        }
    }
    // 在 binaryToHex 方法中，首先对输入的二进制字符串进行补位，确保其长度是4的倍数。
    // 然后，遍历二进制字符串，每次取4位进行处理，将其转换为对应的十进制数，再将该十进制数转换为十六进制数，并添加到结果字符串中。
    // 最后返回转换后的十六进制字符串。

    // （为什么每次都是取4位处理？
    // 每次取4位处理是因为在二进制数转换为十六进制数时，每4位二进制数对应一个十六进制数。具体地说，十六进制中的一个数字可以表示4位二进制数的所有可能性，
    // 从 0000 到 1111（即从 0 到 15）。因此，为了将二进制数转换为十六进制数，我们需要将二进制数按照每4位进行分组处理。）
    public static String binaryToHex(String binaryString) {
        while (binaryString.length() % 4 != 0) {
            binaryString = "0" + binaryString;
        }

        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i += 4) {
            String binaryChunk = binaryString.substring(i, i + 4);
            int decimal = Integer.parseInt(binaryChunk, 2);
            String hex = Integer.toHexString(decimal);
            hexString.append(hex);
        }
        return hexString.toString();
    }


    // 笨方法：
//    public static void P24多路归并Ⅱ(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while (n-->0){
//            String str  = sc.next();
//            int len = str.length();
//            if (len%4==1){
//                str="000"+str;
//            }else if(len%4==2){
//                str="00"+str;
//            }else if (len%4==3){
//                str="0"+str;
//            }
//
//            String result = "";
//            // 十六进制每个数字对应 4 位二进制数（将二进制每四位转为一个十六进制）
//            for (int i=0;i<str.length();i+=4){
//
//                if (str.substring(i,i+4).equals("0001")){
//                    result+="1";
//                }else if (str.substring(i,i+4).equals("0010")){
//                    result+="2";
//                }else if (str.substring(i,i+4).equals("0011")){
//                    result+="3";
//                }else if (str.substring(i,i+4).equals("0100")){
//                    result+="4";
//                }else if (str.substring(i,i+4).equals("0101")){
//                    result+="5";
//                }else if (str.substring(i,i+4).equals("0110")){
//                    result+="6";
//                }else if (str.substring(i,i+4).equals("0111")){
//                    result+="7";
//                }else if (str.substring(i,i+4).equals("1000")){
//                    result+="8";
//                }else if (str.substring(i,i+4).equals("1001")){
//                    result+="9";
//                }else if (str.substring(i,i+4).equals("1010")){
//                    result+="A获得木头";
//                }else if (str.substring(i,i+4).equals("1011")){
//                    result+="B";
//                }else if (str.substring(i,i+4).equals("1100")){
//                    result+="C_PolycarpRecoversthePermutation";
//                }else if (str.substring(i,i+4).equals("1101")){
//                    result+="D";
//                }else if (str.substring(i,i+4).equals("1110")){
//                    result+="E";
//                }else if (str.substring(i,i+4).equals("1111")){
//                    result+="FStonesinTheBucket";
//                }else if(str.substring(i,i+4).equals("0000")){
//                    result+="0";
//                }
//            }
//            System.out.println(result);
//        }
//    }

}

/*

2
01110001
10110010

71
B2

 */





