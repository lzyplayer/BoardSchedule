
/**
 * Created by vicky on 2018/4/18.
 */
public class BoardingHeap {

    private Passenger[] passengers;
    private int currLength = 0;
    private int size =30;
    public BoardingHeap() {
        passengers = new Passenger[30];
        passengers[0] = null;
    }

    public static int Parent(int cur) {
        return cur / 2;
    }

    public static int leftChild(int cur) {
        return cur * 2;
    }

    public static int rightChild(int cur) {
        return cur * 2 + 1;
    }
    private Passenger[] expand(){
        //扩容
        Passenger[] myPassengers = new Passenger[2*(size+1)];
        int i=0;
        for(Passenger p : passengers){
            myPassengers[i]=passengers[i];
            i++;
        }
        passengers=myPassengers;
        size*=2;
        return passengers;
    }
    public void enque(Passenger per) {
        //数组大小检测
        if (currLength==(size-1))expand();
        int curr = ++currLength;
        passengers[curr] = per;
        //shifting
        while (curr != 1) {
            if (per.getPriority() < passengers[Parent(curr)].getPriority()) {
                passengers[curr] = passengers[Parent(curr)];
                passengers[Parent(curr)] = per;
                curr = Parent(curr);
            } else break;
        }
    }

    public Passenger dequeue() {
        if (currLength == 0) return null;
        Passenger result = passengers[1];
        int curr = currLength--;
        passengers[1] = passengers[curr];
        curr = 1;
        while (leftChild(curr) <= currLength) {
            int ready;
            if (rightChild(curr) <= currLength) {
                if (passengers[rightChild(curr)].getPriority() <= passengers[leftChild(curr)].getPriority()) {
                    ready = rightChild(curr);
                } else ready = leftChild(curr);
            }
            else  ready = leftChild(curr);
            if (passengers[curr].getPriority()>=passengers[ready].getPriority()){
                Passenger temp =passengers[curr];
                passengers[curr]= passengers[ready];
                passengers[ready]= temp;
                curr = ready;
                }
                else break;


        }
        return result;
    }

    public int getCurrLength() {
        return currLength;
    }

    public void setCurrLength(int currLength) {
        this.currLength = currLength;
    }
}
