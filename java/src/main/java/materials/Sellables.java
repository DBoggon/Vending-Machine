package materials;

public abstract class Sellables {

	private String name;
	private Double price;
	private String slotLocation;
	private Integer quantity = 5;
	String snackType = "";
	private String snackMotto;
	
	//public static List<Sellables> sellablesList = new ArrayList<Sellables>();

	public Sellables(String name, Double price, String slotLocation, int quantity, String snackType, String snackMotto) {
		
		this.name = name;
		this.price = price;
		this.slotLocation = slotLocation;
		this.quantity = quantity;
		this.snackType = "";
		this.snackMotto = snackMotto;

	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		
		return price;
	}

	public String getSlotLocation() {
		return slotLocation;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getSnackType() {
		return snackType;

	}
	
	public String getsnackMotto() {
	return snackMotto;
	}

	public String setsnackMotto() {
		// TODO Auto-generated method stub
		return null;
	}

}

//A1|Potato Crisps|3.05|Chip
//A2|Stackers|1.45|Chip
//A3|Grain Waves|2.75|Chip
//A4|Cloud Popcorn|3.65|Chip
//
//B1|Moonpie|1.80|Candy
//B2|Cowtales|1.50|Candy
//B3|Wonka Bar|1.50|Candy
//B4|Crunchie|1.75|Candy
//
//C1|Cola|1.25|Drink
//C2|Dr. Salt|1.50|Drink
//C3|Mountain Melter|1.50|Drink
//C4|Heavy|1.50|Drink
//
//D1|U-Chews|0.85|Gum
//D2|Little League Chew|0.95|Gum
//D3|Chiclets|0.75|Gum
//D4|Triplemint|0.75|Gum

