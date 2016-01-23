import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
/*
* This program simulates a given amount of rare elite treasure trail rewards for old school runescape.
* Inputs: amount of elite caskets to open.
* Outputs: amount of rare, megarare, and 3rd age items obtained.
*/

class Elite {
	
	public static void main(String[] args) {

		String[] rare = {"Top hat", "Sagacious spectacles", "Royal sceptre", "Royal gown top", "Royal gown bottom", "Royal crown", 
				"Ranger's tunic", "Musketeer hat", "Musketeer tabard", "Musketeer pants", "Monocle", "Bronze dragon mask", "Iron dragon mask", 
				"Steel dragon mask", "Mithril dragon mask", "Dragon full helm ornament kit", "Dragon chainbody ornament kit", 
				"Dragon skirt ornament kit", "Dragon sq shield ornament kit", "Light infinity colour kit", "Dark infinity colour kit", 
				"Fury ornament kit", "Katana", "Dragon cane", "Deerstalker", "Briefcase", "Black d'hide body (t)", "Black d'hide chaps (t)", 
				"Black d'hide body (g)", "Black d'hide chaps (g)", "Big pirate hat", "Afro", "Megarare"};

		String[] megarare = {"Gilded full helm", "Gilded platebody", "Gilded platelegs", "Gilded plateskirt", "Gilded kiteshield", 
				"Gilded boots", "Gilded scimitar", "Crystal key", "Lava dragon mask", "Battlestaves", "Ranging potions", "Saradomin brews", 
				"Extended antifire potions", "Super energy potions", "Bucket", "3rd age"};

		String[] thirdage = {"Third age range coif", "Third age range top", "Third age range legs", "Third age vambraces", "Third age mage hat", 
				"Third age mage robe top", "Third age robe", "Third age amulet", "Third age full helmet", "Third age platebody", "Third age platelegs", 
				"Third age kiteshield", "Third age wand", "Third age bow", "Third age longsword", "Third age cloak"};

		int[] rareFreq = new int[33];
		int[] megarareFreq = new int[16];
		int[] thirdAgeFreq = new int[16];
		int scanned = 0;
		int rares = 0;

		Random rand = new Random();
		Scanner sc = new Scanner(System.in);


		System.out.println("Enter number of elite caskets to open: ");

		try {
			scanned = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error, input a number.");
			System.exit(-1);
		}

		/* This loop generates 4 random numbers with linear distribution in order to simulate a given number of caskets being opened.
			Chance of: 
			landing on rare item table = 1/6.25
			landing on mega rare item table = 1/206.25
			landing on 3rd age item table = 1/3300
			getting a specific rare item = 1/206
			getting a specific mega rare item = 1/3300
			getting a specific 3rd age item = 1/52800
		*/
		for (int ctr = 0; ctr < scanned; ctr++) {
			int firstRand = rand.nextInt(25);
			/* First roll with 4/25 chance of hitting rare item table */
			if (firstRand < 5) {
				rares++; //keeps track of how many time the user hit the rare item table
				int secondRand = rand.nextInt(33);
				/* Second roll with 1/33 chance of hitting mega rare item table */
				if (secondRand == 32) {
					rareFreq[32]++; //keeps track of how many time the user hit the mega rare item table
					int thirdRand = rand.nextInt(16);
					/* Third roll with 1/16 chance of hitting 3rd age item table */
					if (thirdRand == 15) {
						megarareFreq[15]++; //keeps track of how many time the user hit the 3rd age item table
						int fourthRand = rand.nextInt(16);
						thirdAgeFreq[fourthRand]++;
					} else {
						megarareFreq[thirdRand]++;
					}

				} else {
					rareFreq[secondRand]++;
				}
			}
		}

		System.out.println("--------------FREQUENCY OF RARE ITEMS--------------\n");

		for (int a = 0; a < rare.length; a++) {
			System.out.println(rare[a] + " x" + rareFreq[a]);
		}
		System.out.println();

		System.out.println("------------FREQUENCY OF MEGARARE ITEMS------------\n");

		for (int a = 0; a < megarare.length; a++) {
			System.out.println(megarare[a] + " x" + megarareFreq[a]);
		}
		System.out.println();

		System.out.println("-------------FREQUENCY OF 3RD AGE ITEMS------------\n");

		for (int a = 0; a < thirdage.length; a++) {
			System.out.println(thirdage[a] + " x" + thirdAgeFreq[a]);
		}

		System.out.println("\n\nTotal number of rares: " + rares);
		System.out.println("Total number of mega rares: " + rareFreq[32]);
		System.out.println("Total number of third age: " + megarareFreq[15]);
	}

}