public interface Queue<T> {
     
    // return the size of the queue
    public int size();
     
    public boolean isEmpty();
     
    public boolean isFull();
     
    // insert an element into the queue 
    public void enqueue(T obj) throws QueueFullException;
     
    // removes an element from the queue 
    public T dequeue() throws QueueEmptyException;
    
    public class QueueFullException extends RuntimeException {
    	 
        public QueueFullException(){
            super();
        }
         
        public QueueFullException(String message){
            super(message);
        }
         
        public QueueFullException(String message, Throwable cause){
            super(message, cause);
        }
    }

    public class QueueEmptyException extends RuntimeException {
    	 
        public QueueEmptyException(){
            super();
        }
         
        public QueueEmptyException(String message){
            super(message);
        }
         
        public QueueEmptyException(String message, Throwable cause){
            super(message, cause);
        }
    }
 
}

