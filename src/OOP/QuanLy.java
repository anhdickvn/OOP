package OOP;

import java.util.Scanner;

public class QuanLy extends ConNguoi {
	private String idQuanLy;
	private double luong;
	private String khuLamViec;

	public QuanLy() {
	}

	public QuanLy(String hoTen, String maDinhDanh, String ngaySinh, String diaChi, String soDienThoai, String idQuanLy,
			double luong, String khuLamViec) {
		super(hoTen, maDinhDanh, ngaySinh, diaChi, soDienThoai);
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

	@Override
	public static void xuatQuanLy() {
    QuanLy dsQL[] = new QuanLy[0];
    try {
        BufferedReader br = new BufferedReader(new FileReader("QuanLy.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] st = line.split(";");

            QuanLy ql = new QuanLy(
                st[0],st[1],st[2],st[3],st[4],  // Thuộc tính con người               
                st[5],                 // idQuanLy
                Double.parseDouble(st[6]), // luong
                st[7]                  // khuLamViec
            );

            dsQL = java.util.Arrays.copyOf(dsQL, dsQL.length + 1);
            dsQL[dsQL.length - 1] = ql;
        }
        br.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    System.out.printf("%-20s| %-15s| %-12s| %-15s| %-12s| %-10s| %-12s| %-15s\n",
        "Ho Ten", "Ma Dinh Danh", "Ngay Sinh", "Dia Chi", "SDT",
        "ID QL", "Luong", "Khu Lam Viec");
    System.out.println("-----------------------------------------------------------------------------------------------------------");
    for (QuanLy ql : dsQL) {
        System.out.println(ql);
    }
}
@Override
public String toString() {
    return String.format("%-20s| %-15s| %-12s| %-15s| %-12s| %-10s| %-12.0f| %-15s",
        getHoTen(), getMaDinhDanh(), getNgaySinh(), getDiaChi(), getSoDienThoai(),
        idQuanLy, luong, khuLamViec);
}
}
