import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.util.Random;
import java.io.IOException;
import java.io.FileReader;


public class Program {
	public static void main(String[] args){
		game();
	}
	static void hangmanPrinter (int mistakeCount) {
		switch(mistakeCount) {
			case 0: 	
				System.out.println("  +---+");
				System.out.println("  |   |");
				System.out.println("  |   |");
		        System.out.println("      |");
				System.out.println("      |");
				System.out.println("      |");
				System.out.println("=========");
				break;
			case 1:
				System.out.println("  +---+");
				System.out.println("  |   |");
				System.out.println("  0   |");
		        System.out.println("      |");
				System.out.println("      |");
				System.out.println("      |");
				System.out.println("=========");
				break;
			case 2:
				System.out.println("  +---+");
				System.out.println("  |   |");
				System.out.println("  0   |");
		        System.out.println("  |   |");
				System.out.println("      |");
				System.out.println("      |");
				System.out.println("=========");
				break;
			case 3:
				System.out.println("  +---+");
				System.out.println("  |   |");
				System.out.println("  0   |");
		        System.out.println(" /|   |");
				System.out.println("      |");
				System.out.println("      |");
				System.out.println("=========");
				break;
			case 4:
				System.out.println("  +---+");
				System.out.println("  |   |");
				System.out.println("  0   |");
		        System.out.println(" /|\\  |");
				System.out.println("      |");
				System.out.println("      |");
				System.out.println("=========");
				break;
			case 5:
				System.out.println("  +---+");
				System.out.println("  |   |");
				System.out.println("  0   |");
		        System.out.println(" /|\\  |");
				System.out.println("  |   |");
				System.out.println("      |");
				System.out.println("=========");
				break;
			case 6:
				System.out.println("  +---+");
				System.out.println("  |   |");
				System.out.println("  0   |");
		        System.out.println(" /|\\  |");
				System.out.println("  |   |");
				System.out.println(" /    |");
				System.out.println("=========");
				break;
			case 7:
				System.out.println("  +---+");
				System.out.println("  |   |");
				System.out.println("  0   |");
		        System.out.println(" /|\\  |");
				System.out.println("  |   |");
				System.out.println(" / \\  |");
				System.out.println("=========");
				break;
		}
	}
	static ArrayList<Character> arrOfStarsCreater(int length) {
		ArrayList<Character> arrToReturn = new ArrayList<Character>();
		for (int i = 0; i <= length - 1; i++) {
			arrToReturn.add('*');
		}
		return arrToReturn;
	}
	static String wordGenerator() {
		ArrayList<String> words = new ArrayList<String>();
		
		Random rnd = new Random();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/russian_nouns.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				words.add(line);
			}
		} catch (IOException ex) {
			System.out.println(ex);
		}
		String word = words.get(rnd.nextInt(words.size() - 1));
		return word;
		
	}
	static boolean startGame() {
		System.out.println("1.Start new game\n2.Exit");
		Scanner sc = new Scanner(System.in);
		int option;
		System.out.println("Input option");
		option = sc.nextInt();
		switch (option) {
			case 1:
				return true;
			case 2:
				System.out.println("Shut down the game. Good luck!");
				return false;
		}
		return false;
	}
	static ArrayList<Character> arrOfLetters(String word) {
		ArrayList<Character> outputArrList = new ArrayList<Character>();
		char[] temp = word.toCharArray();
		for (char symb : temp) {
			outputArrList.add(symb);
		}
		return outputArrList;
	}
	static void game(){
		String word = wordGenerator();
		List<Character> arrOfWord = arrOfLetters(word);
		List<Character> arrOfIncorrectLetter = new ArrayList<Character>();
		List<Character> arrOfCorrectLetter = new ArrayList<Character>();
		List<Character> arrOfStars = arrOfStarsCreater(arrOfWord.size());
		int mistakeCount = 0;
		String inputText;
		char inputChar;
		boolean flag = false;
		Scanner sc = new Scanner(System.in, "windows-1251");
		System.out.println("Welcome to hangman game");
		flag = startGame();
		while (flag) {
			hangmanPrinter(mistakeCount);
			System.out.println(arrOfStars);
			System.out.println("Input the letter");
			inputText = sc.next().toLowerCase();
			inputChar = inputText.charAt(0);
			if (inputText.length() != 1 || "1234567890".indexOf(inputChar) != -1) {
				System.out.println("Incorrect input. Try again");
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
				mistakeCount = 0;
				flag = startGame();
				}
			if (mistakeCount == 7) {
				System.out.printf("Game is over. Word is %s\n", word);
				mistakeCount = 0;
				flag = startGame();
			}
		}
	}
}





             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
