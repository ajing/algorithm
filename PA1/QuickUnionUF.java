import java.util.Arrays;

public class QuickUnionUF
{
    public int[] id;
    public QuickUnionUF(int N)
    {
        id = new int[N];
        for (int i = 0; i<N; i++) id[i] = i;
    }
    private int root(int i)
    {
        while (i!=id[i]) i = id[i];
        return i;
    }
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}

class Test2
{
    public static void main(String[] args)
    {
        QuickUnionUF UF = new QuickUnionUF(10);
//        UF.union(1,9);
//        UF.union(0,8);
//        UF.union(7,5);
//        UF.union(8,5);
//        UF.union(6,4);
//        UF.union(1,6);
//        UF.union(2,6);
//        UF.union(5,4);
//        UF.union(3,8);
        UF.union(9,8);
        UF.union(1,0);
        UF.union(4,5);
        UF.union(7,6);
        UF.union(2,1);
        UF.union(9,0);
        UF.union(6,4);
        UF.union(8,6);
        UF.union(3,5);
//        for(int i = 0; i < UF)
//        {
//        }
        System.out.println(Arrays.toString(UF.id));
    }
}