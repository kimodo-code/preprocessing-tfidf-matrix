import java.io.IOException;
import java.util.Arrays;

public class Driver {//run

	public static void main (String [] args) throws IOException {

		//TASK1
		Task1 t1 = new Task1();//create task 1 object
		t1.goTask1();//task 1 object and task1 method incorporating all the task 1 instructions => execute

		//TASK2
		Task2 t2 = new Task2();//create task 2 object
		t2.createIndices("input_s2.txt", "output_t2.txt");//TYPE IN FILENAME HERE

		//TASK3
		Task3 t3 = new Task3();//create task 3 object
		t3.createTFIDFMatrix("output_t3.txt");//TYPE IN FILENAME HERE

		//TASK4
		Task4 t4 = new Task4();
		double [] documentA =  t4.getArrayA();//fetch array a from the first method
		// System.out.println(Arrays.toString(documentA));//check

		double [] documentB = t4.getArrayB();//fetch array b from the second method
		//System.out.println(Arrays.toString(documentB));//check

		double answer = t4.cosineSimilarity(documentA, documentB);//pass the two arrays into the cosine similarity method
		System.out.println("\n" + answer);//check answer - single figure ok
		t4.printAnswer(answer);//PRINT THE ANSWER TO CONSOLE
	}
}
