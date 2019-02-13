package ru.job4j.calculate;

/**
 * Class used for printing input parameter 3 times
 * @author rvk12
 * @since 13.02.2018
 * @version 1
 */
public class Calculate {
	public String echo(String value) {
		return String.format("%s %s %s", value, value, value);
	}
	
	/**
	 * Creates new Calculate object and prints result of method echo in console
	 * @param args - args
	 */
	public static void main(String[] args){
		Calculate calc = new Calculate();
		System.out.println(calc.echo("aah"));
	}
}