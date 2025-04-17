package 校队.Num4月28日_牛客小白月赛92;

import java.util.Scanner;

// 数学
// 牛客：https://ac.nowcoder.com/acm/contest/81126/C

public class C耕种时间到 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[100005];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();

        long max = 0;
        // 容易知道 3^30 > 10^9，所以收割 30 次以后所有小麦种子的等级都会为 1。
        for (int i = 0; i <= 30; i++) {
            long cur = 0;

            for (int j = 1; j <= n; j++) {
                long times = i, hava = 1, num = arr[j];
                while (times-- > 0) {
                    num = (int) Math.ceil(1.0 * num / 3.0); // 向上取整
                    hava *= 2;
                }
                if (num == x) cur += hava;
            }
            max = Math.max(max, cur);
        }
        System.out.println(max);
    }
}


/*
 int n,x;cin>>n;
    vector<int>a(n);
    for(auto&v:a) cin>>v;
    cin>>x;
    ll num=1,ans=0;
    for(int i=0;i<20;++i){
        ll t=0;
        for(int j=0;j<n;++j){
            if(a[j]==x) ++t;
            a[j]=(a[j]+2)/3;
        }
        ans=max(ans,num*t);
        num*=2ll;
    }
    cout<<ans;

 */
