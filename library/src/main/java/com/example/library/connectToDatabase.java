package com.example.library;

import java.sql.*;

public class connectToDatabase {
	public static void main (String arg[])
	{
		Connection connection = null;
		try {
			//Connecting to the database, with url, username and password
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection (
					"jdbc:mysql://localhost:3306/library",
					"root", "root");
		}
	}
}
