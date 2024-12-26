package entity;

public class ChiTietSuDungDichVu {
	private PhieuDatPhong pdp;
	private DichVu dichVu;
	private String tenDV;
	private int soLuong;
	private double donGia;
	private String donVi;

	public ChiTietSuDungDichVu(PhieuDatPhong pdp, DichVu dichVu, String tenDV, int soLuong, double donGia,
			String donVi) {
		super();
		this.pdp = pdp;
		this.dichVu = dichVu;
		this.tenDV = tenDV;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.donVi = donVi;
	}

	public ChiTietSuDungDichVu() {
		super();
	}

	public ChiTietSuDungDichVu(PhieuDatPhong pdp) {
		super();
		this.pdp = pdp;
	}

	public PhieuDatPhong getPdp() {
		return pdp;
	}

	public void setPdp(PhieuDatPhong pdp) {
		this.pdp = pdp;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
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

	public long tinhTienDichVu() {
		long sum = 0;
		sum = (long) (soLuong * donGia);
		return sum;
	}

	@Override
	public String toString() {
		return "ChiTietSuDungDichVu [pdp=" + pdp + ", dichVu=" + dichVu + ", tenDV=" + tenDV + ", soLuong=" + soLuong
				+ ", donGia=" + donGia + ", donVi=" + donVi + "]";
	}

}
