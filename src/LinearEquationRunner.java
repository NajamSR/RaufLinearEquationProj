import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");
        String coord1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coord2 = scan.nextLine();

        int xone = Integer.parseInt(coord1.substring(1, coord1.indexOf(",")));
        int yone = Integer.parseInt(coord1.substring(coord1.indexOf(" ") + 1, coord1.indexOf(")")));
        int xtwo = Integer.parseInt(coord2.substring(1, coord2.indexOf(",")));
        int ytwo = Integer.parseInt(coord2.substring(coord2.indexOf(" ") + 1, coord2.indexOf(")")));

        if (xone == xtwo) {
            System.out.println("These points are on a vertical line: x = " + xone);
            System.out.println("bleh");
        } else {
            LinearEquation equation = new LinearEquation(xone, yone, xtwo, ytwo);
            System.out.println();
            System.out.println(equation.lineInfo());

            System.out.println("\nEnter a value for x: ");
            double x = scan.nextDouble();
            System.out.println("The point on the line is " + equation.coordinateForX(x));
        }
    }
}

