package task1;
import task1.book;
import task1.User;

import java.util.*;

//ʵ�ֹ��ܣ�ͼ����� ʵ��ͼ�����ɾ�Ĳ�

//ͼ����������������ID���Ƿ��� ������Ա������
//�û����������û��� ����������Ա���� Ĭ���û���Ϊadmin ����Ϊ123456

//Ҫ���û�����ͨ���û��������½ͼ�����ϵͳ δ��¼����֤ʧ�ܵ�ʱ���ܽ������ϵͳ

public class start {

    static int a=0;
    public void checkbook(List<book> books,User admin)    //��  ��ID����ͼ��
    {
    	if(admin.Check())
		{
    		System.out.println("������ID");
    		Scanner sc = new Scanner(System.in); 
            int id = sc.nextInt();
        	book a=new book();
        	a.setID(id);
			for(int n=0;n<books.size();n++)
			{
				book b=books.get(n);
				if(a.getID()==b.getID())
				{
					System.out.println("���ҳɹ�");
					System.out.println("����"+b.getname());
					if(b.check()) System.out.println("��������");
					else System.out.println("δ������");
					return;
				}
				//System.out.println("����ʧ��");
			}
			System.out.println("����ʧ��");
		}
		else {
			System.out.println("���¼���ȡȨ��");
		}
    }
	public void addbook(book a,List<book> books,User admin)       //��   �ϼ�ͼ��
	{
		if(admin.Check())
		{
			if(a.getstate_initialize())
				{books.add(a);
				System.out.println("����ϼ�����ɹ���");
				}
			else System.out.println("������δ���ú� �޷��ϼ�");
		}
		else {
			System.out.println("���¼���ȡȨ��");
		}
	}
	public void delete(List<book> books,User admin)       //ɾ  ��IDɾ��
	{
		if(admin.Check())
		{
    		System.out.println("������ID");
    		Scanner sc = new Scanner(System.in); 
            int id = sc.nextInt();
        	book a=new book();
        	a.setID(id);
			for(int n=0;n<books.size();n++)
			{
				book b=books.get(n);
				if(a.getID()==b.getID())
				{
					books.remove(b);
					System.out.println("ɾ���ɹ�");
					return;
				}

			}
			System.out.println("�޴��� ɾ��ʧ��");
		}
		else {
			System.out.println("���¼���ȡȨ��");
		}
	}
	public void changebook(List<book> books,User admin)       
	{
		if(admin.Check())
		{
    		System.out.println("������ID");
    		Scanner sc = new Scanner(System.in); 
            int id = sc.nextInt();
        	book a=new book();
        	a.setID(id);
			for(int n=0;n<books.size();n++)
			{
				book b=books.get(n);
				if(a.getID()==b.getID())
				{
					books.remove(b);
					System.out.println("����������");
			        Scanner bc = new Scanner(System.in);
			        String name=bc.nextLine();
			        b.setname(name);
					books.add(b);
					System.out.println("�޸ĳɹ�");
					return;
				}

			}
			System.out.println("�޴��� �޸�ʧ��");
		}
		else {
			System.out.println("���¼���ȡȨ��");
		}
	}
	public static void main(String[] args) {
		start system =new start();
		User admin = new User(123456,"admin");
		List<book> books = new ArrayList<>() ;
		while(true)
		{
			System.out.println("����������:");
			Scanner sc = new Scanner(System.in); 
	         int passport = sc.nextInt();
	        admin.login(passport);
	        while(admin.Check())
	        {
	        	System.out.println("����ͼ�����ϵͳ��1.�ϼ����� 2.ɾ��ͼ�� 3.�޸�ͼ����Ϣ 4.����ͼ�� 5.�ǳ�");
		         int choice = sc.nextInt();
		         if(choice==1)
		         {
		        	 book a=new book();
		        	 a.newbook();
		        	 system.addbook(a, books, admin);
		         }
		         if(choice==4)
		         {
		        	 system.checkbook(books, admin);
		         }
		         if(choice==2)
		         {
		        	 system.delete(books,admin);
		         }
		         if(choice==3)
		         {
		        	 system.changebook(books, admin);
		         }
		         if(choice==5)
		         {
		        	 return;
		         }
	        }
		}
	
	}

}
