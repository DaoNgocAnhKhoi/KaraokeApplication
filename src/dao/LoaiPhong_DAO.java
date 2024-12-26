package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import connectDB.ConnectDB;
import entity.LoaiPhong;

public class LoaiPhong_DAO {
	public LoaiPhong_DAO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<LoaiPhong> getAlltbLoaiPhong() {
		ArrayList<LoaiPhong> dslp = new ArrayList<LoaiPhong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from loaiphong";
			Statement statement = con.createStatement();
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maLP = rs.getString(1);
				String tenLP = rs.getString(2);
				int soLuongNguoi = rs.getInt(3);
				double gia = rs.getDouble(4);
				String moTa = rs.getString(5);
				String hinhAnh = rs.getString(6);

				LoaiPhong lp = new LoaiPhong(maLP, tenLP, soLuongNguoi, gia, moTa, hinhAnh);
				dslp.add(lp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dslp;
	}

	public LoaiPhong getLoaiPhongMoiNhat() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		LoaiPhong lp = null;

		try {
			Statement statement = con.createStatement();
			String sql = "Select top 1 * from loaiphong ORDER BY MaLP DESC ";
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maLP = rs.getString(1);
				String tenLP = rs.getString(2);
				int soLuongNguoi = rs.getInt(3);
				double gia = rs.getDouble(4);
				String moTa = rs.getString(5);
				String hinhAnh = rs.getString(6);
				lp = new LoaiPhong(maLP, tenLP, soLuongNguoi, gia, moTa, hinhAnh);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lp;
	}

	public LoaiPhong getLoaiPhongTheoMa(String maLoaiPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		LoaiPhong lp = null;
		PreparedStatement statement = null;

		try {
			String sql = "Select * from loaiphong where maLP=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, maLoaiPhong);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maLP = rs.getString(1);
				String tenLP = rs.getString(2);
				int soLuongNguoi = rs.getInt(3);
				double gia = rs.getDouble(4);
				String moTa = rs.getString(5);
				String hinhAnh = rs.getString(6);
				lp = new LoaiPhong(maLP, tenLP, soLuongNguoi, gia, moTa, hinhAnh);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lp;
	}

	public LoaiPhong getLoaiPhongTheoTen(String tenLoaiPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		LoaiPhong lp = null;
		PreparedStatement statement = null;

		try {
			String sql = "Select * from loaiphong where tenLoaiPhong=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenLoaiPhong);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maLP = rs.getString(1);
				String tenLP = rs.getString(2);
				int soLuongNguoi = rs.getInt(3);
				double gia = rs.getDouble(4);
				String moTa = rs.getString(5);
				String hinhAnh = rs.getString(6);
				lp = new LoaiPhong(maLP, tenLP, soLuongNguoi, gia, moTa, hinhAnh);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lp;
	}

	public boolean create(LoaiPhong lp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			// stored procedures tự động phát sinh
			CallableStatement myCall = con.prepareCall("{call PhatSinhIDLP(?)}");
			myCall.registerOutParameter(1, Types.VARCHAR);
			myCall.execute();
			String maLP = myCall.getString(1);

			stmt = con.prepareStatement("insert into " + "loaiPhong values(?,?,?,?,?,?)");
			stmt.setString(1, maLP);
			stmt.setString(2, lp.getTenLP());
			stmt.setInt(3, lp.getSoLuongNguoi());
			stmt.setDouble(4, lp.getGia());
			stmt.setString(5, lp.getMoTa());
			stmt.setString(6, lp.getHinhAnh());

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

	public boolean delete(String maLP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		try {
			String deletePhongQuery = "DELETE FROM phong WHERE MaLP = ?";
			PreparedStatement updateStatement = con.prepareStatement(deletePhongQuery);
			updateStatement.setString(1, maLP);
			n = updateStatement.executeUpdate();
			String deleteQuery = "DELETE FROM loaiphong WHERE MaLP = ?";
			PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
			deleteStatement.setString(1, maLP);
			n += deleteStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean update(LoaiPhong lp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update LoaiPhong set TenLoaiPhong=?,"
					+ "SoLuongNguoiChuaDuoc=?,Gia=?,moTa=?,hinhanh=? " + "where maLP=?");

			stmt.setString(1, lp.getTenLP());
			stmt.setInt(2, lp.getSoLuongNguoi());
			stmt.setDouble(3, lp.getGia());
			stmt.setString(4, lp.getMoTa());
			stmt.setString(5, lp.getHinhAnh());
			stmt.setString(6, lp.getMaLP());
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

	// Khôi thêm
	public Map<String, String> getAllLoaiPhong() {
		Map<String, String> list = new HashMap<String, String>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;

		try {
			String sql = "select MaLP, TenLoaiPhong\r\n" + "from LoaiPhong\r\n" + "group by MaLP, TenLoaiPhong";
			statement = con.prepareStatement(sql);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				list.put(rs.getString("MaLP"), rs.getString("TenLoaiPhong"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
