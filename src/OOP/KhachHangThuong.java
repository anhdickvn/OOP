package OOP;

import java.io.*;
import java.util.*;

class KhachHangThuong extends KhachHang {
    private int soLanMua;

    public KhachHangThuong() {}

    public KhachHangThuong(String hoTen, String ngaySinh, String diaChi, String soDienThoai,
                           String idKhachHang, int soLanMua) {
        super(hoTen, ngaySinh, diaChi, soDienThoai, idKhachHang);
        this.soLanMua = soLanMua;
    }

    public int getSoLanMua() {
        return soLanMua;
    }

    public void setSoLanMua(int soLanMua) {
        this.soLanMua = soLanMua;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so lan mua hang: ");
        soLanMua = sc.nextInt();
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("\n=== Khach Hang Thuong ===");
        super.hienThiThongTin();
        System.out.println("So lan mua: " + soLanMua);
    }

    public static List<KhachHangThuong> docTuFile() {
        String fileName = "khachhangthuong.txt";
        List<KhachHangThuong> danhSach = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String hoTen = parts[0];
                    String ngaySinh = parts[1];
                    String diaChi = parts[2];
                    String soDienThoai = parts[3];
                    String idKhachHang = parts[4];
                    int soLanMua = Integer.parseInt(parts[5]);
                    danhSach.add(new KhachHangThuong(hoTen, ngaySinh, diaChi, soDienThoai, idKhachHang, soLanMua));
                }
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
        return danhSach;
    }
}
