package OOP;

import java.util.Scanner;

public class NhanVien extends ConNguoi {
	private String idNhanVien;
	private double luong;
	private String chucVu;
	private String ca;
	private double doanhThu;

	public NhanVien() {
	}

	public NhanVien(String hoTen, String maDinhDanh, String ngaySinh, String diaChi, String soDienThoai,
			String idNhanVien, double luong, String chucVu, String ca, double doanhThu) {
		super(hoTen, maDinhDanh, ngaySinh, diaChi, soDienThoai);
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

	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ID Nhan Vien: ");
		idNhanVien = sc.nextLine();
		System.out.print("Nhap luong: ");
		luong = Double.parseDouble(sc.nextLine());
		System.out.print("Nhap chuc vu: ");
		chucVu = sc.nextLine();
		System.out.print("Nhap ca lam viec: ");
		ca = sc.nextLine();
		System.out.print("Nhap doanh thu: ");
		doanhThu = sc.nextDouble();
		sc.nextLine();
	}

	@Override
	public void hienThiThongTin() {
		System.out.println("=== Thong tin Nhan Vien ===");
		super.hienThiThongTin();
		System.out.println("ID Nhan Vien: " + idNhanVien);
		System.out.println("Luong: " + luong);
		System.out.println("Chuc vu: " + chucVu);
		System.out.println("Ca lam viec: " + ca);
		System.out.println("Doanh Thu: " + doanhThu);
	}
}