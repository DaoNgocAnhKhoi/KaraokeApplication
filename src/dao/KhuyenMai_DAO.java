package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.KhuyenMai;


public class KhuyenMai_DAO {
	public KhuyenMai_DAO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<KhuyenMai> getAlltbKhuyenMai() {
		ArrayList<KhuyenMai> dskm = new ArrayList<KhuyenMai>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhuyenMai";
			Statement statement = con.createStatement();
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maKM = rs.getString(1);
				String tenKM = rs.getString(2);
				String dkApDung = rs.getString(3);
				Float giaTriKM = rs.getFloat(4);
				Date ngayBatDau = rs.getDate(5);
				Date ngayKetThuc = rs.getDate(6);
				
				KhuyenMai km = new KhuyenMai(maKM, tenKM, dkApDung, giaTriKM, ngayBatDau, ngayKetThuc);

				dskm.add(km);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dskm;
	}

	public KhuyenMai getKhuyenMaiMoiNhat() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		KhuyenMai km = null;

		try {
			Statement statement = con.createStatement();
			String sql = "Select top 1 * from phong ORDER BY MaP DESC ";
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maKM = rs.getString(1);
				String tenKM = rs.getString(2);
				String dkApDung = rs.getString(3);
				Float giaTriKM = rs.getFloat(4);
				Date ngayBatDau = rs.getDate(5);
				Date ngayKetThuc = rs.getDate(6);
				
				km = new KhuyenMai(maKM, tenKM, dkApDung, giaTriKM, ngayBatDau, ngayKetThuc);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return km;
	}

	public KhuyenMai getKhuyenMaiTheoMa(String maKhuyenMai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		KhuyenMai km = null;
		PreparedStatement statement = null;

		try {
			String sql = "Select * from khuyenmai where maKM=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKhuyenMai);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maKM = rs.getString(1);
				String tenKM = rs.getString(2);
				String dkApDung = rs.getString(3);
				Float giaTriKM = rs.getFloat(4);
				Date ngayBatDau = rs.getDate(5);
				Date ngayKetThuc = rs.getDate(6);
				
				km = new KhuyenMai(maKM, tenKM, dkApDung, giaTriKM, ngayBatDau, ngayKetThuc);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return km;
	}

	public KhuyenMai getKhuyenMaiTheoTen(String tenKhuyenMai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		KhuyenMai km = null;
		PreparedStatement statement = null;

		try {
			String sql = "Select * from KhuyenMai where tenKM=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenKhuyenMai);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maKM = rs.getString(1);
				String tenKM = rs.getString(2);
				String dkApDung = rs.getString(3);
				Float giaTriKM = rs.getFloat(4);
				Date ngayBatDau = rs.getDate(5);
				Date ngayKetThuc = rs.getDate(6);
				
				km = new KhuyenMai(maKM, tenKM, dkApDung, giaTriKM, ngayBatDau, ngayKetThuc);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return km;
	}

	public boolean create(KhuyenMai km) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			// stored procedures tự động phát sinh
			CallableStatement myCall = con.prepareCall("{call PhatSinhIDKM(?)}");
			myCall.registerOutParameter(1, Types.VARCHAR);
			myCall.execute();
			String maP = myCall.getString(1);

			stmt = con.prepareStatement("insert into " + "KhuyenMai values(?,?,?,?,?,?)");
			stmt.setString(1, maP);
			stmt.setString(2, km.getTenKM());
			stmt.setString(3, km.getDieuKienApDung());
			stmt.setDouble(4, km.getGiaTriKhuyenMai());
			stmt.setDate(5, new java.sql.Date(km.getNgayBatDau().getTime()));
			stmt.setDate(6, new java.sql.Date(km.getNgayKetThuc().getTime()));
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

	public boolean delete(String maKM) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		try {
			String deleteQuery = "DELETE FROM KhuyenMai WHERE maKM = ?";
			PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
			deleteStatement.setString(1, maKM);
			n = deleteStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean update(KhuyenMai km) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update KhuyenMai set TenKm=?," + "DieuKienApDung=?,GiaTriKM=?,NgayBatDau=?,NgayKetThuc=?" + "where MaKM=?");

			stmt.setString(1, km.getMaKM());
			stmt.setString(2, km.getTenKM());
			stmt.setString(3, km.getDieuKienApDung());
			stmt.setDouble(4, km.getGiaTriKhuyenMai());
			stmt.setDate(5, new java.sql.Date(km.getNgayBatDau().getTime()));
			stmt.setDate(6, new java.sql.Date(km.getNgayKetThuc().getTime()));
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

	public ArrayList<KhuyenMai> timKiemKH(String ma, String ten, String dieuKienApDung, float GiaTriKm, Date ngayBatDau, Date ngayKetThuc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ArrayList<KhuyenMai> ds = new ArrayList<KhuyenMai>();
		String sql = "SELECT *" + "FROM KHUYENMAI " + "WHERE (? IS NULL OR MaKM like '%'+?+'%') "
				+ "And (? IS NULL OR TenKM like '%'+?+'%') "+ "AND(? is null or DieuKienApDung like '%'+?+'%')"
				+ "AND(? is null or GiaTriKM = ?) " 
				+ "AND(? is null or NgayBatDau = ?) " + "AND(? is null or NgayKetThuc = ?) ";
		try {
			statement = con.prepareStatement(sql);
			if (ma == null) {
				statement.setNull(1, Types.NVARCHAR);
				statement.setNull(2, Types.NVARCHAR);
			} else {
				statement.setString(1, "%" + ma + "%");
				statement.setString(2, "%" + ma + "%");
			}
			if (ten == null) {
				statement.setNull(3, Types.NVARCHAR);
				statement.setNull(4, Types.NVARCHAR);
			} else {
				statement.setString(3, "%" + ten + "%");
				statement.setString(4, "%" + ten + "%");
			}
			if (dieuKienApDung == null) {
				statement.setNull(5, Types.NVARCHAR);
				statement.setNull(6, Types.NVARCHAR);
			} else {
				statement.setString(5, "%" + dieuKienApDung + "%");
				statement.setString(6, "%" + dieuKienApDung + "%");
			}
			if (GiaTriKm == 0) {
				statement.setNull(7, Types.FLOAT);
				statement.setNull(8, Types.FLOAT);
			} else {
				statement.setString(7, "%" + GiaTriKm + "%");
				statement.setString(8, "%" + GiaTriKm + "%");
			}
			if (ngayBatDau == null) {
				statement.setNull(9, Types.DATE);
				statement.setNull(10, Types.DATE);
			} else {
				statement.setDate(9, new java.sql.Date(ngayBatDau.getTime()));
				statement.setDate(10, new java.sql.Date(ngayBatDau.getTime()));
			}
			if (ngayKetThuc == null) {
				statement.setNull(11, Types.DATE);
				statement.setNull(12, Types.DATE);
			} else {
				statement.setDate(11, new java.sql.Date(ngayKetThuc.getTime()));
				statement.setDate(12, new java.sql.Date(ngayKetThuc.getTime()));
			}
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maKM = rs.getString(1);
				String tenKM = rs.getString(2);
				String dkApDung = rs.getString(3);
				Float giaTriKM = rs.getFloat(4);
				Date ngayBatDauu = rs.getDate(5);
				Date ngayKetThucc = rs.getDate(6);
				
				KhuyenMai km = new KhuyenMai(maKM, tenKM, dkApDung, giaTriKM, ngayBatDauu, ngayKetThucc);
				ds.add(km);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return ds;
	}

}
