import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static ArrayList<Activity> ActivityList = new ArrayList<Activity>();
	private static Scanner scan;
	static int input = -1;
	static int selected = -1;
	
	
	
	/* ********************************************
	 * 
	 * 		CREATE ACTIVITY
	 * 
	 * ********************************************/
	
	public static Activity createActivity(){
		String name = "";
		boolean[] YN = new boolean[4];
		
		String[] questions = new String[4];
		questions[0] = "Do you need to be together to do this?";
		questions[1] = "Do you want to go out?";
		questions[2] = "Do you need to be alone?";
		questions[3] = "Can this Activity be done again?";
		
		if(input==2){
			System.out.println("What's the activity?");
			name = scan.nextLine();// scan.nextLine();
		}
		
		for(int i=0; i<4; i++){
			System.out.println(questions[i]);
			try{YN[i] = scan.nextBoolean();}
			catch(Exception ea){
				System.out.println("Nice try. Now what's the answer?"); 
				scan.next();
				i--;
			}
		}
		
		// EDIT
		if(input==3){
			boolean active = ActivityList.get(selected).active;
			
			System.out.println("Completed?");
			try{if(scan.nextBoolean()==true){ActivityList.get(selected).setCompleted();}}
			catch(Exception e){}
			
			System.out.println("Active?");
			try{
				if(scan.nextBoolean()==true){active = true;}
				else{active = false;}
			}catch(Exception e){}
			
			ActivityList.get(selected).edit(
					ActivityList.get(selected).name, 
					YN[0], YN[1], YN[2], YN[3], 
					ActivityList.get(selected).completed, 
					ActivityList.get(selected).lastcompleted, 
					active
			);
			
			return null;
		}
		
		// ADD
		else{return new Activity(name, YN[0], YN[1], YN[2], YN[3], 0, "", true);}
	}

	
	
	/* ********************************************
	 * 
	 * 		MAIN
	 * 
	 * ********************************************/
	
	public static void main(String[] args){
		
		scan = new Scanner(System.in);
		ReadNWrite textFile = new ReadNWrite();
		ActivityList = textFile.load();
		
		System.out.println("- - - - - - - - - - - - - - - - - - - -");
		System.out.println("Welcome to Activity Generator!");
		
		while(input!=0){
			
			System.out.println("What would you like to do?");
			System.out.println("   1. Generate Activity");
			System.out.println("   2. Add an Activity");
			System.out.println("   3. View All Activities");
			System.out.println("   0. Exit");
			
			try{input = scan.nextInt(); scan.nextLine();}
			catch(InputMismatchException e){scan.nextLine();}
			
			System.out.println("- - - - - - - - - - - - - - - - - - - -");
			
			switch(input){
			
				/************************************************
				 * 		GENERATE ACTIVITY
				 ************************************************/
			
				case 1: 
					System.out.println("Generate Activity" + "\n");
					int chosen = (int) Math.random() * ActivityList.size();
					System.out.println(ActivityList.get(chosen));
					break;
					
					
				/************************************************
				 * 		ADD ACTIVITY
				 ************************************************/
					
				case 2: 
					ActivityList.add(createActivity());
					break;
				
					
				/************************************************
				 * 		VIEW ALL ACTIVITY
				 ************************************************/	
					
				case 3: 
					System.out.println("View All Activities" + "\n");
					for(int i=0; i<ActivityList.size(); i++){
						System.out.println(i+1 + ". " + ActivityList.get(i).name.toUpperCase());
					}
					System.out.println();
					System.out.println("Would You Like to Select an Activity?");
					
					try{selected = scan.nextInt()-1;}
					catch(Exception e){scan.nextLine();}
					
					for(int i=0; i<ActivityList.size(); i++){
						if(selected==i){System.out.println(ActivityList.get(selected));
					
							// EDIT ACTIVITY	
							System.out.println("Edit this Activty?");
							try{
								if(scan.nextBoolean()==true){scan.nextLine(); createActivity();}
								else{
						
								// DELETE ACTIVITY 
								System.out.println("Delete this Activity?");
								try{if(scan.nextBoolean()==true){scan.nextLine(); ActivityList.remove(selected);}}
								catch(Exception ea){scan.nextLine();}
								
								}
							}catch(Exception ea){scan.nextLine();}
						}
					}
					
					break;
				
					
				/************************************************
				 * 		EXIT
				 ************************************************/	
					
				case 0:
					System.out.println("Thank you for using Activity Generator");
					textFile.save(ActivityList);
					break;
					
				default: 
					System.out.println("Invalid Input");
					break;
					
			}			
			System.out.println("- - - - - - - - - - - - - - - - - - - -");
		
		}
		
	}
}
