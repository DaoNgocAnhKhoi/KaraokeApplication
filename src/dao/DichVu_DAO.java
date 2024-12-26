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
import java.util.List;
import java.util.Map;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.LoaiDichVu;

public class DichVu_DAO {
	public DichVu_DAO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<DichVu> getAlltbDichVu() {
		ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DichVu";
			Statement statement = con.createStatement();
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maDichVu = rs.getString(1);
				String tenDichVu = rs.getString(2);
				int soLuong = rs.getInt(3);
				String donVi = rs.getString(4);
				Double donGia = rs.getDouble(5);
				LoaiDichVu loaiDichVu = new LoaiDichVu(rs.getString(6));
				String hinhAnh = rs.getString(7);
				DichVu dv = new DichVu(maDichVu, tenDichVu, soLuong, donVi, donGia, loaiDichVu, hinhAnh);
				dsdv.add(dv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsdv;
	}

	public ArrayList<DichVu> getAllDichVuTheoTenLoaiDV(String tenLoaiDV) {
		ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT * " + "FROM DichVu " + "JOIN LoaiDichVu ON DichVu.MaLDV = LoaiDichVu.MaLDV "
					+ "WHERE LoaiDichVu.TenLoaiDV = ?;";
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			statement = con.prepareStatement(sql);
			statement.setString(1, tenLoaiDV);
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maDichVu = rs.getString(1);
				String tenDichVu = rs.getString(2);
				int soLuong = rs.getInt(3);
				String donVi = rs.getString(4);
				Double donGia = rs.getDouble(5);
				LoaiDichVu loaiDichVu = new LoaiDichVu(rs.getString(6));
				String hinhAnh = rs.getString(7);
				DichVu dv = new DichVu(maDichVu, tenDichVu, soLuong, donVi, donGia, loaiDichVu, hinhAnh);
				dsdv.add(dv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsdv;
	}

	public List<DichVu> getDichVuTheoLoai(String maLDV) {
		List<DichVu> danhSachDichVu = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;

		try {
			String sql = "SELECT * FROM dichvu WHERE maLDV = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maLDV);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String maDichVu = rs.getString(1);
				String tenDichVu = rs.getString(2);
				int soLuong = rs.getInt(3);
				String donVi = rs.getString(4);
				Double donGia = rs.getDouble(5);
				LoaiDichVu loaiDichVu = new LoaiDichVu(rs.getString(6));
				String hinhAnh = rs.getString(7);
				DichVu dv = new DichVu(maDichVu, tenDichVu, soLuong, donVi, donGia, loaiDichVu, hinhAnh);
				danhSachDichVu.add(dv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// Xử lý các ngoại lệ nếu cần
		}

		return danhSachDichVu;
	}

	public DichVu getDichVuMoiNhat() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		DichVu dv = null;

		try {
			Statement statement = con.createStatement();
			String sql = "Select top 1 * from dichvu ORDER BY MaDV DESC ";
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maDichVu = rs.getString(1);
				String tenDichVu = rs.getString(2);
				int soLuong = rs.getInt(3);
				String donVi = rs.getString(4);
				Double donGia = rs.getDouble(5);
				LoaiDichVu loaiDichVu = new LoaiDichVu(rs.getString(6));
				String hinhAnh = rs.getString(5);
				dv = new DichVu(maDichVu, tenDichVu, soLuong, donVi, donGia, loaiDichVu, hinhAnh);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dv;
	}

	public DichVu getDichVuTheoMa(String maDV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		DichVu dv = null;
		PreparedStatement statement = null;

		try {
			String sql = "Select * from dichvu where maDV=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, maDV);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maDichVu = rs.getString(1);
				String tenDichVu = rs.getString(2);
				int soLuong = rs.getInt(3);
				String donVi = rs.getString(4);
				Double donGia = rs.getDouble(5);
				LoaiDichVu loaiDichVu = new LoaiDichVu(rs.getString(6));
				String hinhAnh = rs.getString(7);
				dv = new DichVu(maDichVu, tenDichVu, soLuong, donVi, donGia, loaiDichVu, hinhAnh);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dv;
	}

	public DichVu getDichVuTheoTen(String tenDV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		DichVu dv = null;
		PreparedStatement statement = null;

		try {
			String sql = "Select * from dichvu where tenDV=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenDV);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maDichVu = rs.getString(1);
				String tenDichVu = rs.getString(2);
				int soLuong = rs.getInt(3);
				String donVi = rs.getString(4);
				Double donGia = rs.getDouble(5);
				LoaiDichVu loaiDichVu = new LoaiDichVu(rs.getString(6));
				String hinhAnh = rs.getString(7);
				dv = new DichVu(maDichVu, tenDichVu, soLuong, donVi, donGia, loaiDichVu, hinhAnh);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dv;
	}

	public boolean create(DichVu dv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			// stored procedures tự động phát sinh
			CallableStatement myCall = con.prepareCall("{call phatSinhIDDV(?)}");
			myCall.registerOutParameter(1, Types.VARCHAR);
			myCall.execute();
			String maDichVu = myCall.getString(1);

			stmt = con.prepareStatement("insert into " + "dichvu values(?,?,?,?,?,?,?)");
			stmt.setString(1, maDichVu);
			stmt.setString(2, dv.getTenDichVu());
			stmt.setInt(3, dv.getSoLuong());
			stmt.setString(4, dv.getDonVi());
			stmt.setDouble(5, dv.getDonGia());
			stmt.setString(6, dv.getLoaiDichVu().getMaLoaiDichVu());
			stmt.setString(7, dv.getHinhAnh());

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

	public boolean delete(String maDV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		try {
			String deleteQuery = "DELETE FROM dichvu WHERE MaDV = ?";
			PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
			deleteStatement.setString(1, maDV);
			n += deleteStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean update(DichVu dv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update dichvu set tenDV=?," + "SoLuong=?,DonVi=?,DonGia=?,MaLDV=?,hinhanh=? " + "where maDV=?");

			stmt.setString(1, dv.getTenDichVu());
			stmt.setInt(2, dv.getSoLuong());
			stmt.setString(3, dv.getDonVi());
			stmt.setDouble(4, dv.getDonGia());
			stmt.setString(5, dv.getLoaiDichVu().getMaLoaiDichVu());
			stmt.setString(6, dv.getHinhAnh());
			stmt.setString(7, dv.getMaDichVu());
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

	public boolean capNhapSoLuongTonKho(DichVu dv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update dichvu set SoLuong=soLuong 	- ? where maDV=?");
			stmt.setInt(1, dv.getSoLuong());
			stmt.setString(2, dv.getMaDichVu());
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

	public ArrayList<DichVu> timKiemDichVu(String ma, String ten, String giaBD, String giaKT, String ldv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;

		ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
		String sql = "SELECT * FROM dichvu " + "WHERE (? IS NULL OR MaDV like '%'+?+'%') "
				+ "AND (? IS NULL OR TenDV like '%'+?+'%') "
				+ " AND ((? IS NULL AND ? IS NULL) OR (DonGia >= ? AND DonGia <= ?)) "
				+ "AND (? IS NULL OR MaLDV like '%'+?+'%')";
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
			if (giaBD == null && giaKT == null) {
				statement.setNull(5, Types.FLOAT);
				statement.setNull(6, Types.FLOAT);
				statement.setNull(7, Types.FLOAT);
				statement.setNull(8, Types.FLOAT);
			} else {
				statement.setDouble(5, Double.parseDouble(giaBD));
				statement.setDouble(6, Double.parseDouble(giaKT));
				statement.setDouble(7, Double.parseDouble(giaBD));
				statement.setDouble(8, Double.parseDouble(giaKT));
			}
			if (ldv == null) {
				statement.setNull(9, Types.NVARCHAR);
				statement.setNull(10, Types.NVARCHAR);
			} else {
				statement.setString(9, "%" + ldv + "%");
				statement.setString(10, "%" + ldv + "%");
			}

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maDichVu = rs.getString(1);
				String tenDichVu = rs.getString(2);
				int soLuong = rs.getInt(3);
				String donVi = rs.getString(4);
				Double donGia = rs.getDouble(5);
				LoaiDichVu loaiDichVu = new LoaiDichVu(rs.getString(6));
				String hinhAnh = rs.getString(7);
				DichVu dv = new DichVu(maDichVu, tenDichVu, soLuong, donVi, donGia, loaiDichVu, hinhAnh);
				dsdv.add(dv);
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
		return dsdv;
	}

	// KHÔI thêm
	public Map<String, String> getAllDichVu() {
		Map<String, String> list = new HashMap<String, String>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;

		try {
			String sql = "select MaDV, TenDV\r\n" + "from DichVu\r\n" + "group by MaDV, TenDV";
			statement = con.prepareStatement(sql);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				list.put(rs.getString("MaDV"), rs.getString("TenDV"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
