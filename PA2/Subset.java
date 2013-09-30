public class Subset
{
    public static void main(String[] args)
    {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> stringQueue = new RandomizedQueue<String>();
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            stringQueue.enqueue(s);
        }
        while (k > 0)
        {
            String w = stringQueue.dequeue();
            StdOut.println(w);
            k--;
        }
        //for(String i :stringQueue){
        //    StdOut.println(i);
        //}
    }
}
