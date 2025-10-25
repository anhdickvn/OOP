package OOP;


public class ThuongNhanVien {
    public void tinhThuong() {
        NhanVien[] ds = NhanVien.dsNV;

        if (ds == null || ds.length == 0) {
            System.out.println("Chua co du lieu");
            return;
        }

        System.out.println("\n=== DANH SACH NHAN VIEN DUOC THUONG ===");
        boolean coNhanVienThuong = false;

        for (NhanVien nv : ds) {
            double doanhThuNV = nv.getDoanhThu();

            if (doanhThuNV > 1000000) {
                double tienThuong = doanhThuNV * 0.1;
                coNhanVienThuong = true;

                System.out.println("Ho ten: " + nv.getHoTen());
                System.out.println("Chuc vu: " + nv.getChucVu());
                System.out.println("Doanh thu: " + doanhThuNV);
                System.out.println("Tien thuong: " + tienThuong);
                System.out.println("--------------------------------");
            }
        }

        if (!coNhanVienThuong) {
            System.out.println("Khong co nhan vien nao duoc nhan thuong");
        }
    }
