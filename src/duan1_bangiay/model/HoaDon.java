/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_bangiay.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HoaDon {

    private int id; // Primary key
    private int idNhanVien; // Foreign key
    private int idKhachHang; // Foreign key
    private int idPhieuGiamGia; // Foreign key
    private String maHoaDon; // Unique identifier
    private BigDecimal tongTien; // Total amount
    private BigDecimal giamGia; // Discount
    private LocalDateTime ngayTao; // Creation date
    private BigDecimal thanhTien; // Final amount
    private boolean trangThai; // Status (active/inactive)

    // Constructors
    public HoaDon() {
    }

    public HoaDon(int id, int idNhanVien, int idKhachHang, int idPhieuGiamGia, String maHoaDon, BigDecimal tongTien,
            BigDecimal giamGia, LocalDateTime ngayTao, BigDecimal thanhTien, boolean trangThai) {
        this.id = id;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.idPhieuGiamGia = idPhieuGiamGia;
        this.maHoaDon = maHoaDon;
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

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
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

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
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

    @Override
    public String toString() {
        return "HoaDon{"
                + "id=" + id
                + ", idNhanVien=" + idNhanVien
                + ", idKhachHang=" + idKhachHang
                + ", idPhieuGiamGia=" + idPhieuGiamGia
                + ", maHoaDon='" + maHoaDon + '\''
                + ", tongTien=" + tongTien
                + ", giamGia=" + giamGia
                + ", ngayTao=" + ngayTao
                + ", thanhTien=" + thanhTien
                + ", trangThai=" + trangThai
                + '}';
    }
}
