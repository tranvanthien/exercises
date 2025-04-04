package bai34;

public class MyTime {
	private int hour=0;
	private int minute=0;
	private int second =0; 
	
	public MyTime() {
	}
	
	public MyTime(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return "MyTime [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}
	 public MyTime nextSecond() {
        second++;
        if (second == 60) {
            second = 0;
            nextMinute();
        }
        return this;
    }
	
	 public MyTime nextMinute() {
	        minute++;
	        if (minute == 60) {
	            minute = 0;
	            nextHour();
	        }
	        return this;
	    }
	 public MyTime nextHour() {
	        hour = (hour + 1) % 24;
	        return this;
	 
	 }
	 public MyTime previousSecond() {
	        second--;
	        if (second < 0) {
	            second = 59;
	            previousMinute();
	        }
	        return this;
	    }

	    public MyTime previousMinute() {
	        minute--;
	        if (minute < 0) {
	            minute = 59;
	            previousHour();
	        }
	        return this;
	    }

	    public MyTime previousHour() {
	        hour = (hour - 1 + 24) % 24;
	        return this;
	    }
}