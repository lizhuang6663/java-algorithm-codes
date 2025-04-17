package 洛谷.no;

import java.util.Scanner;


//洛谷： https://www.luogu.com.cn/problem/P7993

public class P7993LonelyPhotoB {

    //时间超限，可以用前缀和优化，但是还是不行
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();

        long result = 0;
        for (int i = 0; i <= str.length() - 3; i++) {
            for (int j = i + 3; j < str.length() + 1; j++) {
                String temp = str.substring(i, j);

                long numG = temp.length() - temp.replace("G", "").length();
                long numH = temp.length() - temp.replace("H", "").length();

                if ((temp.contains("G") && numG < 2) || (temp.contains("H") && numH < 2) ) result++;

            }
        }
        System.out.println(result);
    }


    // 数学解法：https://www.luogu.com.cn/article/r9onbw4d
    /*


    #include <cstdio>
#define N 500007
typedef long long unsigned llu;
int n;
char t[N];
llu c;
llu a[N],b[N];
int g,h;
int P24多路归并Ⅱ(){
	scanf("%d%s",&n,t+1);
	g=h=0;
	for(int i=1;i<=n;++i){
		if(t[i]=='G'){
			a[i]=b[g]=i-g-1;
			g=i;
		}
		else{
			a[i]=b[h]=i-h-1;
			h=i;
		}
	}
	b[g]=n+1-g-1,
	b[h]=n+1-h-1;
	for(int i=1;i<=n;++i){
		if(a[i]>=2){
			c+=a[i]-1;
		}
		if(b[i]>=2){
			c+=b[i]-1;
		}
		if(a[i]>=1&&b[i]>=1){
			c+=a[i]*b[i];
		}
	}
	printf("%llu\n",c);
	return 0;
}

     */

}


/*

输入：
50
GGGGGGGGGGGGGGGGGGGGGGGGGHGGGGGGGGGGGGGGGGGGGGGGGG

输出：647
 */