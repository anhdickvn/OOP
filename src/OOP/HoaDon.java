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
		System.out.println("Mã hóa đơn tự động: " + idHoaDon);

		System.out.print("Nhập ID khách hàng: ");
		idKhachHang = sc.nextLine();

		System.out.print("Nhập mã CTKM (Enter nếu không có): ");
		idCTKM = sc.nextLine();

		Sach[] kho = Sach.docKho();
		System.out.println("========== Sách trong kho ==========");
		for (int i = 0; i < kho.length; i++) {
			System.out.printf("%d. %-30s | Giá: %-8.0f VND | SL: %d\n", i + 1, kho[i].getTenSach(), kho[i].getGia(),
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
					System.out.println("❌ Không tồn tại!");
					continue;
				}
				if (kho[chon].getSoLuong() == 0) {
					System.out.println("❌ Hết hàng!");
					continue;
				}
				break;
			}

			int sl;
			while (true) {
				System.out.print("Nhập số lượng mua: ");
				sl = Integer.parseInt(sc.nextLine());
				if (sl <= 0) {
					System.out.println("❌ Số lượng phải > 0!");
				} else if (sl > kho[chon].getSoLuong()) {
					System.out.println("❌ Không đủ hàng! Còn " + kho[chon].getSoLuong());
				} else
					break;
			}

			dsSach[i] = kho[chon];
			dsSoLuong[i] = sl;
			soLuong += sl;
			tongTien += kho[chon].getGia() * sl;

			int slMoi = kho[chon].getSoLuong() - sl;
			kho[chon].setSoLuong(slMoi);
			capNhatSoLuongTrongFile(kho[chon].getIdSach(), slMoi);
		}

		ngayInPhieu = java.time.LocalDate.now().toString();
		double tongSauGiam = tongTien;

		// ===== CTKM =====
		ChuongTrinhKM kmHopLe = null;
		if (!idCTKM.isEmpty()) {
			ChuongTrinhKM[] dsKM = ChuongTrinhKM.docFile();
			boolean timThay = false;
			String today = java.time.LocalDate.now().toString();

			for (ChuongTrinhKM km : dsKM) {
				if (km.getIdCTKM().equalsIgnoreCase(idCTKM)) {
					timThay = true;
					if (today.compareTo(km.getNgayBatDau()) >= 0 && today.compareTo(km.getNgayKetThuc()) <= 0) {
						kmHopLe = km;
						break;
					} else {
						System.out.println("❌ Mã CTKM đã hết hạn!");
					}
				}
			}
			if (!timThay) {
				System.out.println("❌ Không tìm thấy mã CTKM này!");
			}
			if (kmHopLe != null) {
				System.out.println("Áp dụng CTKM: " + kmHopLe.getPhanTramKhuyenMai() + "%");
				tongSauGiam -= kmHopLe.tinhGiamGia(tongTien);
			}
		}

		// ===== GIẢM GIÁ KH =====
		KhachHang kh = new KhachHang();
		kh.setTongChiTieu(tongTien);
		double mucGiam = kh.getMucGiamGia();
		if (mucGiam > 0) {
			System.out.println("Giảm giá KH: " + mucGiam + "%");
			tongSauGiam *= (1 - mucGiam / 100);
		}

		double tongTienSauThue = tongSauGiam * 1.08;

		System.out.println("\n=========== HÓA ĐƠN ===========");
		System.out.println("Mã HĐ: " + idHoaDon);
		System.out.println("Ngày in: " + ngayInPhieu);
		System.out.println("Tổng SL: " + soLuong);
		System.out.printf("Tổng tiền (chưa thuế): %.0f VND\n", tongTien);
		if (kmHopLe != null)
			System.out.println("Giảm CTKM: " + kmHopLe.getPhanTramKhuyenMai() + "%");
		System.out.printf("Giảm KH: %.2f%%\n", mucGiam);
		System.out.printf("Tổng sau giảm: %.0f VND\n", tongSauGiam);
		System.out.println("Thuế VAT: 8%");
		System.out.printf("Tổng tiền sau thuế: %.0f VND\n", tongTienSauThue);
		System.out.println("==============================");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("hoadon.txt", true));
			bw.write("=========================================\n");
			bw.write("MÃ HÓA ĐƠN: " + idHoaDon + "\n");
			bw.write("NGÀY IN: " + ngayInPhieu + "\n");
			bw.write("ID KH: " + idKhachHang + "\n");
			bw.write("CTKM: " + (idCTKM.isEmpty() ? "Không có" : idCTKM) + "\n");
			bw.write("TỔNG SL: " + soLuong + "\n");
			bw.write("TỔNG TIỀN: " + tongTien + " VND\n");
			if (kmHopLe != null)
				bw.write("GIẢM CTKM: " + kmHopLe.getPhanTramKhuyenMai() + "%\n");
			bw.write("GIẢM KH: " + mucGiam + "%\n");
			bw.write("VAT: 8%\n");
			bw.write("TỔNG SAU THUẾ: " + tongTienSauThue + " VND\n");
			bw.write("=========================================\n\n");
			bw.close();
			System.out.println("Xuất thành công hóa đơn");
		} catch (Exception e) {
			System.out.println("❌ Lỗi ghi hóa đơn: " + e.getMessage());
		}
	}

	private void capNhatSoLuongTrongFile(String idSach, int soLuongMoi) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("sach.txt"));
			StringBuilder noiDungMoi = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(";");
				if (parts[0].equals(idSach))
					parts[4] = String.valueOf(soLuongMoi);
				noiDungMoi.append(String.join(";", parts)).append("\n");
			}
			br.close();

			BufferedWriter bw = new BufferedWriter(new FileWriter("sach.txt"));
			bw.write(noiDungMoi.toString());
			bw.close();
		} catch (Exception e) {
			System.out.println("❌ Lỗi cập nhật kho: " + e.getMessage());
		}
	}
}
