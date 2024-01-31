package duan1_nhom1.model;

<<<<<<< HEAD
import java.util.Date;

public class Khach {
     private String id;
=======
import java.util.UUID;
import java.sql.Date;

/**
 *
 * @author maccuacu
 */
public class Khach {
    private UUID id;
>>>>>>> 5e7e693 (prive khách hàng)
    private String maKhachHang;
    private String tenKhachHang;
    private String sdt;
    private Date ngayTao;
    private Date ngaySua;
    private Boolean trangThai;

<<<<<<< HEAD
    public Khach() { 
    }

    public Khach(String id, String maKhachHang, String tenKhachHang, String sdt, Date ngayTao, Date ngaySua, Boolean trangThai) {
=======
    public Khach() {
    }

    public Khach(UUID id, String maKhachHang, String tenKhachHang, String sdt, Date ngayTao, Date ngaySua, Boolean trangThai) {
>>>>>>> 5e7e693 (prive khách hàng)
        this.id = id;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }
<<<<<<< HEAD
    public String getId() {
        return id;
    }

    public void setId(String id) {
=======

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
>>>>>>> 5e7e693 (prive khách hàng)
        this.id = id;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
<<<<<<< HEAD
=======
    
    
>>>>>>> 5e7e693 (prive khách hàng)
    
}
