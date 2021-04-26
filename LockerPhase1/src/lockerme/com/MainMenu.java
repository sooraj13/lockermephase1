package lockerme.com;

import java.util.Scanner;

public class MainMenu {
	
	
	static FileManager fm =  new FileManager();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		startApp();

	}


	public static void startApp() {
		
		System.out.println("------------------------------------------------------------");
		System.out.println("    LOCKERME.COM                ");
		System.out.println("                Developed By : Sooraj PV");
		System.out.println("------------------------------------------------------------");
		System.out.println("Press A For Displaying Files In Ascending Order");
		System.out.println("Press B For Add,Delete Or Search Files");
		System.out.println("Press C For Closing The Application");
		
		String option = sc.nextLine();
		if(option.equalsIgnoreCase("A")) {
			System.out.println("Kindly Enter The Directory To Be Searched (Example:  F:/sooraj ): ");
			String path = sc.nextLine();
			fm.displayFiles(path);
		}
		else if(option.equalsIgnoreCase("B")){
			subMenu();
		}
		else if(option.equalsIgnoreCase("C")) {
			System.out.println("Application Terminated");
		}
		else {
			System.out.println("Invalid Option Provided.Kindly Provide A Valid Input.");
			System.out.println("\n");
			startApp();
		}
	}


	public static void subMenu() {

		System.out.println("Press 1 To Add File ");
		System.out.println("Press 2 To Delete File");
		System.out.println("Press 3 To Search File");
		System.out.println("Press 4 For Going Back To Main Menu");
		String subOption = sc.nextLine();
		if(subOption.equalsIgnoreCase("1")) {
			System.out.println("Kindly Enter The Directory Where File Needs To Be Added (Example:  F:/sooraj ): ");
			String path = sc.nextLine();
			System.out.println("Please Provide The File Name  With Extension: ");
			String fileName = sc.nextLine();
			fm.addFile(fileName,path);
			System.out.println("\n");
			subMenu();
		}
		else if(subOption.equalsIgnoreCase("2")) {
			System.out.println("Kindly Enter The Directory Where File Needs To Be Deleted From (Example:  F:/sooraj ): ");
			String path = sc.nextLine();
			System.out.println("Please provide the file name to delete with extension: ");
			String fileName = sc.nextLine();
			fm.deleteFile(fileName,path);
			System.out.println("\n");
			subMenu();
		}
		else if(subOption.equalsIgnoreCase("3")) {
			System.out.println("Kindly Enter The Directory Where File Needs To Be Searched (Example:  F:/sooraj ): ");
			String path = sc.nextLine();
			System.out.println("Please provide the file name to be searched with extension: ");
			String fileName = sc.nextLine();
			fm.searchFile(fileName,path);
			System.out.println("\n");
			subMenu();
		}
		else if(subOption.equalsIgnoreCase("4")) {
			System.out.println("\n");
			startApp();
		}
		else {
			System.out.println("Invalid Option Provided.Kindly Provide A Valid Input.");
			System.out.println("\n");
			subMenu();
		}

	}

}
