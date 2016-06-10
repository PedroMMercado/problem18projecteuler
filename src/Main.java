import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	// Maximum path sum I Problem 18
	public static void main(String[] args) {
		int number = countLine("input.txt");
		System.out.println(maxPath("input.txt", number));
	}
	
	public static int countLine(String fileName){
		int count = 0;
		File file = new File(fileName);
		try {
			Scanner input = new Scanner(file);
			while(input.hasNextLine()){
				input.nextLine();
				count++;
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}
	

	public static int maxPath(String fileName, int lineCount){
		int [][] array = new int[lineCount][lineCount];
		File file = new File(fileName);
		try {
			Scanner input = new Scanner(file);
			String [] temp;
			String line;
			// keep track of the row
			int i = 0;
			// populate array with triangle from input file
			while(input.hasNextLine()){
				line = input.nextLine();
				temp = line.split(" ");
				for(int j = 0; j < temp.length;j++){
					// need to fix this out of bounds exception
					array[i][j] = Integer.parseInt(temp[j]);
					System.out.println("Value is " + array[i][j]);
				}
				i++;
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i = lineCount - 2; i >= 0;i--){
			for(int j = 0; j <= i;j++){
				array[i][j] = array[i][j] + Math.max(array[i + 1][j],array[i + 1][j + 1]);
			}
		}
		return array[0][0];
	}
	

}
