import java.sql.*;
import java.util.Scanner;
public class test {
	public void show()
	{
		System.out.println("|------------------------------|");
		System.out.println("请输入您的选择!");
		System.out.println("1.增加学生信息!");
		System.out.println("2.修改指定学号的学生信息!");
		System.out.println("3.删除指定学号的学生信息!");
		System.out.println("4.按照性别找出学生基本信息!");
		System.out.println("5.按照年龄段找出学生基本信息!");
		System.out.println("6.退出系统!");
		System.out.println("|------------------------------|");
		
	}
	public void Add_STU(PreparedStatement pr,Connection conn) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入增加学生的信息！");
		System.out.print("学号：");
		String no=sc.next();
		System.out.print("姓名：");
		String name=sc.next();
		System.out.print("班级：");
		String cls=sc.next();
		System.out.print("年龄：");
		int age=sc.nextInt();
		System.out.print("性别：");
		String sex=sc.next();
		String sql="insert into Student values(?,?,?,?,?)";//使用通配符进行预处理
		pr=conn.prepareStatement(sql);
		pr.setString(1, no);	pr.setString(2, name);	
		pr.setString(3, cls);	pr.setInt(4, age);
		pr.setString(5, sex);
		pr.executeUpdate();
		System.out.println("增加成功！");
		
	}
	
	public void Delete_STU(PreparedStatement pr,Connection conn) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入您要删除的学号：");
		String no=sc.next();
		String sql="delete from Student where Sno=?";
		pr=conn.prepareStatement(sql);
		pr.setString(1, no);
		System.out.println("删除成功！");
		pr.executeUpdate();
		
		
	}
	
	public void Alter_STU(PreparedStatement pr,Connection conn) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入您要修改学生的学号：");
		String no=sc.next();
		String sql="update Student set Sname=? , Class=? , Age=? , Sex=? where Sno=?";
		System.out.println("请输入修改学生的信息！");
		System.out.print("姓名：");
		String name=sc.next();
		System.out.print("班级：");
		String cls=sc.next();
		System.out.print("年龄：");
		int age=sc.nextInt();
		System.out.print("性别：");
		String sex=sc.next();
		pr=conn.prepareStatement(sql);
		pr.setString(1, name); 	pr.setString(2, cls);
		pr.setInt(3, age); pr.setString(4, sex);
		pr.setString(5, no);
		pr.executeUpdate();
		System.out.println("修改成功！");
		pr.executeUpdate();
		
	}
	
	public void Find_Sex(PreparedStatement pr,Connection conn) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		String sql="select* from Student where Sex=?";
		pr=conn.prepareStatement(sql);
		System.out.print("请输入您要查找的性别：");
		String sex=sc.next();
		pr.setString(1, sex);
		ResultSet rs=pr.executeQuery();
		System.out.println("学号"+ "\t" + "姓名" +"\t "+"班级"+"\t" + "年龄"+"\t"+"性别");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+ "\t" + rs.getString(2) +"\t "+rs.getString(3)+"\t" + rs.getInt(4)+"\t"+rs.getString(5));
			
		}
		System.out.println("按性别查找成功！");
	}
	
	public void Find_Age(PreparedStatement pr,Connection conn) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		String sql="select* from Student where Age>=? and Age<=?";
		pr=conn.prepareStatement(sql);
		int age_1,age_2;
		System.out.println("请输入查找的范围：");
		age_1=sc.nextInt();
		age_2=sc.nextInt();
		pr.setInt(1, age_1);
		pr.setInt(2, age_2);
		ResultSet rs=pr.executeQuery();
		System.out.println("学号"+ "\t" + "姓名" +"\t "+"班级"+"\t" + "年龄"+"\t"+"性别");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+ "\t" + rs.getString(2) +"\t "+rs.getString(3)+"\t" + rs.getInt(4)+"\t"+rs.getString(5));
		}
		System.out.println("按年龄段查找成功！");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		test t=new test();
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/lanty";
		String user= "root";
		String password="";
		Connection con=DriverManager.getConnection(url, user, password);
		//一个Connection对象表示对一个数据源已经建立的一条连接
		PreparedStatement pre=null;
		//PreparedStatement对象将参数化的SQL语句发送到数据库
		t.show();
		int n;
		while(true)
		{	
			System.out.print("请输入您的选择:");
			Scanner sc=new Scanner(System.in);
			n=sc.nextInt();
			if(n==6)
				break;
			switch(n)
			{
			case 1: t.Add_STU(pre, con);	    break;
			case 2: t.Alter_STU(pre, con);		break;
			case 3: t.Delete_STU(pre, con);		break;
			case 4: t.Find_Sex(pre, con);       break;
			case 5: t.Find_Age(pre, con);       break;
			}
		}
		con.close();
		pre.close();
		
	}
	
}
