package OOP;

import java.util.Scanner;

public class KhachHangVIP extends KhachHang {
	private double mucGiamGia;
	private int diemTichLuy;

	public KhachHangVIP() {
	}

	public KhachHangVIP(String hoTen, String maDinhDanh, String ngaySinh, String diaChi, String soDienThoai,
			String idKhachHang, double mucGiamGia, int diemTichLuy) {
		super(hoTen, maDinhDanh, ngaySinh, diaChi, soDienThoai, idKhachHang);
		this.mucGiamGia = mucGiamGia;
		this.diemTichLuy = diemTichLuy;
	}

	public double getMucGiamGia() {
		return mucGiamGia;
	}

	public void setMucGiamGia(double mucGiamGia) {
		this.mucGiamGia = mucGiamGia;
	}

	public int getDiemTichLuy() {
		return diemTichLuy;
	}

	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}

	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap muc giam gia (%): ");
		mucGiamGia = sc.nextDouble();
		System.out.print("Nhap diem tich luy: ");
		diemTichLuy = sc.nextInt();
	}

	@Override
	public void hienThiThongTin() {
		System.out.println("=== Khach Hang VIP ===");
		super.hienThiThongTin();
		System.out.println("Muc giam gia: " + mucGiamGia + "%");
		System.out.println("Diem tich luy: " + diemTichLuy);
	}
}