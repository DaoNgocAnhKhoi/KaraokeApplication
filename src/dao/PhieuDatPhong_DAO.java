package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;

public class PhieuDatPhong_DAO {
	public PhieuDatPhong_DAO() {
		// TODO Auto-generated constructor stub
	}

	public PhieuDatPhong getPhieuDatPhongMoiNhat() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PhieuDatPhong pdp = null;

		try {
			Statement statement = con.createStatement();
			String sql = "Select top 1 * from phieudatphong ORDER BY MaPDP DESC ";
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maPDP = rs.getString(1);
				NhanVien nv = new NhanVien(rs.getString(2));
				KhachHang kh = new KhachHang(rs.getString(3));
				LocalDateTime ngayLapHoaDon = rs.getTimestamp(4).toLocalDateTime();
				Date NgayNhanPhong = rs.getDate(5);
				LocalTime gioNhanPhong = rs.getTime(6).toLocalTime();
				LocalTime gioTraPhong = rs.getTime(7).toLocalTime();
				String tinhTrang = rs.getString(8);

				pdp = new PhieuDatPhong(maPDP, nv, kh, ngayLapHoaDon, NgayNhanPhong, gioNhanPhong, gioTraPhong,
						tinhTrang);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pdp;
	}

	public PhieuDatPhong getPhieuDatPhongTheoMaPhong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		PhieuDatPhong pdp = null;

		try {
			String sql = "SELECT * FROM PhieuDatPhong WHERE MaPDP IN (SELECT MaPDP FROM ChiTietPhieuDatPhong WHERE MaP = ?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maPDP = rs.getString(1);
				NhanVien nv = new NhanVien(rs.getString(2));
				KhachHang kh = new KhachHang(rs.getString(3));
				LocalDateTime ngayLapHoaDon = rs.getTimestamp(4).toLocalDateTime();
				Date NgayNhanPhong = rs.getDate(5);
				LocalTime gioNhanPhong = rs.getTime(6).toLocalTime();
				LocalTime gioTraPhong = rs.getTime(7).toLocalTime();
				String tinhTrang = rs.getString(8);

				pdp = new PhieuDatPhong(maPDP, nv, kh, ngayLapHoaDon, NgayNhanPhong, gioNhanPhong, gioTraPhong,
						tinhTrang);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pdp;
	}

	public ArrayList<PhieuDatPhong> getDSPhieuDatPhongTheoMaPhong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ArrayList<PhieuDatPhong> dspdp = new ArrayList<>();

