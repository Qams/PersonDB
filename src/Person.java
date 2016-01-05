import java.io.Serializable;

public class Person implements Serializable{
	private FullName fullName;
	private String phone;
	private String pesel;
	
	public Person(String fn, String ph, String pe)
	{
		fullName = new FullName(fn);
		phone = ph;
		pesel = pe;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName.setFullName(fullName);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public String toString()
	{
		return "Full name: " + fullName + "; Phone: " + phone + "; Pesel: " + pesel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pesel == null) ? 0 : pesel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		return true;
	}

	

	
	
}
