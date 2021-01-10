package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import com.techelevator.view.Menu;
import materials.Funds;
import materials.Inventory;
import materials.Sellables;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU = { "Feed Money", "Select Product", "Finish Transaction", "Back" };
	private static final String[] FEED_MONEY_MENU = { "1", "5", "10", "Back" };
	private Menu menu;
	private Funds funds = new Funds();
	Inventory inventoryList = new Inventory();

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}
	

	public Object inventoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}


	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			System.out.println("You picked: " + choice);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				List<Sellables> listOfStuff = inventoryList.getSellables();
				for (Sellables groupOfItems : listOfStuff) {
					Integer quanity = groupOfItems.getQuantity();
					System.out.println(groupOfItems.getName() + "|" + groupOfItems.getSnackType());
				}
			}
			if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				// do purchase

				String selection = "";

				while (!selection.equals("Back")) {
					selection = (String) menu.getChoiceFromOptions(PURCHASE_MENU);

					if (selection.equals("Feed Money")) {
						processMoney();
					}

					if (selection.equals("Select Product")) {

					}
					if (selection.equals("Finish Transaction")) {
						funds.changeBack();

						System.out.println("\n" + "Thank you for your purchase.");
						break;
					}

					List<Sellables> listOfStuff = inventoryList.getSellables();

					for (Sellables groupOfItems : listOfStuff) {
						Integer quanity = groupOfItems.getQuantity();
						System.out.println(groupOfItems.getSlotLocation() + "|" + groupOfItems.getName() + "|"
								+ groupOfItems.getPrice() + "|" + groupOfItems.getSnackType() + "|" + quanity
								+ " REMAINING");

					}

					// 1. Let's ask the user what they want.
					Scanner scanner = new Scanner(System.in);
					System.out.println("\n" + "Select something to buy");
					String someName = scanner.nextLine().toUpperCase();

					// 2. Loop through the inventory list and see if we can find it.
					for (Sellables items : listOfStuff) {

						// TODO:
						// - If you don't have enough money, you can't go into this if block.
						
						
						
					

						Double currentFunds = funds.getBalance();
						Double itemPrice = items.getPrice();

						if (currentFunds < 0.75) {
							System.out.println("Ope, enter more money");
							break;
						}

						if (someName.equals(items.getSlotLocation())) {

							// TODO:
							// - If the inventory is already zero, you can't deduct the qty, and
							// therefore you can't buy

							int currentQty = items.getQuantity();
							int newQty = currentQty - 1;
							items.setQuantity(newQty);

							while (funds.getBalance() >= items.getPrice()) {

								if (newQty >= 1) {
									funds.setDeductBalance(itemPrice);

									System.out.println("\n" + "You've selected " + items.getName() + " for $"
											+ items.getPrice() + ". " + items.getsnackMotto());

									System.out.println(
											"\n" + "There are " + newQty + " " + items.getName() + " remaining! ");

									if (newQty <= 0) {
										System.out.println("SOLD OUT");
									}

									System.out.println("\n" + "You have $" + funds.getBalance() + " left.");

									if (currentFunds < itemPrice) {
										System.out.println("Ope, your current balance is " + currentFunds
												+ " please add more funds.");
									}
									break;
								}

							}

						}
					}
				}

			}
			if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				auditLog();
				System.out.println("Thank you! Come Again!");
				System.exit(0);
			}
		}
	}

	public void processMoney() {

		String selection = "";
		while (!selection.equals("Back")) {

			selection = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU);

			if (selection.equals("1")) {
				funds.setBalance(1);

			}

			else if (selection.equals("5")) {
				funds.setBalance(5);

			}

			else if (selection.equals("10")) {
				funds.setBalance(10);

			}

			System.out.println("You have $" + funds.getBalance());
		}

	}
	
	//toString time/date works well
	//right now, log only stores last choice, not entire day
	//maybe implementing a list and/or loop somewhere to store entire day
	
	
	public String toStringLog() {
		
		SimpleDateFormat timeStamp = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
		String purchase = (String) menu.getChoiceFromOptions(PURCHASE_MENU);
		
		DecimalFormat df2 = new DecimalFormat("#.##");
		
		String getBal = df2.format(funds.getBalance());
		//String getChange = df2.format(funds.balance);
																										//not right
		return " > " + timeStamp.format(Calendar.getInstance().getTime()) + " " + purchase +  ": " + "$" + getBal + "$" + getChange;
		
	}
	
	public void auditLog() {

		List<String> dateTime = new ArrayList<String>();
		String fileName = "Log.txt";
		File newFile = new File(fileName);
		
		try (PrintWriter log = new PrintWriter(newFile.getAbsoluteFile())) {
			LocalDateTime dasDate = LocalDateTime.now();
			for (int i =0; i < dateTime.size(); i++) {
				dateTime.addAll(dateTime);
			}
			log.write(toStringLog());
			log.write(dateTime.size());
		
//			log.write(dasDate.getMonthValue());
//			log.write(dasDate.getDayOfMonth());
//			log.write(dasDate.getYear());
//			log.write(dasDate.getHour());
//			log.write(dasDate.getMinute());
//			log.write(dasDate.getSecond());
		} catch (FileNotFoundException e1) {

			System.out.println("Something went wrong.");
			
			// e1.printStackTrace();
		}

		
	}
	

}
