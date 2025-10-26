package OOP;
import java.io.*;
import java.util.*;
class KhachHangVIP extends KhachHang {  
	private double mucGiamGia;
	private double tongTienMua;
	private int diemTichLuy;

	public KhachHangVIP() {
	}

	public KhachHangVIP(String hoTen, String ngaySinh, String diaChi, String soDienThoai,
			String idKhachHang, double mucGiamGia, int diemTichLuy, double tongTienMua) {
		super(hoTen, ngaySinh, diaChi, soDienThoai, idKhachHang);
		this.mucGiamGia = mucGiamGia;
		this.diemTichLuy = diemTichLuy;
		this.tongTienMua = tongTienMua;
	}

	public double getMucGiamGia() {
		return mucGiamGia;
	}

	public void setMucGiamGia(double mucGiamGia) {
		this.mucGiamGia = mucGiamGia;
	}

	public int getDiemTichLuy() {
		return diemTichLuy;
	}

	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}

	public double getTongTienMua() {
		return tongTienMua;
	}

	public void setTongTienMua(double tongTienMua) {
		this.tongTienMua = tongTienMua;
	}

	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap tong so tien da mua (VND): ");
		tongTienMua = sc.nextDouble();
		diemTichLuy = (int) (tongTienMua / 1000);

		if (diemTichLuy > 100)
			mucGiamGia = 0.15;
		else if (diemTichLuy > 50 && diemTichLuy <= 100)
			mucGiamGia = 0.1;
		else if (diemTichLuy > 0 && diemTichLuy <=50)
			mucGiamGia = 0.05;
		System.out.println("Muc giam gia hien tai: " + (mucGiamGia * 100) + "%");
	}

	@Override
	public void hienThiThongTin() {
		System.out.println("\n=== Khach Hang VIP ===");
		super.hienThiThongTin();
		System.out.println("Tong tien da mua: " + tongTienMua + " VND");
		System.out.println("Diem tich luy: " + diemTichLuy);
		System.out.println("Muc giam gia hien tai: " + (mucGiamGia * 100) + "%");    
    }
     public static List<KhachHangVIP> docTuFile() {
        String fileName = "khachhangvip.txt"; // file nằm cùng thư mục project
        List<KhachHangVIP> danhSach = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 8) {
                    String hoTen = parts[0];
                    String ngaySinh = parts[1];
                    String diaChi = parts[2];
                    String soDienThoai = parts[3];
                    String idKhachHang = parts[4];
                    double tongTienMua = Double.parseDouble(parts[5]);
                    int diemTichLuy = Integer.parseInt(parts[6]);
                    double mucGiamGia = Double.parseDouble(parts[7]);
                    danhSach.add(new KhachHangVIP(hoTen, ngaySinh, diaChi, soDienThoai, idKhachHang,
                            mucGiamGia, diemTichLuy, tongTienMua));
                }
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
        return danhSach;
    }
}

