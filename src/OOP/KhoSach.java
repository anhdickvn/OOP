package OOP;

import java.util.Scanner;

public class KhoSach {
	private Sach[] ds;
	private int soLuongSachKho;

	public KhoSach() {
	}

	public KhoSach(Sach[] ds, int soLuongSachKho) {
		this.ds = ds;
		this.soLuongSachKho = soLuongSachKho;
	}

	public Sach[] getDs() {
		return ds;
	}

	public void setDs(Sach[] ds) {
		this.ds = ds;
	}

	public int getSoLuongSachKho() {
		return soLuongSachKho;
	}

	public void setSoLuongSachKho(int soLuongSachKho) {
		this.soLuongSachKho = soLuongSachKho;
	}

	public void nhapDS() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong sach trong kho: ");
		int soLuongSach = sc.nextInt();
		ds = new Sach[soLuongSach];
		sc.nextLine();
		for (int i = 0; i < soLuongSach; i++) {
			System.out.println("Sach thu " + (i + 1) + ": ");
			ds[i] = new Sach();
			ds[i].nhap();
		}
	}

	public void xuatDS() {
		System.out.println("\n==================== DANH SÁCH SÁCH TRONG KHO ====================");
		System.out.printf("%-10s %-25s %-15s %-15s %-15s %-10s %-10s %-15s %-15s\n", "ID Sách", "Tên Sách",
				"ID Tác Giả", "ID Thể Loại", "ID NXB", "Năm XB", "Số Lượng", "Giá Gốc", "Giá Sau Thuế");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < ds.length; i++) {
			ds[i].xuat();
		}
	}
}
