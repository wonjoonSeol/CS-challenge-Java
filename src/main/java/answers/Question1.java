package answers;

public class Question1 {
	public static int bestMergedPortfolio(int[] portfolios) {
		if (portfolios.length == 1) return portfolios[0];
	    int portfolioC = 0;
	    int current;
	    for (int i = 0; i < portfolios.length; i++) {
	    	for (int j = i; j < portfolios.length; j++) {
				current = portfolios[i] ^ portfolios[j];
				if (portfolioC < current) portfolioC = current;
			}
		}
		return portfolioC;
	}
}
