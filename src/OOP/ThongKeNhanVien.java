Package OOP;
import java.util.Scanner;

public class ThongKeNhanVien {
    

    public NhanVien[] getDsNhanVien() {
        return NhanVien.dsNV;
    }

    // ================== THỐNG KÊ THEO DOANH THU ==================
    public void thongKeNhanVienTheoDoanhThu() {
        NhanVien[] dsNhanVien = getDsNhanVien();
        if (dsNhanVien == null || dsNhanVien.length == 0) {
            System.out.println("Chua co du lieu nhan vien!");
            return;
        }

        // Sắp xếp tăng dần theo Doanh thu
        for (int i = 0; i < dsNhanVien.length - 1; i++) {
            for (int j = 0; j < dsNhanVien.length - 1 - i; j++) {
                if (dsNhanVien[j].getDoanhThu() > dsNhanVien[j + 1].getDoanhThu()) {
                    NhanVien temp = dsNhanVien[j];
                    dsNhanVien[j] = dsNhanVien[j + 1];
                    dsNhanVien[j + 1] = temp;
                }
            }
        }
        System.out.println("===THONG KE NHAN VIEN CO DOANH THU TANG DAN===");
        System.out.printf("\n%-15s| %-20s| %-15s| %-15s| %-10s\n",
        "Mã NV", "Họ tên", "Chức vụ", "Ngày sinh", "Doanh thu");
        System.out.println("------------------------------------------------------------------------------------------");

        for (NhanVien nv : dsNhanVien) {
            System.out.printf("%-15s| %-20s| %-15s| %-15s| %-10.2f\n",
                    nv.getIdNhanVien(),
                    nv.getHoTen(),
                    nv.getChucVu(),
                    nv.getNgaySinh(),
                    nv.getDoanhThu());
        }

    }

    public void thongKeTuoiTangDan() {
        NhanVien[] dsNhanVien = getDsNhanVien();
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
        System.out.printf("\n%-15s| %-20s| %-15s| %-15s| %-10s\n",
        "Mã NV", "Họ tên", "Ngày sinh", "Chức vụ", "Tuổi");
        System.out.println("------------------------------------------------------------------------");
        for (NhanVien nv : dsNhanVien) {
            int tuoi = namHienTai - tachNamTuNgaySinh(nv.getNgaySinh());
            System.out.printf("%-15s| %-20s| %-15s| %-15s| %-10d\n",
            nv.getIdNhanVien(),
            nv.getHoTen(),
            nv.getNgaySinh(),
            nv.getChucVu(),
            tuoi);
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
            return java.time.LocalDate.now().getYear();
        }
    }

    public void thongKeTheoChucVu() {
        NhanVien[] dsNhanVien = getDsNhanVien();
        if (dsNhanVien == null || dsNhanVien.length == 0) {
            System.out.println("Chua co du lieu nhan vien!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuc vu can thong ke (VD: Bao ve, Thu ngan, Ban hang): ");
        String cv = sc.nextLine();

        boolean timThay = false;
        System.out.println("\n=== DANH SACH NHAN VIEN CO CHUC VU: " + cv.toUpperCase() + " ===");
        System.out.printf("\n%-15s| %-20s| %-15s| %-15s\n",
        "Mã NV", "Họ tên", "Chức vụ", "Ngày sinh");
        System.out.println("--------------------------------------------------------------");

        for (NhanVien nv : dsNhanVien) {
            if (nv.getChucVu() != null && nv.getChucVu().equalsIgnoreCase(cv)) {
                System.out.printf("%-15s| %-20s| %-15s| %-15s\n",
                nv.getIdNhanVien(),
                nv.getHoTen(),
                nv.getChucVu(),
                nv.getNgaySinh());
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong co nhan vien nao giu chuc vu: " + cv);
        }

    }
}

