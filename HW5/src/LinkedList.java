public class LinkedList {
	public Node head = null;    
    public Node tail = null;    
    private double mean = 0;    
    
    public void addNode(int data) {        
        Node newNode = new Node(data);        
        if(head == null) {      
            head = newNode;    
            tail = newNode;    
        }    
        else {    
            tail.next = newNode;     
            tail = newNode;    
        }    
    }    
    
    public double mean() {
    	int total = 0;
    	int i = 0;
    	Node current = head;
    	while (current != null) {
    		total += current.data;
    		current = current.next;
    		i++;
    	}
    	mean = total/i;
    	return mean;
    }
    
    public double stdDev() {
    	double total = 0;
    	int i = 0;
    	Node current = head;
    	while (current != null) {
    		total += Math.pow(mean - current.data, 2);
    		current = current.next;
    		i++;
    	}
    	total = total / i;
    	return Math.sqrt(total);
    }
}
