package entity;

import java.time.LocalTime;

public class ChiTietHoaDon {
	private HoaDon hd;
	private Phong p;
	private String tenPhong;
	private double donGia;
	private String donVi;
	private LocalTime thoiGianSuDung;

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(HoaDon hd) {
		super();
		this.hd = hd;
	}

	public ChiTietHoaDon(HoaDon hd, Phong p, String tenPhong, double donGia, String donVi, LocalTime thoiGianSuDung) {
		super();
		this.hd = hd;
		this.p = p;
		this.tenPhong = tenPhong;
		this.donGia = donGia;
		this.donVi = donVi;
		this.thoiGianSuDung = thoiGianSuDung;
	}

	public HoaDon getHd() {
		return hd;
	}

	public void setHd(HoaDon hd) {
		this.hd = hd;
	}

	public Phong getP() {
		return p;
	}

	public void setP(Phong p) {
		this.p = p;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public LocalTime getThoiGianSuDung() {
		return thoiGianSuDung;
	}

	public void setThoiGianSuDung(LocalTime thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [hd=" + hd + ", p=" + p + ", tenPhong=" + tenPhong + ", donGia=" + donGia + ", donVi="
				+ donVi + ", thoiGianSuDung=" + thoiGianSuDung + "]";
	}

}