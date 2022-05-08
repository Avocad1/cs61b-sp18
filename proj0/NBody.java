public class NBody{
    public static double readRadius(String file){
        In in = new In(file);
        int first_line = in.readInt();
        double second_line = in.readDouble();
        return second_line;
    }

    public static Planet[] readPlanets(String file){
        In in = new In(file);
        int P_Num = in.readInt();
        double Radius = in.readDouble();
        Planet[] ArrayofP = new Planet[P_Num];

        for (int row = 0; row < P_Num; row += 1){
            double xP  = in.readDouble(), yP = in.readDouble();
            double xV  = in.readDouble(), yV = in.readDouble();
            double m   = in.readDouble();
            String img = in.readString();
            ArrayofP[row] = new Planet(xP, yP, xV, yV, m, img);
        }
        return ArrayofP;
    }
    public static void main(String[] args){
        /** Collecting All Needed Input */
        double T = Double.parseDouble (args[0]);
        double dt = Double.parseDouble (args[1]);
        String filename = args[2];

        double TheRadius = readRadius(filename);
        Planet[] TheArray = readPlanets(filename);

        /** Drawing the Background. */
        StdDraw.setXscale(-TheRadius/2, TheRadius/2);
        StdDraw.setYscale(-TheRadius/2, TheRadius/2);

        /* Clears the drawing window. */
        StdDraw.clear();

        /* Stamps the starfield.jpg. */
        StdDraw.picture(0, 0, "images/starfield.jpg");

        /** Drawing All of the Planets */
        for (int a = 0; a < TheArray.length; a += 1){
            TheArray[a].draw();
            StdDraw.show();
        }

        /** Enable double buffering */
        StdDraw.enableDoubleBuffering();

        /** Create a time variable and set it to 0.
         * Set up a loop to loop until this time variable is T
         **/
        double time = 0;
        double[] xForces = new double [TheArray.length];
        double[] yForces = new double [TheArray.length];
        while (time < T){
            /** Calculate the net x and y forces for each planet,
             * storing these in the xForces and yForces arrays respectively.
             */
            for (int a2 = 0; a2 < TheArray.length; a2+=1){
                xForces[a2] = TheArray[a2].calcNetForceExertedByX(TheArray);
                yForces[a2] = TheArray[a2].calcNetForceExertedByY(TheArray);
            }

            /** Call update on each of the planets. */
            for(int j=0;j < TheArray.length;j++) {
                TheArray[j].update(dt, xForces[j], yForces[j]);
            }

            StdDraw.setXscale(-TheRadius/2, TheRadius/2);
            StdDraw.setYscale(-TheRadius/2, TheRadius/2);

            /* Clears the drawing window. */
            StdDraw.clear();

            /* Stamps the starfield.jpg. */
            StdDraw.picture(0, 0, "images/starfield.jpg");

            /** Draw all of the planets. */
            for (int a = 0; a < TheArray.length; a += 1){
                TheArray[a].draw();
                StdDraw.show();
            }

            /** Display and pause for 20ms */
            StdDraw.show();
            StdDraw.pause(20);

            /** Increase time variable by dt. */
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