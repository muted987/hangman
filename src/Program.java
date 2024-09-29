import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.util.Random;
import java.io.IOException;
import java.io.FileReader;

public class Program {
	public static void main(String[] args){
		String word = wordGenerator();
		System.out.println(word);
		char[] temp = word.toCharArray();
		ArrayList<Character> arrOfWord = new ArrayList<>();
		for (char symb : temp) {
			arrOfWord.add(symb);
		}
		ArrayList<Character> arrOfStars;
		arrOfStars = arrayPrinter(word);
		int mistakeCount = 0;
		String inputText;
		char inputChar;
		Scanner sc = new Scanner(System.in);
		while (true) {
			hangmanPrinter(mistakeCount);
			System.out.println(arrOfStars);
			System.out.println("Введите букву");
			inputText = sc.next().toLowerCase();
			if (inputText.length() != 1) {
				System.out.println("Неправильный ввод");
				continue;
			}
			else {
				inputChar = inputText.charAt(0);

				int indexOfWord = arrOfWord.indexOf(inputChar);
				if (indexOfWord == -1) {
					System.out.println("Ошибка");
					mistakeCount++;
				} else {
					while (arrOfWord.contains(inputChar)) {
						indexOfWord = arrOfWord.indexOf(inputChar);
						arrOfStars.set(indexOfWord, inputChar);
						arrOfWord.set(indexOfWord, '*');
					}
				}
			}
			if (!arrOfStars.contains('*')) {
				System.out.println("Победа!");
				break; 
				}
			if (mistakeCount == 7) {
				System.out.print("Игра окончена. Поражение. ");
				System.out.print(word);
				break;
			}
		}
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
		ArrayList<Character> arrToReturn = new ArrayList<>();
		for (int i = 0; i <= lengthOfWord - 1; i++) {
			arrToReturn.add('*');
		}
		return arrToReturn;
	}
	static String wordGenerator() {
		ArrayList<String> words = new ArrayList<>();
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
}





             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
