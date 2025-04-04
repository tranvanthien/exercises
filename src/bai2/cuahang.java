package bai2;

public class cuahang extends Thread{
    private final datve bookingSystem;
    private final String agentName;


    public cuahang(datve bookingSystem, String agentName) {
        this.bookingSystem = bookingSystem;
        this.agentName = agentName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            int seatNumber = (int) (Math.random() * 10) + 1;
            bookingSystem.bookTicket(agentName, seatNumber);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
