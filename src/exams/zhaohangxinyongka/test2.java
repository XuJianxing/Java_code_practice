package exams.zhaohangxinyongka;
/*
给一个树，1是根节点，有边权，可能是负数，
求每个点构成的子树里，从根出发最长的路径（可以没有路径，所以至少是0）节点数20W

dp的是dp[当前节点]=max(dp[子节点]+路径权)，遍历一遍树就行
重点是存边的方式吧..用的acm里的方法，链表vector那种存也行，别二维数组..
别开N*N的二维数组..存双向边，存答案用longlong..
 */
import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
    /*
struct { int v, w, ne; }a[200005 << 1];
int h[200005];
int k;
int vi[200005];
LL ans[200005];
void add(int u, int v, int w)//初始k=1
{
    a[k].v = v, a[k].w = w, a[k].ne = h[u], h[u] = k++;
}
LL dfs(int u)
{
    if (vi[u] == 1)
        return ans[u];
    vi[u] = 1;
    for (int i = h[u]; i; i = a[i].ne)
    {
        LL temp = a[i].w;

        if (vi[a[i].v] == 0)
            ans[u] = max(ans[u], temp + dfs(a[i].v));
    }
    return ans[u];
}

int main()
{
    int i, j;
    int n;
    while (~scanf("%d", &n))
    {
        k = 1;
        for (i = 1; i < n; i++)
        {
            int x, y, z;
            scanf("%d%d%d", &x, &y, &z);
            add(x, y, z);
            add(y, x, z);
        }
        printf("%lld", dfs(1));

        for (i = 2; i <= n; i++)
            printf(" %lld",dfs(i));
        puts("");
    }
    return 0;
}

     */
}
