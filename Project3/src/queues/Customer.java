package queues;

public class Customer 
{
    private double remaining_time;
	
	public Customer() 
    {
		this.remaining_time = 2;
	}
	
	public void updateTime(double update_time) 
    {
		remaining_time = remaining_time + update_time;
	}

    public double remainingTime() 
    {
		return remaining_time;
	}
}
