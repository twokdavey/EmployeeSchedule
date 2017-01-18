package dmccrac1_assignment2;

import java.util.Scanner;

public class EmployeeWorkHours {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Please enter how many employees are in the schedule: ");
		int employeeCount = scan.nextInt();

		int workDays = 0;
		//only continues when user chooses 1-7 work days for the schedule
		do{
		System.out.println("Please enter how many work days that is in the schedule: ");
		 workDays = scan.nextInt();
		}while(workDays<=1 && workDays>=7);
		
		// creates 2dimensional based on user input, +2 due to having employee id and having a way to total employee hours for future reference
		String[][] schedule = new String[employeeCount][workDays + 2];
		scan.nextLine();

		// user inputs hours for each employee
		enterHours(schedule);
		// creates a display of the schedule
		displaySchedule(schedule);
		// parse the 2 dimensional array for the total work hours for each employee
		calculateTotal(schedule);
		//takes the array and sorts it and all rows so it is consistent for future use
		reverse(schedule);
		//takes the array and prints out the employee and total hours
		printList(schedule);

	}

	public static void calculateTotal(String[][] schedule) {

		for (int i = 0; i < schedule.length; i++) {
			int total = 0;
			for (int j = 1; j < schedule[i].length - 1; j++) {

				total += Integer.parseInt(schedule[i][j]);

			}
			schedule[i][schedule[i].length - 1] = "" + total;
		}
	}

	public static void displaySchedule(String[][] schedule) {
		System.out.println("-------------");
		for (int i = 0; i < schedule.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < schedule[i].length - 1; j++) {
				System.out.print(schedule[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	public static void enterHours(String[][] schedule) {
		for (int i = 0; i < schedule.length; i++) {
			schedule[i][0] = "Employee " + i;
			for (int j = 1; j < schedule[i].length - 1; j++) {
				System.out.println("Please enter hours for " + schedule[i][0] + " day " + j);
				schedule[i][j] = scan.nextLine();

			}

		}

	}

	public static void reverse(String[][] list) {
		int counter=0;
		while (counter < 10) {
			for (int i = 0; i < list.length - 1; i++) {
				int parser = 0;
				parser = Integer.parseInt(list[i][list[i].length - 1]);
				int parser2 = 0;
				parser2 = Integer.parseInt(list[i + 1][list[i].length - 1]);
				for (int j = 0; j < list[i].length; j++) {
					if (parser < parser2) {
						String temp = list[i][j];
						list[i][j] = list[i + 1][j];
						list[i + 1][j] = temp;
					}
				}
			}
			counter++;
		}

	}
	
	
	public static void printList(String[][] list){
		for (int i = 0; i < list.length; i++) {

			System.out.println(list[i][0] + " worked " + list[i][list[i].length - 1] + " hours");
		}
	}
}