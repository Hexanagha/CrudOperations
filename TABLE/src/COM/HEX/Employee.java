package COM.HEX;

import java.util.Scanner;
import java.sql.*;

public class Employee {
	public static void main(String args[]) {

		int id, salary, out;

		String name, address;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sampledd", "root", "root");
			con.createStatement();

			Scanner s = new Scanner(System.in);
			System.out.println("select the operation");

			out = s.nextInt();

			if (out == 1) {
				String sql = "INSERT INTO emp1 values(?,?,?,?)";

				PreparedStatement Statement = con.prepareStatement(sql);

				System.out.println("enter the id");
				id = s.nextInt();
				Statement.setInt(1, id);
				System.out.println("enter the name");
				name = s.next();
				Statement.setString(2, name);
				System.out.println("enter the address");
				address = s.next();
				Statement.setString(3, address);
				System.out.println("enter the salary");
				salary = s.nextInt();
				Statement.setInt(4, salary);

				int rowsInserted = Statement.executeUpdate();

				if (rowsInserted > 0) {

					System.out.println("new row is created");
				}
			}else if (out == 2) {
				String sql = "UPDATE emp1 set name=? ,address=?,salary=? WHERE id=?";

				PreparedStatement Statement = con.prepareStatement(sql);

				

		        System.out.println("update the name");
				name = s.next();
				Statement.setString(1, name);
				System.out.println("address");
				address = s.next();
				Statement.setString(2, address);
				System.out.println("update the salart");
				salary = s.nextInt();
				Statement.setInt(3, salary);
				
				System.out.println("update the id");
				id=s.nextInt();
				Statement.setInt(4,id);
				int rowsUpdated = Statement.executeUpdate();
				if (rowsUpdated > 0) {

					System.out.println("row is updated");
				}
			}else if (out == 3) {
				String sql = "DELETE from emp1 where id=?";

				PreparedStatement Statement = con.prepareStatement(sql);

				System.out.println("delete the id");
				id = s.nextInt();
				Statement.setInt(1, id);
				int rowsUpdated = Statement.executeUpdate();
				if (rowsUpdated > 0) {

					System.out.println("row is deleted");
				}

			} else {
				System.out.println("there is an error");
			}
		} catch (Exception e) {

			System.out.print("print the Exception e" + e);
		}

	}

}
