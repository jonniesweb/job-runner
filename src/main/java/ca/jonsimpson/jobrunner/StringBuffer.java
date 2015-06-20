package ca.jonsimpson.jobrunner;

import java.util.LinkedList;

public class StringBuffer {
	
	LinkedList<Character> list = new LinkedList<Character>();
	
	public synchronized void add(char i) {
		list.add(i);
	}
	
	public synchronized String getString() {
		
		char[] c = new char[list.size()];
		Character[] array = list.toArray(new Character[] {});
		for (int i = 0; i < array.length; i++) {
			c[i] = array[i];
		}
		
		return new String(c);
	}
	
	
	public static void main(String[] args) {
		StringBuffer b = new StringBuffer();
		
		b.add('a');
		b.add('b');
		b.add('c');
		
		String string = b.getString();
		System.out.println(string);
	}
	
	
}
