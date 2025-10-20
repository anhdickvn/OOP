package OOP;

import java.util.Scanner;

public abstract class ConNguoi {
	private String hoTen;
	private String maDinhDanh;
	private String ngaySinh;
	private String diaChi;
	private String soDienThoai;

	public ConNguoi() {
	}

	public ConNguoi(String hoTen, String maDinhDanh, String ngaySinh, String diaChi, String soDienThoai) {
		this.hoTen = hoTen;
		this.maDinhDanh = maDinhDanh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMaDinhDanh() {
		return maDinhDanh;
	}

	public void setMaDinhDanh(String maDinhDanh) {
		this.maDinhDanh = maDinhDanh;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public void nhapThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ho va ten: ");
		hoTen = sc.nextLine();
		System.out.print("Nhap Ma Dinh Danh: ");
		maDinhDanh = sc.nextLine();
		System.out.print("Nhap ngay sinh: ");
		ngaySinh = sc.nextLine();
		System.out.print("Nhap dia chi: ");
		diaChi = sc.nextLine();
		System.out.print("Nhap so dien thoai: ");
		soDienThoai = sc.nextLine();
	}

	public void hienThiThongTin() {
		System.out.println("Ho va Ten: " + hoTen);
		System.out.println("Ma Dinh Danh: " + maDinhDanh);
		System.out.println("Ngay Sinh: " + ngaySinh);
		System.out.println("Dia Chi: " + diaChi);
		System.out.println("So Dien Thoai: " + soDienThoai);
	}
}
