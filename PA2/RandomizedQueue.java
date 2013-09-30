public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] s;
    private int N = 0;

    public RandomizedQueue()           // construct an empty randomized queue
    {
        s = (Item[]) new Object[1]
    }
    public boolean isEmpty()           // is the queue empty?
    {
        return N == 0;
    }
    public int size()                  // return the number of items on the queue
    {
        return s.length;
    }
    private void resize( int capacity )
    {
        Item[] new_s = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++)
        {
            new_s[i] = s[i];
        }
        s = new_s;
        N = capacity;
    }
    public void enqueue(Item item)     // add the item
    {
        if (N == s.length)  resize( 2*s.length );
        int rand = StdRandom.uniform(N)
        s[N++] = item;
    }
    public Item dequeue()              // delete and return a random item
    {
        item = s[N--];
        s[N] = null;
        if (N < s.length/4) resize( s.length/2 );
        return item;
    }
    public Item sample()               // return (but do not delete) a random item
    public Iterator<Item> iterator()   // return an independent iterator over items in random order
}
