package bai2;

import java.util.HashSet;
import java.util.Set;

public class datve extends Thread{
    private final int totalSeats;
    private final Set<Integer> soldTickets = new HashSet<>();


    public datve(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public synchronized boolean bookTicket(String agentName, int seatNumber) {
        if (seatNumber < 1 || seatNumber > totalSeats || soldTickets.contains(seatNumber)) {
            System.out.println(agentName + ": Ghế " + seatNumber + " đã được đặt trước hoặc không hợp lệ.");
            return false;
        }
        soldTickets.add(seatNumber);
        System.out.println(agentName + " Đạt thành công ghế  " + seatNumber);
        return true;
    }
}
