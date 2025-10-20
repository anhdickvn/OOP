package OOP;

public class OOP {
	public static void main(String[] args) {
		ThongKeNhanVien thongKe = new ThongKeNhanVien();
		thongKe.nhapThongTin(); // nhập thông tin nv
		ThuongNhanVien thuong = new ThuongNhanVien();
		thuong.tinhThuong(thongKe); // thưởng nhân viên
		KhachHangThuong khThuong = new KhachHangThuong();
		KhachHangVIP khVIP = new KhachHangVIP();

		System.out.println("Nhap thong tin khach hang thuong:");
		khThuong.nhapThongTin();

		System.out.println("\nNhap thong tin khach hang VIP:");
		khVIP.nhapThongTin();

		System.out.println("\n=== DANH SACH KHACH HANG ===");
		khThuong.hienThiThongTin();
		khVIP.hienThiThongTin();
		KhoSach kho = new KhoSach();
		HoaDon hoaDon = new HoaDon();
		kho.nhapDS(); // nhập kho sách
		kho.xuatDS(); // xuất kho sách
		hoaDon.nhapHoaDon(kho);
		hoaDon.xuatHoaDon();
	}
}
