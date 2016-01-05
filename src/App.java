import java.util.Scanner;

public class App {

	private int f=1;
	private int choose;
	private Scanner sc = new Scanner(System.in);
	PersonList list = new PersonList();
	private MacroCommand macro = new MacroCommand();
	
	public void start()
	{
		while(!isEnd())
		{
			choose = printMenuAndReturnChoose();
			if(choose == 1)
				macro.addCommand(new Add(list, addPerson())).execute();
			else if(choose == 2)
				macro.addCommand(new Listing(list)).execute();
			else if(choose == 3)
				macro.addCommand(new RemovePerson(list, removePerson())).execute();
			else if(choose == 4)
			{
				int ch = filterPerson();
				if(ch == 1)
				{
					System.out.println("Podaj imie: ");
					String im = sc.next();
					macro.addCommand(new FilterPersons(list, list.new NameFilter(im))).execute();
				}
				else if(ch == 2)
				{
					System.out.println("Podaj nazwisko: ");
					String im = sc.next();
					macro.addCommand(new FilterPersons(list, list.new SurnameFilter(im))).execute();
				}
				else
				{
					System.out.println("Podaj rok urodzenia: ");
					Integer im = sc.nextInt();
					macro.addCommand(new FilterPersons(list, list.new BirthYearFilter(im))).execute();
				}
			}
			else
				f=0;		
		}
	}
	
	private int printMenuAndReturnChoose()
	{
		System.out.println("Witaj w bazie uzytkownikow");
		System.out.println("1. Dodaj uzytkownika");
		System.out.println("2. Wyswietl uzytkownikow");
		System.out.println("3. Usun uzytkownika");
		System.out.println("4. Filtruj uzytkownikow");
		System.out.println("[INNY] Wyjdz");
		System.out.println("---> ");
		return sc.nextInt();
	}
	
	private int removePerson()
	{
		System.out.println("Podaj ktora osobe z kolei usunac: ");
		return sc.nextInt()-1;
	}
	
	private int filterPerson()
	{
		System.out.println("1. Filtr imienny");
		System.out.println("2. Filtr po nazwisku");
		System.out.println("3. Filtr po roku urodzenia");
		int ch = sc.nextInt();
		return ch;
	}
	
	private Person addPerson()
	{
		System.out.println("Podaj imie: ");
		String name = sc.next();
		System.out.println("Podaj nazwisko: ");
		String sname = sc.next();
		System.out.println("Podaj PESEL: ");
		String pes = sc.next();
		System.out.println("Podaj numer telefonu: ");
		String phone = sc.next();
		return new Person(name + " " + sname, phone, pes);
	}

	public boolean isEnd()
	{
		if(f==0)
			return true;
		else return false;
	}
	
	public static void main(String[] args) {
		
		/*Person p1 = new Person("Robert Nowak", "786821219", "94031838923");
		Person p2 = new Person("Adam Kowalski", "886834262", "91051112327");
		Person p3 = new Person("Jan Malinowski", "789986271", "94081568973");
		PersonList list = new PersonList();
		MacroCommand macro = new MacroCommand();
		list.addPerson(p1);
		Add add = new Add(list, p2); Add add2 = new Add(list, p3); 
		Listing l = new Listing(list);
		macro.addCommand(add); macro.addCommand(add2);macro.addCommand(l);
		macro.execute();*/
		App app = new App();
		app.start();
		
		
		
	}
}
