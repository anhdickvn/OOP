package OOP;

public class OOP {
	public static void main(String[] args) {
		Sach.xuatKho();
		ThongKeNhanVien tk = new ThongKeNhanVien();
ThuongNhanVien thuong = new ThuongNhanVien();
NhanVien.xuatNhanVien();
QuanLy.xuatQuanLy();
tk.thongKeNhanVienTheoDoanhThu();
tk.thongKeTheoChucVu();
tk.thongKeTuoiTangDan();
thuong.tinhThuong();
DanhSachConNguoi.ChucNangNhanVien();
DanhSachConNguoi.ChucNangQuanLy();
	}
}
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== QUẢN LÝ KHÁCH HÀNG =====");
            System.out.println("1. Xem danh sách khách hàng");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Sửa khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Tìm kiếm khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> xuat();
                case "2" -> them();
                case "3" -> sua();
                case "4" -> xoa();
                case "5" -> timKiem();
                case "0" -> { System.out.println("👋 Thoát chương trình!"); return; }
                default -> System.out.println("⚠️ Lựa chọn không hợp lệ!");
            }
        }
    }

