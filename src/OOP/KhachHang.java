package OOP;

import java.util.Scanner;

public class KhachHang extends ConNguoi {
	private String idKhachHang;

	public KhachHang() {
	}

	public KhachHang(String hoTen, String maDinhDanh, String ngaySinh, String diaChi, String soDienThoai,
			String idKhachHang) {
		super(hoTen, maDinhDanh, ngaySinh, diaChi, soDienThoai);
		this.idKhachHang = idKhachHang;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ID khach hang: ");
		idKhachHang = sc.nextLine();
	}

	@Override
	public void hienThiThongTin() {
		System.out.println("=== Thong tin khach hang ===");
		super.hienThiThongTin();
		System.out.println("ID khach hang: " + idKhachHang);
	}
}
