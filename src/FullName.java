public class FullName {

	private String[] name;
	private String surname;
	
	public FullName(String fullName)
	{
		setFullName(fullName);
	}
	
	public void setFullName(String fullName)
	{
		String[] tmp = fullName.split(" ");
		surname = tmp[tmp.length-1];
		name = new String[tmp.length-1];
		if(tmp.length>1)
		{
			for(int i=0;i<tmp.length-1; i++)
			{
				name[i] = tmp[i];
			}
		}
	}
	
	public String getName()
	{
		String tmp = "";
		for(String s : name)
			tmp += s;
		return tmp;
	}
	
	public String getSurname()
	{
		return surname;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(String s : name)
			sb.append(s + " ");
		sb.append(surname);
		return sb.toString();
	}
	
}
