

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
    soLuongSachKho = soLuongSach;
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

 class ThongKeHoaDon {
    private HoaDon[] dsHoaDon;
    private int soLuongHoaDon;

    public ThongKeHoaDon() {}

    public ThongKeHoaDon(HoaDon[] dsHoaDon, int soLuongHoaDon) {
        this.dsHoaDon = dsHoaDon;
        this.soLuongHoaDon = soLuongHoaDon;
    }

    public void nhapDSHoaDon(KhoSach kho) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng hóa đơn: ");
        soLuongHoaDon = sc.nextInt();
        sc.nextLine();
        dsHoaDon = new HoaDon[soLuongHoaDon];
        for (int i = 0; i < soLuongHoaDon; i++) {
            System.out.println("=== Nhập hóa đơn thứ " + (i + 1) + " ===");
            dsHoaDon[i] = new HoaDon();
            dsHoaDon[i].nhapHoaDon(kho);
        }
    }

    public void thongKeTheoThang() {
        if (dsHoaDon == null || soLuongHoaDon == 0) {
            System.out.println("Chưa có dữ liệu hóa đơn!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tháng cần thống kê (1-12): ");
        int thang = sc.nextInt();
        System.out.print("Nhập năm cần thống kê (ví dụ: 2025): ");
        int nam = sc.nextInt();

        System.out.println("\n=== THỐNG KÊ SÁCH BÁN THÁNG " + thang + "/" + nam + " ===");
        System.out.printf("%-10s %-25s %-10s %-15s\n", "ID Sách", "Tên Sách", "SL Bán", "Doanh Thu");

        boolean coDuLieu = false;

        String[] idSachTK = new String[100];
        String[] tenSachTK = new String[100];
        int[] soLuongBanTK = new int[100];
        double[] doanhThuTK = new double[100];
        int dem = 0;

        for (int i = 0; i < soLuongHoaDon; i++) {
            HoaDon hd = dsHoaDon[i];
            if (hd.getNgayInPhieu() == null || hd.getNgayInPhieu().isEmpty()) continue;

            String[] parts = hd.getNgayInPhieu().split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);

            if (month == thang && year == nam) {
                coDuLieu = true;
                Sach[] dsSach = hd.getDsSach();
                int[] dsSoLuong = hd.getDsSoLuong();

                for (int j = 0; j < dsSach.length; j++) {
                    String id = dsSach[j].getIdSach();
                    String ten = dsSach[j].getTenSach();
                    int sl = dsSoLuong[j];
                    double tien = dsSach[j].getGia() * sl;

                    boolean daCo = false;
                    for (int k = 0; k < dem; k++) {
                        if (idSachTK[k].equals(id)) {
                            soLuongBanTK[k] += sl;
                            doanhThuTK[k] += tien;
                            daCo = true;
                            break;
                        }
                    }

                    if (!daCo) {
                        idSachTK[dem] = id;
                        tenSachTK[dem] = ten;
                        soLuongBanTK[dem] = sl;
                        doanhThuTK[dem] = tien;
                        dem++;
                    }
                }
            }
        }

        if (!coDuLieu) {
            System.out.println("Không có dữ liệu hóa đơn trong tháng này!");
            return;
        }

        for (int i = 0; i < dem; i++) {
            System.out.printf("%-10s %-25s %-10d %-15.2f\n",
                    idSachTK[i], tenSachTK[i], soLuongBanTK[i], doanhThuTK[i]);
        }
    }
}
class ThongKeThangBanSach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== 1. Nhập kho sách =====
        KhoSach kho = new KhoSach();
        kho.nhapDS();  // nhập từ bàn phím

        // ===== 2. Nhập danh sách hóa đơn =====
        System.out.print("Nhập số lượng hóa đơn cần nhập: ");
        int soHD = sc.nextInt();
        sc.nextLine();
        HoaDon[] dsHD = new HoaDon[soHD];

        for (int i = 0; i < soHD; i++) {
            System.out.println("\n=== Nhập hóa đơn thứ " + (i + 1) + " ===");
            dsHD[i] = new HoaDon();
            dsHD[i].nhapHoaDon(kho);
        }

        // ===== 3. Thống kê theo tháng =====
        ThongKeHoaDon tk = new ThongKeHoaDon(dsHD, soHD);
        tk.thongKeTheoThang();

        sc.close();
    }
}
