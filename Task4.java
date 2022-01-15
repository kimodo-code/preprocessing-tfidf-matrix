import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task4 {



	/*
	 * 			D1				D2	
	 * first	0.698970004		0
	 * 
	 * compare 0.698970004 and 0 to compare how often the query "first" appears in document 1 as oppose to document 2
	 * Therefore position [1,1] = documentA and position [2,1]=document b for the query "first". Go down the rows to compare each query for
	 * those two documents with all the query terms
	 * 
	 * all figures from column 1 need to fill the array called document A. all figures from column 2 need to fill
	 * the array called document b.
	 * 
	 * once header document titles have been removed (wipe out the whole first line)
	 * extract first block after alphabetical characters to get column 1?
	 * go on one whitespace and then extract next block to get column 2?
	 * 
	 * A dimension for each term. So for example an array with three terms  = {0,1,1}
	 * 
	 */





	// can't return multiple values in java! so, method is recreated to return array b

	public double[] getArrayA() throws IOException {

		double[] documentADoubleArray;
		double[] documentBDoubleArray;

		ArrayList<String> arrlistA = new ArrayList<String>();
		ArrayList<String> arrlistB = new ArrayList<String>();


		File file = new File("./input_s4.txt");


		//create a scanner object that reads this file
		Scanner in = new Scanner(file);

		String[] documentAStringArray;
		String docA = null;
		String[] documentBStringArray;
		String docB = null;


		in.nextLine();//call the first line but don't save it anywhere to remove the first line
		in.next();//will this remove the first word?




		while (in.hasNext()) {









			docA = in.next();//first number 0.698970004
			docB = in.next();//second number 0


			//docA += in.next();
			docA += (" ");//add a space so that later on we can delimit on whitespace
			//docB += in.next();
			docB += (" ");//add a space so that later on we can delimit on whitespace

			//System.out.println(docA + "is doc a");
			//System.out.println(docB + "is doc b");

			arrlistA.add(docA);
			arrlistB.add(docB);


			in.nextLine();//skip past remaining numbers on line and go to start of next line

			if (in.hasNext() == false) {//once you reach the end of the text input (no more tokens via hasNext()) then exit loop
				break;
			}




			in.next();//skip the first word (except for when last line has been reached - in that case exit with if statement above)




		}

		//System.out.println(Arrays.toString(arrlistA.toArray()));//check output of arraylist
		//System.out.println(Arrays.toString(arrlistB.toArray()));


		/*
		in.nextLine();//skip past remaining numbers on line and go to start of next line
		in.next();//skip past the first word

		docA += in.next();
		docA += (" ");
		docB += in.next();
		docB += (" ");

		in.nextLine();
		in.next();

		docA += in.next();
		docA += (" ");
		docB += in.next();
		docB += (" ");
		 */


		//arraylist of objects needs to be converted into array of doubles...
		Object[] objectArrayA = arrlistA.toArray();//convert arraylist of objects into array of objects
		documentAStringArray = Arrays.copyOf(objectArrayA, objectArrayA.length, String[].class);//convert array of objects into array of strings


		Object[] objectArrayB = arrlistB.toArray();//same for doc b
		documentBStringArray = Arrays.copyOf(objectArrayB, objectArrayB.length, String[].class);

		//documentAStringArray = docA.split(" ");
		//documentBStringArray = docB.split(" ");


		documentADoubleArray = Arrays.stream(documentAStringArray)//convert string array to double array created at beginning of method
				.mapToDouble(Double::parseDouble)
				.toArray();

		documentBDoubleArray = Arrays.stream(documentBStringArray)//convert string array to double array
				.mapToDouble(Double::parseDouble)
				.toArray();


		//System.out.println(Arrays.toString(documentADoubleArray));//print array of doca aka D1
		//System.out.println(Arrays.toString(documentBDoubleArray));//print array of docb aka D2



		return documentBDoubleArray;

		//System.out.println(docA);
		//System.out.println(docB);







	}

	public double[] getArrayB() throws IOException {

		double[] documentADoubleArray;
		double[] documentBDoubleArray;

		ArrayList<String> arrlistA = new ArrayList<String>();
		ArrayList<String> arrlistB = new ArrayList<String>();


		File file = new File("./input_s4.txt");


		//create a scanner object that reads this file
		Scanner in = new Scanner(file);

		String[] documentAStringArray;
		String docA = null;
		String[] documentBStringArray;
		String docB = null;


		in.nextLine();//call the first line but don't save it anywhere to remove the first line
		in.next();//will this remove the first word?




		while (in.hasNext()) {









			docA = in.next();//first number 0.698970004
			docB = in.next();//second number 0


			//docA += in.next();
			docA += (" ");//add a space so that later on we can delimit on whitespace
			//docB += in.next();
			docB += (" ");//add a space so that later on we can delimit on whitespace

			//System.out.println(docA + "is doc a");
			//System.out.println(docB + "is doc b");

			arrlistA.add(docA);
			arrlistB.add(docB);


			in.nextLine();//skip past remaining numbers on line and go to start of next line

			if (in.hasNext() == false) {//once you reach the end of the text input (no more tokens via hasNext()) then exit loop
				break;
			}




			in.next();//skip the first word (except for when last line has been reached - in that case exit with if statement above)




		}

		//System.out.println(Arrays.toString(arrlistA.toArray()));//check output of arraylist
		//System.out.println(Arrays.toString(arrlistB.toArray()));


		/*
		in.nextLine();//skip past remaining numbers on line and go to start of next line
		in.next();//skip past the first word

		docA += in.next();
		docA += (" ");
		docB += in.next();
		docB += (" ");

		in.nextLine();
		in.next();

		docA += in.next();
		docA += (" ");
		docB += in.next();
		docB += (" ");
		 */


		//arraylist of objects needs to be converted into array of doubles...
		Object[] objectArrayA = arrlistA.toArray();//convert arraylist of objects into array of objects
		documentAStringArray = Arrays.copyOf(objectArrayA, objectArrayA.length, String[].class);//convert array of objects into array of strings


		Object[] objectArrayB = arrlistB.toArray();//same for doc b
		documentBStringArray = Arrays.copyOf(objectArrayB, objectArrayB.length, String[].class);

		//documentAStringArray = docA.split(" ");
		//documentBStringArray = docB.split(" ");


		documentADoubleArray = Arrays.stream(documentAStringArray)//convert string array to double array created at beginning of method
				.mapToDouble(Double::parseDouble)
				.toArray();

		documentBDoubleArray = Arrays.stream(documentBStringArray)//convert string array to double array
				.mapToDouble(Double::parseDouble)
				.toArray();


		//System.out.println(Arrays.toString(documentADoubleArray));//print array of doca aka D1
		//System.out.println(Arrays.toString(documentBDoubleArray));//print array of docb aka D2



		return documentADoubleArray;

		//System.out.println(docA);
		//System.out.println(docB);







	}



	public double cosineSimilarity(double[] documentA, double[] documentB) 
	{

		double cosineSimilarity = 0.0;//begin with a total of 0
		double lengthA = 0.0;
		double lengthB = 0.0;
		double dotProduct = 0.0;



		for (int i = 0; i < documentA.length; i++) //Go through whole array of numbers. Either one will do. There should be no difference in length between doc a and doc b
		{
			dotProduct += documentA[i] * documentB[i];  //a.b //multiply vector a by vector b (for same dimension?)
			lengthA += Math.pow(documentA[i], 2);  //(a^2)//take the value in that dimension of vector a, square it, add to total
			lengthB += Math.pow(documentB[i], 2); //(b^2)//take the value in that dimension of vector b, square it, add to total
		}

		lengthA = Math.sqrt(lengthA);//sqrt(a^2)//length vector a is square root of total
		lengthB = Math.sqrt(lengthB);//sqrt(b^2)//length vector b is square root of total

		// if (lengthA > 0.0 && lengthB > 0.0)//don't multiply by zero
		//{
		cosineSimilarity = dotProduct / (lengthA * lengthB);//a.b/|a| x |b|


		//} 

		return cosineSimilarity;
	}

	public void printAnswer(double answer) {

		try {
			PrintWriter writer = new PrintWriter("./output_t4.txt");



			writer.println(answer);





			writer.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}



