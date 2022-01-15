import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Task3 {


	String input_3;
	String output_3;
	String output_1;
	public static String term;
	public static ArrayList<String> doc;
	public static List<List<String>> documentSet;


	public void goTask3() throws FileNotFoundException {

		File file = new File("./" + output_1);//create new file object, concatenate ./ to find in folder

		Scanner sca = new Scanner(file);//scanner file input

		//split on whitespace for term String
		//split on return for document array



		while (sca.hasNext())  {//how to extract the header row of documents across the top - split on whitespace and exit while loop when first letter is no longer D

			String term = sca.next();//bring in each word separated by whitespace (next() function) while loop ensures correct exit when last word is reached


			//sca.useDelimiter("\n");

			System.out.println(term);









			File file2 = new File("./" + output_1);//create new file object, concatenate ./ to find in folder

			Scanner scan = new Scanner(file2);

			while (scan.hasNextLine())  {//how to extract the header row of documents across the top - split on whitespace and exit while loop when first letter is no longer D

				ArrayList<String> doc = new ArrayList<String>();
				String temp = scan.nextLine();//bring in each word separated by whitespace (next() function) while loop ensures correct exit when last word is reached
				doc.add(temp);

				//sca.useDelimiter("\n");

				System.out.println(doc);



			}

		}

	}




	public void printFile3() {

		try {
			PrintWriter writer = new PrintWriter("./" + output_3);


			TFIDFCalc tfidfobject = new TFIDFCalc();

			//System.out.println(tfidfobject.tfIdf(doc, documentSet, term)); throws compilation error


			writer.println("This is sample Task3 output");
			System.out.println("\n This is sample Task3 output");//PRINTS TO CONSOLE












			writer.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}




	public void createTFIDFMatrix (String output_3) {


		this.output_3 = output_3;

		this.printFile3();

	}


}

