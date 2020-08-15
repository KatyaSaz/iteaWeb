package wb.model;

public class Product {

	private int id;
	private double price;
	private String description;
	private String shortDescription;
	private String name;
	private int category;

	public Product() {
	}

	public Product(int id, double price, String description, String name, int category) {
		super();
		this.id = id;
		this.price = price;
		this.description = description;
		this.name = name;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public Product setId(int id) {
		this.id = id;
		return this;
	}

	public String getPrice() {
		return String.format("%.2f", price);
	}

	public Product setPrice(double price) {
		this.price = price;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Product setDescription(String description) {
		this.description = description;
		return this;
	}
	

	public String getShortDescription() {
		return description.substring(0, 100)+"...";
	}

	public String getName() {
		return name;
	}

	public Product setName(String name) {
		this.name = name;
		return this;
	}

	public int getCategory() {
		return category;
	}

	public Product setCategory(int category) {
		this.category = category;
		return this;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", description=" + description + ", name=" + name
				+ ", category=" + category + "]";
	}

}
