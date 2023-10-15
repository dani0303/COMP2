package queues;

public class Store 
{
	private final int NUM_REGS = 8;
	private final double ARRIVAL_TIME = 0.25;
    private Register[] register;
	private int lost = 0;
	private int served = 0;

	public Store() 
    {
		register = new Register[NUM_REGS];
		for (int i = 0; i < register.length; i++) 
        {
			register[i] = new Register();
		}
	}

	public void update() 
    {
		for (double i = 0; i < 16 * 60; i += ARRIVAL_TIME) 
        {
			for (int j = 0; j < register.length; j++) 
            {
				served += register[j].updateReg(ARRIVAL_TIME);
			}
			int shortestLine = register[0].getLineLength();
			int index = 0;
			for (int j = 0; j < register.length; j++) 
            {
				if (register[j].getLineLength() < shortestLine) 
                {
					shortestLine = register[j].getLineLength();
					index = j;
				}
			}
			if (shortestLine < 4) 
            {
				register[index].addCustomer();
			} else 
            {
				lost++;
			}
		}
		System.out.println("Customers served: " + served + "\nlost customers: " + lost);
	}
}
