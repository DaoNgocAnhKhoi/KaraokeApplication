package entity;

public class TaiKhoan {
	private String maTK;
	private String tenDangNhap;
	private String matKhau;
	private NhanVien nv;

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(String maTK) {
		super();
		this.maTK = maTK;
	}

	public TaiKhoan(String maTK, String tenDangNhap, String matKhau, NhanVien nv) {
		super();
		this.maTK = maTK;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.nv = nv;
	}

	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public NhanVien getNhanVien() {
		return nv;
	}

	public void setNhanVien(NhanVien nv) {
		this.nv = nv;
	}

	@Override
	public String toString() {
		return "TaiKhoan [maTK=" + maTK + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", nv="
				+ nv + "]";
	}
}
