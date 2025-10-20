package OOP;

import java.util.Scanner;

class KhachHangThuong extends KhachHang {
	private int soLanMua;

	public KhachHangThuong() {
	}

	public KhachHangThuong(String hoTen, String maDinhDanh, String ngaySinh, String diaChi, String soDienThoai,
			String idKhachHang, int soLanMua) {
		super(hoTen, maDinhDanh, ngaySinh, diaChi, soDienThoai, idKhachHang);
		this.soLanMua = soLanMua;
	}

	public int getSoLanMua() {
		return soLanMua;
	}

	public void setSoLanMua(int soLanMua) {
		this.soLanMua = soLanMua;
	}

	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so lan mua hang: ");
		soLanMua = sc.nextInt();
	}

	@Override
	public void hienThiThongTin() {
		System.out.println("=== Khach Hang Thuong ===");
		super.hienThiThongTin();
		System.out.println("So lan mua: " + soLanMua);
	}
}
