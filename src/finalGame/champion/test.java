package finalGame.champion;

public class test {

	public static void main(String[] args) {

		int masterCounter = 500;
		
		
		boolean key = true;
		int counter = 0;
		
		while(masterCounter > 0) {
			
			if (key) {
				System.out.println("Oa");
				key = !key;
				counter = 50;
			}
			
			if (counter > 0 ) {
				counter--;
			}
			
			if (counter == 1) {
				key = !key;
			}
			
			System.out.println(counter);
			masterCounter--;
		}

	}

}
