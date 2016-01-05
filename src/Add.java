package pl.agh.edu.lab4;
import java.util.ArrayList;

import pl.agh.edu.*;

public class Add implements Command{

	private PersonList list;
	private Person person;
	public Add(PersonList list, Person person)
	{
		this.list = list;
		this.person = person;
	}
	
	@Override
	public void execute() {
		
		list.addPerson(person);
	}
}
