package runningOfTheBulls;

public class StreetMap {
	public Coordinates[][] gridArray = new Coordinates[20][20];

	public void makeGrid() {
		for (int col = 0; col < 20; col++) {
			for (int row = 0; row < 20; row++) {
				gridArray[col][row] = new Coordinates();

				if (row == 0 || col == 0 || row == 19 || col == 19) {
					if (col == 0 && row == 1) {
						gridArray[col][row].setValue('S');
						gridArray[col][row].setTier(row);
						gridArray[col][row].setColumn(col);
					} else if (row == 18 && col == 19) {
						gridArray[col][row].setValue('E');
						gridArray[col][row].setTier(row);
						gridArray[col][row].setColumn(col);
					} else {
						gridArray[col][row].setValue('W');
						gridArray[col][row].setTier(row);
						gridArray[col][row].setColumn(col);
					}

				} else {
					if (((int) (Math.random() * 5)) == 1) {
						gridArray[col][row].setValue('W');
						gridArray[col][row].setTier(row);
						gridArray[col][row].setColumn(col);
					} else {
						gridArray[col][row].setValue(' ');
						gridArray[col][row].setTier(row);
						gridArray[col][row].setColumn(col);
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		StreetMap thing = new StreetMap();
		thing.makeGrid();
	}

}