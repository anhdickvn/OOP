package OOP;

import java.io.BufferedReader;
import java.io.FileReader;

public class ChuongTrinhKM implements IGiamGia {
	private String idSach;
	private String idCTKM;
	private double phanTramKhuyenMai;
	private String ngayBatDau;
	private String ngayKetThuc;

	public ChuongTrinhKM() {
	}

	public ChuongTrinhKM(String idSach, String idCTKM, double phanTramKhuyenMai, String ngayBatDau,
			String ngayKetThuc) {
		this.idSach = idSach;
		this.idCTKM = idCTKM;
		this.phanTramKhuyenMai = phanTramKhuyenMai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getIdSach() {
		return idSach;
	}

	public String getIdCTKM() {
		return idCTKM;
	}

	public double getPhanTramKhuyenMai() {
		return phanTramKhuyenMai;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	@Override
	public double tinhGiamGia(double tongTien) {
		return tongTien * (phanTramKhuyenMai / 100);
	}

	// ===== Đọc file ctkm.txt (dạng:
	// idSach;idCTKM;phanTramKhuyenMai;ngayBatDau;ngayKetThuc) =====
	public static ChuongTrinhKM[] docFile() {
		ChuongTrinhKM[] ds = new ChuongTrinhKM[0];
		try {
			BufferedReader br = new BufferedReader(new FileReader("ctkm.txt"));
			int count = 0;
			String line;

			// Đếm số dòng
			while ((line = br.readLine()) != null) {
				if (!line.trim().isEmpty())
					count++;
			}
			br.close();

			ds = new ChuongTrinhKM[count];
			br = new BufferedReader(new FileReader("ctkm.txt"));
			int i = 0;

			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty())
					continue;
				String[] parts = line.split(";");
				if (parts.length >= 5) {
					ds[i++] = new ChuongTrinhKM(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3], parts[4]);
				}
			}
			br.close();

		} catch (Exception e) {
			System.out.println("Lỗi đọc file CTKM: " + e.getMessage());
		}
		return ds;
	}
}
