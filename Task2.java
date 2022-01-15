import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Task2 {

	String input_;
	String output_;
	HashMap <String, LinkedList<String>> words;//hashmap with document title (D1, D2 etc) as values and words as keys - inverted index

	public Task2 () {
		input_ = null;
		output_ = null;
		words = new HashMap();
	}

	public void readFile2 () {
		try {
			//  Block of code to try
			File file = new File("./" + input_);//create new file object, concatenate ./ to find in folder
			Scanner sca = new Scanner(file);//scanner file input
			String currentDoc = new String("");//currentDoc and nextDoc will be used later as a marker for D1, D2, D3 etc so that we are able to split the text into identifier/title part and document part
			String nextDoc = new String("D1");//start at D1
			int docNumber = 1;//handle the number part of DX separately to the D part 
			while (sca.hasNext()) {
				String word = sca.next();//bring in each word separated by whitespace (next() function) while loop ensures correct exit when last word is reached
				if (word.equals(nextDoc)) {//if it's a document identifier, then make currentDoc same as nextDoc and push nextDoc on by one. So if currentDoc = D2, nextDoc will equal D3 and so on. When D3 is reached, nextDoc becomes D4.
					currentDoc = new String(nextDoc);
					docNumber = docNumber + 1;
					nextDoc = "D" + docNumber; //conversion from int to string	
				}
				else {//if it's a word from the doc
					if (words.containsKey(word)) {
						LinkedList<String> list= words.get(word);//then create a linked list and put word in it
						if (list.contains(currentDoc)) {//if the same doc title is already in the list
							//then do no nothing. i.e. don't double up values
						}
						else {
							list.add(currentDoc);//otherwise add doc title to list
						}
					}
					else {
						LinkedList<String> list=new LinkedList<String>();
						list.add(currentDoc);
						words.put(word, list);//put word in key and doc in value via list
					}
				}
			}
		}
		catch(FileNotFoundException err) {
			//  Block of code to handle errors
			System.out.println(err);
		}
		//System.out.print(words);
	}

	public void printFile2() {
		try {
			PrintWriter writer = new PrintWriter("./" + output_);
			Iterator it = words.entrySet().iterator();//print hashmap to output file with an iterator
			while (it.hasNext()) {
				HashMap.Entry pair = (HashMap.Entry)it.next();
				//TO DO create a string, a print it instead of value
				String invIndex = (pair.getKey() + "\t" + pair.getValue());
				writer.println(invIndex);
				System.out.println(invIndex);//HERE IT PRINTS TO CONSOLE
				it.remove();
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createIndices (String input_, String output_) {
		this.input_ = input_;
		this.output_ = output_;
		this.readFile2();
		this.printFile2();
	}
}
