package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietSuDungDichVu;
import entity.DichVu;
import entity.PhieuDatPhong;

public class ChiTietSuDungDichVu_DAO {
	public ChiTietSuDungDichVu_DAO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ChiTietSuDungDichVu> getCTSDDVTheoMa(String maPDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		ArrayList<ChiTietSuDungDichVu> dsctdv = new ArrayList<ChiTietSuDungDichVu>();
		try {
			String sql = "Select * from chitietsudungdichvu where maPDP=? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPDP);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				PhieuDatPhong pdp = new PhieuDatPhong(rs.getString(1));
				DichVu dv = new DichVu(rs.getString(2));
				String tenDV = rs.getString(3);
				int soLuong = rs.getInt(4);
				double donGia = rs.getDouble(5);
				String donVi = rs.getString(6);
				ChiTietSuDungDichVu ctdv = new ChiTietSuDungDichVu(pdp, dv, tenDV, soLuong, donGia, donVi);
				dsctdv.add(ctdv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsctdv;
	}

	public boolean deleteTheoMaPDP(String maPDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		try {
			String deleteQuery = "DELETE FROM chitietsudungdichvu WHERE MaPDP = ?";
			PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
			deleteStatement.setString(1, maPDP);
			n = deleteStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean create(ChiTietSuDungDichVu ctdv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into " + "chitietsudungdichvu values(?,?,?,?,?,?)");
			stmt.setString(1, ctdv.getPdp().getMaPDP());
			stmt.setString(2, ctdv.getDichVu().getMaDichVu());
			stmt.setString(3, ctdv.getTenDV());
			stmt.setInt(4, ctdv.getSoLuong());
			stmt.setDouble(5, ctdv.getDonGia());
			stmt.setString(6, ctdv.getDonVi());

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
}
