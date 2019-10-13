public class Planet{

	private static final double gravConstant = 6.67e-11;
	private static final String imgDir = "images/";

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
	**/
	public double calcForceExertedBy(Planet p){
		if(this == p) return 0;
		double distance = this.calcDistance(p);
		double m1 = this.mass;
		double m2 = p.mass;
		double rSquare = distance * distance;
		return (gravConstant*m1*m2)/rSquare;
	}

	/* Returns the force exerted by the argument Planet on 
	* this Planet in X direction.
	**/
	public double calcForceExertedByX(Planet p){
		if(this == p) return 0;
		double force = calcForceExertedBy(p);
		double r = calcDistance(p);								
		double dx = p.xxPos - this.xxPos;
		return (force*dx)/r;
	}

	/* Returns the force exerted by the argument Planet on 
	* this Planet in Y-direction.
	**/
	public double calcForceExertedByY(Planet p){
		if(this == p) return 0;
		double force = calcForceExertedBy(p);
		double r = calcDistance(p);
		double dy = p.yyPos - this.yyPos;
		return (force*dy)/r;
	}

	/* Returns the net force exerted by the given array of 
	* planets on this planet.
	**/
	public double calcNetForceExertedByX(Planet[] planets){
		double netForceX = 0.0;
		for(Planet p:planets){
			netForceX += calcForceExertedByX(p);
		}
		return netForceX;
	}

	/* Returns the net force exerted by given array
	* of palents on this planet.
	**/
	public double calcNetForceExertedByY(Planet[] planets){
		double netForceY = 0.0;
		for(Planet p: planets){
			netForceY += calcForceExertedByY(p);
		}
		return netForceY;
	}

	/* Updates the velocity and position of this planet according to
	* the given forces(fx, fy) in x,y direction and small change
	* in time (dt).
	**/
	public void update(double dt, double fx, double fy){
		double accX = fx/this.mass;
		this.xxVel += accX*dt;
		this.xxPos += xxVel*dt;

		double accY = fy/this.mass;
		this.yyVel += accY*dt;
		this.yyPos += yyVel*dt;
	}

	/* Draws itself in its current position.
	**/
	public void draw(){
		StdDraw.picture(xxPos, yyPos, imgDir+imgFileName);
		//StdDraw.show();
	}


}