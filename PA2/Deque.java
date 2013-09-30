import java.util.NoSuchElementException;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first, last;
    private int N;
    private class Node
    {
        Item   item;
        Node   prev;
        Node   next;
    }
    public Deque()                     // construct an empty deque
    {
        first = null;
        last  = null;
        N     = 0;
    }
    public boolean isEmpty()           // is the deque empty?
    {
        return N == 0;
    }
    public int size()                  // return the number of items on the deque
    {
        return N;
    }
    public void addFirst(Item item)    // insert the item at the front
    {
        if (item == null) throw new NullPointerException();
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (isEmpty()) last = first;
        else          oldfirst.prev = first;
        N++;
    }
    public void addLast(Item item)     // insert the item at the end
    {
        if (item == null) throw new NullPointerException();
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.prev  = oldlast;
        if (isEmpty()) first = last;
        else          oldlast.next = last;
        N++;
    }
    public Item removeFirst()          // delete and return the item at the front
    {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item  = first.item;
        first      = first.next;
        N--;
        if (isEmpty()) { last = null; }
        else { first.prev = null; }
        return item;
    }
    public Item removeLast()           // delete and return the item at the end
    {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = last.item;
        last      = last.prev;
        N--;
        if (isEmpty()) { first = null; }
        else { last.next = null; }
        return item;
    }

    public Iterator<Item> iterator()   // return an iterator over items in order from front to end
    {   return new DequeIterator();  }

    private class DequeIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext() {  return current != null;  }
        public void remove()     {  throw new UnsupportedOperationException("Cannot Remove");  }
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current   = current.next;
            return item;
        }
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        StdOut.println(N + " random integers between 0 and 99");
        Deque<Integer> alist = new Deque<Integer>();
        for (int i = 0; i < N; i++)
            alist.addLast((int) (100 * Math.random()));
        //for (Integer i : alist)
        //    StdOut.println(i);
        // remove
        StdOut.println("remove from first");
        while (!alist.isEmpty())
        {
            StdOut.println("size of list:" + alist.size());
            StdOut.println(alist.removeFirst());
        }
        for (int i = 0; i < N; i++)
            alist.addFirst((int) (100 * Math.random()));
        StdOut.println("new list");
        //for (Integer i : alist)
        //    StdOut.println(i);
        // remove
        StdOut.println("remove from last");
        while (!alist.isEmpty())
            StdOut.println(alist.removeLast());
    }
}
