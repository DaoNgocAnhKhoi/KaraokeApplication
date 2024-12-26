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
import entity.ChiTietPhieuDatPhong;
import entity.PhieuDatPhong;
import entity.Phong;

public class ChiTietPhieuDatPhong_DAO {
	public ChiTietPhieuDatPhong_DAO() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean create(ChiTietPhieuDatPhong ctpdp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into " + "chitietphieudatphong values(?,?,?)");
			stmt.setString(1, ctpdp.getPdp().getMaPDP());
			stmt.setString(2, ctpdp.getPhong().getMaPhong());
			if (ctpdp.getThoiGianSuDung() != null)
				stmt.setTime(3, java.sql.Time.valueOf(ctpdp.getThoiGianSuDung()));
			else
				stmt.setNull(3, Types.TIME);

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

	public boolean updateThoiGianSuDungPhong(LocalTime thoiGianSuDung, String maPhong, String maPDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update chitietphieudatphong set thoigiansudungphong=? " + "where maP=? and maPDP=?");

			stmt.setTime(1, java.sql.Time.valueOf(thoiGianSuDung));
			stmt.setString(2, maPhong);
			stmt.setString(3, maPDP);
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
	
	public ChiTietPhieuDatPhong check(String maPDP,String maP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ChiTietPhieuDatPhong ctpdp = null;
		PreparedStatement statement = null;
		try {
			String sql = "Select * from chitietphieudatphong where maPDP = ? and maP=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPDP);
			statement.setString(1, maP);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				String maPhieuDatPhong = rs.getString(1);
				String maPhong = rs.getString(2);
				LocalTime thoiGianSD = rs.getTime(3).toLocalTime();
				
				ctpdp = new ChiTietPhieuDatPhong(new Phong(maPhong), new PhieuDatPhong(maPhieuDatPhong), thoiGianSD);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ctpdp;
	}
	

	public ChiTietPhieuDatPhong getChiTietPhieuDatPhongTheoMa(String maPDP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ChiTietPhieuDatPhong ctpdp = null;
		PreparedStatement statement = null;

		try {
			String sql = "select * from ChiTietPhieuDatPhong where MaPDP =? ";
			statement = con.prepareStatement(sql);
			statement.setString(1,maPDP);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				PhieuDatPhong maPhieu = new PhieuDatPhong( rs.getString(1));
				Phong phong = new Phong(rs.getString(2));
				LocalTime thoiGianSuDung = (rs.getTime(3) != null) ? rs.getTime(3).toLocalTime() : null;
				ctpdp = new ChiTietPhieuDatPhong(phong, maPhieu, thoiGianSuDung);
			
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ctpdp;
	}
	
	public ChiTietPhieuDatPhong getChiTietPhieuDatPhongTheoMaPhong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ChiTietPhieuDatPhong ctpdp = null;
		PreparedStatement statement = null;

		try {
			String sql = "select * from ChiTietPhieuDatPhong where MaP =? ";
			statement = con.prepareStatement(sql);
			statement.setString(1,maPhong);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				PhieuDatPhong maPhieu = new PhieuDatPhong( rs.getString(1));
				Phong phong = new Phong(rs.getString(2));
				LocalTime thoiGianSuDung = (rs.getTime(3) != null) ? rs.getTime(3).toLocalTime() : LocalTime.MIN;
				ctpdp = new ChiTietPhieuDatPhong(phong, maPhieu, thoiGianSuDung);

				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ctpdp;
	}

	public boolean capNhatThoiGianSuDungPhong(String maPDP, LocalTime thoiGianTraPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;

		try {
			stmt = con.prepareStatement("UPDATE chiTietPhieuDatPhong SET thoiGianSuDungPhong = ? WHERE maPDP = ? and thoiGianSuDungPhong IS NULL");
			stmt.setTime(1, Time.valueOf(thoiGianTraPhong));
			stmt.setString(2, maPDP);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public ArrayList<ChiTietPhieuDatPhong> getALLPhieuDatPhongTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();	
		PreparedStatement statement = null;
		ArrayList<ChiTietPhieuDatPhong> dsctpdp = new ArrayList<ChiTietPhieuDatPhong>();
		try {
			String sql = "select * from ChiTietPhieuDatPhong where MaPDP =?";
			statement = con.prepareStatement(sql);
			statement.setString(1,ma);
			// Thực hiện câu lệnh sql trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				PhieuDatPhong maPhieu = new PhieuDatPhong( rs.getString(1));
				Phong phong = new Phong(rs.getString(2));
				LocalTime thoiGianSuDung = (rs.getTime(3) != null) ? rs.getTime(3).toLocalTime() : LocalTime.MIN;
				ChiTietPhieuDatPhong ctpdp = new ChiTietPhieuDatPhong(phong, maPhieu, thoiGianSuDung);
				dsctpdp.add(ctpdp);
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsctpdp;
	}

	public boolean checkThoiGianSuDung(String maPDP, String maP) {
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	

	    try {
	        String sql = "SELECT * FROM chitietphieudatphong WHERE maPDP = ? AND maP = ? AND thoiGianSudungphong IS NULL";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, maPDP);
	        stmt.setString(2, maP);
	        ResultSet rs = stmt.executeQuery();

	        // Check if ResultSet has any records
	        return rs.next();
	    } catch (SQLException e) {
	        // Handle exceptions
	        e.printStackTrace();
	        return false;
	    }
	}
}
