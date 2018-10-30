package answers;

public class Question4 {

	public static int selectionFailedTradedesks(String[][] rows, int numberMachines) {
	    if (rows.length == 0) return 0;
	    int minTime = Integer.MAX_VALUE;
	    for (int row = 0; row < rows.length; row++) {
			int xNum = 0;
	        for (int start = 0; start <= rows[row].length - numberMachines; start++) {
				boolean isXFound = false;
				if (rows[row].length - xNum < numberMachines) break;
	        	int end = start + numberMachines;
				int sum = 0;
//				System.out.println("start " + start);
//				System.out.println("end " + end);
				for (int i = start; i < end; i++) {
					if (rows[row][i].equals("X")) {
						start = i;
						xNum++;
						isXFound = true;
						break;
					} else {
						sum += Integer.parseInt(rows[row][i]);
					}
				}
				if (isXFound) {
//					System.out.println("Xfound " + start);
					continue;
				}
				if (sum < minTime) minTime = sum;
//				System.out.println("sum " + sum);
            }
        }
        if (minTime != Integer.MAX_VALUE) return minTime;
        return 0;
	}
}
