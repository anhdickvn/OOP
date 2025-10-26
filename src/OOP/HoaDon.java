package OOP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.UUID;

public class HoaDon {
	private String idHoaDon;
	private String idKhachHang;
	private String idCTKM;
	private String ngayInPhieu;
	private int soLuong;
	private double tongTien;
	private Sach[] dsSach;
	private int[] dsSoLuong;

	public void nhapHoaDon() {
		Scanner sc = new Scanner(System.in);

		idHoaDon = "HD" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
		System.out.println("Mã hóa đơn được tạo tự động: " + idHoaDon);

		System.out.print("Nhập ID khách hàng: ");
		idKhachHang = sc.nextLine();

		System.out.print("Nhập mã CTKM (không có thì ấn enter để bỏ qua): ");
		idCTKM = sc.nextLine();

		KhachHangVIP[] dsVIP = KhachHangVIP.docFile();
		KhachHangVIP khVIP = null;
		for (KhachHangVIP kh : dsVIP) {
			if (kh.getIdKhachHang().equalsIgnoreCase(idKhachHang)) {
				khVIP = kh;
				break;
			}
		}

		Sach[] kho = Sach.docKho();
		System.out.println("================================== Sách trong kho ==================================");
		for (int i = 0; i < kho.length; i++) {
			System.out.printf("%d. %-35s | Giá: %-8.0f VND | SL: %d\n", i + 1, kho[i].getTenSach(), kho[i].getGia(),
					kho[i].getSoLuong());
		}

		System.out.print("Khách mua bao nhiêu loại sách? ");
		int n = Integer.parseInt(sc.nextLine());
		dsSach = new Sach[n];
		dsSoLuong = new int[n];
		tongTien = 0;
		soLuong = 0;

		for (int i = 0; i < n; i++) {
			int chon;
			while (true) {
				System.out.print("Chọn số thứ tự sách muốn mua: ");
				chon = Integer.parseInt(sc.nextLine()) - 1;

				if (chon < 0 || chon >= kho.length) {
					System.out.println("Sách không tồn tại! Vui lòng chọn lại.");
					continue;
				}

				if (kho[chon].getSoLuong() == 0) {
					System.out.println("Sản phẩm này đã hết hàng! Vui lòng chọn sách khác.");
					continue;
				}

				break;
			}

			int sl;
			while (true) {
				System.out.print("Nhập số lượng mua: ");
				sl = Integer.parseInt(sc.nextLine());
				if (sl <= 0)
					System.out.println("Số lượng không hợp lệ! Phải lớn hơn 0.");
				else if (sl > kho[chon].getSoLuong())
					System.out.println("Không đủ hàng! Trong kho chỉ còn " + kho[chon].getSoLuong());
				else
					break;
			}

			dsSach[i] = kho[chon];
			dsSoLuong[i] = sl;
			soLuong += sl;
			tongTien += kho[chon].getGia() * sl;

			int soLuongMoi = kho[chon].getSoLuong() - sl;
			kho[chon].setSoLuong(soLuongMoi);
			capNhatSoLuongTrongFile(kho[chon].getIdSach(), soLuongMoi);
		}

		ngayInPhieu = java.time.LocalDate.now().toString();

		System.out.println("\n=== HÓA ĐƠN ===");
		System.out.println("Mã HĐ: " + idHoaDon);
		System.out.println("Ngày in phiếu: " + ngayInPhieu);
		System.out.println("Tổng SL: " + soLuong);
		System.out.println("Tổng tiền (chưa thuế): " + tongTien + " VND");

		double tongSauGiam = tongTien;
		if (khVIP != null) {
			System.out.println("Khách hàng VIP được giảm: " + khVIP.getMucGiamGia() + "%");
			tongSauGiam = tongTien * (1 - khVIP.getMucGiamGia() / 100);
		}

		double tongTienSauThue = tongSauGiam * 1.08;
		System.out.println("Thuế VAT: 8%");
		System.out.println("Tổng tiền sau thuế: " + tongTienSauThue + " VND");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("hoadon.txt", true));
			bw.write("=========================================\n");
			bw.write("MÃ HÓA ĐƠN: " + idHoaDon + "\n");
			bw.write("NGÀY IN PHIẾU: " + ngayInPhieu + "\n");
			bw.write("ID KHÁCH HÀNG: " + idKhachHang + "\n");
			bw.write("MÃ CTKM: " + (idCTKM.isEmpty() ? "Không có" : idCTKM) + "\n");
			bw.write("TỔNG SỐ LƯỢNG: " + soLuong + "\n");
			bw.write("TỔNG TIỀN (CHƯA THUẾ): " + tongTien + " VND\n");
			bw.write("THUẾ VAT: 8%\n");
			bw.write("TỔNG TIỀN SAU THUẾ: " + tongTienSauThue + " VND\n");
			if (khVIP != null)
				bw.write("GIẢM GIÁ KH VIP: " + khVIP.getMucGiamGia() + "%\n");
			bw.write("=========================================\n\n");
			bw.close();
			System.out.println("Đã ghi đầy đủ hóa đơn vào file hoadon.txt");
		} catch (Exception e) {
			System.out.println("Lỗi khi ghi hóa đơn: " + e.getMessage());
		}
	}

	private void capNhatSoLuongTrongFile(String idSach, int soLuongMoi) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("sach.txt"));
			String noiDungMoi = "";
			String line;

			while ((line = br.readLine()) != null) {
				String[] parts = line.split(";");
				if (parts[0].equals(idSach)) {
					parts[4] = String.valueOf(soLuongMoi);
					line = String.join(";", parts);
				}
				noiDungMoi += line + "\n";
			}
			br.close();

			BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));
			bw.write(noiDungMoi);
			bw.close();

		} catch (Exception e) {
			System.out.println("Lỗi cập nhật kho: " + e.getMessage());
		}
	}
}
