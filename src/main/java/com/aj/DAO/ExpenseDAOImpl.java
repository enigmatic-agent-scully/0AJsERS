package com.aj.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aj.model.Expense;
import com.aj.model.User;
import com.aj.utils.DAOxUtil;

public class ExpenseDAOImpl implements ExpenseDAO {
	Connection connection = null;
	PreparedStatement stmt = null;
	List<Expense> expenses = new ArrayList<>();

	public boolean createNewExpense(Expense ex) {
		boolean success = false;
		try {
			connection = DAOxUtil.getConnection();
			System.out.println("In create expense DAO");
			//String sql = "INSERT INTO expenses VALUES (null, null, 1, null, null, 100.87, 'pending', 'desc')";
			
			String sql = "INSERT INTO expenses VALUES (null, ?, ?, null, null, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			System.out.println(ex);
			//stmt.setInt(1, ex.getExp_id());
			stmt.setInt(1, ex.getFk_e_id());
			stmt.setString(2, ex.getType());
			//stmt.setDate(3, ex.getSubmitted());
			//stmt.setDate(4, ex.getResolved());
			stmt.setString(3, ex.getAmount());
			stmt.setString(4, ex.getState());
			stmt.setString(5, ex.getDesc());
			
			if(stmt.executeUpdate() > 0) {
				System.out.println("Successfully submitted new expense.");
				success = true;
			}
			else {
				System.out.println("Did not insert record.");
				success = false;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("In create new expense");
		}
		return success;
	}

	public List<Expense> selectAllExpenses() {
		
		try {
			connection = DAOxUtil.getConnection();
			
			String sql = "SELECT * FROM expenses";
			
			stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Expense exp = new Expense();
				
				exp.setExp_id(rs.getInt(1));
				exp.setFk_e_id(rs.getInt(2));
				exp.setType(rs.getString(3));
				exp.setSubmitted(rs.getDate(4));
				exp.setResolved(rs.getDate(5));
				exp.setAmount(rs.getString(6));
				exp.setState(rs.getString(7));
				exp.setDesc(rs.getString(8));
				
				expenses.add(exp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expenses;
	}

	public List<Expense> selectPendingExpenses() {
		try {
			connection = DAOxUtil.getConnection();
			
			String sql = "SELECT * FROM expenses WHERE state = ?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, "pending");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Expense exp = new Expense();
				
				exp.setExp_id(rs.getInt(1));
				exp.setFk_e_id(rs.getInt(2));
				exp.setType(rs.getString(3));
				exp.setSubmitted(rs.getDate(4));
				exp.setResolved(rs.getDate(5));
				exp.setAmount(rs.getString(6));
				exp.setState(rs.getString(7));
				exp.setDesc(rs.getString(8));
				
				expenses.add(exp);
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return expenses;
	}

	public String updateExpense(Expense ex) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteExpense(Expense ex) {
		// TODO Auto-generated method stub
		return null;
	}

}
