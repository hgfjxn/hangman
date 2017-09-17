/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.util.*;
import java.io.*;

public class HangmanLexicon {

    private List<String> words;

    public HangmanLexicon() throws Exception{
    	words = new ArrayList<String>();
    	BufferedReader br = new BufferedReader(new FileReader("ShorterLexicon.txt"));
    	String line = "";
    	while( (line = br.readLine())!=null){
    		words.add(line);
    	}
    }
    /** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return words.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return words.get(index);
	};
}