		try {
			String sql = "SELECT * FROM PhieuDatPhong WHERE MaPDP IN (SELECT MaPDP FROM ChiTietPhieuDatPhong WHERE MaP = ?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maPDP = rs.getString(1);
				NhanVien nv = new NhanVien(rs.getString(2));
				KhachHang kh = new KhachHang(rs.getString(3));
				LocalDateTime ngayLapHoaDon = rs.getTimestamp(4).toLocalDateTime();
				Date NgayNhanPhong = rs.getDate(5);
				LocalTime gioNhanPhong = rs.getTime(6).toLocalTime();
				LocalTime gioTraPhong = rs.getTime(7).toLocalTime();
				String tinhTrang = rs.getString(8);

				PhieuDatPhong pdp = new PhieuDatPhong(maPDP, nv, kh, ngayLapHoaDon, NgayNhanPhong, gioNhanPhong,
						gioTraPhong, tinhTrang);
				dspdp.add(pdp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dspdp;
	}

	public PhieuDatPhong getPhieuDatPhongTheoMaPhongVaTinhTrang(String maPhong, String tinhTrang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		PhieuDatPhong pdp = null;

		try {
			String sql = "SELECT * FROM PhieuDatPhong WHERE MaPDP IN (SELECT MaPDP FROM ChiTietPhieuDatPhong WHERE MaP = ?) AND TinhTrang=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			statement.setString(2, tinhTrang);
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maPDP = rs.getString(1);
				NhanVien nv = new NhanVien(rs.getString(2));
				KhachHang kh = new KhachHang(rs.getString(3));
				LocalDateTime ngayLapHoaDon = rs.getTimestamp(4).toLocalDateTime();
				Date NgayNhanPhong = rs.getDate(5);
				LocalTime gioNhanPhong = rs.getTime(6).toLocalTime();
				LocalTime gioTraPhong = rs.getTime(7).toLocalTime();
				String tinhTrangPhieu = rs.getString(8);

				pdp = new PhieuDatPhong(maPDP, nv, kh, ngayLapHoaDon, NgayNhanPhong, gioNhanPhong, gioTraPhong,
						tinhTrangPhieu);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pdp;
	}

	public boolean create(PhieuDatPhong pdp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			// stored procedures tự động phát sinh
			CallableStatement myCall = con.prepareCall("{call phatSinhIDPDP(?)}");
			myCall.registerOutParameter(1, Types.VARCHAR);
			myCall.execute();
			String maPDP = myCall.getString(1);

			stmt = con.prepareStatement("insert into " + "PhieuDatPhong values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, maPDP);
			stmt.setString(2, pdp.getNv().getMaNV());
			stmt.setString(3, pdp.getKh().getMaKH());
			stmt.setTimestamp(4, Timestamp.valueOf(pdp.getNgayLapPhieu()));
			stmt.setDate(5, new java.sql.Date(pdp.getNgayNhanPhong().getTime()));
			stmt.setTime(6, java.sql.Time.valueOf(pdp.getGioNhanPhong()));
			stmt.setTime(7, java.sql.Time.valueOf(pdp.getGioTraPhong()));
			stmt.setString(8, pdp.getTinhTrang());

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

	public boolean deleteTheoMaPDP(String maPDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		try {
			String deleteQuery = "DELETE FROM PhieuDatPhong WHERE MaPDP = ?";
			PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
			deleteStatement.setString(1, maPDP);
			n = deleteStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean deleteTheoMaPhieuDatPhong(String maPDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		try {
			String deleteQuery = "DELETE FROM ChiTietPhieuDatPhong WHERE MaPDP = ?";
			PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
			deleteStatement.setString(1, maPDP);
			String deleteQuery1 = "DELETE FROM PhieuDatPhong WHERE MaPDP = ?";
			PreparedStatement deleteStatement1 = con.prepareStatement(deleteQuery1);
			deleteStatement1.setString(1, maPDP);
			n = deleteStatement.executeUpdate();
			n+= deleteStatement1.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean update(String maPDP, Date ngayNhan, LocalTime gioNhan, LocalTime gioTra) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update phieuDatPhong set ngayNhanPhong=?,"
					+ "gioNhanPhong=?,giotraphongdukien=? " + "where maPDP=?");

			stmt.setDate(1, new java.sql.Date(ngayNhan.getTime()));
			stmt.setTime(2, java.sql.Time.valueOf(gioNhan));
			stmt.setTime(3, java.sql.Time.valueOf(gioTra));
			stmt.setString(4, maPDP);
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

	public boolean update(String maPDP, LocalTime gioNhan) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update phieuDatPhong set " + "gioNhanPhong=? " + "where maPDP=?");

			stmt.setTime(1, java.sql.Time.valueOf(gioNhan));
			stmt.setString(2, maPDP);
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

	// Đạt
	public ArrayList<PhieuDatPhong> getAlltbPhieuDatPhong() {
		ArrayList<PhieuDatPhong> dspdp = new ArrayList<PhieuDatPhong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from phieudatphong ORDER BY MaPDP DESC";
			Statement statement = con.createStatement();
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maPDP = rs.getString(1);
				NhanVien nv = new NhanVien(rs.getString(2));
				KhachHang kh = new KhachHang(rs.getString(3));
				LocalDateTime ngayLapHoaDon = rs.getTimestamp(4).toLocalDateTime();
				Date NgayNhanPhong = rs.getDate(5);
				LocalTime gioNhanPhong = rs.getTime(6).toLocalTime();
				LocalTime gioTraPhong = rs.getTime(7).toLocalTime();
				String tinhtrang = rs.getString(8);
				PhieuDatPhong pdp = new PhieuDatPhong(maPDP, nv, kh, ngayLapHoaDon, NgayNhanPhong, gioNhanPhong,
						gioTraPhong, tinhtrang);
				dspdp.add(pdp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dspdp;

	}

//		Đạt
	public boolean deleteSauKhiThanhToan(String maPDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;

		try {
			// Delete records from ChiTietSuDungDichVu
			String deleteChiTietDichVuQuery = "DELETE FROM ChiTietSuDungDichVu WHERE MaPDP = ?";
			PreparedStatement deleteChiTietDichVuStatement = con.prepareStatement(deleteChiTietDichVuQuery);
			deleteChiTietDichVuStatement.setString(1, maPDP);
			n += deleteChiTietDichVuStatement.executeUpdate();

			// Delete records from ChiTietPhieuDatPhong
			String deleteChiTietPhieuDatPhongQuery = "DELETE FROM ChiTietPhieuDatPhong WHERE MaPDP = ?";
			PreparedStatement deleteChiTietPhieuDatPhongStatement = con
					.prepareStatement(deleteChiTietPhieuDatPhongQuery);
			deleteChiTietPhieuDatPhongStatement.setString(1, maPDP);
			n += deleteChiTietPhieuDatPhongStatement.executeUpdate();

			// Delete record from PhieuDatPhong
			String deletePhieuDatPhongQuery = "DELETE FROM PhieuDatPhong WHERE MaPDP = ?";
			PreparedStatement deletePhieuDatPhongStatement = con.prepareStatement(deletePhieuDatPhongQuery);
			deletePhieuDatPhongStatement.setString(1, maPDP);
			n += deletePhieuDatPhongStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

//		Đạt
	public ArrayList<PhieuDatPhong> getDSPhieuDatPhongTheoKhachHang(String tenKhachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ArrayList<PhieuDatPhong> dspdp = new ArrayList<>();

		try {
			String sql = "SELECT * FROM PhieuDatPhong WHERE MaKH=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenKhachHang);
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maPDP = rs.getString(1);
				NhanVien nv = new NhanVien(rs.getString(2));
				KhachHang kh = new KhachHang(rs.getString(3));
				LocalDateTime ngayLapHoaDon = rs.getTimestamp(4).toLocalDateTime();
				Date NgayNhanPhong = rs.getDate(5);
				LocalTime gioNhanPhong = rs.getTime(6).toLocalTime();
				LocalTime gioTraPhong = rs.getTime(7).toLocalTime();
				String tinhTrang = rs.getString(8);

				PhieuDatPhong pdp = new PhieuDatPhong(maPDP, nv, kh, ngayLapHoaDon, NgayNhanPhong, gioNhanPhong,
						gioTraPhong, tinhTrang);
				dspdp.add(pdp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dspdp;
	}
}
