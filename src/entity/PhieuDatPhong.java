package entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class PhieuDatPhong {
	private String maPDP;
	private NhanVien nv;
	private KhachHang kh;
	private LocalDateTime ngayLapPhieu;
	private Date ngayNhanPhong;
	private LocalTime gioNhanPhong;
	private LocalTime gioTraPhong;
	private String tinhTrang;

	public PhieuDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhieuDatPhong(String maPDP, NhanVien nv, KhachHang kh, LocalDateTime ngayLapPhieu, Date ngayNhanPhong,
			LocalTime gioNhanPhong, LocalTime gioTraPhong, String tinhTrang) {
		super();
		this.maPDP = maPDP;
		this.nv = nv;
		this.kh = kh;
		this.ngayLapPhieu = ngayLapPhieu;
		this.ngayNhanPhong = ngayNhanPhong;
		this.gioNhanPhong = gioNhanPhong;
		this.gioTraPhong = gioTraPhong;
		this.tinhTrang = tinhTrang;
	}

	public PhieuDatPhong(String maPDP) {
		super();
		this.maPDP = maPDP;
	}

	public String getMaPDP() {
		return maPDP;
	}

	public void setMaPDP(String maPDP) {
		this.maPDP = maPDP;
	}

	public NhanVien getNv() {
		return nv;
	}

	public void setNv(NhanVien nv) {
		this.nv = nv;
	}

	public KhachHang getKh() {
		return kh;
	}

	public void setKh(KhachHang kh) {
		this.kh = kh;
	}

	public LocalDateTime getNgayLapPhieu() {
		return ngayLapPhieu;
	}

	public void setNgayLapPhieu(LocalDateTime ngayLapPhieu) {
		this.ngayLapPhieu = ngayLapPhieu;
	}

	public Date getNgayNhanPhong() {
		return ngayNhanPhong;
	}

	public void setNgayNhanPhong(Date ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}

	public LocalTime getGioNhanPhong() {
		return gioNhanPhong;
	}

	public void setGioNhanPhong(LocalTime gioNhanPhong) {
		this.gioNhanPhong = gioNhanPhong;
	}

	public LocalTime getGioTraPhong() {
		return gioTraPhong;
	}

	public void setGioTraPhong(LocalTime gioTraPhong) {
		this.gioTraPhong = gioTraPhong;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public String toString() {
		return "PhieuDatPhong [maPDP=" + maPDP + ", nv=" + nv + ", kh=" + kh + ", ngayLapPhieu=" + ngayLapPhieu
				+ ", ngayNhanPhong=" + ngayNhanPhong + ", gioNhanPhong=" + gioNhanPhong + ", gioTraPhong=" + gioTraPhong
				+ ", tinhTrang=" + tinhTrang + "]";
	}

}
