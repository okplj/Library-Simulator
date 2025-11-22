package project1;
// class named Member
public class Member {
	//  declaring attributes
private int id;
private String name;
private int borrowedCount; 
private int numviewBorrowed;
private int numBorrowes;
private int numReturns;
private double sessionFees;

public static double TotalRevenue;
public static int TotalViewBorrowed;
public static int TotalBorrows;
public static int TotalReturns;
// constructor
public Member(int id, String name, int borrowedCount) {
	this.id = id;
	this.name = name;
	this.borrowedCount = borrowedCount;
	
}
// checking the ability to borrow books
private boolean canBorrow() {
	return borrowedCount < 5;
}
//checking the ability to return books
private boolean canReturn() {
	return borrowedCount > 0;
}
// display the current books
public void viewBorrowedCount() {
	System.out.println("Books currently borrowed: "+ borrowedCount);
	numviewBorrowed++;
	TotalViewBorrowed++;
}
// the process of borrowing
public boolean borrowOne() {
	  if (canBorrow() == false ) {
		 System.out.println(" You can't borrow more than 5 books. ");
		return false;}
	  System.out.println("The book has been successfully borrowed."); // display the operation is complete.
		 System.out.printf( "fee: %.2f\n", 0.50); // display the fees
		 borrowedCount++;
		 numBorrowes++;
		 TotalBorrows++;
		 sessionFees += 0.50;
		 TotalRevenue += 0.50;
		 return true;
	}
// the return process
public boolean returnOne() {
	
	if (canReturn() == false ) {
		System.out.println("You don't have a book to return.");
		return false;}
	
		System.out.println("The book has been successfully returned.");
		 borrowedCount--;
		 numReturns++;
		 TotalReturns++;
		 return true;
	
}
//display the statistics of the current account 
public void displayStatics() {
	System.out.println("Your session summary: ");
	System.out.println("Books borrowed: "+numBorrowes);
	System.out.println("Books returned: "+numReturns);
	System.out.printf("Current fees: %.2f\n",sessionFees);
}
//process to refresh the session summary after each login.
public void reset() {
	this.numBorrowes=0;
	this.numReturns=0;
	this.sessionFees=0.0;
}
// getters
public int getId() {
	return id;
}

public String getName() {
	return name;
}

}

