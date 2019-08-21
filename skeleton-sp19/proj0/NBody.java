/** This class is to simulate a universe specified in a given data file.
*/
public class NBody {

	public static void main(String[] args) {
		System.out.println(readRadius("./data/planets.txt"));
	}

/** read an input file and return the radius of the universe. */
	public static double readRadius(String filePathName) {
		In in = new In(filePathName);
		int numOfPlanets = in.readInt();
		double radiusUniverse = in.readDouble();

		return radiusUniverse;
	}
}