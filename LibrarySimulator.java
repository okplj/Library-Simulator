package project1;
// create a scanner that takes input from the user.
import java.util.Scanner; 
// named the program as LibrarySimulator.
public class LibrarySimulator {

	public static void main(String[] args) {
		Scanner helper = new Scanner(System.in); // scanner for inputs.
		// defining accounts by using constructor Member // using a constructor member to a defined the accounts
		Member account1 =new Member(11,"Saleh",0);
		Member account2 =new Member(22,"Faisal",0);
		Member account3 = new Member(33,"Ali",0); 
	
		boolean start_program = true; // variable to control the loop of the main menu
		// program loop.
		while(start_program)
		{   
			
			// main menu.
			System.out.println("\n WELCOME TO THE SMART LIBRARY  ");
			System.out.println("\nMain Menu\n"); 
			System.out.println("1- Login account 1: "+ account1.getName() + ", ID number:"+ account1.getId());
			System.out.println("2- Login account 2: "+ account2.getName() + ", ID number:"+ account2.getId());
			System.out.println("3- Login account 3: "+ account3.getName() + ", ID number:"+ account3.getId());
			System.out.println("4- login as Administrator");
			System.out.println("5- Exit the program ");
			System.out.println("Enter your option :(put the number of the option only)");
			
			int option = helper.nextInt(); // take input from the user.
			helper.nextLine(); // to clear the buffer of inputs.
			
			// login to the defined accounts.
			if (option >=1 && option<=3) {
				Member currentAccount; // variable to save current accounts
			 if (option == 1) {
				 currentAccount = account1;
			}
			else if (option == 2 ) {
				currentAccount = account2;
			}
			else {
				currentAccount = account3;	
			}
			// process to refresh the session summary after each login.
			 currentAccount.reset();
				
			boolean userinterface = true; // variable to control the loop of the user interface.
			
			while(userinterface) {
				// user interface.
				System.out.println("\n Hello " + currentAccount.getName()+ ", Welcome to the smart library" );
				System.out.println("\n Account Operations Menu");
				System.out.println("1- View Borrowed Books Count:");
				System.out.println("2- Borrow Book ");
				System.out.println("3- Return Book ");
				System.out.println("4- View Session Summary ");
				System.out.println("5- Exit to Main Menu");
				System.out.println("Enter your option: (put the number of the option only)");
				
				int option_interface = helper.nextInt(); // take input from the user.
				helper.nextLine(); // to clear the buffer of inputs.
				
				switch(option_interface) 
				{
				// display the number of books currently borrowed by the user.
				case 1:
					currentAccount.viewBorrowedCount();
					break;
				// borrow books
				case 2:
					currentAccount.borrowOne();
				break;
				// return books 
				case 3: 
					currentAccount.returnOne();
					break;
				// session summary for current user.
				case 4: 
					currentAccount.displayStatics();
				break;
				
				case 5: 
								
					userinterface = false;break; // finishing the session of interface 
					
					default: System.out.println("Invalid option. Try again.");
					break;
				}
				}
			}
			       // login as administrator.
			else if (option == 4) { 
				// to login as administrator you must enter the password.
				System.out.println("Enter the password: ");
				String password = helper.nextLine(); 
				// create the password.
				if (!password.equals("smart library")) {
					System.out.println(" The password is incorrect. Try again."); // user alert message.
				}
			
			
				else {
					boolean adminpage = true; // variable to control the loop of the administrator interface.
					while (adminpage) { 
						// Administrator Menu.
						System.out.println("\nAdministrator Menu");
						System.out.println("1- View Total Revenue");
						System.out.println("2- Most Frequent Operation");
						System.out.println("3- Exit to Main Menu");
						System.out.println("Enter the option number: ");
						int option_admin = helper.nextInt(); // take input from the user.
						
						switch (option_admin) {
						// display the total revenue.
						case 1: System.out.printf("The Total Revenue: %.2f\n",Member.TotalRevenue);break;
						// display the most frequent operation.
						case 2: if(Member.TotalBorrows > Member.TotalReturns)
							System.out.println("The Most Frequent Operation is borrow");
						else if (Member.TotalReturns > 	Member.TotalBorrows)
							System.out.println("The Most Frequent operation is return");
						else if (Member.TotalReturns == 0 && Member.TotalBorrows == 0)
							System.out.println("No operation has happened yet");
						else if (Member.TotalReturns == Member.TotalBorrows)
							System.out.println("Borrow and Return have the same frequent operation");
						break;
						case 3:adminpage = false ;break; // finishing the session of interface.
						
						default: System.out.println("Invalid option. Try again"); // user alert message.
						}
					}
				}
		}
			
			// exit the program.
			 else if (option == 5) {
				 System.out.println("Hope you enjoyed using The Smart Library. Thank you for visiting. Goodbye :)"); 
				  start_program = false;} // finishing the program.
			 
				  else System.out.println("Invalid option. Try again"); // user alert message.
			  
			}
		helper.close(); // close the scanner.
}

}

