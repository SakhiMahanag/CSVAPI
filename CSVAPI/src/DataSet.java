
public class DataSet {

	String name,contact,addr;
	int id;
	
	DataSet(int i,String n,String c,String a)
	{
		this.id = i;
		this.name = n;
		this.contact = c;
		this.addr = a;
	}
	public void setID(int i)
	{
		this.id = i;
	}
	public void setName(String nm)
	{
		this.name = nm;
	}
	public void setContactD(String ct)
	{
		this.contact = ct;
	}
	public void setAddress(String add)
	{
		this.addr = add;
	}
	public int getId()
	{
		return this.id;
	}
	public String getName()
	{
		return this.name;
	}
	public String getContact()
	{
		return this.contact;
	}
	public String getAddress()
	{
		return this.addr;
	}
	public String toString()
	{
		return "Id : "+id+"\nName : "+name+"\nContact No: "+contact+"\nAddress : "+addr;
	}
}
