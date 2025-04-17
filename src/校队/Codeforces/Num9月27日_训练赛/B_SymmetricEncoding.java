package 校队.Codeforces.Num9月27日_训练赛;

// 简单
// Codeforces：https://vjudge.net/contest/657988#problem/A

public class B_SymmetricEncoding {

}


/*

package P24多路归并Ⅱ

import (
	"fmt"
	"sort"
	"strings"
)

func P24多路归并Ⅱ() {
	t := 0
	fmt.Scanln(&t)
	for i := 0; i < t; i++ {
		n := 0
		str := ""
		fmt.Scanln(&n)
		fmt.Scanln(&str)

		// 提取字符串
		temp := ""
		for j := 0; j < n; j++ {
			if strings.Contains(temp, string(str[j])) {
				continue
			}
			temp += string(str[j])
		}
		runes := []rune(temp)
		sort.Slice(runes, func(i, j int) bool {
			return runes[i] < runes[j]
		})
		temp = string(runes)

		// map：对应关系
		m := make(map[byte]byte)
		for j := 0; j < len(temp); j++ {
			m[temp[j]] = temp[len(temp)-j-1]
		}

		// 输出
		for j := 0; j < len(str); j++ {
			fmt.Print(string(m[str[j]]))
		}
		fmt.Println()
	}
}



 */