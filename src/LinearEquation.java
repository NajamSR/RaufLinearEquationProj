public class LinearEquation {

    /* Instance Variables */

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    int deltaX; // helper variable to assist in finding the fraction when slope does not reduce to an integer
    int deltaY; // helper variable to assist in finding the fraction when slope does not reduce to an integer

    /* Creates a LinearEquation object */

    public LinearEquation(int x1, int y1, int x2, int y2) {
        /* all instance variables are set to their corresponding parameters */
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;

            /* Both helper variables are set to the difference in the x-values and difference of the y-values respectively:
               this aids in calculating slope and distance so I don't repeatedly have to use (x2 - x1) or (y2 - y1) */
            deltaX = x2 - x1;
            deltaY = y2 - y1;
    }

  

    /* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to the nearest hundredth */

    public double distance() {
        return (roundedToHundredth(Math.sqrt(((double)deltaX)*((double)deltaX) + ((double)deltaY)*((double)deltaY))));
    }

    /* Calculates and returns the y-intercept of the line between (x1, y1) and (x2, y2), rounded to the nearest hundredth */

    public double yIntercept() {
        return roundedToHundredth(y1 - slope() * x1);
    }

    /* Calculates and returns the slope of the line between (x1, y1) and (x2, y2), rounded to the nearest hundredth */

    public double slope() {
        return (roundedToHundredth((double) (deltaY) / deltaX));
    }

    /* Returns a String that represents the linear equation of the line through points (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5". */

    public String equation() {

        String line = "y = "; // equation variable is initialized to y =, but slope and y-intercept will be concatenated later on

        /* giant if-else-else statement to determine what should be concatenated for the slope */
        if (slope() == 1) {

            line += "x"; // this executes when the slope is positive 1

        } else if (slope() == -1) {

            line += "-x"; // this executes when the slope is negative 1

        } else if (slope() == 0) {

            line += ""; // if the slope is 0, nothing is concatenated here

        } else if (slope() % 1 == 0) {

            line += (int) slope() + "x"; // this executes if the slope is an integer that is not 0, 1, or -1

        } else if (deltaX < 0) {

            line += (deltaY * -1) + "/" + (deltaX * -1) + "x"; // this executes when the denominator of the slope fraction (deltaX) would be negative, and fixes it to make it positive

        } else {

            line += deltaY + "/" + deltaX + "x"; // this executes when deltaX is positive and the slope is not an integer, so there are no denominator issues

        }

        /* if-else-else statement to determine how to concatenate the y-intercept, if it should */
        if (slope() == 0 && yIntercept() % 1 == 0) {

            line += (int) (yIntercept()); // if the slope is 0 and the y-intercept is an integer, the y-intercept in integer form is concatenated

        } else if (yIntercept() < 0) {

            line += " - " + Math.abs(yIntercept()); // if y-intercept is negative and the above case does not apply, this executes to correctly assign the subtraction sign

        } else if (yIntercept() > 0) {

            line += " + " + yIntercept(); // if y-intercept is positive and the above case does not apply, this executes to correctly assign the addition sign

        } // if the y-intercept is 0 and the slope is not 0, nothing is concatenated here

        return line; // the equation is outputted
    }

  

    /* Returns a String of the coordinate point on the line that has the given x value, with both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */

    public String coordinateForX(double xValue) {
        return ("(" + roundedToHundredth(xValue) + ", " + roundedToHundredth(xValue * slope() + yIntercept()) + ")");
    }

    /* "Helper" method for use elsewhere in my methods; returns the value toRound rounded to the nearest hundredth */

    public double roundedToHundredth(double toRound) {
        return (Math.round(toRound * 100) / 100.0);
    }

    /* Returns a string that includes all information about the linear equation, each on separate lines: */

    public String lineInfo() {

        String info = "The two points are: (";

        info += x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";

        info += "\nThe equation of the line between these points is: " + equation();

        info += "\nThe slope of this line is: " + slope();

        info += "\nThe y-intercept of the line is: " + yIntercept();

        info += "\nThe distance between the two points is: " + distance();

        return info;

    }

  }
