package main;

public class DiskBook {
	private Disk[] data=new Disk[1000];
	public void addDisk(Disk d) {
		int id=d.getId();
		Disk disk=findDisk(id);
		if(disk==null) {
			data[id]=d;
		}else {
			int num=disk.getNum();
			num=num+d.getNum();
			disk.setNum(num);
		}
		//print();
	}

	public String removeDisk(int id) {
		String uName=new String();
		try {
			int i=0;
			for (Disk disk:data) {
				if(data[i]!=null&&disk.getId()==id) {
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
	
	public Disk findDisk(int id) {
		// TODO Auto-generated method stub
		for(Disk disk:data) {
			if(disk!=null&&disk.getId()==id) {return data[id];}
		}
		//System.out.println("There has no disk numbered "+id);
		return null;
	}
	
	public void print() {
		String result=toString();
		System.out.println(result);
	}
	
	public String toString() {
		String result="";
		for (Disk disk:data) {
			if(disk!=null) {result+=disk+"\n";}
		}
		return result;
	}

	public void initial() {
		// TODO Auto-generated method stub
		Disk[] disk=new Disk[5];
		//编号，书名，进货价格，出租价格，出售价格，在库数量
		disk[0]=new Disk(0001,"The Little Prince",10,1,15,50,0,0);
		disk[1]=new Disk(0002,"The Old Man And The Sea",13,1,20,30,0,0);
		disk[2]=new Disk(0003,"To Kill A Mockingbird",25,2,35,50,0,0);
		disk[3]=new Disk(0004,"Pride And Prejudice",10,1,15,35,0,0);
		disk[4]=new Disk(0005,"Wuthering Heights",15,1,23,50,0,0);
		for(int i=0;i<5;i++) {
			addDisk(disk[i]);
		}
		//print();
	}



	public Disk getDisk(int bookId) {
		// TODO Auto-generated method stub
		for(Disk disk:data) {
			if(disk!=null&&disk.getId()==bookId) {return disk;}
		}
		return null;
	}

}
