package pl.agh.edu.lab4;

import pl.agh.edu.Person;
import pl.agh.edu.PersonList;

public class RemovePerson implements Command{

	private PersonList list;
	private Person person;
	int i;
	
	public RemovePerson(PersonList list, Person person) {
		this.list = list;
		this.person = person;
	}
	
	public RemovePerson(PersonList list, int i)
	{
		this.list = list;
		this.i = i;
	}
	
	@Override
	public void execute() {
		list.removePerson(i);
	}

}
