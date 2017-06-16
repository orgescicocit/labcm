class PaymentCard {

	private int id;
	private double credit;

	public PaymentCard(int id, double credit) {
		this.id = id;
		this.credit = credit;
	}

	public int getId() {
		return id;
	}

	public double getCredit() {
		return credit;
	}

	public void decreaseCredit(double cost) {
		credit -= cost;
	}

	public void recharge(double amount) {
		credit += amount;
	}
}
