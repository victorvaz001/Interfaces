package application;

import devices.ComboDevice;
import devices.ConcretePrinter;
import devices.ConcreteScanner;

public class Program5 {

	public static void main(String[] args) {
		
		ConcretePrinter p = new ConcretePrinter("1080");
		p.processDoc("My Letter");
		p.print("My Letter");
		
		System.out.println();
		ConcreteScanner s = new ConcreteScanner("2003");
		s.processDoc("My Email");
		System.out.println("Scann result: " + s.scan());
		
		System.out.println();
		ComboDevice c = new ComboDevice("2");
		c.processDoc("My dissertation");
		c.print("My dissertaion");
		System.out.println("Scan result: " + c.scan());

	}

}
