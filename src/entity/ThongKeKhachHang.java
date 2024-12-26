package entity;

import java.sql.Date;

public class ThongKeKhachHang {
	private int tongKhachHang;
	private int khachHangCu;
	private int khachHangMoi;
	private Date ngay;
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	public int getTongKhachHang() {
		return tongKhachHang;
	}
	public void setTongKhachHang(int tongKhachHang) {
		this.tongKhachHang = tongKhachHang;
	}
	public int getKhachHangCu() {
		return khachHangCu;
	}
	public void setKhachHangCu(int khachHangCu) {
		this.khachHangCu = khachHangCu;
	}
	public int getKhachHangMoi() {
		return khachHangMoi;
	}
	public void setKhachHangMoi(int khachHangMoi) {
		this.khachHangMoi = khachHangMoi;
	}
	public ThongKeKhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ThongKeKhachHang(int tongKhachHang, int khachHangCu, int khachHangMoi, Date ngay) {
		super();
		this.tongKhachHang = tongKhachHang;
		this.khachHangCu = khachHangCu;
		this.khachHangMoi = khachHangMoi;
		this.ngay = ngay;
	}
}
