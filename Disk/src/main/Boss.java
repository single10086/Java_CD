package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boss {
	private Function f=new Function(); 
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		Boss boss=new Boss();
		boss.begin();
	}
	
	private void begin() {
		// TODO Auto-generated method stub
		f.getUb().initial();
		f.getDb().initial();
		f.getUb().print();
		f.getDb().print();
		while(true) {
			printMainMenu();
			int choice=0;
			try {
				choice=readUserInput();
				while(true) {
					try {
						if(choice<1||choice>4) {
							System.out.println("Out of range! Please input again");
							choice=readUserInput();
							continue;
						}else {break;}
					}catch(NumberFormatException e) {e.printStackTrace();}
				}
			}catch(NumberFormatException e) {e.printStackTrace();}
			
			switch(choice) {
			case 1:
				userManage();
				break;
			case 2:
				diskManage();
				break;
			case 3:
				f.Statistics();
				break;
			case 4:
				return;
			}
		}
	}

	private void diskManage() {
		// TODO Auto-generated method stub
		while(true) {
			printDiskMenu();
			int choice=readUserInput();
			switch(choice) {
			case 1:
				f.rentOrSail(true);			//����
				break;
			case 2:
				f.rentOrSail(false);		//����
				break;
			case 3:
				f.returnBook();
				break;	
			case 4:
				f.purchase();
				break;
			case 5:
				begin();
				return;
			}
		}
	}

	private void printDiskMenu() {
		// TODO Auto-generated method stub
		System.out.println("1:���");
		System.out.println("2:����");	
		System.out.println("3:�黹");	
		System.out.println("4:����");
		System.out.println("5:�˳�");
	}

	private void userManage() {
		// TODO Auto-generated method stub
		while(true) {
			printUSerMenu();
			int choice=readUserInput();
			switch(choice) {
			case 1:
				f.addUser();
				break;
			case 2:
				f.removeUser();
				break;
			case 3:
				f.findUser();
				break;
			case 4:
				return;
			}
		}
	}

	private void printUSerMenu() {
		// TODO Auto-generated method stub
		System.out.println("1:���ӻ�Ա");		//��ӳ�Ա
		System.out.println("2:ɾ����Ա");	//ɾ����Ա
		System.out.println("3:Ѱ�һ�Ա");	//ɾ����Ա
		System.out.println("4:�˳�");
	}

	private int readUserInput() {
		// TODO Auto-generated method stub
		try {
			String line;
			line=in.readLine();
			return Integer.parseInt(line);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private void printMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("---------------------------");
		System.out.println("1:User Manage");
		System.out.println("2:Disk Manage");
		System.out.println("3:Statistics of revenue and expenditure");
		System.out.println("4:quit");
	}
}
