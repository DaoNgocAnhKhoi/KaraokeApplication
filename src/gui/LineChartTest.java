package gui;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.time.Year;
import java.time.YearMonth;
import javax.swing.JPanel;

import com.itextpdf.text.Font;

import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import gui.ModelChart;

/**
 *
 * @author RAVEN
 */
public class LineChartTest extends JPanel {

	/**
	 * Creates new form Test
	 */
	public LineChartTest() {
		setVisible(true);
		initComponents();
		chart.setTitle("Tổng Quan");
		chart.addLegend("Tất cả KH", Color.decode("#7b4397"), Color.decode("#dc2430"));
		chart.addLegend("KH Cũ", Color.decode("#e65c00"), Color.decode("#F9D423"));
		chart.addLegend("KH Mới", Color.decode("#0099F7"), Color.decode("#F11712"));
		chart.addLegend("KH Quen", Color.decode("#0099F7"), Color.decode("#F11712"));
		setDataKhachHang();
//		test();
	}

	public LineChartTest(String thongKeDoanhThu) {
		setVisible(true);
		initComponents();
		chart.setTitle("Tổng Quan");
		chart.setSize(400, 600);
		chart.addLegend("Tổng doanh thu", Color.decode("#7b4397"), Color.decode("#dc2430"));
		chart.addLegend("DT cao nhất", Color.decode("#0099F7"), Color.decode("#F11712"));
		chart.addLegend("DT thấp nhất", Color.decode("#0099F7"), Color.decode("#F11712"));
		setDataDoanhThu();
	}

	private void test() {
		chart.clear();
		chart.addData(new ModelChart("T1", new double[] { 500, 50, 100 }));
		chart.addData(new ModelChart("T2", new double[] { 600, 300, 150 }));
		chart.addData(new ModelChart("T3", new double[] { 200, 50, 2000 }));
		chart.addData(new ModelChart("T4", new double[] { 480, 700, 100 }));
		chart.addData(new ModelChart("T5", new double[] { 350, 540, 500 }));
		chart.addData(new ModelChart("T6", new double[] { 450, 800, 100 }));
		chart.addData(new ModelChart("T7", new double[] { 450, 800, 100 }));
		chart.addData(new ModelChart("T8", new double[] { 450, 800, 100 }));
		chart.addData(new ModelChart("T9", new double[] { 450, 800, 100 }));
		chart.addData(new ModelChart("T10", new double[] { 450, 800, 100 }));
		chart.addData(new ModelChart("T11", new double[] { 450, 800, 100 }));
		chart.addData(new ModelChart("T12", new double[] { 450, 800, 100 }));
		chart.start();
	}

	private void setDataDoanhThu() {
		HoaDon_DAO hd_dao = new HoaDon_DAO();
		Double thongKeTongDoanhThu[] = hd_dao.thongKeBieuDoLineTongDoanhThu(Year.now().getValue());
		Double doanhThuCaoNhatMoThang[] = hd_dao.thongKeBieuDoLineDoanhThuCaoNhatMoiThang(Year.now().getValue());
		Double doanhThuThapNhatMoThang[] = hd_dao.thongKeBieuDoLineDoanhThuThapNhatMoiThang(Year.now().getValue());

		chart.clear();
		chart.addData(new ModelChart("T1", new double[] { thongKeTongDoanhThu[0],
				doanhThuCaoNhatMoThang[0], doanhThuThapNhatMoThang[0] }));
		chart.addData(new ModelChart("T2", new double[] { thongKeTongDoanhThu[1],
				doanhThuCaoNhatMoThang[1], doanhThuThapNhatMoThang[1] }));
		chart.addData(new ModelChart("T3", new double[] { thongKeTongDoanhThu[2],
				doanhThuCaoNhatMoThang[2], doanhThuThapNhatMoThang[2] }));
		chart.addData(new ModelChart("T4", new double[] { thongKeTongDoanhThu[3],
				doanhThuCaoNhatMoThang[3], doanhThuThapNhatMoThang[3] }));
		chart.addData(new ModelChart("T5", new double[] { thongKeTongDoanhThu[4],
				doanhThuCaoNhatMoThang[4], doanhThuThapNhatMoThang[4] }));
		chart.addData(new ModelChart("T6", new double[] { thongKeTongDoanhThu[5],
				doanhThuCaoNhatMoThang[5], doanhThuThapNhatMoThang[5] }));
		chart.addData(new ModelChart("T7", new double[] { thongKeTongDoanhThu[6],
				doanhThuCaoNhatMoThang[6], doanhThuThapNhatMoThang[6] }));
		chart.addData(new ModelChart("T8", new double[] { thongKeTongDoanhThu[7],
				doanhThuCaoNhatMoThang[7], doanhThuThapNhatMoThang[7] }));
		chart.addData(new ModelChart("T9", new double[] { thongKeTongDoanhThu[8],
				doanhThuCaoNhatMoThang[8], doanhThuThapNhatMoThang[8] }));
		chart.addData(new ModelChart("T10", new double[] { thongKeTongDoanhThu[9],
				doanhThuCaoNhatMoThang[9], doanhThuThapNhatMoThang[9] }));
		chart.addData(new ModelChart("T11", new double[] { thongKeTongDoanhThu[10],
				doanhThuCaoNhatMoThang[10], doanhThuThapNhatMoThang[10] }));
		chart.addData(new ModelChart("T12", new double[] { thongKeTongDoanhThu[11],
				doanhThuCaoNhatMoThang[11], doanhThuThapNhatMoThang[11] }));
		chart.start();
	}

