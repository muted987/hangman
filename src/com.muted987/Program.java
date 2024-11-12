package com.muted987;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.util.Random;
import java.io.IOException;
import java.io.FileReader;


public class Program {
	public static void main(String[] args){
		startGame();
	}
	static ArrayList<Character> arrOfStarsCreator(int length) {
		ArrayList<Character> arrToReturn = new ArrayList<>();
		for (int i = 0; i <= length - 1; i++) {
			arrToReturn.add('*');
		}
		return arrToReturn;
	}
	static String wordGenerator() {
		ArrayList<String> words = new ArrayList<>();
		
		Random rnd = new Random();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/resources/english_nouns.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				words.add(line);
			}
		} catch (IOException ex) {
			System.out.println(ex);
		}
		return words.get(rnd.nextInt(words.size() - 1));

	}
	static void startGame() {
		System.out.println("1.Start new game\n2.Exit");
		Scanner sc = new Scanner(System.in);
		int option;
		System.out.println("Input option");
		option = sc.nextInt();
		switch (option) {
			case 1:
				game();
			case 2:
				System.out.println("Shut down the game. Good luck!");
				System.exit(1);
		}
	}
	static ArrayList<Character> arrOfLetters(String word) {
		ArrayList<Character> outputArrList = new ArrayList<>();
		char[] temp = word.toCharArray();
		for (char symbol : temp) {
			outputArrList.add(symbol);
		}
		return outputArrList;
	}
	static void game(){
		HangmanPrinter hangman = new HangmanPrinter();
		String word = wordGenerator();
		List<Character> arrOfWord = arrOfLetters(word);
		List<Character> arrOfIncorrectLetter = new ArrayList<>();
		List<Character> arrOfCorrectLetter = new ArrayList<>();
		List<Character> arrOfStars = arrOfStarsCreator(arrOfWord.size());
		int mistakeCount = 0;
		String inputText;
		char inputChar;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to hangman game");
		while (true) {
            System.out.println(hangman.hangmanPrinter(mistakeCount));
			System.out.println(arrOfStars);
			System.out.println("Input the letter");
			inputText = sc.next().toLowerCase();
			inputChar = inputText.charAt(0);
			if (inputText.length() != 1 || "1234567890,!@#$%^&()_+|/\\<>.".indexOf(inputChar) != -1 || !arrOfIncorrectLetter.contains(inputChar)) {
				System.out.println("Incorrect input. Try again");
				arrOfIncorrectLetter.add(inputChar);
				mistakeCount++;
			}
			else {
				int indexOfWord = arrOfWord.indexOf(inputChar);
				if (indexOfWord == -1) {
					System.out.println("Error");
					if (!arrOfIncorrectLetter.contains(inputChar)) {
						arrOfIncorrectLetter.add(inputChar);
						mistakeCount++;
					}
					else {
						System.out.println("Letter already used");
					}
				} else {
					arrOfCorrectLetter.add(inputChar);
					while (arrOfWord.contains(inputChar)) {
						indexOfWord = arrOfWord.indexOf(inputChar);
						arrOfStars.set(indexOfWord, inputChar);
						arrOfWord.set(indexOfWord, '*');
					}
				}
			}
			if (!arrOfStars.contains('*')) {
				System.out.printf("Win! Word is %s\n", word);
				System.out.println(arrOfIncorrectLetter);
				mistakeCount = 0;
				startGame();
				}
			if (mistakeCount == 7) {
				System.out.printf("Game is over. Word is %s\n", word);
				System.out.println(hangman.hangmanPrinter(mistakeCount));
				System.out.print(arrOfIncorrectLetter);
				System.out.println("- incorrect symbols");
				System.out.print(arrOfCorrectLetter);
				System.out.println("- correct symbols\n\n");
				mistakeCount = 0;
				startGame();
			}
		}
	}
}





             
             
             
             
             
             
             
             
             
             
             
             
             
             
             