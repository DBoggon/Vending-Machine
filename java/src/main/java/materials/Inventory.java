package materials;

import java.time.LocalDateTime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import com.techelevator.VendingMachineCLI;
import com.techelevator.view.Menu;



import java.time.LocalDate;

public class Inventory {
	
	
	

	private List<Sellables> sellablesList = new ArrayList<Sellables>();

	public Inventory() {

		File productFile = new File("vendingmachine.csv");

		try {
			Scanner scanner = new Scanner(productFile);

			while (scanner.hasNextLine()) {

				String line = scanner.nextLine();
				String[] snackArr = line.split("\\|");

				if (snackArr[3].equals("Chip")) {
					Sellables chips = new Chips(snackArr[1], Double.parseDouble(snackArr[2]), snackArr[0], 5,
							snackArr[3], "Crunch Crunch, Yum!");
					sellablesList.add(chips);
				}
				if (snackArr[3].equals("Candy")) {
					Sellables candy = new Candy(snackArr[1], Double.parseDouble(snackArr[2]), snackArr[0], 5,
							snackArr[3], "Munch Munch, Yum!");
					sellablesList.add(candy);
				}
				if (snackArr[3].equals("Gum")) {
					Sellables gum = new Gum(snackArr[1], Double.parseDouble(snackArr[2]), snackArr[0], 5, snackArr[3],
							"Chew Chew, Yum!");
					sellablesList.add(gum);
				}
				if (snackArr[3].equals("Drink")) {
					Sellables drink = new Drink(snackArr[1], Double.parseDouble(snackArr[2]), snackArr[0], 5,
							snackArr[3], "Glug Glug, Yum!");
					sellablesList.add(drink);
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("file read error");
		}
	}

	public List<Sellables> getSellables() {
		return this.sellablesList;
	}

//	public void auditLog() {
//
//		List<String> dateTime = new ArrayList<String>();
//		String fileName = "Log.txt";
//		File newFile = new File(fileName);
//		
//		try (PrintWriter log = new PrintWriter(newFile.getAbsoluteFile())) {
//			LocalDateTime dasDate = LocalDateTime.now();
//			for (int i =0; i < dateTime.size(); i++) {
//				dateTime.addAll(dateTime);
//			}
//			log.write(toStringLog());
//			log.write(dateTime.size());
//		
////			log.write(dasDate.getMonthValue());
////			log.write(dasDate.getDayOfMonth());
////			log.write(dasDate.getYear());
////			log.write(dasDate.getHour());
////			log.write(dasDate.getMinute());
////			log.write(dasDate.getSecond());
//		} catch (FileNotFoundException e1) {
//
//			System.out.println("Something went wrong.");
//			
//			// e1.printStackTrace();
//		}
//
//		
//	}
//	
	
	
	
}
