public class CardQueue {
    private Node front, rear;
    private static class Node {
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
    public void enqueue(String data) {
        Node newNode = new Node(data);
        if(rear == null){
            front = rear = newNode;
        }
         else {
             rear.next = newNode;
             rear = newNode;
        }
    }
    public String dequeue() {
        if (front == null) {
            return null;
        }
        String data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }
    public boolean isEmpty() {
        return front == null;
    }
    public String[] toArray() {
        int size = 0;
        Node temp = front;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        String[] array = new String[size];
        temp = front;
        int index = 0;
        while(temp!=null){
            array[index++] = temp.data;
            temp = temp.next;
        }
        return array;
    }
    public void clear(){
        front = rear = null;
    }
}


