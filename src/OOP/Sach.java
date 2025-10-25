package OOP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Sach {
	private String idSach;
	private String tenSach;
	private String idNhaXuatBan;
	private double gia;
	private int namXuatBan;
	private int soLuong;
	private TacGia[] tacGia;
	private TheLoai[] theLoai;
	private NhaXuatBan nhaXuatBan;
	private static double thueVAT = 0.1;

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

	public Sach() {
	}

	public Sach(String idSach, String tenSach, double gia, int namXuatBan, int soLuong, NhaXuatBan nhaXuatBan) {
		this.idSach = idSach;
		this.tenSach = tenSach;
		this.gia = gia;
		this.namXuatBan = namXuatBan;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
	}

	public static void xuatKho() {
		Sach ds[] = new Sach[0];
		try {
			BufferedReader br = new BufferedReader(new FileReader("test.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] st = line.split(";");
				NhaXuatBan nhaXuatBan = new NhaXuatBan(st[5], st[6], st[7]);
				Sach s = new Sach(st[0], st[1], Double.parseDouble(st[2]), Integer.parseInt(st[3]),
						Integer.parseInt(st[4]), nhaXuatBan);
				String[] idTGs = st[8].split(",");
				String[] tenTGs = st[9].split(",");
				TacGia[] tgArr = new TacGia[tenTGs.length];
				for (int i = 0; i < tenTGs.length; i++) {
					String id = idTGs[i].trim();
					String ten = tenTGs[i].trim();
					tgArr[i] = new TacGia(id, ten);
				}

				s.setTacGia(tgArr);
				String[] idTLs = st[10].split(",");
				String[] tenTLs = st[11].split(",");
				TheLoai[] tlArr = new TheLoai[idTLs.length];
				for (int i = 0; i < idTLs.length; i++) {
					String id = idTLs[i].trim();
					String ten = tenTLs[i].trim();
					tlArr[i] = new TheLoai(id, ten);
				}
				s.setTheLoai(tlArr);
				ds = Arrays.copyOf(ds, ds.length + 1);
				ds[ds.length - 1] = s;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Sach s : ds) {
			System.out.println(s);
		}
	}

	@Override
	public String toString() {
		return idSach + " - " + tenSach + " - " + Arrays.toString(tacGia) + " " + gia + " - " + namXuatBan + " - "
				+ soLuong + " - " + nhaXuatBan.toString() + " - " + Arrays.toString(theLoai);
	}

}

//	public double tinhTienSauThue() {
//	return gia + gia * thueVAT;
//}
