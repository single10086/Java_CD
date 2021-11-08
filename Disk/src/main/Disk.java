 package main;
public class Disk {
	private int id;
	private String name=null;
	private int price=0;			//进货价格
	private int lendPrice=0;		//出租价格
	private int salePrice=0;		//出售价格
	private int num=0;				//disk在库数量
	private int borrow=0;
	private int sale=0;
	
	public Disk(int id,String name,int price,int lendPrice,int salePrice,int num,int borrow,int sale) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.lendPrice=lendPrice;
		this.salePrice=salePrice;
		this.num=num;
		this.borrow=borrow;
		this.sale=sale;
	}
	
	public Disk() {}

	public int getId() {return id;}
	public void setId(int id) {this.id=id;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price=price;}
	
	public int getLendPrice() {return lendPrice;}
	public void setLendPrice(int lendPrice) {this.lendPrice=lendPrice;}
	
	public int getSalePrice() {return salePrice;}
	public void setSalePrice(int salePrice) {this.salePrice=salePrice;}
	
	public int getNum() {return num;}
	public void setNum(int num) {this.num=num;}

	public int getBorrow() {return borrow;}
	public void setborrow(int borrow) {this.borrow=borrow;}
	
	public int getSale() {return sale;}
	public void setSale(int sale) {this.sale=sale;}
	
	public String toString() {
		return "Disk [id="+id+", name="+name+", price="+price+", num="+num+", borrowed="+borrow+", sailed="+sale+"]";
	}
	
	public int hashCode() {
		final int prime=31;
		int result=1;
		result=prime*result+id;
		result=prime*result+((name==null)?0:name.hashCode());
		result=prime*result+num;
		result=prime*result+price;
		return result;
	}
	
	public boolean equals(Object obj) {
		if(this==obj) {return true;}
		if(obj==null) {return false;}
		if(getClass()!=obj.getClass()) {return false;}
		
		Disk other=(Disk)obj;
		if(id!=other.id) {return false;}
		if(price!=other.price) {return false;}
		if(name==null) {
			if(other.name!=null) {return false;}
		}
		else if(!name.equals(other.name)) {return false;}
		return true;
	}
}
