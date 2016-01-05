package pl.agh.edu.lab4;

import pl.agh.edu.Filter;
import pl.agh.edu.Person;
import pl.agh.edu.PersonList;

public class FilterPersons implements Command{

	private Filter<Person> filter;
	private PersonList list;
	
	public FilterPersons(PersonList list, Filter<Person> filter) {
		this.list = list;
		this.filter = filter;
	}
	@Override
	public void execute() {
		for(Person p : list.filter(filter))
		{
			System.out.println(p);
		}
	}
	
}
