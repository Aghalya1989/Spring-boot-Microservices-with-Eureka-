package com.javainterview.questions;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableDemo {
	
	private final int id;
	private final String name;
	private final List<String> hobbies;
	public ImmutableDemo(int id, String name, List<String> hobbies) {
		super();
		this.id = id;
		this.name = name;
		this.hobbies = new ArrayList<>();
		for(String e :hobbies)
		{
		this.hobbies.add(e);
		}
		
	}
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}
	public List<String> getHobbies() {
		/*
		 * List<String> newList = new ArrayList<>();
		 * 
		 * for(String e :this.hobbies) newList.add(e);
		 */
		return hobbies;
	}
	/*
	 * public void setId(int id) { this.id = id; }
	 */

	/*
	 * public void setName(String name) { this.name = name; }
	 */
	
	/*
	 * public void setHobbies(List<String> hobbies) { this.hobbies = hobbies; }
	 */
	
	public static void main(String[] args) {
		List <String> hobbies = new ArrayList<>(); // new list will be created in heap and assign  a reference to it
		hobbies.add("Singing");
		ImmutableDemo demo = new ImmutableDemo(1,"Aghalya",hobbies);
		System.out.println(demo.getId()+"  "+demo.getName()+"   "+demo.getHobbies());
		hobbies.add("Dancing");
		System.out.println(demo.getId()+"  "+demo.getName()+"   "+demo.getHobbies());
		// if you are not returning the new reference in get then we can actually change the object
		demo.getHobbies().set(0, "Writing");
		System.out.println(demo.getId()+"  "+demo.getName()+"   "+demo.getHobbies());
		
		//Ways of changing the instance variables of ImmutableDemo object
		//1. By directly accessing instance variables
		//2. By setter methods.
		//3. By passing object references in the constructor
		//4. By getter methods also,we can get the hobbies list and we can change the values
	}

}
