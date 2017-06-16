class Column {

	private String name;
	private int quantity;

	public Column(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String getNome() {
		return name;
	}

	public void decrementQuantity() {
		quantity--;
	}

	public int getQuantity() {
		return quantity;
	}
}
