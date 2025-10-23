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
	}
	
public void thongKeNhanVienTheoDoanhThu() {
    if (dsNhanVien == null || dsNhanVien.length == 0) {
        System.out.println("Chua co du lieu nhan vien!");
        return;
    }

    NhanVien[] sapXep = dsNhanVien.clone();

    for (int i = 0; i < sapXep.length - 1; i++) {
        for (int j = 0; j < sapXep.length - 1 - i; j++) {
            if (sapXep[j].getDoanhThu() > sapXep[j + 1].getDoanhThu()) {
                NhanVien temp = sapXep[j];
                sapXep[j] = sapXep[j + 1];
                sapXep[j + 1] = temp;
            }
        }
    }

    System.out.println("\n=== DANH SACH NHAN VIEN THEO DOANH THU TANG DAN ===");
    for (NhanVien nv : sapXep) {
        nv.hienThiThongTin();
        System.out.println(">> Doanh thu: " + nv.getDoanhThu());
        System.out.println("--------------------------------");
    }
}
public void thongKeTheoChucVu() {
    if (dsNhanVien == null || dsNhanVien.length == 0) {
        System.out.println("Chua co du lieu nhan vien!");
        return;
    }

    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap chuc vu can thong ke (VD: Bao ve, Thu ngan, Ban hang): ");
    String cv = sc.nextLine();

    boolean timThay = false;
    System.out.println("\n=== DANH SACH NHAN VIEN CO CHUC VU: " + cv.toUpperCase() + " ===");

    for (NhanVien nv : dsNhanVien) {
        if (nv.getChucVu() != null && nv.getChucVu().equalsIgnoreCase(cv)) {
            nv.hienThiThongTin();
            System.out.println("--------------------------------");
            timThay = true;
        }
    }

    if (!timThay) {
        System.out.println("Khong co nhan vien nao giu chuc vu: " + cv);
    }
}
public void thongKeTuoiTangDan() {
    if (dsNhanVien == null || dsNhanVien.length == 0) {
        System.out.println("Chua co du lieu nhan vien!");
        return;
    }

    int namHienTai = java.time.LocalDate.now().getYear();

    for (int i = 0; i < dsNhanVien.length - 1; i++) {
        for (int j = 0; j < dsNhanVien.length - 1 - i; j++) {
            int tuoi1 = namHienTai - tachNamTuNgaySinh(dsNhanVien[j].getNgaySinh());
            int tuoi2 = namHienTai - tachNamTuNgaySinh(dsNhanVien[j + 1].getNgaySinh());
            
            if (tuoi1 > tuoi2) { 
                NhanVien temp = dsNhanVien[j];
                dsNhanVien[j] = dsNhanVien[j + 1];
                dsNhanVien[j + 1] = temp;
            }
        }
    }

    System.out.println("\n=== DANH SACH NHAN VIEN SAP XEP TUOI TANG DAN ===");
    for (NhanVien nv : dsNhanVien) {
        int tuoi = namHienTai - tachNamTuNgaySinh(nv.getNgaySinh());
        nv.hienThiThongTin();
        System.out.println("Tuoi: " + tuoi);
        System.out.println("--------------------------------");
    }
}

private int tachNamTuNgaySinh(String ngaySinh) {
    try {
        if (ngaySinh.contains("/")) {
            String[] parts = ngaySinh.split("/");
            return Integer.parseInt(parts[2]); 
        } else {
            return Integer.parseInt(ngaySinh);
        }
    } catch (Exception e) {
        System.out.println("Loi dinh dang ngay sinh: " + ngaySinh);
        return java.time.LocalDate.now().getYear(); 
    	}
	}
}
