package answers;

public class Question4 {

	public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
	    if (rows.length < 1) return 0;
	    int minTime = Integer.MAX_VALUE;
        boolean isFound = false;

	    for (int i = 0; i < rows.length; i++) {
            int conseq = numberMachines;
            int current = 0;
	        for (int j = 0; j < rows[i].length; j++) {
	            if (rows[i][j].equals("X")) {
	                conseq = numberMachines;
                } else {
	                conseq--;
	                current += Integer.parseInt(rows[i][j]);
                }
	            if (conseq == 0) {
	            	isFound = true;
					if (current < minTime) minTime = current;
				}
            }
        }
        if (isFound) return minTime;
        return 0;
	}

	// count x and compare with size
}
