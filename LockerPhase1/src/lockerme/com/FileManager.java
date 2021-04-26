package lockerme.com;

import java.io.File;
import java.util.Date;

public class FileManager {
	
	/**
	 * To display files of a directory in ascending order.Using Bubble sorting technique
	 * @param path
	 */
	public void displayFiles(String path) {
		try {
			File file = new File(path);
			String[] fileList = file.list();
			if(fileList == null || fileList.length <1) {
				System.out.println("No Files Exist Under the Directory " + path);
				System.out.println("\n");
				MainMenu.startApp();

			}
			System.out.println("Files Under The Directory " + path );
			System.out.println("---------------------------------------");
			for(int i=0;i<fileList.length;i++) {
				for(int j=0;j<fileList.length-i;j++) {
					if(fileList[i].compareTo(fileList[j]) >0){
						String temp = fileList[i];
						fileList[i] = fileList[j];
						fileList[i] = temp;
					}
					
				}
			}
			for(String fileName : fileList) {
				System.out.println(fileName);
			}
			System.out.println("\n");
			MainMenu.startApp();
		}
		catch(Exception e) {
			System.out.println("Exception occured Kindly Contact The System Admin ");
			MainMenu.startApp();
		}
	}
	
	/**
	 * To add a file in a specified directory
	 * @param fileName
	 * @param path
	 */
	public void addFile(String fileName,String path) {
		try {
			File myFile = new File(path, fileName);
			boolean result = myFile.createNewFile();  
			if(result) {
				System.out.println("File Added Successfully");
			}
			else {
				System.out.println("Provided File Name Already Exists");
			}
		}
		catch(Exception e) {
			System.out.println("Exception Occured Kindly Check The Path,File Name And Extension Provided. ");
		}
	}
	
	/**
	 * To delete a file from specific directory
	 * @param fileName
	 */
	public void deleteFile(String fileName,String path) {

		File deleteFile = new File(path, fileName);
		boolean result = deleteFile.delete();
		if(result) {
			System.out.println("File deleted Successfully ");
		}
		else {
			System.out.println("Mentioned File Not Found Under The Directory " + path);
		}

	}
	
	/**
	 * To search File in a specific directory
	 * @param fileName
	 */
	public void searchFile(String fileName,String path) {
		File searchFile = new File(path, fileName);
		boolean result = searchFile.exists();
		if(result) {
			System.out.println("Mentioned File Details:");
			System.out.println("-----------------------");
			System.out.println("Name: " + searchFile.getName());
			System.out.println("Absolute Path: " + searchFile.getAbsolutePath());
			System.out.println("Size: " + searchFile.length());
			System.out.println("Last Modified: " + new Date(searchFile.lastModified()));
			
		}
		else {
			System.out.println("Mentioned File Does Not Exist Under The Directory " + path);
		}
	}

}
