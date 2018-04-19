import java.util.Iterator;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        BoardingScheduler.checkIn("sample2.txt");
        Queue<Passenger> boardList =BoardingScheduler.getBoardSettle();
        System.out.println("vicky's Airline :)");
        System.out.println("0 Boarding begins");
        int finalTime=0;
        while (!boardList.isEmpty()){
            Passenger temp = boardList.poll();
            System.out.println(temp.getBoardTime()+" "+temp.getName()+" "+temp.getSeat()+" (done "+temp.getDoneTime()+")");
            finalTime=temp.getDoneTime();
        }
        System.out.println((finalTime+1)+" All passengers have boarded!");

//        System.out.println("Hello World!");
//        BoardingScheduler.checkIn("sample1.txt");
//        Passenger p1 =new Passenger("1",1,"1A");
//        Passenger p2 =new Passenger("2",2,"2A");
//        Passenger p3 =new Passenger("3",3,"3A");
//        Passenger p4 =new Passenger("4",1,"1A");
//        Passenger p5 =new Passenger("5",2,"2A");
//        Passenger p6 =new Passenger("6",3,"3A");
//
//        p1.setPriority(10);
//        p2.setPriority(4);
//        p3.setPriority(3);
//        p4.setPriority(5);
//        p5.setPriority(1);
//        p6.setPriority(7);
//        BoardingHeap boardingHeap = new BoardingHeap();
//        boardingHeap.enque(p1);
//        boardingHeap.enque(p2);
//        boardingHeap.enque(p3);
//        boardingHeap.dequeue();
//        boardingHeap.enque(p4);
//        boardingHeap.dequeue();
//        boardingHeap.dequeue();
//        boardingHeap.enque(p5);
//        boardingHeap.dequeue();
//        boardingHeap.enque(p6);
//                boardingHeap.dequeue();
//                boardingHeap.dequeue();
//         System.out.println("Hello World!");
//        String seat = "12A";
//        System.out.println(Integer.parseInt(seat.substring(0,seat.length()-1)));
    }
}
