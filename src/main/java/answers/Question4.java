package answers;

public class Question4 {

	public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
	    if (rows.length < 1) return 0;
	    int minTime = 0;
        int conseq;
        int current;
	    for (int i = 0; i < rows.length; i++) {
            conseq = numberMachines;
            current = 0;
	        for (int j = 0; j < rows[i].length; i++) {
	            if (rows[i][j].equals("X")) {
	                conseq = numberMachines;
                } else {
	                conseq--;
	                current += Integer.parseInt(rows[i][j]);
                }
	            if (conseq == 0 && current < minTime) minTime = current;

            }
        }
        return minTime;
	}
}
