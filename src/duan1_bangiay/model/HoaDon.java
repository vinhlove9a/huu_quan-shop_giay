/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_bangiay.model;

/**
 *
 * @author Vinh
 */
import java.math.BigDecimal;
import java.util.Date;

public class HoaDon {

    private int id;               // Primary Key
    private int idNhanVien;       // Foreign Key referencing NhanVien
    private int idKhachHang;      // Foreign Key referencing KhachHang
    private int idPhieuGiamGia;   // Foreign Key referencing PhieuGiamGia
    private BigDecimal tongTien;  // Total Amount
    private BigDecimal giamGia;   // Discount Amount
    private Date ngayTao;         // Creation Date
    private BigDecimal thanhTien; // Final Amount
    private boolean trangThai;    // Status (Paid/Unpaid)
    // Additional fields for names
    private String tenKhachHang;
    private String tenNhanVien;

    // Getters and Setters for the names
    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    // Constructor (no-argument)
    public HoaDon() {
    }

    // Constructor (with arguments)
    public HoaDon(int id, int idNhanVien, int idKhachHang, int idPhieuGiamGia,
            BigDecimal tongTien, BigDecimal giamGia, Date ngayTao,
            BigDecimal thanhTien, boolean trangThai) {
        this.id = id;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.idPhieuGiamGia = idPhieuGiamGia;
        this.tongTien = tongTien;
        this.giamGia = giamGia;
        this.ngayTao = ngayTao;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdPhieuGiamGia() {
        return idPhieuGiamGia;
    }

    public void setIdPhieuGiamGia(int idPhieuGiamGia) {
        this.idPhieuGiamGia = idPhieuGiamGia;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public BigDecimal getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(BigDecimal giamGia) {
        this.giamGia = giamGia;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    // Override toString for debugging/logging purposes
    @Override
    public String toString() {
        return "HoaDon{"
                + "id=" + id
                + ", idNhanVien=" + idNhanVien
                + ", idKhachHang=" + idKhachHang
                + ", idPhieuGiamGia=" + idPhieuGiamGia
                + ", tongTien=" + tongTien
                + ", giamGia=" + giamGia
                + ", ngayTao=" + ngayTao
                + ", thanhTien=" + thanhTien
                + ", trangThai=" + (trangThai ? "Đã thanh toán" : "Chưa thanh toán")
                + '}';
    }
}
