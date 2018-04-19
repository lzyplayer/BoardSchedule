import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by vicky on 2018/4/18.
 */
public class BoardingScheduler {
    private static BoardingHeap boardingHeap = new BoardingHeap();
    public static Queue<Passenger> boardSettle = new LinkedList<Passenger>();//包含已经上飞机
    private static int  time = 0;

    public static void boardFlight(Iterator<Passenger> passengers){
        Queue<Passenger> passengerQueue =new LinkedList<Passenger>() ;
        while (passengers.hasNext()) {//把所有准备checkin的乘客装进队列
            passengerQueue.offer(passengers.next());
        }
        while(!passengerQueue.isEmpty()||boardingHeap.getCurrLength()!=0){
            while (!passengerQueue.isEmpty()&&passengerQueue.element().getCheckInTime()==time){
                Passenger currP = passengerQueue.poll();
                if (currP.getPreferredBoardingNum()!=100)
                    currP.setPriority(currP.getPreferredBoardingNum());
                else currP.setPriority(calculateDoneTimeEstimate(currP));//依据是否特权来确定优先级
                boardingHeap.enque(currP);
            }
            if (boardingHeap.getCurrLength()!=0){
                Passenger toBoard = boardingHeap.dequeue();
                toBoard.setBoardTime(time);
                int ableToStartTime=time;
                Iterator<Passenger> boardIteraor =boardSettle.iterator();
                while (boardIteraor.hasNext()){ //作为即将登机的下一个乘客，根据已登机者确定完成时间
                    Passenger tarCur = boardIteraor.next();
                    if (tarCur.getSeatRow()<=toBoard.getSeatRow())
                        if(tarCur.getDoneTime()>ableToStartTime)ableToStartTime=tarCur.getDoneTime();
                }
                toBoard.setDoneTime(ableToStartTime+5);
                boardSettle.offer(toBoard);//乘客登机
            }
            time++;
//            if (time==10){
//                System.out.println("now 17");
//            }
        }
        //        p.cal
        //        p.setPriority();
    }
    public static int calculateDoneTimeEstimate(Passenger p){
        int ableToStartTime=time;
        Iterator<Passenger> boardIteraor =boardSettle.iterator();
        while (boardIteraor.hasNext()){
            Passenger tarCur = boardIteraor.next();
            if (tarCur.getSeatRow()<=p.getSeatRow())
                if(ableToStartTime<tarCur.getDoneTime())ableToStartTime=tarCur.getDoneTime();
        }
        p.setDoneTimeEstimate(ableToStartTime+5);
        return ableToStartTime+5;
    }

    /**
     * Reads in a file containing a list of flight passengers in the order they
     * check in and runs the boardFlight() method with those passengers.
     * @author Tina, Alexi
     * @param flight is the name of the input file in the project directory
     */
    public static void checkIn(String flight) {
        File f = new File(flight);
        try {
            Scanner s = new Scanner(f);
            List<Passenger> passengers = new ArrayList<Passenger>();
            while(s.hasNextLine()) {
                //Data are separated by commas and possibly also whitespace.
                String[] line = s.nextLine().split("\\s*,\\s*");
                if (line.length == 3) //Default preferredBoarding 0 constructor
                    passengers.add(new Passenger(line[0],
                            Integer.parseInt(line[1]),
                            line[2]));
                else //Use the preferredBoarding number if given
                    passengers.add(new Passenger(line[0],
                            Integer.parseInt(line[1]),
                            line[2],
                            Integer.parseInt(line[3])));
            }
            s.close();
            boardFlight(passengers.iterator());
        } catch (IOException e) {
            System.out.println("Error: Unable to load file " + flight);
        }
    }
    public static Queue<Passenger> getBoardSettle() {
        return boardSettle;
    }
}
