package main;

public class User {
	private int id=0;
	private String name=null;
	private int money=0;
	DiskBook note=new DiskBook();
	public User(int id,String name,int money) {
		super();
		this.id=id;
		this.name=name;
		this.money=money;
		this.note=null;
	}
	public User() {}
	
	public int hashCode() {
		final int prime=31;
		int result=1;
		result=prime*result+id;
		result=prime*result+money;
		result=prime*result+((name==null)?0:name.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if(this==obj) {return true;}
		if(obj==null) {return false;}
		if(getClass()!=obj.getClass()) {return false;}
		
		User other=(User)obj;
		if(id!=other.id) {return false;}
		if(money!=other.money) {return false;}
		if(name==null) {
			if(other.name!=null) {return false;}
		}
		else if(!name.equals(other.name)) {return false;}
		return true;
	}
	
	public String toString() {
		String result="User [id="+id+", name="+name+", money="+money+"]"+"\0";
		if(note!=null) {
			result+=note.toString();
		}
		return result;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id=id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	
	public int getMoney() {return money;}
	public void setMoney(int money) {this.money=money;}
	
	public DiskBook getNote() {return note;}
	public void setNote(DiskBook note) {this.note=note;}

}
