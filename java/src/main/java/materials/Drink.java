package materials;

public class Drink extends Sellables {

	
	public Drink(String name, Double price, String slotLocation, int quantity, String snackType, String snackMotto) {
		super(name, price, slotLocation, quantity, snackType, snackMotto);
		
	}
	
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public Double getPrice() {
		// TODO Auto-generated method stub
		return super.getPrice();
	}

	@Override
	public String getSlotLocation() {
		// TODO Auto-generated method stub
		return super.getSlotLocation();
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return super.getQuantity();
	}
	@Override
	public String getsnackMotto() {
		//snackMotto = "Glug Glug, Yum!";
		
		return super.getsnackMotto();
		}
	
	
	
	@Override
	public String getSnackType() {
		snackType = "Drink";
	return super.getSnackType();
	}
	
	
	
	
	

}
