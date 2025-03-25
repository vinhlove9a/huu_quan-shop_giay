/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_bangiay.repository;

import duan1_bangiay.model.HoaDon;
import duan1_bangiay.utils.DBConnect;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Vinh
 */
public class HoaDonRepository {

    public List<HoaDon> getUnpaidInvoices() {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String query = "SELECT ID, IDNhanVien, IDKhachHang, IDPhieuGiamGia, NgayTao, TongTien, GiamGia, ThanhTien, TrangThai "
                + "FROM HoaDon WHERE TrangThai = 0";

        try (Connection connection = DBConnect.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(resultSet.getInt("ID"));
                hoaDon.setIdNhanVien(resultSet.getInt("IDNhanVien"));
                hoaDon.setIdKhachHang(resultSet.getInt("IDKhachHang"));
                hoaDon.setIdPhieuGiamGia(resultSet.getInt("IDPhieuGiamGia"));
                hoaDon.setNgayTao(resultSet.getTimestamp("NgayTao"));
                hoaDon.setTongTien(resultSet.getBigDecimal("TongTien"));
                hoaDon.setGiamGia(resultSet.getBigDecimal("GiamGia"));
                hoaDon.setThanhTien(resultSet.getBigDecimal("ThanhTien"));
                hoaDon.setTrangThai(resultSet.getBoolean("TrangThai"));

                hoaDonList.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDonList;
    }

    public List<HoaDon> getPaidInvoices() {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String query = "SELECT ID, IDNhanVien, IDKhachHang, IDPhieuGiamGia, NgayTao, TongTien, GiamGia, ThanhTien, TrangThai "
                + "FROM HoaDon WHERE TrangThai = 1";

        try (Connection connection = DBConnect.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(resultSet.getInt("ID"));
                hoaDon.setIdNhanVien(resultSet.getInt("IDNhanVien"));
                hoaDon.setIdKhachHang(resultSet.getInt("IDKhachHang"));
                hoaDon.setIdPhieuGiamGia(resultSet.getInt("IDPhieuGiamGia"));
                hoaDon.setNgayTao(resultSet.getTimestamp("NgayTao"));
                hoaDon.setTongTien(resultSet.getBigDecimal("TongTien"));
                hoaDon.setGiamGia(resultSet.getBigDecimal("GiamGia"));
                hoaDon.setThanhTien(resultSet.getBigDecimal("ThanhTien"));
                hoaDon.setTrangThai(resultSet.getBoolean("TrangThai"));

                hoaDonList.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDonList;
    }
    public HoaDon getHoaDonWithNames(int hoaDonId) {
    String query = "SELECT hd.ID, hd.IDNhanVien, hd.IDKhachHang, hd.NgayTao, hd.TongTien, hd.GiamGia, hd.ThanhTien, hd.TrangThai, " +
                   "kh.TenKhachHang, nv.TenNhanVien " +
                   "FROM HoaDon hd " +
                   "JOIN KhachHang kh ON hd.IDKhachHang = kh.ID " +
                   "JOIN NhanVien nv ON hd.IDNhanVien = nv.ID " +
                   "WHERE hd.ID = ?";

    try (Connection connection = DBConnect.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.setInt(1, hoaDonId);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(resultSet.getInt("ID"));
                hoaDon.setIdNhanVien(resultSet.getInt("IDNhanVien"));
                hoaDon.setIdKhachHang(resultSet.getInt("IDKhachHang"));
                hoaDon.setNgayTao(resultSet.getTimestamp("NgayTao"));
                hoaDon.setTongTien(resultSet.getBigDecimal("TongTien"));
                hoaDon.setGiamGia(resultSet.getBigDecimal("GiamGia"));
                hoaDon.setThanhTien(resultSet.getBigDecimal("ThanhTien"));
                hoaDon.setTrangThai(resultSet.getBoolean("TrangThai"));

                // Fill the names
                hoaDon.setTenKhachHang(resultSet.getString("TenKhachHang"));
                hoaDon.setTenNhanVien(resultSet.getString("TenNhanVien"));

                return hoaDon;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
}
