package OOP;

import java.util.Scanner;

public class ThongKeNhanVien {
	private NhanVien[] dsNhanVien;

	public ThongKeNhanVien() {
	}

	public ThongKeNhanVien(NhanVien[] dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public NhanVien[] getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(NhanVien[] dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public void nhapThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong nhan vien: ");
		int n = sc.nextInt();
		sc.nextLine();
		dsNhanVien = new NhanVien[n];
		for (int i = 0; i < n; i++) {
			System.out.println("\nNhap thong tin nhan vien " + (i + 1) + ":");
			dsNhanVien[i] = new NhanVien();
			dsNhanVien[i].nhapThongTin();
		}
	}

	public void hienThiThongKe() {
		System.out.println("\nThong ke nhan vien:");
		System.out.println("\nDanh sach nhan vien:");
		for (NhanVien nv : dsNhanVien)
			nv.hienThiThongTin();
		;
	}
}