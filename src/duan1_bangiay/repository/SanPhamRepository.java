/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_bangiay.repository;

import duan1_bangiay.model.SanPham;
import duan1_bangiay.utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {

    public List<Object[]> getAllSanPham() {
        List<Object[]> dataList = new ArrayList<>();
        String sql = "SELECT ROW_NUMBER() OVER (ORDER BY sp.ID) AS STT, "
                + "sp.MaSanPham, sp.TenSanPham, th.TenTH AS ThuongHieu, "
                + "ctp.DonGia AS GiaBan, ctp.SoLuong, kt.TenKT AS Size, ms.TenMS AS MauSac "
                + "FROM SanPham sp "
                + "JOIN ChiTietSanPham ctp ON sp.IDChiTietSanPham = ctp.ID "
                + "JOIN ThuongHieu th ON ctp.IDThuongHieu = th.ID "
                + "JOIN KichThuoc kt ON ctp.IDKichThuoc = kt.ID "
                + "JOIN MauSac ms ON ctp.IDMauSac = ms.ID";

        try (Connection connection = DBConnect.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getInt("STT"),
                    rs.getString("MaSanPham"),
                    rs.getString("TenSanPham"),
                    rs.getString("ThuongHieu"),
                    rs.getBigDecimal("GiaBan"),
                    rs.getInt("SoLuong"),
                    rs.getString("Size"),
                    rs.getString("MauSac")
                };
                dataList.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public List<Object[]> searchSanPham(String keyword) {
        List<Object[]> searchResults = new ArrayList<>();
        String sql = "SELECT ROW_NUMBER() OVER (ORDER BY sp.ID) AS STT, "
                + "sp.MaSanPham, sp.TenSanPham, th.TenTH AS ThuongHieu, "
                + "ctp.DonGia AS GiaBan, ctp.SoLuong, kt.TenKT AS Size, ms.TenMS AS MauSac "
                + "FROM SanPham sp "
                + "JOIN ChiTietSanPham ctp ON sp.IDChiTietSanPham = ctp.ID "
                + "JOIN ThuongHieu th ON ctp.IDThuongHieu = th.ID "
                + "JOIN KichThuoc kt ON ctp.IDKichThuoc = kt.ID "
                + "JOIN MauSac ms ON ctp.IDMauSac = ms.ID "
                + "WHERE sp.MaSanPham LIKE ? OR sp.TenSanPham LIKE ?";

        try (Connection connection = DBConnect.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            // Use wildcard to perform partial matches
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getInt("STT"), // Serial Number
                    rs.getString("MaSanPham"), // Product Code
                    rs.getString("TenSanPham"), // Product Name
                    rs.getString("ThuongHieu"), // Brand
                    rs.getBigDecimal("GiaBan"), // Price
                    rs.getInt("SoLuong"), // Quantity
                    rs.getString("Size"), // Size
                    rs.getString("MauSac") // Color
                };
                searchResults.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchResults;
    }
}
