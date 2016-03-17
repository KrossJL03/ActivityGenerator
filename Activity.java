
import java.util.Date;


public class Activity {
	
	String name;
	boolean together;
	boolean goOut;
	boolean alone;
	boolean repeatable;
	int completed;
	String lastcompleted;
	boolean active;
	
	Activity(String a, boolean b, boolean c, boolean d, boolean e, int f, String g, boolean h){
		name = a;
		together = b;
		goOut = c;
		alone = d;
		repeatable = e;
		completed = f;
		lastcompleted = g;
		active = h;
	}
	
	void edit(String a, boolean b, boolean c, boolean d, boolean e, int f, String g, boolean h){
		name = a;
		together = b;
		goOut = c;
		alone = d;
		repeatable = e;
		completed = f;
		lastcompleted = g;
		active = h;
	}
	
/*	boolean again(){
		if(completed==false | repeatable==true){return true;}
		else{return false;}
	}
*/	
	void setCompleted(){
		completed++;
		lastcompleted = new Date().toString();
		if(repeatable==false){active = false;}
	}
	
	public String toString(){
		
		String 							print =  "***************************************"		+ "\n";
										print += name.toUpperCase() 							+ "\n";
			   							print += "---------------------------------------" 		+ "\n";
		if(together==true){				print += " + Together"									+ "\n";	}
		if(goOut==true){				print += " + Going Out"									+ "\n";	}
		if(alone==true){				print += " + Just Us"									+ "\n";	}
		if(repeatable==true){			print += "---------------------------------------" 		+ "\n";
		if(lastcompleted.length()>0){	print += "You did this " + lastcompleted				+ "\n"; }
										print += "You've done this " + completed + " times" 	+ "\n";	}
										print += "***************************************"		+ "\n";
								
		return print;
	}
	
	public String print(){
		return name + " %% " + together + " %% " +  goOut + " %% " + alone + " %% " + repeatable+ " %% " + completed + " %% " + lastcompleted + " %% " + active + "\n";
	}

}
