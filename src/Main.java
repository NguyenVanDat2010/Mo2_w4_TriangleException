import java.util.Scanner;

public class Main {
    public void checkSideRectangle(double side) throws Triangle {
        if (side < 0) {
            throw new Triangle("Cạnh bạn nhập vào bé hơn 0");
        }
    }

    public void checkRectangle(double side1, double side2, double side3) throws Triangle {
        if ((side1 + side2) <= side3 || (side1 + side3) <= side2 || (side2 + side3) <= side1) {
            throw new Triangle("Các cạnh bạn nhập vào không phải là tam giác");
        }
    }

    public void checkRightTriangle(double side1, double side2, double side3) throws Triangle {
        if (Math.pow(side1, 2) != (Math.pow(side2, 2) + Math.pow(side3, 2)) &&
                Math.pow(side2, 2) != (Math.pow(side1, 2) + Math.pow(side3, 2)) &&
                Math.pow(side3, 2) != (Math.pow(side1, 2) + Math.pow(side2, 2))) {
            throw new Triangle("Không phải là tam giác vuông");
        }
    }

    public double getArea(double side1, double side2, double side3) {
        double max = side1;
        if (max < side2) {
            if (side2 < side3) {
                max = side3;
            } else max = side2;
        }
        if (max == side1) {
            return (side2 * side3) / 2;
        } else if (max == side2) {
            return (side1 * side3) / 2;
        } else return (side1 * side2) / 2;

    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập 3 cạnh của tam giác: ");
            double side1 = scanner.nextDouble();
            double side2 = scanner.nextDouble();
            double side3 = scanner.nextDouble();

            Main myMain = new Main();
            myMain.checkSideRectangle(side1);
            myMain.checkSideRectangle(side2);
            myMain.checkSideRectangle(side3);
            myMain.checkRectangle(side1, side2, side3);
            myMain.checkRightTriangle(side1, side2, side3);
            System.out.println(myMain.getArea(side1,side2,side3));

        } catch (Triangle triangle) {
//            System.out.println(triangle.getMessage());
            triangle.printStackTrace();
        }
    }
}
