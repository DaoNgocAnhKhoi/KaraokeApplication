package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.LoaiDichVu;

public class LoaiDichVu_DAO {
	public LoaiDichVu_DAO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<LoaiDichVu> getAlltbLoaiDichVu() {
		ArrayList<LoaiDichVu> dsldv = new ArrayList<LoaiDichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from LoaiDichVu";
			Statement statement = con.createStatement();
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maLoaiDichVu = rs.getString(1);
				String tenLoaiDichVu = rs.getString(2);
				
				LoaiDichVu ldv = new LoaiDichVu(maLoaiDichVu, tenLoaiDichVu);
				dsldv.add(ldv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsldv;
	}
	
	public LoaiDichVu getLoaiDichVuMoiNhat() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		LoaiDichVu ldv = null;

		try {
			Statement statement = con.createStatement();
			String sql = "Select top 1 * from loaidichvu ORDER BY MaLDV DESC ";
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maLoaiDichVu = rs.getString(1);
				String tenLoaiDichVu = rs.getString(2);
				ldv = new LoaiDichVu(maLoaiDichVu, tenLoaiDichVu);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ldv;
	}
	
	public LoaiDichVu getLoaiDichVuTheoMa(String maLoaiDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		LoaiDichVu ldv = null;
		PreparedStatement statement = null;

		try {
			String sql = "Select * from loaidichvu where maLDV=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, maLoaiDichVu);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maLDV = rs.getString(1);
				String tenLDV = rs.getString(2);
				ldv = new LoaiDichVu(maLDV, tenLDV);
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ldv;
	}

	public LoaiDichVu getLoaiDichVuTheoTen(String tenLoaiDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		LoaiDichVu ldv = null;
		PreparedStatement statement = null;

		try {
			String sql = "Select * from loaidichvu where tenLoaiDV=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenLoaiDichVu);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maLDV = rs.getString(1);
				String tenLDV = rs.getString(2);
				ldv = new LoaiDichVu(maLDV, tenLDV);
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ldv;
	}
	
	public boolean create(LoaiDichVu ldv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			// stored procedures tự động phát sinh
			CallableStatement myCall = con.prepareCall("{call phatSinhIDLDV(?)}");
			myCall.registerOutParameter(1, Types.VARCHAR);
			myCall.execute();
			String maLoaiDichVu = myCall.getString(1);

			stmt = con.prepareStatement("insert into " + "LoaiDichVu values(?,?)");
			stmt.setString(1, maLoaiDichVu);
			stmt.setString(2, ldv.getTenLoaiDichVu());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean delete(String maLoaiDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		try {
			String deleteLoaiDichVuQuery = "DELETE FROM dichvu WHERE MaLDV = ?";
			PreparedStatement updateStatement = con.prepareStatement(deleteLoaiDichVuQuery);
			updateStatement.setString(1, maLoaiDichVu);
			n = updateStatement.executeUpdate();
			String deleteQuery = "DELETE FROM LoaiDichVu WHERE MaLDV = ?";
			PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
			deleteStatement.setString(1, maLoaiDichVu);
			n += deleteStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean update(LoaiDichVu ldv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update loaidichvu set TenLoaiDV=? where MaLDV=?");

			stmt.setString(1, ldv.getTenLoaiDichVu());
			stmt.setString(2, ldv.getMaLoaiDichVu());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
