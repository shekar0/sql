
	package example;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.util.Scanner;

	public class deletion {
		private static final String User="root";
		private static final String Password="root";
		
		
		public static void main(String[] args) {
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println("enter database name :");
			    String Url="jdbc:mysql://localhost:3306/"+sc.next();
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection conn=DriverManager.getConnection(Url, User, Password);
				System.out.println("enter table name :");
				String sql="delete from "+sc.next()+" where id = ?";
				
				PreparedStatement pmst=conn.prepareStatement(sql);
				System.out.println("enter id:");
				pmst.setInt(1,sc.nextInt());
				int i=pmst.executeUpdate();
				if(i>0)
				{
					System.out.println("successfully deleted");
				}
				else {
					System.out.println("not deleted");
				}
				conn.close();
				pmst.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}


	}


