package entity;

public class ChiTietSuDungDichVuHoaDon {
	private HoaDon hd;
	private DichVu dv;
	private String tenDichVu;
	private int soLuong;
	private double donGia;
	private String donVi;

	public ChiTietSuDungDichVuHoaDon(HoaDon hd, DichVu dv, String tenDichVu, int soLuong, double donGia, String donVi) {
		super();
		this.hd = hd;
		this.dv = dv;
		this.tenDichVu = tenDichVu;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.donVi = donVi;
	}

	public ChiTietSuDungDichVuHoaDon(HoaDon hd) {
		super();
		this.hd = hd;
	}

	public ChiTietSuDungDichVuHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon getHd() {
		return hd;
	}

	public void setHd(HoaDon hd) {
		this.hd = hd;
	}

	public DichVu getDv() {
		return dv;
	}

	public void setDv(DichVu dv) {
		this.dv = dv;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
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

	@Override
	public String toString() {
		return "ChiTietSuDungDichVuHoaDon [hd=" + hd + ", dv=" + dv + ", tenDichVu=" + tenDichVu + ", soLuong="
				+ soLuong + ", donGia=" + donGia + ", donVi=" + donVi + "]";
	}

}
