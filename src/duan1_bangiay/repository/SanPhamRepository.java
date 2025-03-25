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

    public List<SanPham> getAll() {
        List<SanPham> sanPhamList = new ArrayList<>();
        String query = "SELECT sp.MaSanPham, sp.TenSanPham, th.TenTH AS ThuongHieu, "
                + "ctsp.DonGia AS GiaBan, ctsp.SoLuong, kt.TenKT AS Size, ms.TenMS AS MauSac "
                + "FROM SanPham sp "
                + "JOIN ChiTietSanPham ctsp ON sp.IDChiTietSanPham = ctsp.ID "
                + "JOIN ThuongHieu th ON ctsp.IDThuongHieu = th.ID "
                + "JOIN KichThuoc kt ON ctsp.IDKichThuoc = kt.ID "
                + "JOIN MauSac ms ON ctsp.IDMauSac = ms.ID";

        try (Connection connection = DBConnect.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            int stt = 1; // Serial number
            while (resultSet.next()) {
                SanPham sanPham = new SanPham(
                        stt++, // Serial number
                        resultSet.getString("MaSanPham"), // Product Code
                        resultSet.getString("TenSanPham"), // Product Name
                        resultSet.getString("ThuongHieu"), // Brand
                        resultSet.getBigDecimal("GiaBan"), // Price
                        resultSet.getInt("SoLuong"), // Quantity
                        resultSet.getString("Size"), // Size
                        resultSet.getString("MauSac") // Color
                );

                sanPhamList.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhamList;
    }

    public List<SanPham> searchSanPham(String searchText) {
        List<SanPham> sanPhamList = new ArrayList<>();
        String query = "SELECT sp.MaSanPham, sp.TenSanPham, th.TenTH AS ThuongHieu, "
                + "ctsp.DonGia AS GiaBan, ctsp.SoLuong, kt.TenKT AS Size, ms.TenMS AS MauSac "
                + "FROM SanPham sp "
                + "JOIN ChiTietSanPham ctsp ON sp.IDChiTietSanPham = ctsp.ID "
                + "JOIN ThuongHieu th ON ctsp.IDThuongHieu = th.ID "
                + "JOIN KichThuoc kt ON ctsp.IDKichThuoc = kt.ID "
                + "JOIN MauSac ms ON ctsp.IDMauSac = ms.ID "
                + "WHERE sp.MaSanPham LIKE ? OR sp.TenSanPham LIKE ?";

        try (Connection connection = DBConnect.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, "%" + searchText + "%"); // Search by MaSanPham
            preparedStatement.setString(2, "%" + searchText + "%"); // Search by TenSanPham

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    SanPham sanPham = new SanPham(
                            0, // STT will be added in the view
                            resultSet.getString("MaSanPham"),
                            resultSet.getString("TenSanPham"),
                            resultSet.getString("ThuongHieu"),
                            resultSet.getBigDecimal("GiaBan"),
                            resultSet.getInt("SoLuong"),
                            resultSet.getString("Size"),
                            resultSet.getString("MauSac")
                    );
                    sanPhamList.add(sanPham);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhamList;
    }
}
