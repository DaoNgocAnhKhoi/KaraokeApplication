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
import entity.LoaiPhong;
import entity.Phong;

public class Phong_DAO {
	public Phong_DAO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Phong> getAlltbPhong() {
		ArrayList<Phong> dsp = new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from phong";
			Statement statement = con.createStatement();
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maP = rs.getString(1);
				String tenP = rs.getString(2);
				String tinhTrang = rs.getString(3);
				LoaiPhong lp = new LoaiPhong(rs.getString(4));

				Phong p = new Phong(maP, tenP, lp, tinhTrang);
				dsp.add(p);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsp;
	}

	public Phong getPhongMoiNhat() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Phong p = null;

		try {
			Statement statement = con.createStatement();
			String sql = "Select top 1 * from phong ORDER BY MaP DESC ";
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maP = rs.getString(1);
				String tenP = rs.getString(2);
				String tinhTrang = rs.getString(3);
				LoaiPhong lp = new LoaiPhong(rs.getString(4));

				p = new Phong(maP, tenP, lp, tinhTrang);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}

	public Phong getPhongTheoMa(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Phong p = null;
		PreparedStatement statement = null;

		try {
			String sql = "Select * from phong where maP=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maP = rs.getString(1);
				String tenP = rs.getString(2);
				String tinhTrang = rs.getString(3);
				LoaiPhong lp = new LoaiPhong(rs.getString(4));

				p = new Phong(maP, tenP, lp, tinhTrang);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}

	public Phong getPhongTheoTen(String tenPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		Phong p = null;
		PreparedStatement statement = null;

		try {
			String sql = "Select * from phong where tenPhong=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenPhong);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maP = rs.getString(1);
				String tenP = rs.getString(2);
				String tinhTrang = rs.getString(3);
				LoaiPhong lp = new LoaiPhong(rs.getString(4));

				p = new Phong(maP, tenP, lp, tinhTrang);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}

	public boolean create(Phong p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			// stored procedures tự động phát sinh
			CallableStatement myCall = con.prepareCall("{call PhatSinhIDP(?)}");
			myCall.registerOutParameter(1, Types.VARCHAR);
			myCall.execute();
			String maP = myCall.getString(1);

			stmt = con.prepareStatement("insert into " + "Phong values(?,?,?,?)");
			stmt.setString(1, maP);
			stmt.setString(2, p.getTenPhong());
			stmt.setString(3, p.getTinhTrang());
			stmt.setString(4, p.getLp().getMaLP());

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

	public boolean delete(String maP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		try {
			String deleteQuery = "DELETE FROM Phong WHERE MaP = ?";
			PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
			deleteStatement.setString(1, maP);
			n = deleteStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean update(Phong p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update phong set tenPhong=?," + "TrangThai=?,MaLP=? " + "where maP=?");

			stmt.setString(1, p.getTenPhong());
			stmt.setString(2, p.getTinhTrang());
			stmt.setString(3, p.getLp().getMaLP());
			stmt.setString(4, p.getMaPhong());
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

	public ArrayList<Phong> timKiemPhongOGiaoDienDP(String ten, String tinhTrang, String loaiPhong, int soNguoi) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ArrayList<Phong> ds = new ArrayList<Phong>();
		String sql = "SELECT * FROM Phong " + "WHERE (? IS NULL OR TenPhong LIKE '%' + ? + '%') "
				+ "AND (? IS NULL OR TrangThai LIKE '%' + ? + '%') "
				+ "AND (MaLP IN (SELECT MaLP FROM LoaiPhong WHERE (? IS NULL OR TenLoaiPhong LIKE '%' + ? + '%'))) "
				+ "AND (MaLP IN (SELECT MaLP FROM LoaiPhong WHERE (? IS NULL OR SoLuongNguoiChuaDuoc = ?)))";
		try {
			statement = con.prepareStatement(sql);
			if (ten == null) {
				statement.setNull(1, Types.NVARCHAR);
				statement.setNull(2, Types.NVARCHAR);
			} else {
				statement.setString(1, "%" + ten + "%");
				statement.setString(2, "%" + ten + "%");
			}
			if (tinhTrang == null) {
				statement.setNull(3, Types.NVARCHAR);
				statement.setNull(4, Types.NVARCHAR);
			} else {
				statement.setString(3, "%" + tinhTrang + "%");
				statement.setString(4, "%" + tinhTrang + "%");
			}
			if (loaiPhong == null) {
				statement.setNull(5, Types.NVARCHAR);
				statement.setNull(6, Types.NVARCHAR);
			} else {
				statement.setString(5, "%" + loaiPhong + "%");
				statement.setString(6, "%" + loaiPhong + "%");
			}
			if (soNguoi == 0) {
				statement.setNull(7, Types.INTEGER);
				statement.setNull(8, Types.INTEGER);
			} else {
				statement.setInt(7, soNguoi);
				statement.setInt(8, soNguoi);
			}
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maP = rs.getString(1);
				String tenP = rs.getString(2);
				String tt = rs.getString(3);
				LoaiPhong lp = new LoaiPhong(rs.getString(4));

				Phong p = new Phong(maP, tenP, lp, tt);
				ds.add(p);
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
	
	public ArrayList<Phong> timKiemPhong(String ten, String tinhTrang, String loaiPhong, String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ArrayList<Phong> ds = new ArrayList<Phong>();
		String sql = "SELECT * FROM Phong " + "WHERE (? IS NULL OR TenPhong LIKE '%' + ? + '%') "
				+ "AND (? IS NULL OR TrangThai LIKE '%' + ? + '%') "
				+ "AND (MaLP IN (SELECT MaLP FROM LoaiPhong WHERE (? IS NULL OR TenLoaiPhong LIKE '%' + ? + '%'))) "
				+ "AND (? is null or maP like '%' + ? + '%')";
		try {
			statement = con.prepareStatement(sql);
			if (ten == null) {
				statement.setNull(1, Types.NVARCHAR);
				statement.setNull(2, Types.NVARCHAR);
			} else {
				statement.setString(1, "%" + ten + "%");
				statement.setString(2, "%" + ten + "%");
			}
			if (tinhTrang == null) {
				statement.setNull(3, Types.NVARCHAR);
				statement.setNull(4, Types.NVARCHAR);
			} else {
				statement.setString(3, "%" + tinhTrang + "%");
				statement.setString(4, "%" + tinhTrang + "%");
			}
			if (loaiPhong == null) {
				statement.setNull(5, Types.NVARCHAR);
				statement.setNull(6, Types.NVARCHAR);
			} else {
				statement.setString(5, "%" + loaiPhong + "%");
				statement.setString(6, "%" + loaiPhong + "%");
			}
			if (ma == null) {
				statement.setNull(7, Types.NVARCHAR);
				statement.setNull(8, Types.NVARCHAR);
			} else {
				statement.setString(7, ma);
				statement.setString(8, ma);
			}
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maP = rs.getString(1);
				String tenP = rs.getString(2);
				String tt = rs.getString(3);
				LoaiPhong lp = new LoaiPhong(rs.getString(4));

				Phong p = new Phong(maP, tenP, lp, tt);
				ds.add(p);
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

	public boolean capNhatTrangThaiPhong(String ma) throws SQLException {
		Connection con = ConnectDB.getConnection();
		String sql = "update phong set trangThai = N'Phòng trống' where maP = '" + ma + "'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean capNhatTrangThaiPhong(String ma, String trangThai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmtUpdate = null;
		int n = 0;
		try {
			stmtUpdate = con.prepareStatement("update Phong set TrangThai=? " + "where MaP=?");
			stmtUpdate.setString(1, trangThai);
			stmtUpdate.setString(2, ma);
			n += stmtUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmtUpdate.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
