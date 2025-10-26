package OOP;


public class ThuongNhanVien {
    public void tinhThuong() {
        NhanVien[] ds = NhanVien.dsNV;

        if (ds == null || ds.length == 0) {
            System.out.println("Chưa có dữ liệu");
            return;
        }
         System.out.println("\n=== DANH SÁCH NHÂN VIÊN ĐƯỢC THƯỞNG ===\n");

        // In tiêu đề bảng
        System.out.printf("%-25s| %-15s| %-15s| %-15s\n",
                "Họ tên", "Chức vụ", "Doanh thu", "Tiền thưởng");
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
            System.out.println("Không có nhân viên nào được thưởng");
            }
        }
    }
