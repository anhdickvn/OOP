package OOP;
import java.util.Scanner;
class KhachHangVIP extends KhachHang {
	private double mucGiamGia;
	private double tongTienMua;
	private int diemTichLuy;

	public KhachHangVIP() {
	}

	public KhachHangVIP(String hoTen, String maDinhDanh, String ngaySinh, String diaChi, String soDienThoai,
			String idKhachHang, double mucGiamGia, int diemTichLuy, double tongTienMua) {
		super(hoTen, maDinhDanh, ngaySinh, diaChi, soDienThoai, idKhachHang);
		this.mucGiamGia = mucGiamGia;
		this.diemTichLuy = diemTichLuy;
		this.diemTichLuy = (int)(tongTienMua/1000);
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
	public double getTongTienMua(){
		return tongTienMua;
	}
	public void setTongTienMua(double tongTienMua) {
		this.tongTienMua=tongTienMua;
		this.diemTichLuy=(int)(tongTienMua/1000);

	}

	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap tong so tien da mua (VND):");
		tongTienMua=sc.nextDouble();
		System.out.println("Nhap muc giam gia");
		mucGiamGia = sc.nextDouble();
		diemTichLuy=(int)(tongTienMua/1000);

	}

	@Override
    public void hienThiThongTin() {
        System.out.println("\n=== Khach Hang VIP ===");
        super.hienThiThongTin();
        System.out.println("Tong tien da mua: " + tongTienMua + " VND");
        System.out.println("Diem tich luy: " + diemTichLuy);
        System.out.println("Muc giam gia hien tai: " + mucGiamGia + "%");
    }
}
