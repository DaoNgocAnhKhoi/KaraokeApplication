package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import connectDB.ConnectDB;
import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.LoaiPhong_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;

public class FrmGiaoDienNhanPhongCho extends JFrame implements ActionListener {
	private JLabel lblTraPhong;
	private JComboBox cmbGio, cmbPhut;
	private JPanel pnlGio;
	private JButton btnNhanPhong;
	private KhachHang_DAO kh_dao;
	private NhanVien_DAO nv_dao;
	private Phong_DAO p_dao;
	private HoaDon_DAO hd_dao;
	private ChiTietHoaDon_DAO cthd_dao;
	private LoaiPhong_DAO lp_dao;
	private NhanVien nvThucThi;
	private ArrayList<Phong> dsp;
	private Map<JPanel, String> dspdc;
	private PnGiaoDienDatPhong pnl;
	private PhieuDatPhong_DAO pdp_dao;

	public FrmGiaoDienNhanPhongCho(ArrayList<Phong> dspht, NhanVien nv, Map<JPanel, String> danhSachPhongDuocChon,
			PnGiaoDienDatPhong pnlGiaoDienDatPhong) {
		// TODO Auto-generated constructor stub
		super("Nhận phòng");
		// TODO Auto-generated constructor stub
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
		pdp_dao = new PhieuDatPhong_DAO();
		pnl = pnlGiaoDienDatPhong;
		dspdc = danhSachPhongDuocChon;
		nvThucThi = nv;
		dsp = dspht;
		lp_dao = new LoaiPhong_DAO();
		kh_dao = new KhachHang_DAO();
		nv_dao = new NhanVien_DAO();
		p_dao = new Phong_DAO();
		hd_dao = new HoaDon_DAO();
		cthd_dao = new ChiTietHoaDon_DAO();
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new BorderLayout());

		// Tạo panel header luôn xuất hiện trong mọi giao diện
		JPanel pnlHeader = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				Paint p = new GradientPaint(0.0f, 0.0f, new Color(0xff005b), getWidth(), getHeight(),
						new Color(0xffe53b), true);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setPaint(p);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};
		JLabel lblTitle = new JLabel("Nhận phòng chờ", SwingConstants.CENTER);
		lblTitle.setForeground(Color.white);
		lblTitle.setFont(new Font("Time New Roman", Font.BOLD, 30));
		pnlHeader.add(lblTitle);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(null);
		// Label "Tên phòng"
		String ten = "";
		for (int i = 0; i < dspht.size(); i++) {
			ten += dspht.get(i).getTenPhong();
			if (dspht.size() != 1 && i != dspht.size() - 1)
				ten += ",";
		}
		JLabel lblTenPhong = new JLabel("Tên phòng:" + ten);
		lblTenPhong.setBounds(10, 10, 200, 20);
		pnlCenter.add(lblTenPhong);

		// Label "Thời gian trả phòng"
		lblTraPhong = new JLabel("Thời gian trả phòng:");
		lblTraPhong.setBounds(10, 40, 150, 20);
		pnlCenter.add(lblTraPhong);

		// Panel chứa ComboBox cho giờ và phút
		pnlGio = new JPanel();
		pnlGio.setLayout(null);
		pnlGio.setBounds(160, 40, 150, 20);

		// Label ":" giữa giờ và phút
		JLabel lbHaiCham = new JLabel(":");
		lbHaiCham.setBounds(60, 0, 10, 20);
		pnlGio.add(lbHaiCham);

		// ComboBox cho giờ
		cmbGio = new JComboBox();
		cmbGio.setBounds(0, 0, 50, 20);
		for (int i = 0; i <= 23; i++) {
			String gio = (i <= 9) ? "0" + i : String.valueOf(i);
			cmbGio.addItem(gio);
		}
		pnlGio.add(cmbGio);

		// ComboBox cho phút
		cmbPhut = new JComboBox();
		cmbPhut.setBounds(70, 0, 50, 20);
		for (int j = 0; j <= 59; j++) {
			String phut = (j <= 9) ? "0" + j : String.valueOf(j);
			cmbPhut.addItem(phut);
		}
		pnlGio.add(cmbPhut);

		pnlCenter.add(pnlGio);

		btnNhanPhong = new JButton("Nhận phòng");
		btnNhanPhong.setBounds(260, 70, 120, 30);
		pnlCenter.add(btnNhanPhong);

		btnNhanPhong.addActionListener(this);

		pnlMain.add(pnlHeader, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		this.add(pnlMain);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 200);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnNhanPhong)) {
			KhachHang kh = pdp_dao.getPhieuDatPhongTheoMaPhong(dsp.get(0).getMaPhong()).getKh();
			for (int i = 0; i < dsp.size(); i++) {
				pdp_dao.update(pdp_dao.getPhieuDatPhongTheoMaPhong(dsp.get(i).getMaPhong()).getMaPDP(), new Date(System.currentTimeMillis()), LocalTime.now(),
						LocalTime.of(Integer.parseInt(cmbGio.getSelectedItem().toString()),
								Integer.parseInt(cmbPhut.getSelectedItem().toString())));
				p_dao.capNhatTrangThaiPhong(dsp.get(i).getMaPhong(), "Phòng đang sử dụng");
			}
			pnl.xoaHetPhong();
			pnl.docDuLieuVaoBang(p_dao.getAlltbPhong());
			JOptionPane.showMessageDialog(null, "Đã nhận phòng thành công");
			this.dispose();
		}
	}
}
