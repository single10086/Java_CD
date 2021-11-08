package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.Boss;

public class Function {
	private UserBook ub=new UserBook();
	private DiskBook db=new DiskBook();
	private int lentCount=0,saleCount=0;
	private int invest=0;
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	public void addUser() {
		// TODO Auto-generated method stub
		try {
			System.out.print("name?");
			String name=in.readLine();
			System.out.print("id?");
			int id=Integer.parseInt(in.readLine());
			System.out.print("money?");
			int money=Integer.parseInt(in.readLine());
			User user=new User(id,name,money);
			ub.addUser(user);
			ub.print();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeUser() {
		// TODO Auto-generated method stub
		try {
			String uName=new String();
			
			System.out.print("id?");
			int id=Integer.parseInt(in.readLine());
			uName=ub.removeUser(id);
			System.out.println("会员 "+uName+" 已被删除");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void findUser() {
		// TODO Auto-generated method stub
		System.out.println("id?");
		try {
			int id=Integer.parseInt(in.readLine());
			User user = ub.findUser(id);
			System.out.println(user);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void rentOrSail(boolean b) {
		// TODO Auto-generated method stub
		try {
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("user id?");
			int userId=Integer.parseInt(in.readLine());			//编号
			System.out.print("book id?");			
			int bookId=Integer.parseInt(in.readLine());			//书名
			System.out.print("how many?");
			int number=Integer.parseInt(in.readLine());
			
			User user=ub.findUser(userId);
			Disk disk=db.findDisk(bookId);
			
			if(b) {
				if(user.getMoney()>(disk.getLendPrice()*number)) {
					int borrow=disk.getBorrow();
					if(borrow+number+disk.getSale()>disk.getNum()) {
						System.out.println("库存不够");
						return;
					}
					//if()
					borrow+=number;
					disk.setborrow(borrow);
					
					int num=disk.getNum();
					num-=borrow;
					disk.setNum(num);
					
					int rest=user.getMoney();
					rest-=disk.getLendPrice()*number;
					user.setMoney(rest);
					lentCount+=disk.getLendPrice()*number;
					
					Disk di=new Disk(bookId,disk.getName(),disk.getPrice(),
							disk.getLendPrice(),disk.getSalePrice(),disk.getNum(),borrow,disk.getSale());
					ub.addNote(user.getId(),di);
					System.out.println(user);
				}
			}
			if(!b) {
				if(user.getMoney()>(disk.getSalePrice()*number)) {
					int sale=disk.getSale();
					if(sale+disk.getBorrow()+number>disk.getNum()) {
						System.out.println("库存不够");
						return;
					}
					sale+=number;
					disk.setSale(sale);
					
					int num=disk.getNum();
					num-=sale;
					disk.setNum(num);
					
					int rest=user.getMoney();
					rest-=disk.getSalePrice()*number;
					user.setMoney(rest);
					//System.out.println(user);
					saleCount+=disk.getSalePrice()*number;
					
					Disk di=new Disk(bookId,disk.getName(),disk.getPrice(),
							disk.getLendPrice(),disk.getSalePrice(),disk.getNum(),disk.getBorrow(),sale);
					ub.addNote(user.getId(),di);
					System.out.println(user);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void returnBook() {
		// TODO Auto-generated method stub
		try {
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("user id?");
			int userId=Integer.parseInt(in.readLine());			//编号
			System.out.print("book id?");			
			int bookId=Integer.parseInt(in.readLine());			//书名
			System.out.print("how many?");
			int number=Integer.parseInt(in.readLine());			//还书数目
			
			User user=ub.findUser(userId);
			Disk disk=db.findDisk(bookId);
			
			if(user.getNote().getDisk(bookId)!=null) {	
				if(user.getNote().getDisk(bookId).getBorrow()<number) {
					System.out.println("所要归还的书籍数目错误");
					return;
				}
			}
			int num=disk.getNum();
			num+=number;
			disk.setNum(num);
			
			int borrow=disk.getBorrow();
			borrow-=number;
			disk.setborrow(borrow);
			
			DiskBook dk=user.getNote();
			
			//System.out.println(user);
			System.out.println(disk);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void purchase() {
		// TODO Auto-generated method stub
		try {
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("id?");
			int id=Integer.parseInt(in.readLine());			//编号
			System.out.print("name?");			
			String name=in.readLine();						//书名
			System.out.print("price?");
			int price=Integer.parseInt(in.readLine());		//进货价格
			System.out.print("lent price?");
			int lentPrice=Integer.parseInt(in.readLine());	//出租价格
			System.out.print("sale price?");
			int salePrice=Integer.parseInt(in.readLine());	//出售价格
			System.out.print("num?");
			int num=Integer.parseInt(in.readLine());		//进货数量			
			
			
			invest+=price*num;		
			Disk disk=new Disk(id,name,price,lentPrice,salePrice,num,0,0);
			db.addDisk(disk);
			db.print();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void Statistics() {
		// TODO Auto-generated method stub
		System.out.println("支出："+invest);
		int count=0;count=lentCount+saleCount;
		System.out.println("收入："+count);
		return;
	}

	public UserBook getUb() {return ub;}
	public DiskBook getDb() {return db;}
	
}

