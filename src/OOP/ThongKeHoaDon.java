import java.util.Scanner;

public class ThongKeHoaDon {
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

        // Dùng mảng tạm để cộng dồn theo từng sách
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

