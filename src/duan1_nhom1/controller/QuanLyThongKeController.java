/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.controller;

import duan1_nhom1.bean.HoaDonBean;
import duan1_nhom1.service.ThongKeImp;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

/**
 *
 * @author maccuacu
 */
public class QuanLyThongKeController {
    private ThongKeImp service = new ThongKeImp();
    
    public void setDataToChart1(JPanel jpnItem){
        List<HoaDonBean> listItem = service.getListByHoaDon();
        
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
         if (listItem != null) {
            for (HoaDonBean item : listItem) {
                dataSet.addValue(item.getSoLuongDaBan(), "Đơn hàng", item.getNgayBan());
            }
        }
         
         JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê số lượng đơn hàng đã bán".toUpperCase(),
                "Thời gian", "Số lượng",
                dataSet, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
//    public void setDataToChart2(JPanel jpnItem) {
//        List<HoaDonBean> listItem = service.getListByHoaDon();
//
//        TaskSeriesCollection ds = new TaskSeriesCollection();
//        JFreeChart ganttChart = ChartFactory.createGanttChart(
//                "BIỂU ĐỒ THEO DÕI TÌNH TRẠNG KHÓA HỌC",
//                "Khóa học", "Thời gian", ds, true, false, false
//        );
//
//        TaskSeries taskSeries;
//        Task task;
//
//        if (listItem != null) {
//            for (HoaDonBean item : listItem) {
//                taskSeries = new TaskSeries(item.getTen_khoa_hoc());
//                task = new Task(item.getTen_khoa_hoc(), new SimpleTimePeriod(item.getNgay_bat_dau(), item.getNgay_ket_thuc()));
//                taskSeries.add(task);
//                ds.add(taskSeries);
//            }
//        }
//
//        ChartPanel chartPanel = new ChartPanel(ganttChart);
//        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));
//
//        jpnItem.removeAll();
//        jpnItem.setLayout(new CardLayout());
//        jpnItem.add(chartPanel);
//        jpnItem.validate();
//        jpnItem.repaint();
//    }
}
