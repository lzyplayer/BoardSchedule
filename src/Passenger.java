/**
 * Created by vicky on 2018/4/18.
 */
public class Passenger {
    private String name;
    private int checkInTime;
    private String seat;
    private int seatRow;
    private int preferredBoardingNum = 100;
    private int estimatedBoardingTime;
    private int priority;
    private int boardTime;
    private int doneTime;

    public boolean compareTo(Passenger other){
        //here!!!!
        return true;
    }

    public void setDoneTimeEstimate(int estimatedBoardingTime) {
        this.estimatedBoardingTime = estimatedBoardingTime;
    }

    public Passenger(String name, int checkInTime, String seat) {
        this.name = name;
        this.checkInTime = checkInTime;
        this.seat = seat;
        this.seatRow=Integer.parseInt(seat.substring(0,seat.length()-1));
    }

    public Passenger(String name, int checkInTime, String seat, int preferredBoardingNum) {
        this.name = name;
        this.checkInTime = checkInTime;
        this.seat = seat;
        this.seatRow=Integer.parseInt(seat.substring(0,seat.length()-1));
        this.preferredBoardingNum = preferredBoardingNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(int checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getPreferredBoardingNum() {
        return preferredBoardingNum;
    }

    public int getEstimatedBoardingTime() {
        return estimatedBoardingTime;
    }


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getBoardTime() {
        return boardTime;
    }

    public void setBoardTime(int boardTime) {
        this.boardTime = boardTime;
    }

    public int getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(int doneTime) {
        this.doneTime = doneTime;
    }
}
