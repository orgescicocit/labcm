
import java.util.*;

public class VendingMachine {

	private PaymentCard [] cards;
	private Beverage [] beverages;
	private Column[] columns;
	private int bevcounter=0; 
	
	public VendingMachine() {
		this.cards = new PaymentCard[100];
		this.beverages = new Beverage[10];
		this.columns = new Column[4];
	}

	public void addBeverage(String name, double price) {
		Beverage b = new Beverage(name, price);
		if (bevcounter<beverages.length){
			beverages[bevcounter]=b;
			bevcounter++;
		}
	}

	public double getPrice(String beverageName) {
		double price=-1.0;
		for (int i=0; i<beverages.length; i++){
			if (beverages[i]!=null)
				if (beverages[i].getName().equals(beverageName))
					price=beverages[i].getPrice();			
			}
		return price;
	}

	public void rechargeCard(int cardId, double credit) {
		for (int i=0; i<cards.length; i++){
			if (cards[i]!=null){
				if (cards[i].getId()==cardId)
					cards[i].recharge(credit);
			}
			else{
				cards[i]=new PaymentCard(cardId, credit);
				return;
			}
		}
	}

	public double getCredit(int cardId) {
		double credit=-1.0;
		for (int i=0; i<cards.length; i++){
			if (cards[i]!=null)
				if (cards[i].getId()==cardId){
					credit=(double)cards[i].getCredit();
				}
			}
		return credit;
	}

	public void refillColumn(int column, String beverageName, int cans) {
		if ((column > 0) && (column < 5))
			columns[column-1]=new Column(beverageName, cans);
	}

	public int availableCans(String beverageName) {
		int count = 0;
		boolean found = false;
		for(int i=0; i<columns.length; i++)
			if (columns[i]!=null)
				if (columns[i].getNome().equals(beverageName)){
					count=count+columns[i].getQuantity();
					found=true;
				}
		if (!found)
			count=-1;
		return count;
	}

	public int sell(String beverageName, int cardId) {
		if (getPrice(beverageName) < 0)
			return -1; // error: beverage does not exist
		
		if (getCredit(cardId) < 0)
			return -1; // error: card does not exist

		if (getCredit(cardId)<getPrice(beverageName))
			return -1; // not enough credit
				
		if (availableCans(beverageName)==0)
			return -1; // no cans

		// else		
		// update credit of payment card
		for (int i=0; i<cards.length; i++)
			if (cards[i]!=null)
				if(cards[i].getId()==cardId)
					cards[i].decreaseCredit(getPrice(beverageName));

		// update number of available cans
		for (int i=0; i<columns.length; i++)
			if (columns[i]!=null)
				if(columns[i].getNome().equals(beverageName)){
					columns[i].decrementQuantity();
					return i+1;
				}
		
		return -1;
		}
}
