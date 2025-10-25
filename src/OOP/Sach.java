package OOP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Sach {
	private String idSach;
	private String tenSach;
	private double gia;
	private int namXuatBan;
	private int soLuong;
	private TacGia[] tacGia;
	private TheLoai[] theLoai;
	private NhaXuatBan nhaXuatBan;
	private static double thueVAT = 0.1;

	public Sach(String idSach, String tenSach, double gia, int namXuatBan, int soLuong, NhaXuatBan nhaXuatBan) {
		this.idSach = idSach;
		this.tenSach = tenSach;
		this.gia = gia;
		this.namXuatBan = namXuatBan;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
	}

	public void setTacGia(TacGia[] tacGia) {
		this.tacGia = tacGia;
	}

	public void setTheLoai(TheLoai[] theLoai) {
		this.theLoai = theLoai;
	}

	public TacGia[] getTacGia() {
		return tacGia;
	}

	public TheLoai[] getTheLoai() {
		return theLoai;
	}

	public String getIdSach() {
		return idSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public double getGia() {
		return gia;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public NhaXuatBan getNhaXuatBan() {
		return nhaXuatBan;
	}

	public static void xuatKho() {
		Sach[] ds = new Sach[0];
		try {
			BufferedReader br = new BufferedReader(new FileReader("test.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] st = line.split(";");
				if (st.length < 12)
					continue; // tránh lỗi khi thiếu trường
				NhaXuatBan nxb = new NhaXuatBan(st[5], st[6], st[7]);
				Sach s = new Sach(st[0], st[1], Double.parseDouble(st[2]), Integer.parseInt(st[3]),
						Integer.parseInt(st[4]), nxb);

				String[] idTGs = st[8].split(",");
				String[] tenTGs = st[9].split(",");
				TacGia[] tgArr = new TacGia[tenTGs.length];
				for (int i = 0; i < tenTGs.length; i++) {
					tgArr[i] = new TacGia(idTGs[i].trim(), tenTGs[i].trim());
				}
				s.setTacGia(tgArr);

				String[] idTLs = st[10].split(",");
				String[] tenTLs = st[11].split(",");
				TheLoai[] tlArr = new TheLoai[idTLs.length];
				for (int i = 0; i < idTLs.length; i++) {
					tlArr[i] = new TheLoai(idTLs[i].trim(), tenTLs[i].trim());
				}
				s.setTheLoai(tlArr);

				ds = Arrays.copyOf(ds, ds.length + 1);
				ds[ds.length - 1] = s;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.printf("%-5s | %-30s | %-40s | %-30s | %-10s | %-8s | %-6s | %-15s\n", "ID", "Tên Sách", "Tác Giả",
				"Thể Loại", "Giá", "NămXB", "SL", "NXB");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------");

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

			System.out.printf("%-5s | %-30s | %-40s | %-30s | %-10.0f | %-8d | %-6d | %-15s\n", s.getIdSach(),
					s.getTenSach(), tgStr, tlStr, s.getGia(), s.getNamXuatBan(), s.getSoLuong(),
					s.getNhaXuatBan().getTenNhaXuatBan());
		}
	}
}