	private void setDataKhachHang() {
		KhachHang_DAO kh_dao = new KhachHang_DAO();
		ArrayList<KhachHang_DAO.KhachHangThongKe>[] dsTongKH = new ArrayList[12];
		ArrayList<KhachHang_DAO.KhachHangThongKe>[] dsKHCu = new ArrayList[12];
		ArrayList<KhachHang_DAO.KhachHangThongKe>[] dsKHMoi = new ArrayList[12];
		ArrayList<KhachHang_DAO.KhachHangThongKe>[] dsKHQuen = new ArrayList[12];

		for (int i = 0; i < dsTongKH.length; i++) {
			dsTongKH[i] = new ArrayList<>();
			dsKHCu[i] = new ArrayList<>();
			dsKHMoi[i] = new ArrayList<>();
			dsKHQuen[i] = new ArrayList<>();

		}

		for (int i = 0; i < dsTongKH.length; i++) {
			dsTongKH[i] = kh_dao.thongKeKhachTheoThang(i + 1, Year.now().getValue());
			dsKHCu[i] = kh_dao.thongKeKHCuTheoThang(i + 1, Year.now().getValue());
			dsKHMoi[i] = kh_dao.thongKeKHMoiTheoThang(i + 1, Year.now().getValue());
			dsKHQuen[i] = kh_dao.thongKeKHQuenTheoThang(i + 1, Year.now().getValue());

		}

		chart.clear();
		chart.addData(new ModelChart("T1",
					new double[] { dsTongKH[0].size(), dsKHCu[0].size(), dsKHMoi[0].size(), dsKHQuen[0].size() }));
		chart.addData(new ModelChart("T2",
				new double[] { dsTongKH[1].size(), dsKHCu[1].size(), dsKHMoi[1].size(), dsKHQuen[1].size() }));
		chart.addData(new ModelChart("T3",
				new double[] { dsTongKH[2].size(), dsKHCu[2].size(), dsKHMoi[2].size(), dsKHQuen[2].size() }));
		chart.addData(new ModelChart("T4",
				new double[] { dsTongKH[3].size(), dsKHCu[3].size(), dsKHMoi[3].size(), dsKHQuen[3].size() }));
		chart.addData(new ModelChart("T5",
				new double[] { dsTongKH[4].size(), dsKHCu[4].size(), dsKHMoi[4].size(), dsKHQuen[4].size() }));
		chart.addData(new ModelChart("T6",
				new double[] { dsTongKH[5].size(), dsKHCu[5].size(), dsKHMoi[5].size(), dsKHQuen[5].size() }));
		chart.addData(new ModelChart("T7",
				new double[] { dsTongKH[6].size(), dsKHCu[6].size(), dsKHMoi[6].size(), dsKHQuen[6].size() }));
		chart.addData(new ModelChart("T8",
				new double[] { dsTongKH[7].size(), dsKHCu[7].size(), dsKHMoi[7].size(), dsKHQuen[7].size() }));
		chart.addData(new ModelChart("T9",
				new double[] { dsTongKH[8].size(), dsKHCu[8].size(), dsKHMoi[8].size(), dsKHQuen[8].size() }));
		chart.addData(new ModelChart("T10",
				new double[] { dsTongKH[9].size(), dsKHCu[9].size(), dsKHMoi[9].size(), dsKHQuen[9].size() }));
		chart.addData(new ModelChart("T11",
				new double[] { dsTongKH[10].size(), dsKHCu[10].size(), dsKHMoi[10].size(), dsKHQuen[10].size() }));
		chart.addData(new ModelChart("T12",
				new double[] { dsTongKH[11].size(), dsKHCu[11].size(), dsKHMoi[11].size(), dsKHQuen[11].size() }));
		chart.start();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		panelShadow1 = new gui.PanelShadow();
		chart = new gui.CurveLineChart();

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		panelShadow1.setBackground(new java.awt.Color(34, 59, 69));
		panelShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panelShadow1.setColorGradient(new java.awt.Color(17, 38, 47));

		chart.setForeground(new java.awt.Color(237, 237, 237));
		chart.setFillColor(true);

		javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
		panelShadow1.setLayout(panelShadow1Layout);
		panelShadow1Layout
				.setHorizontalGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								panelShadow1Layout.createSequentialGroup().addContainerGap()
										.addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
										.addContainerGap()));
		panelShadow1Layout
				.setVerticalGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelShadow1Layout.createSequentialGroup().addContainerGap()
								.addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
								.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelShadow1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelShadow1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

//        pack();
//        setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(LineChartTest.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LineChartTest.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LineChartTest.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LineChartTest.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LineChartTest().setVisible(true);
//            }
//        });
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private gui.CurveLineChart chart;
	private gui.PanelShadow panelShadow1;
	// End of variables declaration//GEN-END:variables
}
