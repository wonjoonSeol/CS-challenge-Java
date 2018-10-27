package answers;

import java.util.HashSet;

public class Question1 {

	public static int bestMergedPortfolio(int[] portfolios) {
//		if (portfolios.length == 1) return portfolios[0];
//	    int maxStockNum = getMaxStockNum(portfolios);
//	    Integer[] uniquePortfolio = checkDuplicate(portfolios);
		return getBestPortfolio(portfolios);
	}

	private static int getBestPortfolio(int[] portfolios) {
		int portfolioC = 0;
		for (int i = 0; i < portfolios.length - 1; i++) {
			for (int j = i + 1; j < portfolios.length; j++) {
				int current = portfolios[i] ^ portfolios[j];
				if (portfolioC < current) portfolioC = current;
			}
		}
		return portfolioC;
	}

	private static int getBestPortfolio(Integer[] portfolios, int maxStockNum) {
		int portfolioC = 0;
		for (int i = 0; i < portfolios.length - 1; i++) {
			for (int j = i + 1; j < portfolios.length; j++) {
				int current = portfolios[i] ^ portfolios[j];
				if (portfolioC < current) portfolioC = current;
				if (maxStockNum == portfolioC) return portfolioC;
			}
		}
		return portfolioC;
	}

	private static Integer[] checkDuplicate(int[] portfolios) {
		HashSet<Integer> set = new HashSet<>();
		for (int portfolio : portfolios) {
			set.add(portfolio);
		}

		return set.toArray(new Integer[0]);
	}

	private static int getMaxStockNum(int[] portfolios) {
		int maxValue =  getMaxValue(portfolios);
		int bits = getNumberOfBits(maxValue);
		return maxPossible(bits);
	}

	private static int getMaxValue(int[] portfolios) {
		int max = 0;
		for (int num : portfolios) {
			if (max < num) max = num;
		}
		return max;
	}

	private static int getNumberOfBits(int num) {
		return 32 - Integer.numberOfLeadingZeros(num);
	}

	private static int maxPossible(int numOfBit) {
	    return twoToPowerUp(numOfBit + 1) - 1;
	}

	// int[] power = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536, 131072};
	private static int twoToPowerUp(int num) {
		switch (num) {
 			case 0: return 1;
			case 1: return 2;
			case 2: return 4;
			case 3: return 8;
			case 4: return 16;
			case 5: return 32;
			case 6: return 64;
			case 7: return 128;
			case 8: return 256;
			case 9: return 512;
			case 10: return 1024;
			case 11: return 2048;
			case 12: return 4096;
			case 13: return 8192;
			case 14: return 16384;
			case 15: return 32768;
			case 16: return 65536;
			case 17: return 131072;
		}
		throw new IndexOutOfBoundsException("twoToPowerUp only supported up to index 17");
	}
}
