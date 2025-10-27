package OOP;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class QuanLy extends ConNguoi {
    public static QuanLy[] dsQL = new QuanLy[0];
	private String idQuanLy;
	private double luong;
	private String khuLamViec;

	public QuanLy() {
	}

	public QuanLy(String hoTen, String ngaySinh, String diaChi, String soDienThoai, String idQuanLy,
			double luong, String khuLamViec) {
		super(hoTen, ngaySinh, diaChi, soDienThoai);
		this.idQuanLy = idQuanLy;
		this.luong = luong;
		this.khuLamViec = khuLamViec;
	}

	public String getIdQuanLy() {
		return idQuanLy;
	}

	public void setIdQuanLy(String idQuanLy) {
		this.idQuanLy = idQuanLy;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public String getKhuLamViec() {
		return khuLamViec;
	}

	public void setKhuLamViec(String khuLamViec) {
		this.khuLamViec = khuLamViec;
	}

  
    public static void ghiFileQuanLy(QuanLy[] danhSach) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("QuanLy.txt"))) {
        for (QuanLy ql : danhSach) {
            String line = ql.getHoTen() + ";" + ql.getNgaySinh() + ";" + ql.getDiaChi() + ";" + ql.getSoDienThoai() + ";" +
                          ql.getIdQuanLy() + ";" + ql.getLuong() + ";" + ql.getKhuLamViec();
            bw.write(line);
            bw.newLine();
        }
    } catch (Exception e) {
        System.out.println(" Lỗi khi ghi file: " + e.getMessage());
    }
}

  public static void xuatQuanLy() {
    dsQL = new QuanLy[0];
    try {
        BufferedReader br = new BufferedReader(new FileReader("QuanLy.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] st = line.split(";");

            QuanLy ql = new QuanLy(
                st[0],st[1],st[2],st[3],  // Thuộc tính con người               
                st[4],                 // idQuanLy
                Double.parseDouble(st[5]), // luong
                st[6]                  // khuLamViec
            );

            dsQL = java.util.Arrays.copyOf(dsQL, dsQL.length + 1);
            dsQL[dsQL.length - 1] = ql;
        }
        br.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
	System.out.println("===DANH SÁCH QUẢN LÝ===");
    System.out.printf("%-20s| %-12s| %-15s| %-12s| %-10s| %-12s| %-15s\n",
        "Họ Tên", "Ngày Sinh", "Địa Chỉ", "SĐT", "ID QL", "Lương", "Khu Làm Việc");
    System.out.println("-----------------------------------------------------------------------------------------------------------");
    for (QuanLy ql : dsQL) {
        System.out.println(ql);
    }
}
@Override
public String toString() {
    return String.format("%-20s| %-12s| %-15s| %-12s| %-10s| %-12.0f| %-15s",
        getHoTen(), getNgaySinh(), getDiaChi(), getSoDienThoai(),
        idQuanLy, luong, khuLamViec);
}			
}
