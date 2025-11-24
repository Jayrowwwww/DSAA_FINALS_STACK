import java.util.Scanner;

class Stack{

	static Scanner input = new Scanner(System.in);
	static int[] stack = new int[0];

	public static void main(String[] args){
		System.out.println("Welcome to my Simple Stack Structured Array System");
		System.out.println("Hello I am Jerreh Romer Salera from BSIT 2A\n");
		System.out.print("Would you like to coninue?(Y/N): ");
		String choose = input.nextLine();

		//Handles continuing options
		if(choose.equalsIgnoreCase("Y")){
			System.out.println("Continuing to options\n");
			option();
		} else {
			System.out.println("Exiting Program....");
			System.exit(0);
		}

	}

	public static void option(){
		System.out.println("\n-------| Hello! Thank You for Looking out on my Propject | -------|");
		System.out.println("[1] push");
		System.out.println("[2] pop");
		System.out.println("[3] peek");
		System.out.println("[4] Show Odd Numbers");
		System.out.println("[5] Show Even Numbers");
		System.out.println("[6] Show Total");
		System.out.println("[7] Exit");
		System.out.println("--------------------------------------------------------------------|");
		System.out.println("--------------------|Your Stacked Arrayt|---------------------------|");
		display();
		System.out.println("--------------------------------------------------------------------|");
		System.out.print("Enter number: ");
		int choice = input.nextInt();
		System.out.println("--------------------------------------------------------------------|");

		//Choices
		switch(choice){
			case 1:
				System.out.println("You choose push\n");

				System.out.print("Enter number to push: ");
				int number = input.nextInt();
				push(number);
				break;
			case 2:
				System.out.println("You choose pop\n");

				System.out.print("How many number you want to remove?: ");
				int remove = input.nextInt();
				pop(remove);
				break;
			case 3:
				System.out.println("You choose peek\n");
				peek();
				break;
			case 4:
				System.out.println("Show Odd Numbers\n");
				Odd();
				break;
			case 5:
				System.out.println("Show Even Numbers\n");
				Even();
				break;
			case 6:
				System.out.println("Show Total\n");
				Total();
				break;
			case 7:
				System.out.println("Exiting Program Goodbye!.....");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid. Exiting Program Goodbye!.....");
				System.exit(0);
		}
	}


	//PUSH
	public static int push(int num){

		//Expanding Array
		int[] newStack = new int[stack.length + 1];

		//Storing same array elements to temporary container
		for (int i = 0; i < stack.length; i++) {
		    newStack[i] = stack[i];
		}

		//Storing number in an index
		newStack[newStack.length - 1] = num;

		//Stores the temporary container into the permanent container
    	stack = newStack;

		//Going back to options
		option();
		return num;

	}


	//POP
	public static int pop(int num) {

		//Check the array if empty
	    if (stack.length == 0) {
	        System.out.println("Stack is empty!\n");
	        option();
	    }

		//Shows Popped Numberr
	    int poppedNum;

		//should be functioned first before removing elements
	    for( int j = 1; j <= num; j++){
			poppedNum = stack[stack.length - j];
			System.out.println("You've Popped: " + poppedNum);
		}

		//New array to remove elements
	    int[] newStack = new int[stack.length - num];

	    for (int i = 0; i < newStack.length; i++) {
	        newStack[i] = stack[i];
	    }

	    stack = newStack;

	    option();
	    return num;
	}

	//PEEK
	public static void peek(){
		//shows the last index
		System.out.println("[" + stack[stack.length - 1] + "]");
		option();
	}

	//DISPLAY
	public static void display(){

		if(stack.length == 0){
			System.out.println("[No Array at the Meantime]");
		} else {
			//sorting the array in (reverse)
			//new array for sorting
			int[] sorted = new int[stack.length];

			//Reverse Sorting
			for (int i = 0; i < stack.length; i++) {
				sorted[i] = stack[stack.length - 1 - i];
				System.out.println("[" + sorted[i] + "]");
			}
		}
	}

	//ODD
	public static void Odd(){
		if(stack.length == 0){
			System.out.println("Please insert some value(s) first!");
			option();
		}

		//searching for every index
		for( int i = 0; i < stack.length; i++){
			//get current value in the specific index
			int num = stack[i];
			//checking if it is odd
			if(num % 2 != 0){
				System.out.println("[" + num + "] : is Odd");
			}
		}
		//return to option
		option();
	}


	//EVENE
	public static void Even(){
		//Look for any value first
		if(stack.length == 0){
			System.out.println("Please insert some value(s) first!");
			option();
		}

		//searching for every index
		for( int i = 0; i < stack.length; i++){
			//get current value in the specific index
			int num = stack[i];
			//checking if it is even
			if(num % 2 == 0){
				System.out.println("[" + num + "] : is Even");
			}
		}
		//return to option
		option();
	}


	//TOTAL
	public static void Total(){
		int total = 0;

		for(int i = 0; i < stack.length; i++){
			total = total + stack[i];
		}

		System.out.println("Total is: [" + total + "]\n");
		option();
	}
}