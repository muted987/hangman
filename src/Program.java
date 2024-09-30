import java.util.ArrayList;
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
	static ArrayList<Character> arrayPrinter (String word) {
		int lengthOfWord = word.length();
		ArrayList<Character> arrToReturn = new ArrayList<Character>();
		for (int i = 0; i <= lengthOfWord - 1; i++) {
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to hangman game\n1.Start new game\n2.Exit");
		int option;
		System.out.println("Input option");
		option = sc.nextInt();
		switch (option) {
			case 1:
				return true;
			case 2:
				System.exit(0);
				break;
		}
		return false;
	}
	static void game(){
		String word;
		word = wordGenerator();
		char[] temp = word.toCharArray();
		ArrayList<Character> arrOfWord = new ArrayList<Character>();
		ArrayList<Character> arrOfMistakeLetter = new ArrayList<Character>();
		for (char symb : temp) {
			arrOfWord.add(symb);
		}
		ArrayList<Character> arrOfStars;
		arrOfStars = arrayPrinter(word);
		int mistakeCount = 0;
		String inputText;
		char inputChar;
		boolean flag = false;
		Scanner sc = new Scanner(System.in, "windows-1251");
		flag = startGame();
		while (flag) {
			hangmanPrinter(mistakeCount);
			System.out.println(arrOfStars);
			System.out.println("Input the letter");
			inputText = sc.next().toLowerCase();
			if (inputText.length() != 1) {
				System.out.println("Incorrect input. Try again");
				continue;
			}
			else {
				inputChar = inputText.charAt(0);

				int indexOfWord = arrOfWord.indexOf(inputChar);
				if (indexOfWord == -1) {
					System.out.println("Error");
					if (!arrOfMistakeLetter.contains(inputChar)) {
						arrOfMistakeLetter.add(inputChar);
						mistakeCount++;	
					}
					else {
						System.out.println("Letter already used");
					}
				} else {
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





             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
