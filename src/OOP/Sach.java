package OOP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Sach {
	private String idSach;
	private String tenSach;
	private double gia;
	private int namXuatBan;
	private int soLuong;
	private TacGia[] tacGia;
	private TheLoai[] theLoai;
	private NhaXuatBan nhaXuatBan;
	private static double thueVAT = 0.08;

	public Sach() {

	}

	public Sach(String idSach, String tenSach, double gia, int namXuatBan, int soLuong, NhaXuatBan nhaXuatBan,
			TacGia[] tacGia, TheLoai[] theLoai) {
		this.idSach = idSach;
		this.tenSach = tenSach;
		this.gia = gia;
		this.namXuatBan = namXuatBan;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
		this.tacGia = tacGia;
		this.theLoai = theLoai;
	}

	public String getIdSach() {
		return idSach;
	}

	public void setIdSach(String idSach) {
		this.idSach = idSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public TacGia[] getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGia[] tacGia) {
		this.tacGia = tacGia;
	}

	public TheLoai[] getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheLoai[] theLoai) {
		this.theLoai = theLoai;
	}

	public NhaXuatBan getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public static double getThueVAT() {
		return thueVAT;
	}

	public static void setThueVAT(double thueVAT) {
		Sach.thueVAT = thueVAT;
	}

	public double tinhTongTienSauThue(int soLuongMua) {
		double tongTruocThue = gia * soLuongMua;
		double tongSauThue = tongTruocThue * (1 + thueVAT);
		return tongSauThue;
	}

	public static Sach[] docKho() {
		Sach[] ds = new Sach[0];
		try {
			BufferedReader br = new BufferedReader(new FileReader("sach.txt"));
			String line;

			while ((line = br.readLine()) != null) {
				String[] st = line.split(";");

				NhaXuatBan nxb = new NhaXuatBan(st[5], st[6], st[7]);

				String[] idTGs = st[8].split(",");
				String[] tenTGs = st[9].split(",");
				TacGia[] tgArr = new TacGia[tenTGs.length];
				for (int i = 0; i < tenTGs.length; i++) {
					tgArr[i] = new TacGia(idTGs[i].trim(), tenTGs[i].trim());
				}

				String[] idTLs = st[10].split(",");
				String[] tenTLs = st[11].split(",");
				TheLoai[] tlArr = new TheLoai[idTLs.length];
				for (int i = 0; i < idTLs.length; i++) {
					tlArr[i] = new TheLoai(idTLs[i].trim(), tenTLs[i].trim());
				}

				Sach s = new Sach(st[0], st[1], Double.parseDouble(st[2]), Integer.parseInt(st[3]),
						Integer.parseInt(st[4]), nxb, tgArr, tlArr);

				ds = Arrays.copyOf(ds, ds.length + 1);
				ds[ds.length - 1] = s;
			}

			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ds;
	}

	public static void xuatKho() {
		Sach[] ds = docKho();
		System.out.printf("%-5s | %-35s | %-50s | %-45s | %-10s | %-8s | %-5s | %-20s\n", "ID", "Tên Sách", "Tác Giả",
				"Thể Loại", "Giá", "NămXB", "SL", "NXB");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		for (Sach s : ds) {
			String tgStr = "";
			for (int i = 0; i < s.getTacGia().length; i++) {
				tgStr += s.getTacGia()[i].getIdTacGia() + " - " + s.getTacGia()[i].getTenTacGia();
				if (i != s.getTacGia().length - 1)
					tgStr += ", ";
			}

			String tlStr = "";
			for (int i = 0; i < s.getTheLoai().length; i++) {
				tlStr += s.getTheLoai()[i].getIdTheLoai() + " - " + s.getTheLoai()[i].getTenTheLoai();
				if (i != s.getTheLoai().length - 1)
					tlStr += ", ";
			}

			System.out.printf("%-5s | %-35s | %-50s | %-45s | %-10.0f | %-8d | %-5d | %-20s\n", s.getIdSach(),
					s.getTenSach(), tgStr, tlStr, s.getGia(), s.getNamXuatBan(), s.getSoLuong(),
					s.getNhaXuatBan().getTenNhaXuatBan());
		}
	}

	public void timKiemSach() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập thông tin muốn tìm (ID / Tên sách / Tác giả / Thể loại): ");
		String tuKhoa = sc.nextLine().toLowerCase();
		Sach[] ds = Sach.docKho();

		boolean timThay = false;

		for (Sach s : ds) {
			boolean timTen = false;
			if (s.getIdSach().equalsIgnoreCase(tuKhoa) || s.getTenSach().toLowerCase().contains(tuKhoa)) {
				timTen = true;
			}

			boolean timTacGia = false;
			if (s.getTacGia() != null) {
				for (TacGia tg : s.getTacGia()) {
					if (tg.getTenTacGia().toLowerCase().contains(tuKhoa)) {
						timTacGia = true;
						break;
					}
				}
			}

			boolean timTheLoai = false;
			if (s.getTheLoai() != null) {
				for (TheLoai tl : s.getTheLoai()) {
					if (tl.getTenTheLoai().toLowerCase().contains(tuKhoa)) {
						timTheLoai = true;
						break;
					}
				}
			}

			if (timTen || timTacGia || timTheLoai) {
				timThay = true;
				System.out.println("───────────────────────────────────────────────");
				System.out.println("📘 ID Sách: " + s.getIdSach());
				System.out.println("Tên sách: " + s.getTenSach());
				System.out.println("Tác giả:");
				for (TacGia tg : s.getTacGia()) {
					System.out.println("   - " + tg.getTenTacGia() + " (ID: " + tg.getIdTacGia() + ")");
				}
				System.out.println("Thể loại:");
				for (TheLoai tl : s.getTheLoai()) {
					System.out.println("   - " + tl.getTenTheLoai() + " (ID: " + tl.getIdTheLoai() + ")");
				}
				System.out.println("───────────────────────────────────────────────");
			}
		}

		if (!timThay) {
			System.out.println("Không tìm thấy sách phù hợp với từ khóa: " + tuKhoa);
		}
	}
}
