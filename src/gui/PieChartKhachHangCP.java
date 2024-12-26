package gui;

import javax.swing.JPanel;

import dao.KhachHang_DAO;

import java.awt.BorderLayout;
import java.awt.Color;
import gui.ModelPieChart;
import gui.PieChart;

public class PieChartKhachHangCP extends JPanel {
    private PieChart pieChart;

    public PieChartKhachHangCP() {
        pieChart = new PieChart();
        initComponents();
        setBackground(new Color(255, 255, 255));
        pieChart.setChartType(PieChart.PeiChartType.DONUT_CHART);
        pieChart.addData(new ModelPieChart("Khách hàng mới", 150, new Color(23, 126, 238)));
        pieChart.addData(new ModelPieChart("Khách hàng cũ", 100, new Color(221, 65, 65)));
        
    }
    
    public PieChartKhachHangCP(int khMoi,int khCu) {
        pieChart = new PieChart();
        initComponents();
        setBackground(new Color(255, 255, 255));
        pieChart.setChartType(PieChart.PeiChartType.DONUT_CHART);
        pieChart.addData(new ModelPieChart("Khách hàng mới", khMoi, new Color(23, 126, 238)));
        pieChart.addData(new ModelPieChart("Khách hàng cũ", khCu, new Color(221, 65, 65)));
        
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        add(pieChart, BorderLayout.CENTER);
    }
   
}
