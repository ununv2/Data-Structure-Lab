
public class Deck extends DeQLinkedList{
	private DeQLinkedList deck;
	
	public Deck() {
		deck = new DeQLinkedList();
	}
	
	public int draw() {
		if(deck.isEmpty()) {
			return -1;
		}
		try {
			return deck.removeFirst();
		} catch (Exception e) {
			return -1;
			}
	}
	
	public int removeNth(int n) {
		int cardValue;
		try {
			cardValue = deck.theList.findKth(n);
			deck.theList.remove(cardValue);
			return cardValue;
			
		} catch (Exception e) {
		}
		return -1;
		
	}
	
	public void putBottom(int n) {
		
		try {
			deck.insertLast(n);
		} catch (Exception e) {
		}
		
	}

	public void reverseTopN(int n) {
		DeQLinkedList deckTemp = new DeQLinkedList();
		try {
			if(deck.isEmpty()) {
				return;
			}
			if(n > deck.size()) {
				n = deck.size();
			}
			for(int i=0; i < n; i++) {
				deckTemp.insertFirst(deck.removeFirst());
			}
			while(!deckTemp.isEmpty()) {
				deck.insertFirst(deckTemp.removeLast());
			}
		}catch(Exception e){
			
		}
		
		
	}
}
