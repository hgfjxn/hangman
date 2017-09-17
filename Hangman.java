/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.util.*;

public class Hangman extends ConsoleProgram {

	private HangmanCanvas hangmanCanvas;

	public void init(){
		hangmanCanvas = new HangmanCanvas();
		add(hangmanCanvas);
	}

    public void run() {
		/* You fill this in */
		try{
			HangmanLexicon hangmanLexicon = new HangmanLexicon();
			String quit = "yes";
			while(!quit.equals("no")){
				println("Welcome to hangman!");
				int remainGuess = 8;
				int right = 0;
				hangmanCanvas.reset();
				Random random = new Random();
				int x = random.nextInt(hangmanLexicon.getWordCount());
				String word = hangmanLexicon.getWord(x);

				int l = word.length();
				char[] puzzl = new char[l];
				for(int i = 0; i < l; i++){
					puzzl[i] = '-';
				}

				while(remainGuess > 0 && right!=l){
					String input = readLine("Your guess: ").toUpperCase();
					while(input.length() != 1 || !Character.isLetter(input.charAt(0))){
						println("your input is illegal, we only accept a sigle letter! Please input again!");
						input = readLine("Your guess: ").toUpperCase();
					}

					boolean contains = false;
					int index = 0;
					while((index = word.indexOf(input,index))!=-1){
						puzzl[index] = word.charAt(index);
						index++;
						right++;
						contains = true;
					}

					String guessed = new String(puzzl);
					if(contains){
						println("The guess is correct.");
						println("The word looks like this: "+guessed);
						hangmanCanvas.displayWord(guessed);
						println("You have "+ remainGuess +" guess left.");
					}else{
						hangmanCanvas.noteIncorrectGuess(input.charAt(0));
						println("There are no "+input+"'s in the word.");
						println("The word looks like this: "+guessed);
						hangmanCanvas.displayWord(guessed);
						println("You have "+ --remainGuess +" guess left.");
					}

				}

				if(right == l){
					println("You win.");
				}else{
					println("You lose.");
				}

				quit = readLine("Do you want continue?(yes/no)");
			}
			System.exit(0);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
