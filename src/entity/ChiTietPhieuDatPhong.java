package entity;

import java.time.LocalTime;

public class ChiTietPhieuDatPhong {
	private Phong phong;
	private PhieuDatPhong pdp;
	private LocalTime thoiGianSuDung;

	public ChiTietPhieuDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietPhieuDatPhong(Phong phong, PhieuDatPhong pdp, LocalTime thoiGianSuDung) {
		super();
		this.phong = phong;
		this.pdp = pdp;
		this.thoiGianSuDung = thoiGianSuDung;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public PhieuDatPhong getPdp() {
		return pdp;
	}

	public void setPdp(PhieuDatPhong pdp) {
		this.pdp = pdp;
	}

	public LocalTime getThoiGianSuDung() {
		return thoiGianSuDung;
	}

	public void setThoiGianSuDung(LocalTime thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuDatPhong [phong=" + phong + ", pdp=" + pdp + ", thoiGianSuDung=" + thoiGianSuDung + "]";
	}

}
