package materials;

public class Candy extends Sellables {

	public Candy(String name, Double price, String slotLocation, int quantity, String snackType, String snackMotto) {
		super(name, price, slotLocation, quantity, snackType, snackMotto);
		// TODO Auto-generated constructor stub
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

	
	public String setSnackMotto() {
	//this.snackMotto = "Munch Munch, Yum!";
		
		return super.getsnackMotto();
		}
	

	@Override
	public String getSnackType() {
		snackType = "Candy";
	return super.getSnackType();
	}
	
}




