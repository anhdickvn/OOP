package OOP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class KhachHangThuong extends KhachHang {
	private int soLanMua;

	public KhachHangThuong() {
		super();
	}

	public KhachHangThuong(String idKhachHang, String hoTen, String ngaySinh, String diaChi, String soDienThoai,
			int soLanMua) {
		super(idKhachHang, hoTen, ngaySinh, diaChi, soDienThoai);
		this.soLanMua = soLanMua;
	}

	public int getSoLanMua() {
		return soLanMua;
	}

	public void setSoLanMua(int soLanMua) {
		this.soLanMua = soLanMua;
	}

	public void hienThiThongTin() {
		System.out.println("=== Khach Hang Thuong ===");
		System.out.println(super.toString());
		System.out.println("So lan mua: " + soLanMua + "\n");
	}

	public static KhachHangThuong[] docFile() {
		KhachHangThuong[] dsKH = new KhachHangThuong[0];

		try (BufferedReader br = new BufferedReader(new FileReader("khthuong.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] st = line.split(";");
				KhachHangThuong kh = new KhachHangThuong(st[0], st[1], st[2], st[3], st[4], Integer.parseInt(st[5]));
				dsKH = Arrays.copyOf(dsKH, dsKH.length + 1);
				dsKH[dsKH.length - 1] = kh;
			}
		} catch (IOException e) {
			System.out.println("Lỗi đọc file: " + e.getMessage());
		}

		return dsKH;
	}

	public static void xuatDanhSach() {
		KhachHangThuong[] dsKH = docFile();
		System.out.printf("%-10s | %-20s | %-12s | %-20s | %-15s | %-12s\n", "ID KH", "Họ Tên", "Ngày Sinh", "Địa Chỉ",
				"SĐT", "Số lần mua");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------");
		for (KhachHangThuong kh : dsKH) {
			System.out.printf("%-10s | %-20s | %-12s | %-20s | %-15s | %-12d\n", kh.getIdKhachHang(), kh.getHoTen(),
					kh.getNgaySinh(), kh.getDiaChi(), kh.getSoDienThoai(), kh.getSoLanMua());
		}

	}
}
