package OOP;


import java.io.*;
import java.util.*;

class KhachHang extends ConNguoi {
	private String idKhachHang;

	public KhachHang() {
		docTuFile("khachhang.txt");
	}

	public KhachHang(String hoTen, String ngaySinh, String diaChi, String soDienThoai, String idKhachHang) {
		super(hoTen, ngaySinh, diaChi, soDienThoai);
		this.idKhachHang = idKhachHang;
		docTuFile("khachhang.txt");
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	@Override
	public void nhapThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ID khach hang: ");
		idKhachHang = sc.nextLine();
		super.nhapThongTin();
	}

	@Override
	public void hienThiThongTin() {
		System.out.println("ID khach hang: " + idKhachHang);
		super.hienThiThongTin();
	}
	private void docTuFile(String tenFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
			String line;
			System.out.println("\n=== DANH SACH KHACH HANG TU FILE ===");
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(";");
				if (parts.length == 5) {
					String id = parts[0];
					String hoTen = parts[1];
					String ngaySinh = parts[2];
					String diaChi = parts[3];
					String soDienThoai = parts[4];

					System.out.println("---------------------------");
					System.out.println("ID khach hang: " + id);
					System.out.println("Ho ten: " + hoTen);
					System.out.println("Ngay sinh: " + ngaySinh);
					System.out.println("Dia chi: " + diaChi);
					System.out.println("So dien thoai: " + soDienThoai);
				}
			}
			System.out.println("---------------------------\n");
		} catch (IOException e) {
			System.out.println("Loi khi doc file: " + e.getMessage());
		}
	}
}
