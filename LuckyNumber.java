import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

//project: Lucky Number
//created: 2/1/2020
//Author: DUNGPASE00299x

public class LuckyNumber {
	static DecimalFormat df2 = new DecimalFormat("#.##");

	static int totalgames;
	static int totalguess;
	static double guessavg;
	static int bestgame = 100;

	// play function
	static void play() {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int low = 0;
		int high = 100;
		int result = rand.nextInt(high - low) + low;
		System.out.println("I'm thinking of a number between 1 and 100...");
		int count = 0;
		int input;
		do {
			System.out.print("Your guess? ");
			input = scan.nextInt();
			if (input > result) {
				System.out.println("It's lower.");
			} else if (input < result) {
				System.out.println("It's higher.");
			}
			count++;
		} while (input != result);

		System.out.println("You got it right in " + count + " guesses!");
		totalgames++;
		totalguess += count;
		if (bestgame > count) {
			bestgame = count;
		}
	}

	// View report
	static void report() {
		System.out.println("Overall results:");
		System.out.println("Total games	= " + totalgames);
		System.out.println("Total guesses	= " + totalguess);
		guessavg = (float) totalguess / totalgames;
		System.out.println("Guesses/game	= " + df2.format(guessavg));
		System.out.println("Best game	= " + bestgame);
	}

	// Main code
	public static void main(String[] args) {
		// Play function
		Scanner scan = new Scanner(System.in);
		String play;
		do {
			play();
			System.out.print("Do you want to play again? ");
			play = scan.nextLine();
		} while (play.contentEquals("y") || play.contentEquals("Y") || play.contentEquals("yes")
				|| play.contentEquals("Yes") || play.contentEquals("YES"));
		// Show report
		System.out.println();
		report();
		System.out.println("End!!");
	}
}
