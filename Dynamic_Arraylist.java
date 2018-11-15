import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.
You are given lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in position of line. 
Take your input from System.in.
Input Format
The first line has an integer n. In each of the next n lines there will be an integer d denoting number of integers on that line and then there will be d space-separated integers. 
In the next line there will be an integer q denoting number of queries. Each query will consist of two integers x and y.
Constraints
1<=n<=20000
0<=d<=50000
1<=q<=1000
1<=x<=n
Each number will fit in signed integer.
Total number of integers in n lines will not cross 10^5

Output Format
In each line, output the number located in position of yth line position of xth . 
If there is no such position, just print "ERROR!
****************************************************************************************************************************************************
*/
/**
 * @author super
 * Date: 2018/10/22
 * Class: COSC-221
 */

public class Dynamic_Arraylist {

	/**
	 * @param args
	 */
	static Scanner keyInput=new Scanner(System.in);
	static int LineNo = 0;
	static int ElementNo=0;
	static int line;
	static int index;
	
	/*
	 * Main method will call the method NumberOfLines once the program runs.
	 */
	
	public static void main(String[] args) {
		try {
		
		
		NumberOfLines();
	}
	
	catch(InputMismatchException e)				/// Catch for unsupported input
	{
		System.out.print("\t\t\t\tYou input messesd up ! \n\t\t\t\tProgram aborted ");
	}		
	}

	
	/*
	 * This method ask the user for the number of lines and validates the range of x  
	 * call the method  FillTheList by refering DeclareArraylist and LineNo as argument 
	 * return the valid value.
	 * 
	 */
	public static int NumberOfLines()
	{
		
		int statCheck=0;
			while(!(statCheck==1))				// THe while will check for the constrains
				{	
					System.out.print("Enter the Number of lines N \nValid Range is 1 to 20000: ");
					LineNo=keyInput.nextInt();	
				if(LineNo>=1 && LineNo<=20000) statCheck=1;	
				else System.out.print("\t\t\tInput not in range, Input again\n");
					
				}
		FillTheList(DeclareArraylist(LineNo));			// method call
		
		return LineNo;			//Return lineno which is a global variable and needed for other methods.
	}
	
	
	/*
	 * This method takes the LineNo as argument which define the number of lines in the arraylist. 
	 * and create a arraylist with element equal to LineNO.
	 * @parm LineNo
	 */
	public static List<List<Integer>> DeclareArraylist(int LineNo)
	{
		List<List<Integer>> OutsideList = new ArrayList<List<Integer>>();			 ///Declare  List of lists
		for (int iterator = 0; iterator < LineNo; iterator++) {						/// Loop to  iterate through the outside list and create inside list.
		    List<Integer> InsideList = new ArrayList<>();						   ///  Create list  name InsideList
		    OutsideList.add(InsideList);										  ///   Add the InsideList to OutsideList
		    
		}
		System.out.print(OutsideList);		// Print the list, Just to keep track of what's happening.
		return OutsideList;				   //  Return the list to pass to the method FillTheList
	
	}
	
	
	/*
	 * This method ask for the numbers of element in the inside list and populate it
	 * 
	 */
	public static void NumberOfElements()
	{
		int statCheck=0;
			while(!(statCheck==1))			/// This loop Validate the constrains range
			{	
					System.out.print("\n\nEnter the Number of items in each line D \nValid Range  is 0 to 50000: ");	//ask for the user for numbers of element in 1 list or line
					ElementNo=keyInput.nextInt();
			if(ElementNo>=0 && ElementNo<=50000) statCheck=1;
			else	System.out.print("\t\t\tInput out of range. Input again" );
			}
	}

	/*

	 * This method will  ask for the element for the inside list and fill with the user input.
	 *	@param OutsideList 
	 */
	public static void FillTheList(List<List<Integer>> list)
	{
		int Linecounter=1;			/// Just the couter to find the line no.
		
		for(int l=0;l<LineNo;l++)	// Loop to take input. 
		{
			NumberOfElements();		// Method call
			for(int InsideIterator=0;InsideIterator<ElementNo;InsideIterator++) {
				
		System.out.print("enter the element of line "+ Linecounter+" ");		// ask for the values of lines
		int LineValue=keyInput.nextInt();
		list.get(l).add(InsideIterator,LineValue);							   // add the input to inside list
			
		}
			Linecounter++;
			
		}
		System.out.print(list);		// Print the list after the data is filled.
		Data_search(list);		   //  Call Data_search with list as argument
	}
	
	/*
	 * This method will ask the user for line and index to search for data.
	 * @parm  OutSideList
	 */
	public static void Data_search(List<List<Integer>> list)
	{
		 int statcheck=0;
		 int query=0;
		 int looper=0;
		 
		 	while(!(statcheck==1))		/// THis loop will check if the user input is within the valid range
						{	
						System.out.print("\n\nEnter the Number of times you want to search ");
						query=keyInput.nextInt();
						if(query>=1 && query<=1000) statcheck=1; 
						}
	
			
			while(looper!=query) {
			
			System.out.print("enter the search query numbers(i.e line and index, 1 4) ");    // ask for the search query
			line=keyInput.nextInt();	index=keyInput.nextInt();							// save the user input to 2 different variables
							
			List<Integer> actual_list=new ArrayList<Integer>();			 ///Create new list name actual_list
			actual_list=list.get(line-1);								/// Copy  the user input line to actual_list
			
	if(line>list.size() || index>actual_list.size()) System.out.println("Error! ");	 /// Print the error
	else System.out.println((actual_list).get(index-1) );							///print the result
			
			
	}
	}}
