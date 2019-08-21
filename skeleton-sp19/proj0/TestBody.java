/** This is a test program that creates 2 bodies
and prints out the pairwise force between them.
This serves as a template for future project where I need to 
develop test bench program for testing the classes every
step of the way.
*/

public class TestBody {
	public static void main(String[] args) {
		Body sun = new Body(1.0e12, 2.0e11, 999, 999, 2.0e30, "sun.gif");
		Body saturn = new Body(2.3e12, 9.5e11, 999, 999, 6.0e26, "saturn.gif");

		System.out.println(sun.calcForceExertedBy(saturn));
		
	}
}