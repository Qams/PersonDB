package pl.agh.edu.lab4;

import java.util.ArrayList;

public class MacroCommand implements Command{

	ArrayList<Command> list = new ArrayList<>();
	
	public void execute() {
		
		for(Command c : list)
		{
			c.execute();
		}
	}
	
	public Command addCommand(Command c)
	{
		list.add(c);
		return c;
	}
	
	public void executeLast()
	{
		if(list.size()>0)
			list.get(list.size()-1).execute();
	}

}
