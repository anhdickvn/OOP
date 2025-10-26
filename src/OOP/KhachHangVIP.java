package OOP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class KhachHangVIP extends KhachHang {
	private double tongChiTieu;
	private double mucGiamGia;
	private int diemTichLuy;

	public KhachHangVIP() {
		super();
	}

	public KhachHangVIP(String idKhachHang, String hoTen, String ngaySinh, String diaChi, String soDienThoai,
			double tongChiTieu) {
		super(idKhachHang, hoTen, ngaySinh, diaChi, soDienThoai);
		this.tongChiTieu = tongChiTieu;
		capNhatUuDai();
	}

	public double getTongChiTieu() {
		return tongChiTieu;
	}

	public void setTongChiTieu(double tongChiTieu) {
		this.tongChiTieu = tongChiTieu;
		capNhatUuDai();
	}

	public double getMucGiamGia() {
		return mucGiamGia;
	}

	public int getDiemTichLuy() {
		return diemTichLuy;
	}

	public void capNhatUuDai() {
		this.diemTichLuy = (int) (tongChiTieu / 10000);
		this.mucGiamGia = diemTichLuy / 100.0;
		if (mucGiamGia > 15)
			mucGiamGia = 15;
	}

	public static KhachHangVIP[] docFile() {
		KhachHangVIP[] dsKH = new KhachHangVIP[0];

		try (BufferedReader br = new BufferedReader(new FileReader("khvip.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] st = line.split(";");
				double tongChiTieu = Double.parseDouble(st[5]);
				KhachHangVIP kh = new KhachHangVIP(st[0], st[1], st[2], st[3], st[4], tongChiTieu);
				dsKH = Arrays.copyOf(dsKH, dsKH.length + 1);
				dsKH[dsKH.length - 1] = kh;
			}
		} catch (IOException e) {
			System.out.println("Lỗi đọc file: " + e.getMessage());
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("khvip.txt"))) {
			for (KhachHangVIP kh : dsKH) {
				bw.write(kh.getIdKhachHang() + ";" + kh.getHoTen() + ";" + kh.getNgaySinh() + ";" + kh.getDiaChi() + ";"
						+ kh.getSoDienThoai() + ";" + kh.getTongChiTieu() + ";" + kh.getDiemTichLuy() + ";"
						+ kh.getMucGiamGia());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Lỗi ghi file: " + e.getMessage());
		}

		return dsKH;
	}

	public static void xuatDanhSach() {
		KhachHangVIP[] dsKH = docFile();
		System.out.printf("%-10s | %-20s | %-12s | %-15s | %-12s | %-12s | %-10s | %-10s\n", "ID KH", "Họ Tên",
				"Ngày Sinh", "Địa Chỉ", "SĐT", "Tổng Chi Tiêu", "Điểm TL", "Giảm giá (%)");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");

		for (KhachHangVIP kh : dsKH) {
			System.out.printf("%-10s | %-20s | %-12s | %-15s | %-12s | %-12.0f | %-10d | %-10.2f\n",
					kh.getIdKhachHang(), kh.getHoTen(), kh.getNgaySinh(), kh.getDiaChi(), kh.getSoDienThoai(),
					kh.getTongChiTieu(), kh.getDiemTichLuy(), kh.getMucGiamGia());
		}
	}
}
