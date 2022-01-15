import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TFIDFCalc {
	
	String term = Task3.term;
	ArrayList<String> doc = Task3.doc;
	List<List<String>> documentSet = Task3.documentSet;
	
	
	

		

		//Term Frequency
	//take in as arguments the documents and the term that's being counted to calculate term frequency

		    public double tf(List<String> doc, String term) {//document as array list, term as string
		        double freqij = 0;//the term frequency, the number of times the term occurs in the document
		        for (String word : doc) {//word and term are synonymous
		            if (term.equals(word))//if there's a match then +1
		                freqij++;//this is the counter, increases with every occurrence of the word/term
		        }
		        return freqij / doc.size();//freq of term i in document j/max frequency j is the formula for tf
		    }

		   
		     //"documentSet" list of list of strings represents the document set
		   
		    
		    //Inverse document Frequency
		    public double idf(List<List<String>> documentSet, String term) {//take in the whole document set and the term string
		        double n = 0;//n = number of documents that contain term
		        for (List<String> doc : documentSet) {//for one document out of the document set
		            for (String word : doc) {//how often does the term occur in that document
		                if (term.equals(word)) {
		                    n++;//increase n for every match
		                    break;
		                }
		            }
		        }
		        return Math.log(documentSet.size() / n);//log of the total number of documents over the number of documents that contain term
		    }

		    
		     //"doc" = a text document
		     //"documentSet" = all documents
		
		    
		    //TF-IDF
		    public double tfIdf(List<String> doc, List<List<String>> documentSet, String term) {
		        return tf(doc, term) * idf(documentSet, term);//the td-idf weight for a term is calculated by multiplying the tf for that document by its idf score

		
		 
		    }


		 

		    }

	



