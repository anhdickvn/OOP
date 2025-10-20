import java.util.Scanner;

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

