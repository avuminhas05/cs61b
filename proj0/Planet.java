public class Planet{

	public static final double gravConstant = 6.67e-11;

	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
					 double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	/* Calculates and returns the distance between this planet and 
	*  the argument Planet.
	**/
	public double calcDistance(Planet p){
		double xDistance = p.xxPos - xxPos;
		double yDistance = p.yyPos - yyPos;
		return Math.pow((xDistance*xDistance) + (yDistance*yDistance), 0.5);
	}

	/* Returns the force exerted by the argument Planet on 
	* this Planet.
	*/
	public double calcForceExertedBy(Planet p){
		double distance = this.calcDistance(p);
		double m1 = this.mass;
		double m2 = p.mass;
		double rSquare = distance * distance;
		return (gravConstant*m1*m2)/rSquare;
	}


}