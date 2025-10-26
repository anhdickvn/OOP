package OOP;


public class ThuongNhanVien {
    public void tinhThuong() {
        NhanVien[] ds = NhanVien.dsNV;

        if (ds == null || ds.length == 0) {
            System.out.println("Chua co du lieu");
            return;
        }
         System.out.println("\n=== DANH SACH NHAN VIEN DUOC THUONG ===\n");

        // In tiêu đề bảng
        System.out.printf("%-25s| %-15s| %-15s| %-15s\n",
                "Ho ten", "Chuc vu", "Doanh thu", "Tien thuong");
        System.out.println("---------------------------------------------------------------------");
        boolean coNhanVienThuong = false;

        for (NhanVien nv : ds) {
            double doanhThuNV = nv.getDoanhThu();

            if (doanhThuNV > 1000000) {
                double tienThuong = doanhThuNV * 0.1;
                coNhanVienThuong = true;

                System.out.printf("%-25s| %-15s| %-15.1f| %-15.1f\n",
                        nv.getHoTen(), nv.getChucVu(), doanhThuNV, tienThuong);
        }
    }

        if (!coNhanVienThuong) {
            System.out.println("Khong co nhan vien nao duoc nhan thuong");
            }
        }
    }
