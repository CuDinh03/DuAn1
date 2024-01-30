package duan1_nhom1.utils;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Uhelper {

    public static Boolean checkNull(JTextField txt, String mess) {

        if (txt.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static Boolean checkKyTuDacBiet(JTextField txt, String mess) {

        if (txt.getText().matches("[@#$%^&*()_+=|<>?{}\\[\\]~`-[!]]+")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static Boolean checkText(JTextField txt, String mess) {

        if (txt.getText().trim().matches("[@#$%^&*()_+=|<>?{}\\[\\]~`-[!]]+")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static Boolean checkSDT(JTextField txt, String mess) {

        if (!txt.getText().trim().matches("[0-9]{10}")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static Boolean checkDate(JDateChooser date, String mess) {

        if (date.equals(null)) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static Boolean checkTime(Date date1, Date date2, String mess) {

        if (!((date1.before(date2)) || (date1.equals(date2)))) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }

        return false;
    }

    public static Boolean checkNumber(JTextField txt, String mess) {

        if (!txt.getText().matches("[0-9]+") || txt.getText().matches("[\s]+")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static Boolean checkSoLuong(JTextField txt, String mess) {

        if (Integer.parseInt(txt.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static Boolean checkPhanTramKM(JTextField txt, String mess) {

        if ((Integer.parseInt(txt.getText()) < 0) || (Integer.parseInt(txt.getText()) > 100)) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static Boolean checkKiTuDacBiet(JTextField txt, String mess) {
        if (!txt.getText().trim().matches("[a-zA-Z0-9]+")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static Boolean checkEmail(JTextField txt, String mess) {
        if (!txt.getText().trim().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }
}
