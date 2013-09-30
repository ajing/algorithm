public class Subset
{
    public static void main(String[] args)
    {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> StringQueue= new RandomizedQueue<String>();
        while(!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            StringQueue.enqueue(s);
        }
        while(k > 0)
        {
            String w = StringQueue.dequeue();
            StdOut.println(w);
            k--;
        }
        for(String i :StringQueue){
            StdOut.println(i);
        }
    }
}
