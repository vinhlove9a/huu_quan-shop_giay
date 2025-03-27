/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_bangiay.repository;

import duan1_bangiay.model.ChiTietHoaDon;
import duan1_bangiay.utils.DBConnect;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinh
 */
public class HoaDonChiTietRepository {

    public List<Object[]> fetchOrderDetailsFromDatabase(String maDonHang) {
        List<Object[]> orderDetails = new ArrayList<>();
        String sql = "SELECT ROW_NUMBER() OVER (ORDER BY cthd.ID) AS STT, "
                + "sp.TenSanPham AS TenHangHoa, cthd.DonGia, cthd.SoLuong, "
                + "(cthd.DonGia * cthd.SoLuong) AS ThanhTien "
                + "FROM ChiTietHoaDon cthd "
                + "JOIN SanPham sp ON cthd.IDSanPham = sp.ID "
                + "JOIN HoaDon hd ON cthd.IDHoaDon = hd.ID "
                + "WHERE hd.MaHoaDon = ?";

        try (Connection connection = DBConnect.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, maDonHang);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] row = new Object[]{
                        rs.getInt("STT"), // Serial Number
                        rs.getString("TenHangHoa"), // Product Name
                        rs.getBigDecimal("DonGia"), // Unit Price
                        rs.getInt("SoLuong"), // Quantity
                        rs.getBigDecimal("ThanhTien") // Total Price
                    };
                    orderDetails.add(row);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching order details: " + e.getMessage());
        }

        return orderDetails;
    }

    public void saveProductToInvoice(String maDonHang, String maSanPham, int soLuong, BigDecimal donGia) {
        String sql = "INSERT INTO ChiTietHoaDon (IDHoaDon, IDSanPham, SoLuong, DonGia) "
                + "VALUES ((SELECT ID FROM HoaDon WHERE MaHoaDon = ?), "
                + "(SELECT ID FROM SanPham WHERE MaSanPham = ?), ?, ?)";
        try (Connection connection = DBConnect.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, maDonHang);
            ps.setString(2, maSanPham);
            ps.setInt(3, soLuong);
            ps.setBigDecimal(4, donGia);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
