import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
import java.io.*;
import java.*;


public class Task1 {



	public void goTask1() throws IOException {




		//create new file object for the corpus
		File fileCorpus = new File("./input_s1.txt");


		//create a scanner object that reads this file
		Scanner diskScanner = new Scanner(fileCorpus);

		String line = "";
		String lineLowerCase = "";
		String[] splitOnTab;

		while (diskScanner.hasNextLine()){//repeat until there are no more lines to read

			line += diskScanner.nextLine();//assigns the line read by the scanner to a line object





			//now for word cleanup -capitalisation
			lineLowerCase = line.toLowerCase();//makes everything lowercase. 


			//punctuation
			lineLowerCase = lineLowerCase.replaceAll("\\p{Punct}","");//removes punctuation


			//get rid of document identifiers - d1, d2, d3 etc


			lineLowerCase = lineLowerCase.replaceAll("^(.+?)\\t", "");//to make sure the text of the first document is index 0.regex:match everything from beginning until first tab.





		}




		splitOnTab = lineLowerCase.split("\\t");



		//capitals and punctuation have been removed, now to tokenise

		splitOnTab = lineLowerCase.split("\\s");//tokenises the line into separate strings based on white space to get words as a basic unit, ready for stopword removal and porters algo


		//System.out.println(Arrays.toString(splitOnTab));
		//now for stopwords

		//a stopword array
		String[] stopwords = {"a", "as", "able", "about", "above", "according", "accordingly", "across", "actually", "after", "afterwards", "again", "against", "aint", "all", "allow", "allows", "almost", "alone", "along", "already", "also", "although", "always", "am", "among", "amongst", "an", "and", "another", "any", "anybody", "anyhow", "anyone", "anything", "anyway", "anyways", "anywhere", "apart", "appear", "appreciate", "appropriate", "are", "arent", "around", "as", "aside", "ask", "asking", "associated", "at", "available", "away", "awfully", "be", "became", "because", "become", "becomes", "becoming", "been", "before", "beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both", "brief", "but", "by", "cmon", "cs", "came", "can", "cant", "cannot", "cant", "cause", "causes", "certain", "certainly", "changes", "clearly", "co", "com", "come", "comes", "concerning", "consequently", "consider", "considering", "contain", "containing", "contains", "corresponding", "could", "couldnt", "course", "currently", "definitely", "described", "despite", "did", "didnt", "different", "do", "does", "doesnt", "doing", "dont", "done", "down", "downwards", "during", "each", "edu", "eg", "eight", "either", "else", "elsewhere", "enough", "entirely", "especially", "et", "etc", "even", "ever", "every", "everybody", "everyone", "everything", "everywhere", "ex", "exactly", "example", "except", "far", "few", "ff", "fifth", "first", "five", "followed", "following", "follows", "for", "former", "formerly", "forth", "four", "from", "further", "furthermore", "get", "gets", "getting", "given", "gives", "go", "goes", "going", "gone", "got", "gotten", "greetings", "had", "hadnt", "happens", "hardly", "has", "hasnt", "have", "havent", "having", "he", "hes", "hello", "help", "hence", "her", "here", "heres", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "hi", "him", "himself", "his", "hither", "hopefully", "how", "howbeit", "however", "i", "id", "ill", "im", "ive", "ie", "if", "ignored", "immediate", "in", "inasmuch", "inc", "indeed", "indicate", "indicated", "indicates", "inner", "insofar", "instead", "into", "inward", "is", "isnt", "it", "itd", "itll", "its", "its", "itself", "just", "keep", "keeps", "kept", "know", "knows", "known", "last", "lately", "later", "latter", "latterly", "least", "less", "lest", "let", "lets", "like", "liked", "likely", "little", "look", "looking", "looks", "ltd", "mainly", "many", "may", "maybe", "me", "mean", "meanwhile", "merely", "might", "more", "moreover", "most", "mostly", "much", "must", "my", "myself", "name", "namely", "nd", "near", "nearly", "necessary", "need", "needs", "neither", "never", "nevertheless", "new", "next", "nine", "no", "nobody", "non", "none", "noone", "nor", "normally", "not", "nothing", "novel", "now", "nowhere", "obviously", "of", "off", "often", "oh", "ok", "okay", "old", "on", "once", "one", "ones", "only", "onto", "or", "other", "others", "otherwise", "ought", "our", "ours", "ourselves", "out", "outside", "over", "overall", "own", "particular", "particularly", "per", "perhaps", "placed", "please", "plus", "possible", "presumably", "probably", "provides", "que", "quite", "qv", "rather", "rd", "re", "really", "reasonably", "regarding", "regardless", "regards", "relatively", "respectively", "right", "said", "same", "saw", "say", "saying", "says", "second", "secondly", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sensible", "sent", "serious", "seriously", "seven", "several", "shall", "she", "should", "shouldnt", "since", "six", "so", "some", "somebody", "somehow", "someone", "something", "sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specified", "specify", "specifying", "still", "sub", "such", "sup", "sure", "ts", "take", "taken", "tell", "tends", "th", "than", "thank", "thanks", "thanx", "that", "thats", "thats", "the", "their", "theirs", "them", "themselves", "then", "thence", "there", "theres", "thereafter", "thereby", "therefore", "therein", "theres", "thereupon", "these", "they", "theyd", "theyll", "theyre", "theyve", "think", "third", "this", "thorough", "thoroughly", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "took", "toward", "towards", "tried", "tries", "truly", "try", "trying", "twice", "two", "un", "under", "unfortunately", "unless", "unlikely", "until", "unto", "up", "upon", "us", "use", "used", "useful", "uses", "using", "usually", "value", "various", "very", "via", "viz", "vs", "want", "wants", "was", "wasnt", "way", "we", "wed", "well", "were", "weve", "welcome", "well", "went", "were", "werent", "what", "whats", "whatever", "when", "whence", "whenever", "where", "wheres", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whos", "whoever", "whole", "whom", "whose", "why", "will", "willing", "wish", "with", "within", "without", "wont", "wonder", "would", "would", "wouldnt", "yes", "yet", "you", "youd", "youll", "youre", "youve", "your", "yours", "yourself", "yourselves", "zero"};

		//make an arraylist so we can add() words
		ArrayList<String> wordsList = new ArrayList<String>();

		//populate the arraylist with words from the corpus
		for (String word : splitOnTab) {
			wordsList.add(word);
		}

		//loop through both the corpus arraylist and the stopword array, if the corpus arraylist contains a word from stopwords, remove it
		for (int i = 0; i < wordsList.size(); i++) {

			for (int j = 0; j < stopwords.length; j++) {
				if (wordsList.contains(stopwords[j])) {
					wordsList.remove(stopwords[j]);//remove words
				}
			}
		}


		//stem words

		for (String str : wordsList) {


			Stemmer stem_ = new Stemmer();


			for (int i = 0; i < str.length(); i++)
			{
				stem_.add(str.charAt(i));
			}
			stem_.stem();

			String stringofEverything = new String(stem_.toString() + " ");//put everything in a string




			stringofEverything = stringofEverything.replaceAll("d[0-9]+", "\r\n" ); //when you see d1, d2, d3 etc replace this with a new line. this untokenises the document text and puts it back in a block of its own


			//System.out.printf(stringofEverything);//print to console to check





			outputFile(stringofEverything);


		}


	}

	//prints to output file


	public static void outputFile(String stringofEverything) throws IOException {


		File file = new File("./output_t1.txt");

		PrintWriter out
		= new PrintWriter(new FileWriter(file, true));//the true keyword appends instead of overwriting the file each time.
		//Without it, each execution writes the string to the file leaving only the last word of the string as the final output. 
		//Another solution to this would be to ensure that the string is only being outputted once,
		//this would avoid problem of appending on each programme execution as well as being faster


		out.write(stringofEverything); 
		System.out.print(stringofEverything);//THIS IS WHAT PRINTS TO THE CONSOLE



		out.close();
	}
}



