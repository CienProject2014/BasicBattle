public class CQueue<T> {
	T t;
	private int front;
	private int rear;
	private int maxSize;
	private T[] queueArray;
	
	@SuppressWarnings("unchecked")
	// ť �迭 ����
	public CQueue(int maxSize){
		
		this.front = 0;
		this.rear = -1;
		
		// ���� ũ�⺸�� �ϳ� ũ�� �����Ѵ� (����� ��ȭ�� ���� ����)
		this.maxSize = maxSize+1;
		this.queueArray = (T[])new Object[this.maxSize];
	}
	
	// ť�� ����ִ��� Ȯ��
	public boolean empty(){
		return (front == rear+1) || (front+maxSize-1 == rear);
	}
	
	// ť�� �� á���� Ȯ��
	public boolean full(){
		return (rear == maxSize-1) || (front+maxSize-2 == rear);
	}
	
	// ť rear�� ������ ���
	public void push(T item){
		
		if(full()) throw new ArrayIndexOutOfBoundsException();
		
		// rear �� �迭�� �������̸� rear �����͸� ������ ������.
		if(rear == maxSize-2){
		rear = -1;
		}
		queueArray[++rear] = item;
	}
	
	// ť���� front ������ ��ȸ
	public T peek(){
		
		if(empty()) throw new ArrayIndexOutOfBoundsException();
		
		return queueArray[front];
	}
	
	// ť���� front ������ ����
	public T get(){
		
		T item = peek();
		front++;
		
		// front�� ���� index�� �迭ũ��+1 �̸� ó������ ���ư���
		if(front==maxSize){
		front = 0;
		}
		return item;
	}
}