package OOP;




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
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

	public NhanVien(String hoTen, String ngaySinh, String diaChi, String soDienThoai,
			String idNhanVien, double luong, String chucVu, String ca, double doanhThu) {
		super(hoTen, ngaySinh, diaChi, soDienThoai);
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

    public static void NhapNhanVien() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhập số lượng nhân viên muốn thêm: ");
    int n = Integer.parseInt(sc.nextLine());

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("NhanVien.txt", true))) { // true = ghi nối tiếp
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập nhân viên thứ " + (i + 1) + " ---");
            System.out.print("Họ tên: ");
            String hoTen = sc.nextLine();
            System.out.print("Ngày sinh: ");
            String ngaySinh = sc.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = sc.nextLine();
            System.out.print("Số điện thoại: ");
            String soDT = sc.nextLine();
            System.out.print("ID nhân viên: ");
            String id = sc.nextLine();
            System.out.print("Lương: ");
            double luong = Double.parseDouble(sc.nextLine());
            System.out.print("Chức vụ: ");
            String chucVu = sc.nextLine();
            System.out.print("Ca làm: ");
            String ca = sc.nextLine();
            System.out.print("Doanh thu: ");
            double doanhThu = Double.parseDouble(sc.nextLine());

            String line = hoTen + ";" + ngaySinh + ";" + diaChi + ";" + soDT + ";" +
                          id + ";" + luong + ";" + chucVu + ";" + ca + ";" + doanhThu;
            bw.write(line);
            bw.newLine();
        }
        System.out.println(" Ghi file thành công vào NhanVien.txt");
    } catch (Exception e) {
        System.out.println(" Lỗi khi ghi file: " + e.getMessage());
    }
}

 public static void xuatNhanVien() {
     dsNV = new NhanVien[0];
    try {
        BufferedReader br = new BufferedReader(new FileReader("NhanVien.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] st = line.split(";");
            NhanVien nv = new NhanVien(
                st[0], st[1], st[2], st[3],     // Thuộc tính ConNguoi
                st[4],                                // idNhanVien
                Double.parseDouble(st[5]),            // luong
                st[6],                                // chucVu
                st[7],                                // ca
                Double.parseDouble(st[8])             // doanhThu
            );
            dsNV = java.util.Arrays.copyOf(dsNV, dsNV.length + 1);
            dsNV[dsNV.length - 1] = nv;
        }
        br.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
	System.out.println("===DANH SÁCH NHÂN VIÊN==="); 
 	System.out.printf("%-20s|%-12s| %-10s| %-7s| %-7s| %-10s| %-10s| %-5s| %-12s\n",
        "Họ Tên", "Ngày Sinh", "Địa chỉ", "SĐT", 
        "ID NV", "Lương", "Chức vụ", "Ca", "Doanh Thu");
    System.out.println("-----------------------------------------------------------------------------------------------------------");
    for (NhanVien nv : dsNV) {
        System.out.println(nv);
    }
}
@Override
public String toString() {
    return String.format("%-20s|%-12s| %-10s| %-7s| %-7s| %-10.0f| %-10s| %-5s| %-12.0f",
        getHoTen(), getNgaySinh(), getDiaChi(), getSoDienThoai(),
        idNhanVien, luong, chucVu, ca, doanhThu);
}
}
