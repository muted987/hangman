
public class HangmanPrinter {
	public String hangmanPrinter (int mistakeCount) {
		String[] hangman = {"   +---+\n   |   |\n       |\n       |\n       |\n       |\n       |\n=========", "   +---+\n   |   |\n   O   |\n       |\n       |\n       |\n       |\n=========", "   +---+\n   |   |\n   O   |\n   |   |\n       |\n       |\n       |\n=========", "   +---+\n   |   |\n   O   |\n  /|   |\n       |\n       |\n       |\n=========", "   +---+\n   |   |\n   O   |\n  /|\\  |\n       |\n       |\n       |\n=========", "   +---+\n   |   |\n   O   |\n  /|\\  |\n   |   |\n       |\n       |\n=========", "   +---+\n   |   |\n   O   |\n  /|\\  |\n   |   |\n  /    |\n       |\n=========", "   +---+\n   |   |\n   O   |\n  /|\\  |\n   |   |\n  / \\  |\n       |\n========="};
		return hangman[mistakeCount];
	}
}
