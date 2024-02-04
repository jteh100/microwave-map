import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class MicrowaveMap {

	public static void main(String[] args) throws IOException {
		
		Scanner keyboard = new Scanner(System.in);
		String location = promptUser(keyboard);
		Scanner map = new Scanner(new File("microwaves.txt"));
		String microwave = getMicrowave(map, location);
		System.out.println("The nearest microwave is in " + microwave + ".");
		
	}
	
	public static String promptUser(Scanner keyboard) {
		System.out.print("Enter the abbreviation of the building you're in: ");
		return keyboard.next().trim();
	}
	
	public static String getMicrowave(Scanner map, String location) {
		String building = "";
		while (map.hasNextLine()) {
			String target = map.nextLine();
			Scanner sector = new Scanner(map.nextLine());
			while (sector.hasNext()) {
				String current = sector.next();
				if (location.equalsIgnoreCase(current)){
					building = target;
				}
			}
		}
		return building;
	}

}
