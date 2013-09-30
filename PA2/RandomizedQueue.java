import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] s;
    private int N = 0;                // number of elements

    public RandomizedQueue()           // construct an empty randomized queue
    {
        s = (Item[]) new Object[1];
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
        assert capacity >= N;
        Item[] new_s = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++)
        {
            new_s[i] = s[i];
        }
        s = new_s;
    }

    public void enqueue(Item item)     // add the item
    {
        if (N == s.length)  resize( 2*s.length );
        s[N++] = item;
    }

    public Item dequeue()              // delete and return a random item
    {
        if (isEmpty()) throw new NoSuchElementException ("Queue underflow");
        int rand = StdRandom.uniform(N);
        //StdOut.println("length of array:" + s.length);
        Item item = s[rand];
        s[rand] = s[--N];
        s[N] = null;
        //for (int i = 0; i < N; i++ ) { StdOut.print(s[i]);}
        if (N < s.length/4) resize( s.length/2 );
        return item;
    }

    public Item sample()               // return (but do not delete) a random item
    {
        int rand = StdRandom.uniform(N);
        return s[rand];
    }

    public Iterator<Item> iterator()   // return an independent iterator over items in random order
    {   return new RandomizedQueueIterator();  }

    private class RandomizedQueueIterator implements Iterator<Item>
    {
        private int current = 0;
        public boolean hasNext() {  return current < N;  }
        public void remove()     {  throw new NoSuchElementException();  }
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = s[current++];
            return item;
        }
    }
}
