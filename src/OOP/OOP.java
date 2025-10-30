package OOP;

import java.util.Scanner;

public class OOP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] usernames = { "admin", "nhanvien", "khachhang" };
		String[] passwords = { "123", "123", "123" };
		String[] roles = { "quanly", "nhanvien", "khachhang" };

		String role = "";
		String user, pass;

		do {
			System.out.print("Nhập tài khoản: ");
			user = sc.nextLine();

			System.out.print("Nhập mật khẩu: ");
			pass = sc.nextLine();

			role = "";
			for (int i = 0; i < usernames.length; i++) {
				if (user.equals(usernames[i]) && pass.equals(passwords[i])) {
					role = roles[i];
					break;
				}
			}

			if (role.equals("")) {
				System.out.println("❌ Sai tài khoản hoặc mật khẩu! Vui lòng thử lại.\n");
			}

		} while (role.equals(""));
		System.out.println("\n✅ Đăng nhập thành công với vai trò: " + role.toUpperCase());
		boolean running = true;
		System.out.print("Nhập ID: ");
		String ID = sc.nextLine();
		while (running) {
			switch (role) {
			case "quanly":
				int chonQL;
				do {
					System.out.println("===== MENU QUẢN LÝ =====");
					System.out.println("1. Quản lý nhân viên");
					System.out.println("2. Quản lý sách");
					System.out.println("3. Xem doanh thu");
					System.out.println("0. Quay lại (Đăng xuất)");
					System.out.print("Chọn: ");
					chonQL = sc.nextInt();
					sc.nextLine();
					System.out.println();

					switch (chonQL) {
					case 1:
						System.out.println("→ Bạn đã chọn: Quản lý nhân viên");
						break;
					case 2:
						System.out.println("→ Bạn đã chọn: Quản lý sách");
						break;
					case 3:
						System.out.println("→ Bạn đã chọn: Xem doanh thu");
						break;
					case 0:
						System.out.println("→ Quay lại màn hình đăng nhập...");
						break;
					default:
						System.out.println("Lựa chọn không hợp lệ!");
						break;
					}

					System.out.println();
				} while (chonQL != 0);
				break;

			case "nhanvien":
				int choice;
				do {
					System.out.println("===Nhân viên vui lòng chọn 1 chức năng===");
					System.out.println("1. Chỉnh sửa thông tin nhân viên ");
					System.out.println("2. Xem thông tin sách trong kho ");
					System.out.println("3. Tìm Sách");
					System.out.println("4. Chỉnh Sửa Sách");
					System.out.println("5. Tạo hóa đơn");
					System.out.println("6. Sửa hóa đơn");
					System.out.println("7. Duyệt đơn hàng");
					System.out.println("0. Thoát");
					choice = Integer.parseInt(sc.nextLine());
					switch (choice) {
					case 1:
						System.out.println("Bạn đã chọn Chỉnh sửa thông tin nhân viên");
						NhanVien.chinhSuaNhanVien();
						break;
					case 2:
						System.out.println("Bạn đã chọn Xem thông tin sách trong kho");
						Sach.xuatKho();
						break;
					case 3:
						System.out.println("Bạn đã chọn Tìm sách");
						Sach.menuTimKiem(ID);
						break;
					case 4:
						System.out.println("Bạn đã chọn Sửa thông tin sách");
						Sach.SuaSach();
						break;
					case 5:
						System.out.println("Bạn đã chọn Tạo hóa đơn mới");
						HoaDon.lapHoaDonTuDonHang();
						break;
					case 6:
						System.out.println("Bạn đã chọn Sửa thông tin hóa đơn");
						HoaDon.suaHoaDon();
						break;
					case 7:
						System.out.println("Bạn đã chọn Duyệt đơn hàng");
						HoaDon.duyetDonHang();
						break;
					case 0:
						System.out.println(" Đang lưu dữ liệu...");
						System.out.println(" Cập nhật thành công!");
						break;
					default:
						System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
					}
				} while (choice != 0);
				break;

			case "khachhang":
				int chonKH;
				do {
					System.out.println("\n===== MENU KHÁCH HÀNG =====");
					System.out.println("1. Xem sách");
					System.out.println("2. Đặt Hàng");
					System.out.println("3. Xem hóa đơn của tôi");
					System.out.println("4. Thay đổi thông tin cá nhân");
					System.out.println("0. Quay lại (Đăng xuất)");
					System.out.print("Chọn: ");
					chonKH = sc.nextInt();
					sc.nextLine();

					switch (chonKH) {
					case 1:
						Sach.xuatKho();
						break;

					case 2:
						Sach.menuTimKiem(ID);
						break;

					case 3:
						System.out.println("→ Chức năng xem hóa đơn cá nhân (đọc từ file hoadon.txt)");
						KhachHang.xuatHoaDonTheoID(ID);
						break;

					case 4:
						System.out.println("4. Thay đổi thông tin cá nhân");
						KhachHang.suaTheoID(ID);

					case 0:
						System.out.println("→ Quay lại màn hình đăng nhập...");
						break;

					default:
						System.out.println("❌ Lựa chọn không hợp lệ!");
						break;
					}

				} while (chonKH != 0);
				break;
			}

			System.out.print("Chọn: ");
			int chon = sc.nextInt();
			sc.nextLine();

			if (chon == 0) {
				System.out.println("Đăng xuất thành công!");
				running = false;
			} else {
				System.out.println("→ Bạn đã chọn chức năng " + chon);
			}
		}

		sc.close();
	}
}
