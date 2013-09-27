import java.util.Arrays;
public class QuickFindUF
{
    public int[] id;
    
    public QuickFindUF(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    
    public boolean connected(int p, int q)
    { return id[p] == id[q]; }
    
    public void union(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i <id.length; i++)
            if(id[i] == pid) id[i] = qid;
    }
}

class Test
{
    public static void main(String[] args)
    {
        QuickFindUF UF = new QuickFindUF(10);
        UF.union(2,3);
        UF.union(5,9);
        UF.union(8,3);
        UF.union(4,3);
        UF.union(6,4);
        UF.union(2,1);
//        for(int i = 0; i < UF)
//        {
//        }
        System.out.println(Arrays.toString(UF.id));
    }
}