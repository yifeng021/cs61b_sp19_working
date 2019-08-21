public class Body {

	static final double GRAVITATIONAL_CONSTANT = 6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName; // name of file corresponds to the image depicts the body

	public Body(double xP, double yP, double xV,
				double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}


	public double calcDistance(Body b) {
		double dx = 0.0;
		double dy = 0.0;
		double r = 0.0;
		double rSumSquared = 0.0;

		dx = b.xxPos - xxPos;
		dy = b.yyPos - yyPos;
		rSumSquared = dx * dx + dy * dy;
		r = Math.sqrt(rSumSquared);
		return r;
	}

/** Take in a body.
return a double describing the force exerted on this body
by the given body.
example: samh.calcForceExertedBy(rocinante)
*/
	public double calcForceExertedBy(Body b) {

		double r = 0.0; //distance
		double F = 0.0; //force

		r = calcDistance(b);
		F = GRAVITATIONAL_CONSTANT * mass * b.mass / (r * r);

		return F;
	}

/** Take in a body.
return a double describing the force exerted in the X direction
on this body by the given body.
example: samh.calcForceExertedByX(rocinante)
*/
	public double calcForceExertedByX(Body b) {
		double r = 0.0; // distance
		double F = 0.0; // force exerted on this body by the given body
		double Fx = 0.0; //force exerted in x dir by given Body b
		double dx = 0.0; // distance in x dir

		r = calcDistance(b);
		F = calcForceExertedBy(b);
		dx = b.xxPos - xxPos;
		Fx = F * dx / r;

		return Fx;
	}
/** Take in a body.
return a double describing the force exerted in the Y direction
on this body by the given body.
example: samh.calcForceExertedByY(rocinante)
*/
	public double calcForceExertedByY(Body b) {
		double r = 0.0; // distance
		double F = 0.0; // force exerted on this body by the given body
		double Fy = 0.0; //force exerted in y dir by given Body b
		double dy = 0.0; // distance in y dir

		r = calcDistance(b);
		F = calcForceExertedBy(b);
		dy = b.yyPos - yyPos;
		Fy = F * dy / r;

		return Fy;
	}

/** Take in an array of bodys.
return a double representing the net force exerted in X direction
on this body by all other bodys in allBodys[].
example: 
Body[] allBodys = {samh, rocinante, aegir};
samh.calcNetForceExertedByX(allBodys);
*/
	public double calcNetForceExertedByX(Body[] allBodys) {
		int bodySize = allBodys.length;
		double netForceByX = 0.0;

		for (int i = 0; i < bodySize; i++) {
			// a body cannot exert gravitational force on itself
			// spoiler alert: it would collapse
			if (this.equals(allBodys[i]) == true) {
				continue;
			}
			netForceByX = netForceByX + calcForceExertedByX(allBodys[i]);
		}

		return netForceByX;
	}

/** Take in an array of bodys.
return a double representing the net force exerted in Y direction
on this body by all other bodys in allBodys[].
example: 
Body[] allBodys = {samh, rocinante, aegir};
samh.calcNetForceExertedByY(allBodys);
*/
	public double calcNetForceExertedByY(Body[] allBodys) {
		int bodySize = allBodys.length;
		double netForceByY = 0.0;

		for (int i = 0; i < bodySize; i++) {
			// a body cannot exert gravitational force on itself
			// spoiler alert: it would collapse
			if (this.equals(allBodys[i]) == true) {
				continue;
			}
			netForceByY = netForceByY + calcForceExertedByY(allBodys[i]);
		}

		return netForceByY;
	}

/** Take in: 
dt - duration of time for which forces were applied
fX - force exerted in X direction
fY - force exerted in Y direction
Method:
1) calculate acceleration using fX and fY
2) calculate new velocity using acceleration and
current velocity
3) calculate new position by using velocity computed 
in 2) and the current position.

example: samh.update(0.005, 10, 3) adjust the velocity and 
position if an X-force of 10N and a Y-force of 3N were 
applied for 0.005s.

*/
	public void update(double dt, double fX, double fY) {
		double aX = 0.0; // acceleration in X dir
		double aY = 0.0; // acceleration in Y dir

		// 1) calculate acceleration
		aX = fX / mass;
		aY = fY / mass;

		// 2) calculate new velocity
		xxVel = xxVel + dt * aX;
		yyVel = yyVel + dt * aY;

		// 3) calculate new position
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;

	}

}














