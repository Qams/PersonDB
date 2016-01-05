import java.util.*;

public class PersonList implements Iterable<Person>{
	
	private ArrayList<Person> zb = new ArrayList<>();
	
	public ArrayList<Person> getZb() {
		return zb;
	}

	public void setZb(ArrayList<Person> zb) {
		this.zb = zb;
	}


	public class NameFilter implements Filter<Person>
	{
		private String n;
		public NameFilter(String n) {
			this.n = n; 
		}
		public boolean meetsCondition(Person obj) {
			return obj.getFullName().getName().equalsIgnoreCase(n);
		}
		
	}
	
	public class SurnameFilter implements Filter<Person>
	{
		private String s;
		public SurnameFilter(String s)
		{
			this.s = s;
		}
		@Override
		public boolean meetsCondition(Person obj) {
			return obj.getFullName().getSurname().equalsIgnoreCase(s);
		}
	}
	
	public class BirthYearFilter implements Filter<Person>
	{
		Integer year;
		public BirthYearFilter(Integer year) {
			this.year = year;
		}
		@Override
		public boolean meetsCondition(Person obj) {
			String tmp = year.toString();
			return tmp.substring(2, 4).equals(obj.getPesel().substring(0, 2));
		}
		
	}
	
	public class AndFilters implements Filter<Person>
	{
		
		ArrayList<Filter<Person>> filters;
		
		public AndFilters(Filter<Person> ...args) {
			filters = new ArrayList<>();
			for(Filter<Person> f : args)
			{
				filters.add(f);
			}
		}
		@Override
		public boolean meetsCondition(Person obj) {
			
				for(Filter<Person> f : filters)
				{
					if(!f.meetsCondition(obj))
						return false;
				}
				return true;
		}
		
	}
	
	
	public List<Person> filter(Filter f)
	{
		List<Person> tmp = new ArrayList<>();
		for(Person p : zb)
		{
			if(f.meetsCondition(p))
				tmp.add(p);
		}
		return tmp;
	}
	
	
	public class nameComp implements Comparator<Person>
	{

		@Override
		public int compare(Person o1, Person o2) {
			
			return o1.getFullName().getName().compareTo(o2.getFullName().getName());
		}
		
	}
	
	
	public boolean addPerson(Person p)
	{
		return zb.add(p);
	}
	
	public boolean removePerson(Person p)
	{
		return zb.remove(p);
	}
	
	public Person removePerson(int i)
	{
		return zb.remove(i);
	}
	
	public void showList()
	{
		if(zb.isEmpty())
			System.out.println("Data base is empty");
		else 
		{
			for(Person p : zb)
			{
				System.out.println(p);
			}
		}
	}
	
	public List<Person> sortName()
	{
		LinkedList<Person> tmp = new LinkedList<>();
		for(Person p : zb)
		{
			tmp.add(p);
		}
		tmp.sort(new nameComp());
		return tmp;
	}
	
	@Override
	public Iterator<Person> iterator() {
		return zb.iterator();
	}
	

}
