package queues;

public class Register 
{
    private int numberOfCustomers = 0;
	private LinkedQueue<Customer> customerQueue;
	private Customer lastCustomer;
    private static final int MAX_LINE = 4;

	public Register() {
		customerQueue = new LinkedQueue<>();
		// customer_queue = new ArrayQueue<>();
	}

	public void addCustomer() 
    {
		if (!isFull()) 
        {
			if (isEmpty()) 
            { 
				Customer new_customer = new Customer();
				customerQueue.enqueue(new_customer);
				numberOfCustomers++;
			} 
            else 
            { 
				LinkedQueue<Customer> temp = new LinkedQueue<>();
				// ArrayQueue<Customer> temp = new ArrayQueue<>();
				int tempNum = numberOfCustomers;
				while (!isEmpty()) {
					lastCustomer = customerQueue.dequeue();
					numberOfCustomers--;
					temp.enqueue(lastCustomer);
				}
				double extraTime = lastCustomer.remainingTime();
				customerQueue = temp;
				Customer newCustomer = new Customer();
				newCustomer.updateTime(extraTime);
				customerQueue.enqueue(newCustomer);
				numberOfCustomers = tempNum;
				numberOfCustomers++;
			}

		}
	}

	public int getLineLength() 
    {
		return numberOfCustomers;
	}

	public boolean isFull() 
    {
		return numberOfCustomers == MAX_LINE;
	}

	public boolean isEmpty() 
    {
		return numberOfCustomers == 0;
	}

	public int updateReg(double arrival_time) 
    {
		int count = 0;
		int temp_num = numberOfCustomers;
		LinkedQueue<Customer> temp = new LinkedQueue<>();
		// ArrayQueue<Customer> temp = new ArrayQueue<>();
		if (!isEmpty()) 
        {
			while (!isEmpty()) 
            {
				Customer customer = customerQueue.dequeue();
				numberOfCustomers--;
				customer.updateTime(-arrival_time);
				if (customer.remainingTime() <= 0) 
                {
					count++;
				} 
                else 
                {
					temp.enqueue(customer);
				}
			}
			customerQueue = temp;
			numberOfCustomers = temp_num - count;
		}
		return count;
	}
}
