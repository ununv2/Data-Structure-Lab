
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		int totalQueue = counters[counters.length-1].removeLast();
		counters[counters.length-1].insertLast(totalQueue);
		double nql = (double) totalQueue/(counters.length+1);
		int neededQueueLength = (int) (Math.round(nql));
		for(DeQ c: counters) {
			if(special.size()>=neededQueueLength) {
				break;
			}
			if(c.size() > neededQueueLength) {
				DeQArray temp = new DeQArray();
				int count = (int) (c.size() - neededQueueLength);
				for(int i=0;i<count;i++) {
					temp.insertFirst(c.removeLast());
				}
				while(special.size()<neededQueueLength && !temp.isEmpty()) {
					special.insertLast(temp.removeFirst());
				}
				if(!temp.isEmpty()) {
					for(int i=0;i<temp.size();i++) {
						c.insertLast(temp.removeFirst());
					}
				}			
			}
			
		}
		if(special.size() == 0) {
			special.insertFirst(counters[counters.length-1].removeLast());
		}
		
	}

}
//for(int i=0; i<counters.length;i++) {
//   if(special.size() >=Nl) {
//    break;
//   }
//   if(counters[i].size()>Nl) {
//    DeQArray temp = new DeQArray();
//    int diff = counters[i].size()-Nl;
//    for(int x=0;x<diff;x++) {
//     temp.insertLast(counters[i].removeLast());
//    }
//    while(special.size() < Nl && temp.size()!=0) {
//     special.insertLast(temp.removeLast());
//    }
//    for(int y=0;y<temp.size();y++) {
//     counters[i].insertLast(temp.removeLast());
//    }
//   }
//  }
//  if(special.size()==0) {
//   special.insertFirst(counters[queue-1].removeLast());
//  }
//  
// }
