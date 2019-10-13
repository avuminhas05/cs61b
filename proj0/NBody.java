public class NBody{

	public static final String imgDir = "images/";

	/* Read the radius of the universe from given file and returns it.
	**/
	public static double readRadius(String fileName){
		In fStream = new In(fileName);
		fStream.readInt();
		double radius = fStream.readDouble();
		fStream.close();
		return radius;
	}

	/* Read the sequence of Planets from given file and returns array of Planets
	**/
	public static Planet[] readPlanets(String fileName){
		In fStream = new In(fileName);
		int numPlanets = fStream.readInt();
		fStream.readDouble();

		Planet[] planets = new Planet[numPlanets];
		for(int i = 0; i<numPlanets; i++){
			double xP = fStream.readDouble();
			double yP = fStream.readDouble();
			double xV = fStream.readDouble();
			double yV = fStream.readDouble();
			double mass = fStream.readDouble();
			String imgFile = fStream.readString();
			planets[i] = new Planet(xP, yP, xV, yV, mass, imgFile);
		}
		fStream.close();
		return planets;
	}

	public static void main(String[] args) {
		
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		String bgImgFileName = "starfield.jpg";

		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		int numPlanets = planets.length;

		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.enableDoubleBuffering();

		double time = 0;
		while(time != T){
			double[] xForces = new double[numPlanets];
			double[] yForces = new double[numPlanets];
			
			// calculate net force in x,y direction on each planet i
			for(int i = 0; i<numPlanets; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			// update each planet position based on net force exerted on them
			for(int i = 0; i<numPlanets; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.clear();
			StdDraw.picture(0, 0, imgDir+bgImgFileName); // draws the background
			for(Planet p: planets){					     // draws all planets
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}


		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
   	   		 StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}