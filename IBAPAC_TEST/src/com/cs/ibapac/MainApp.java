/**
 * 
 */
package com.cs.ibapac;

import java.util.Scanner;

import com.cs.ibapac.Shape;

/**
 * @author SuLEmaN
 * 
 */
public class MainApp {

	Shape shape = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainApp app = new MainApp();
			Scanner scan = new Scanner(System.in);
			String cmd = new String();
			while (!cmd.equals("Q")) {
				System.out.print("enter command:");
				cmd = scan.nextLine();
				app.processCommand(cmd);
			}
		} catch (Exception e) {
			System.out.println("Error occured: " + e.getMessage());
		}
	}

	public void processCommand(String cmd) {
		char ch = cmd.charAt(0);
		String[] cmdStr;
		try {
			switch (ch) {
			case 'C':
				cmdStr = cmd.split(" ");
				shape = new Shape(Integer.parseInt(cmdStr[1]),
						Integer.parseInt(cmdStr[2]));
				shape.prepareCanvas();
				shape.drawShape();
				break;

			case 'L':
				cmdStr = cmd.split(" ");
				if (shape.getShape() == null) {
					System.out
							.println("\nCreate a Canvas First with Command: C w h");
					break;
				}
				shape.prepareLine(Integer.parseInt(cmdStr[1]),
						Integer.parseInt(cmdStr[2]),
						Integer.parseInt(cmdStr[3]),
						Integer.parseInt(cmdStr[4]));
				shape.drawShape();
				break;
			case 'R':
				cmdStr = cmd.split(" ");
				if (shape.getShape() == null) {
					System.out
							.println("\nCreate a Canvas First with Command: C w h \n Example C 20 4");
					break;
				}
				shape.prepareRectangle(Integer.parseInt(cmdStr[1]),
						Integer.parseInt(cmdStr[2]),
						Integer.parseInt(cmdStr[3]),
						Integer.parseInt(cmdStr[4]));
				shape.drawShape();
				break;
			case 'B':
				cmdStr = cmd.split(" ");
				if (shape.getShape() == null) {
					System.out
							.println("\nCreate a Canvas First with Command: C w h \n Example C 20 4");
					break;
				}
				shape.prepareBucketFill(Integer.parseInt(cmdStr[1]),
						Integer.parseInt(cmdStr[2]), cmdStr[3].charAt(0));
				shape.drawShape();
				break;
			case 'Q':
				System.out.println("Exit from program!");
				break;

			default:
				System.out.println("Invalid Command, Try Again");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid command. Try again!!\n");
		} catch (Exception e) {
			System.out.println("Error Occured\n");
		}
	}
}
