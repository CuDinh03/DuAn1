/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.controller;

import duan1_nhom1.bean.HoaDonBean;
import duan1_nhom1.dto.NgayThangDto;
import duan1_nhom1.service.ThongKeImp;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.Month;
import static java.time.Month.JANUARY;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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

    public void setDataToChart1(JPanel jpnItem, Year selectYear) {
        List<HoaDonBean> listItem = service.getListByHoaDon();
        Map<Month, Integer> frequencyTable = new TreeMap<>();
        if (listItem != null) {
            for (HoaDonBean item : listItem) {
                if (item.getNgayBan().getYear() == selectYear.getValue()) {
                    Month thang = item.getNgayBan().getMonth();
                    frequencyTable.put(thang, frequencyTable.getOrDefault(thang, 0) + 1);
                }
            }
        }
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (Map.Entry<Month, Integer> entry : frequencyTable.entrySet()) {
            Month thang = entry.getKey();
            int soLuong = entry.getValue();
            dataSet.addValue(soLuong, "Đơn tháng", thang);
        }

        JFreeChart barChart = ChartFactory.createBarChart(("Biểu đồ thống kê số lượng đơn hàng đã bán trong năm " + selectYear.getValue()).toUpperCase(),
                "Tháng", "Số lượng",
                dataSet, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }

    public void setDataToChart2(JPanel jpnItem, Month selectedMonth, Year selectYear) {
        String thang = null;
        switch (selectedMonth) {
            case JANUARY:
                thang = "1";
                break;
            case FEBRUARY:
                thang = "2";
                break;
            case MARCH:
                thang = "3";
                break;
            case APRIL:
                thang = "4";
                break;
            case MAY:
                thang = "5";
                break;
            case JUNE:
                thang = "6";
                break;
            case JULY:
                thang = "7";
                break;
            case AUGUST:
                thang = "8";
                break;
            case SEPTEMBER:
                thang = "9";
                break;
            case OCTOBER:
                thang = "10";
                break;
            case NOVEMBER:
                thang = "11";
                break;
            case DECEMBER:
                thang = "12";
                break;
            default:
                break;

        }
        List<HoaDonBean> listItem = service.getListByHoaDon();
        Map<Integer, Integer> dailySales = new HashMap<>();

        if (listItem != null) {
            for (HoaDonBean item : listItem) {
                if (item.getNgayBan().getMonth() == selectedMonth && item.getNgayBan().getYear() == selectYear.getValue()) {
                    int ngay = item.getNgayBan().getDayOfMonth();

                    dailySales.put(ngay, item.getSoLuongDaBan());

                }
            }
        }
        Map<Integer, Integer> sortedDailySales = new TreeMap<>(dailySales);

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (Map.Entry<Integer, Integer> entry : sortedDailySales.entrySet()) {
            int ngay = entry.getKey();
            int soLuong = entry.getValue();
            dataSet.addValue(soLuong, "Đơn hàng", String.valueOf(ngay));  // Chuyển sang String để sử dụng như category
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                ("Biểu đồ thống kê số lượng đơn hàng đã bán trong tháng " + thang + " năm " + selectYear.getValue()).toUpperCase(),
                "Ngày", "Số lượng",
                dataSet, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }

}
