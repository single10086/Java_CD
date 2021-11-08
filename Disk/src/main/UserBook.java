package main;
import java.io.IOException;

public class UserBook {
	private User[] data=new User[1000];
	public void addUser(User u) {
		for(User user:data) {
			if(user!=null&&user.getId()==u.getId()) {
				System.out.println("The id has exited, please input another");
				return;
			}
		}
		data[u.getId()]=u;
	}
	public User findUser(int id) {
		for(User user:data) {
			if(user!=null&&user.getId()==id) {return user;}
		}
		return null;
	}
	
	public String removeUser(int id) {
		String uName=new String();
		try {
			int i=0;
			for (User user:data) {
				if(data[i]!=null&&user.getId()==id) {
					uName=data[i].getName();
					data[i]=null;
					print();
					break;
				}
				i++;
			}
		}catch(NumberFormatException e) {e.printStackTrace();}
		return uName;

	}

	public void print() {
		String result=toString();
		System.out.println(result);
	}
	public String toString() {
		String result="";
		for (User user:data) {
			if(user!=null) {
				result+=user+"\n";
			}
		}
		return result;
	}
	public void initial() {
		// TODO Auto-generated method stub
		User u[]=new User[5];
		u[0]=new User(1,"a",100);
		u[1]=new User(2,"b",200);
		u[2]=new User(3,"c",300);
		u[3]=new User(4,"d",400);
		u[4]=new User(5,"e",500);
		for(int i=0;i<5;i++) {
			addUser(u[i]);
		}
		//print();
	}
	public void addNote(int id, Disk di) {
		// TODO Auto-generated method stub
		DiskBook dk=new DiskBook();
		int i=0;
		for(User user:data) {
			if(data[i]!=null&&data[i].getId()==id) {
				if(dk==null) {	
					dk=data[i].getNote();
				}
				dk.addDisk(di);
				data[i].setNote(dk);
				//System.out.println(data[i].getNote());
				return;
			}
			i++;
		}
		
	}
}

