package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Time;
import java.sql.Types;
import java.time.LocalTime;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Phong;

public class ChiTietHoaDon_DAO {
	public ChiTietHoaDon_DAO() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon getCTHDTheoTenPhong(String tenPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ChiTietHoaDon cthd = null;
		PreparedStatement statement = null;

		try {
			String sql = "Select * from chitiethoadon where tenP=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenPhong);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				HoaDon hd = new HoaDon(rs.getString(1));
				Phong phong = new Phong(rs.getString(2));
				String ten = rs.getString(3);
				LocalTime thoiGianSD = rs.getTime(4).toLocalTime();
				double donGia = rs.getDouble(5);
				String donVi = rs.getString(6);
				cthd = new ChiTietHoaDon(hd, phong, tenPhong, donGia, donVi, thoiGianSD);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cthd;
	}

	public boolean create(ChiTietHoaDon cthd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into " + "chitiethoadon values(?,?,?,?,?,?)");
			stmt.setString(1, cthd.getHd().getMaHoaDon());
			if (cthd.getP().getMaPhong() != null)
				stmt.setString(2, cthd.getP().getMaPhong());
			else
				stmt.setNull(2, Types.VARCHAR);
			if (cthd.getTenPhong() != null)
				stmt.setString(3, cthd.getTenPhong());
			else
				stmt.setNull(3, Types.VARCHAR);
			if (cthd.getThoiGianSuDung() != null)
				stmt.setTime(4, java.sql.Time.valueOf(cthd.getThoiGianSuDung()));
			else
				stmt.setNull(4, Types.TIME);
			if (cthd.getDonGia() != 0)
				stmt.setDouble(5, cthd.getDonGia());
			else
				stmt.setNull(5, Types.FLOAT);
			if (cthd.getDonVi() != null)
				stmt.setString(6, cthd.getDonVi());
			else
				stmt.setNull(6, Types.VARCHAR);
			n += stmt.executeUpdate();
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

	public boolean update(ChiTietHoaDon cthd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update chiTietHoaDon set maP=?,tenP=?,ThoiGianSuDungPhong=?,DonGia=?,DonVi=? " + "where maHD=?");
			stmt.setString(1, cthd.getP().getMaPhong());
			stmt.setString(2, cthd.getTenPhong());
			stmt.setTime(3, Time.valueOf(cthd.getThoiGianSuDung()));
			stmt.setDouble(4, cthd.getDonGia());
			stmt.setString(5, cthd.getDonVi());
			stmt.setString(6, cthd.getHd().getMaHoaDon());

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

	public ChiTietHoaDon check(String maHD, String maP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ChiTietHoaDon cthd = null;
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM chitiethoadon WHERE maHD = ? AND maP = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			statement.setString(2, maP);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String ma = rs.getString(1);
				Phong maPhong = new Phong(rs.getString(2));
				String tenPhong = rs.getString(3);
				LocalTime thoiGianSD = rs.getTime(4).toLocalTime();
				double dongia = rs.getDouble(5);
				String donvi = rs.getString(6);

				cthd = new ChiTietHoaDon(null, maPhong, tenPhong, dongia, donvi, thoiGianSD);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cthd;
	}

	public ArrayList<ChiTietHoaDon> getCTHDTheoMaHD(String maHD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
		PreparedStatement statement = null;

		try {
			String sql = "Select * from chitiethoadon where mahd=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				HoaDon hd = new HoaDon(rs.getString(1));
				Phong phong = new Phong(rs.getString(2));
				String tenPhong = rs.getString(3);
				LocalTime thoiGianSD = rs.getTime(4).toLocalTime();
				double donGia = rs.getDouble(5);
				String donVi = rs.getString(6);

				ChiTietHoaDon cthd = new ChiTietHoaDon(hd, phong, tenPhong, donGia, donVi, thoiGianSD);
				dscthd.add(cthd);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dscthd;
	}
}
