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

		double univRadius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		StdDraw.setScale(-univRadius, univRadius);
		StdDraw.clear();

		StdDraw.picture(0, 0, imgDir+bgImgFileName); // draws the background													
		for(Planet p: planets){									          // draws all planets
			p.draw();
		}

		StdDraw.show();
		StdDraw.pause(2000);
	}
}