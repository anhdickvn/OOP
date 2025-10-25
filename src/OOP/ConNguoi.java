package OOP;

import java.util.Scanner;

abstract class ConNguoi {
	private String hoTen;
	private String ngaySinh;
	private String diaChi;
	private String soDienThoai;

	public ConNguoi() {
	}

	public ConNguoi(String hoTen, String ngaySinh, String diaChi, String soDienThoai) {
		this.hoTen = hoTen;
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
		System.out.print("Nhap ho ten: ");
		hoTen = sc.nextLine();
		System.out.print("Nhap ngay sinh: ");
		ngaySinh = sc.nextLine();
		System.out.print("Nhap dia chi: ");
		diaChi = sc.nextLine();
		System.out.print("Nhap so dien thoai: ");
		soDienThoai = sc.nextLine();
	}

	public void hienThiThongTin() {
		System.out.println("Ho ten: " + hoTen);
		System.out.println("Ngay sinh: " + ngaySinh);
		System.out.println("Dia chi: " + diaChi);
		System.out.println("So dien thoai: " + soDienThoai);
	}
}
