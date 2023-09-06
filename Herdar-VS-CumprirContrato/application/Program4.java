package application;

import java.util.Scanner;

import model.entities.Circle;
import model.entities.Retangle;
import model.entities.Shape;
import model.enums.Color;

public class Program4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Shape s1 = new Circle(Color.BLACK, 2.0);
		Shape s2 = new Retangle(Color.BLACK, 3.0, 4.0);
		
		System.out.println("Circle color: " + s1.getColor());
		System.out.println("Circle area: " + String.format("%.3f", s1.area()));
		System.out.println("Rectangle color: " + s2.getColor());
		System.out.println("Rectangle area: " + String.format("%.3f", s2.area()));
		
		sc.close();
	}
}
