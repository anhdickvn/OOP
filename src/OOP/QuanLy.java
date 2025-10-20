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
	public void nhapThongTin() {
		super.nhapThongTin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ID quan ly: ");
		idQuanLy = sc.nextLine();
		System.out.print("Nhap luong: ");
		luong = sc.nextDouble();
		sc.nextLine();
		System.out.print("Nhap khu lam viec: ");
		khuLamViec = sc.nextLine();
	}

	@Override
	public void hienThiThongTin() {
		System.out.println("=== Thong tin Quan Ly ===");
		super.hienThiThongTin();
		System.out.println("ID Quan Ly: " + idQuanLy);
		System.out.println("Luong: " + luong);
		System.out.println("Khu lam viec: " + khuLamViec);
	}
}
