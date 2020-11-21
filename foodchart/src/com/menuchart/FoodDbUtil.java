package com.menuchart;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FoodDbUtil {
	public static  List<Food> getFoodList() throws ClassNotFoundException, SQLException{
		ArrayList<Food> food=new ArrayList<>();
		String url="jdbc:mysql://localhost:3306/elephant";
		String username="root";
		String password="Azam/235";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, username, password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from foodcart");
		
		while(rs.next()) {
			int id=rs.getInt(1);
			String item=rs.getString(2);
			float price=rs.getFloat(3);
			Food f=new Food(id, item, price);
			food.add(f);
		}
		return food;
	}
}
