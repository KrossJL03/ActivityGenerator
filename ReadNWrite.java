import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadNWrite {

	private Scanner read;

	ReadNWrite(){}

	ArrayList<Activity> load(){
		ArrayList<Activity> ActivityList = new ArrayList<Activity>();
		try{
			FileReader readList = new FileReader("activities.txt");
			read = new Scanner(readList);
			for(; read.hasNextLine();){
				String a = read.nextLine();
				String[] b = a.split(" %% ");
				if(b.length==8){
					Activity x = new Activity(b[0],Boolean.parseBoolean(b[1]),Boolean.parseBoolean(b[2]),Boolean.parseBoolean(b[3]),Boolean.parseBoolean(b[4]),Integer.parseInt(b[5]),b[6],Boolean.parseBoolean(b[7]));
					ActivityList.add(x);
				}
			}
			System.out.println(ActivityList.size() + " Activities have been loaded.");
			readList.close();
			return ActivityList;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Fail to load Activities.");
			return null;
		}
	}
	
	boolean save(ArrayList<Activity> list){
		try{
			FileWriter writeList = new FileWriter("activities.txt");
			for(int i=0; i<list.size(); i++){
				writeList.write(list.get(i).print());
			}
			System.out.println("Activities have been saved.");
			writeList.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Fail to save Activities.");
			return false;
		} 
	}
	
	
}
