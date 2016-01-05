import pl.agh.edu.PersonList;

public class Listing implements Command{

	private PersonList list;
	
	public Listing(PersonList list)
	{
		this.list = list;
	}
	@Override
	public void execute() {
		
		list.showList();
	}

}
