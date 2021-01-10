package materials;

public class Gum extends Sellables{

	public Gum(String name, Double price, String slotLocation, int quantity, String snackType, String snackMotto) {
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

//	@Override
//	public String getsnackMotto() {
//		return this.getsnackMotto();
//	}
	
	
	@Override
	public String getSnackType() {
		snackType = "Gum";
	return super.getSnackType();
	}
	
	
	

}
