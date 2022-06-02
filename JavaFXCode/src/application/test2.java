package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class test2 extends Application {
	private static final String URL = "jdbc:mysql:///details";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public void insert(String n, String e, String s, String g, String i) {
		Scanner scan = null;
		String query = null;
		String query1 = null;
		String query2 = null;
		Connection con = null;
		Statement st = null;
		int count = 0;

		try {
		// create Scanner class object
		query = "INSERT INTO studentform VALUES (\'" + n + "\' , " + "\'" + e +"\' ," + "\'"+ s + "\' ," + "\'" + g + "\' ," + "\'" +i + "\') ";
		query1="UPDATE studentform SET Name='maha' where Name='fizza'";
		query2="DELETE FROM studentform WHERE Name='maha';";
		// establish the connection
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		// create JDBC statement object
		if(con != null) {
		st = con.createStatement();
		}
		// execute the SQL query
		if(st != null) {
		count = st.executeUpdate(query2);
		}
		// display result
		System.out.println(count + " record inserted.");

		} catch(SQLException se) {
		se.printStackTrace();
		} catch(Exception e1) {
		e1.printStackTrace();
		} // try-catch block end

		finally {
		// close JDBC objects
		try {
		if(st != null) st.close();
		} catch(SQLException se) {
		se.printStackTrace();
		}
		try {
		if(con != null) con.close();
		} catch(SQLException se) {
		se.printStackTrace();
		}
		try {
		if(scan != null) scan.close();
		} catch(Exception e1) {
		e1.printStackTrace();
		}
		}//finally
		
		
	}
	
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// variables for connection
		final String url = "jdbc:mysql:///details";
		final String user = "root";
		final String password = "root";
		// establish the connection
		Connection con = DriverManager.getConnection(url, user, password);
		// display status message
		if (con == null) {
		System.out.println("JDBC connection is not established");
		return;
		} else {
		System.out.println("Congratulations, JDBC connection is established successfully.\n");
		}
		//Remember to close the JDBC connection
		con.close();
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Label l1 = new Label("Enter Name");
		Label l2 = new Label("Enter Email");
		Label l3 = new Label("Enter Subject");
		Label l4 = new Label("Enter Gender");
		Label l5 = new Label("Enter Interests");
		
		TextField t1 = new TextField("");
		TextField t2 = new TextField("");
		ComboBox <String> c1 = new ComboBox<String>();
		c1.getItems().addAll("scd", "we", "sm", "bpe");
		ToggleGroup toto = new ToggleGroup();
		RadioButton r1 = new RadioButton("Male");
		RadioButton r2 = new RadioButton("Female");
		RadioButton r3 = new RadioButton("Other");
		r1.setToggleGroup(toto);
		r2.setToggleGroup(toto);
		r3.setToggleGroup(toto);
		
		CheckBox ch1 = new CheckBox("SE");
		CheckBox ch2 = new CheckBox("CS");
		CheckBox ch3 = new CheckBox("CYS");
		
		Button b = new Button("Click me!");
		b.setOnAction(new EventHandler<ActionEvent> (){

			public void handle(ActionEvent arg0) {
				String n="", e="", s="",g="",i="";
				Label lo1 = new Label("");
				Label lo2 = new Label("");
				Label lo3 = new Label("");
				Label lo4 = new Label("");
				Label lo5 = new Label("");
				if(t1.getText() != "" && t2.getText() != "") {
					n = t1.getText();
					e = t2.getText();
					lo1.setText(t1.getText());
					lo2.setText(t2.getText());
				}
				if(ch1.isSelected()) {
					i = ch1.getText();
					lo3.setText(ch1.getText());
				} else if(ch2.isSelected()) {
					i = ch2.getText();
					lo3.setText(ch2.getText());
				} else if(ch3.isSelected()) {
					i = ch3.getText();
					lo3.setText(ch3.getText());
				}
				
				if(r1.isSelected()) {
					g = r1.getText();
					lo4.setText(r1.getText());
				} else if(r2.isSelected()) {
					g = r2.getText();
					lo3.setText(r2.getText());
				} else if(r3.isSelected()) {
					g = r3.getText();
					lo3.setText(r3.getText());
				}
				
				if(c1.getValue()!= null) {
					s = c1.getValue();
					lo5.setText(c1.getValue());
				}
				
				insert(n,e,s,g,i);
				GridPane h1 = new GridPane();
//				h.getChildren().addAll(l1,l2,l3,l4,l5,t1,t2,r1,r2,r3,ch1,ch2,ch3, c1);
				h1.setHgap(20);
				h1.setVgap(20);
				h1.add(lo1,0, 0);
				h1.add(lo2, 1, 1);
				h1.add(lo3, 2, 2);
				h1.add(lo4, 3, 3);
				h1.add(lo5, 4, 4);
				
				Scene sc = new Scene(h1);
				Stage stage2 = new Stage();
				stage2.setScene(sc);
				stage2.setWidth(500);
				stage2.setHeight(600);
				stage2.setTitle("2sra App");
				stage2.show();
			}
			
		});
		GridPane h = new GridPane();
//		h.getChildren().addAll(l1,l2,l3,l4,l5,t1,t2,r1,r2,r3,ch1,ch2,ch3, c1);
		h.setHgap(20);
		h.setVgap(20);
		h.add(l1,0, 0);
		h.add(t1, 1, 0);
		h.add(l2, 0, 1);
		h.add(t2, 1, 1);
		h.add(l4, 0, 2);
		h.add(r1, 1, 2);
		h.add(r2, 1, 3);
		h.add(r3, 1, 4);
		h.add(l3, 0, 5);
		h.add(ch1, 1, 5);
		h.add(ch2, 1, 6);
		h.add(ch3, 1, 7);
		h.add(l5, 0, 8);
		h.add(c1, 1, 8);
		h.add(b, 0, 9);
		
		Scene sc = new Scene(h);
		stage.setScene(sc);
		stage.setWidth(500);
		stage.setHeight(600);
		stage.setTitle("Bunty's App");
		stage.show();
		}
		
	}
