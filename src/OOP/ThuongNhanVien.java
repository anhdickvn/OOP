package OOP;

import java.util.Scanner;

public class ThuongNhanVien {
	private double soTienThuong;

	public ThuongNhanVien() {
	}

	public double getSoTienThuong() {
		return soTienThuong;
	}

	public void setSoTienThuong(double soTienThuong) {
		this.soTienThuong = soTienThuong;
	}

	public void tinhThuong(ThongKeNhanVien tk) {
		if (tk == null || tk.getDsNhanVien() == null || tk.getDsNhanVien().length == 0) {
			System.out.println("Chua co du lieu nhan vien!");
			return;
		}

		Scanner sc = new Scanner(System.in);

		System.out.println("\n=== DANH SACH NHAN VIEN DUOC THUONG ===");
		boolean coNhanVienThuong = false;

		for (NhanVien nv : tk.getDsNhanVien()) {
			double doanhThuNV = nv.getDoanhThu();

			if (doanhThuNV > 100000000) {
				soTienThuong = doanhThuNV * 0.1;
				coNhanVienThuong = true;

				nv.hienThiThongTin();
				System.out.println("Doanh thu: " + doanhThuNV);
				System.out.println(">> So Tien Thuong: " + soTienThuong);
				System.out.println("--------------------------------");
			}
		}

		if (!coNhanVienThuong) {
			System.out.println("Nhan vien Phe");
		}
	}
}