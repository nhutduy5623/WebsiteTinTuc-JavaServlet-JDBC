package com.laptrinhwebJEE.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhwebJEE.dao.GenericDAO;
import com.laptrinhwebJEE.mapper.IRowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/newservletjee";
			String userName = "root";
			String passWord = "1234";
			return DriverManager.getConnection(url, userName, passWord);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, IRowMapper<T> rowMapper, Object... Parameters) {
		List<T> results = new ArrayList<>();
		Connection Con = getConnection();
		if (Con != null) {
			PreparedStatement pS = null;
			ResultSet rS = null;
			try {
				pS = Con.prepareStatement(sql);
				setParameters(pS, Parameters);
				rS = pS.executeQuery();
				while (rS.next()) { 
					results.add(rowMapper.mapperRow(rS));
				}

				return results;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					Con.close();
					if(pS != null) 
						pS.close();
					if(rS != null )
						rS.close();
				} catch (SQLException e) {
					System.out.println("fail!: Con.close();\r\n" + "					pS.close();\r\n"
							+ "					rS.close(); ");
					return null;

				}

			}
		}

		return null;
	}

	public void setParameters(PreparedStatement pS, Object... parameters) {
		for (int i = 0; i < parameters.length; i++) {
			try {
				if (parameters[i] instanceof Long) {
					pS.setLong(i + 1, (Long) parameters[i]);
				} else if (parameters[i] instanceof String) {
					pS.setString(i + 1, (String) parameters[i]);
				} else if (parameters[i] instanceof Integer) {
					pS.setInt(i + 1, (int) parameters[i]);
				} else if (parameters[i] instanceof Timestamp) {
					pS.setTimestamp(i + 1, (Timestamp) parameters[i]);
				} 

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public <T> Long save(String sql, Object... parameters) {
		Connection con = getConnection();
		if (con != null) {
			PreparedStatement pS = null;
			ResultSet rS = null;
			try {
				con.setAutoCommit(false);
				pS = con.prepareStatement(sql, pS.RETURN_GENERATED_KEYS);
				setParameters(pS, parameters);
				
				pS.executeUpdate();
				rS = pS.getGeneratedKeys();
				Long id = null;
				if (rS.next()) id = rS.getLong(1);
				con.commit();
				return id;
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					con.close();					
					if (pS != null) 
						pS.close();
					if (rS != null) 
						rS.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			
			}
			
		}
		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection con = getConnection();
		if (con != null) {
			PreparedStatement pS = null;
			try {
				con.setAutoCommit(false);
				pS = con.prepareStatement(sql);
				setParameters(pS, parameters);
				pS.executeUpdate();
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					con.close();					
					if (pS != null) 
						pS.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			
			}
			
		}
	}

	@Override
	public void delete(String sql, Object... parameters) {
		Connection con = getConnection();
		if (con != null) {
			PreparedStatement pS = null;
			try {
				con.setAutoCommit(false);
				pS = con.prepareStatement(sql);
				setParameters(pS, parameters);
				pS.executeUpdate();
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					con.close();					
					if (pS != null) 
						pS.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			
			}
			
		}
	}

	@Override
	public int count(String sql, Object... parameters) {
		int count=0;
		Connection Con = getConnection();
		if (Con != null) {
			PreparedStatement pS = null;
			ResultSet rS = null;
			try {
				pS = Con.prepareStatement(sql);
				setParameters(pS, parameters);
				rS = pS.executeQuery();
				while(rS.next()) {
					count = rS.getInt(1);					
				}
				return count;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					Con.close();
					pS.close();
					rS.close();
				} catch (SQLException e) {
					System.out.println("fail!: Con.close();\r\n" + "					pS.close();\r\n"
							+ "					rS.close(); ");
					return 0;

				}

			}
		}

		return 0;
	}
	
	
}
