
public class SimulateQueue {

	CustomerInfo[][] allEvents; //events in each and every queue
 
	MyQueue[] allQueues; // queues of people, corresponding to the events

	public SimulateQueue(CustomerInfo[][] allEvents, MyQueue[] allQueues) {
		super();
		this.allEvents = allEvents;
		this.allQueues = allQueues;
	}

	public void stateBeforeTimeT(int t) throws Exception {
		//TODO: implement this method.
		int index = 0;
		for(CustomerInfo[] eachQueue : allEvents) {
			for(CustomerInfo eachEvent: eachQueue) {
				if(eachEvent.getTime() >= t) {
					break;
				}
				if(eachEvent.getEvent() == 1) {
					allQueues[index].insertLast(1);
				}else if(eachEvent.getEvent() == -1) {
					if(!allQueues[index].isEmpty()) {
						allQueues[index].removeFirst();
					}
				}
			}
			index++;
			
			
		}



	}

}
