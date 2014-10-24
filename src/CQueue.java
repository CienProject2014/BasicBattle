import java.lang.reflect.Array;

public class CQueue<T> implements Queue<T>{
     
    private static final int capacity = 5;
    private T[] Q;
    private final int N; // capacity
    private int f = 0;
    private int r = 0;
 
     
    public CQueue(){
        this(capacity);
    }
     
    @SuppressWarnings("unchecked")
	public CQueue(int capacity){
        N = capacity;
        Q = (T[]) new Object[N];
    }
 
    public int size() {
        if(r > f)
            return r - f;
        return N - f + r;
    }
 
    public boolean isEmpty() {
        return (r == f) ? true : false;
    }
 
    public boolean isFull() {
        int diff = r - f; 
        if(diff == -1 || diff == (N -1))
            return true;
        return false;
    }
 
    public void enqueue(T obj) throws QueueFullException {
        if(isFull()){
            throw new QueueFullException("Queue is Full.");
        }else{
            Q[r] = obj;
            r = (r + 1) % N;
        }
    }
 
    public T dequeue() throws QueueEmptyException {
        T item; 
        if(isEmpty()){
            throw new QueueEmptyException();
        }else{
            item = Q[f];
            Q[f] = null;
            f = (f + 1) % N;
        }
       return item;
    }
 
}