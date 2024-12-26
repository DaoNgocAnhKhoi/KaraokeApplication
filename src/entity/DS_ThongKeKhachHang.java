package entity;

import java.util.ArrayList;

public class DS_ThongKeKhachHang {
	private ArrayList<ThongKeKhachHang> ds_tkkh;

	public DS_ThongKeKhachHang() {
		ds_tkkh = new ArrayList<ThongKeKhachHang>();
	}

	public void themThongKe(ThongKeKhachHang tkkh) {
		ds_tkkh.add(tkkh);
	}

	public ArrayList<ThongKeKhachHang> getDs_tkkh() {
		return ds_tkkh;
	}

}
