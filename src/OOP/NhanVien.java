package OOP;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class NhanVien extends ConNguoi {
     public static NhanVien[] dsNV = new NhanVien[0];
	private String idNhanVien;
	private double luong;
	private String chucVu;
	private String ca;
	private double doanhThu;

	public NhanVien() {
	}

	public NhanVien(String hoTen, String maDinhDanh, String ngaySinh, String diaChi, String soDienThoai,
			String idNhanVien, double luong, String chucVu, String ca, double doanhThu) {
		super(hoTen, maDinhDanh, ngaySinh, diaChi, soDienThoai);
		this.idNhanVien = idNhanVien;
		this.luong = luong;
		this.chucVu = chucVu;
		this.ca = ca;
		this.doanhThu = doanhThu;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	public String getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(String idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

 public static void xuatNhanVien() {
     dsNV = new NhanVien[0];
    try {
        BufferedReader br = new BufferedReader(new FileReader("NhanVien.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] st = line.split(";");
            NhanVien nv = new NhanVien(
                st[0], st[1], st[2], st[3], st[4],    // Thuộc tính ConNguoi
                st[5],                                // idNhanVien
                Double.parseDouble(st[6]),            // luong
                st[7],                                // chucVu
                st[8],                                // ca
                Double.parseDouble(st[9])             // doanhThu
            );
            dsNV = java.util.Arrays.copyOf(dsNV, dsNV.length + 1);
            dsNV[dsNV.length - 1] = nv;
        }
        br.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
	System.out.println("===DANH SÁCH NHÂN VIÊN==="); 
 	System.out.printf("%-20s| %-15s| %-12s| %-10s| %-7s| %-7s| %-10s| %-10s| %-5s| %-12s\n",
        "Họ Tên", "Ma Định Danh", "Ngày Sinh", "Địa chỉ", "SĐT", 
        "ID NV", "Lương", "Chức vụ", "Ca", "Doanh Thu");
    System.out.println("-----------------------------------------------------------------------------------------------------------");
    for (NhanVien nv : dsNV) {
        System.out.println(nv);
    }
}
@Override
public String toString() {
    return String.format("%-20s| %-15s| %-12s| %-10s| %-7s| %-7s| %-10.0f| %-10s| %-5s| %-12.0f",
        getHoTen(), getMaDinhDanh(), getNgaySinh(), getDiaChi(), getSoDienThoai(),
        idNhanVien, luong, chucVu, ca, doanhThu);
}
}
