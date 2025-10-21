package OOP;
class Sach {
	private String idSach;
	private String idNhaXuatBan;
	private TacGia[] tacGia;
	private TheLoai[] theLoai;
	private double gia;
	private String tenSach;
	private int namXuatBan;
	private int soLuong;
	private static double thueVAT = 0.1;

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

	public String getIdSach() {
		return idSach;
	}

	public void setIdSach(String idSach) {
		this.idSach = idSach;
	}
	public void setIDNXB(String idNhaXuatBan){
		this.idNhaXuatBan = idNhaXuatBan;
	}
	public String getIDNXB(){
		return idNhaXuatBan;
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

	public static double getThueVAT() {
		return thueVAT;
	}

	public static void setThueVAT(double thueVAT) {
		Sach.thueVAT = thueVAT;
	}

	public Sach() {
	}

	public Sach(String idSach, String tenSach, String idTacGia, String idTheLoai, String idNhaXuatBan, double gia,int namXuatBan, int soLuong) {
		this.idSach = idSach;
		this.tenSach = tenSach;
		this.idNhaXuatBan = idNhaXuatBan;
		this.gia = gia;
		this.namXuatBan = namXuatBan;
		this.soLuong = soLuong;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ID sách: ");
		idSach = sc.nextLine();

		System.out.print("Nhập tên sách: ");
		tenSach = sc.nextLine();

		System.out.print("Nhap ID NXB: ");
		idNhaXuatBan = sc.nextLine();

		System.out.print("Nhập năm xuất bản: ");
		namXuatBan = sc.nextInt();

		System.out.print("Nhập giá sách: ");
		gia = sc.nextDouble();

		System.out.println("Nhập số lượng: ");
		soLuong = sc.nextInt();
	}

	public void xuat() {
		System.out.printf("%-10s %-25s %-10d %-10d %-10d %-15.2f %-15.2f\n", idSach, tenSach,idNhaXuatBan, namXuatBan, soLuong, gia, tinhTienSauThue());
	}

	public double tinhTienSauThue() {
		return gia + gia * thueVAT;
	}

	public void NhapDSTacGia() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so luong tac gia: ");
		int soLuongTacGia = sc.nextInt();
		sc.nextLine();
		tacGia = new TacGia[soLuongTacGia];

		for (int i = 0; i < soLuongTacGia; i++) {
			System.out.println("Tac gia thu " + (i + 1) + ": ");
			tacGia[i] = new TacGia();
			tacGia[i].nhap();
		}
	}

	public void xuatDSTacGia() {
		System.out.printf("%-15s %-25s %-15s\n", "ID Tác Giả", "Tên Tác Giả", "Ngày Sinh");
		System.out.println("---------------------------------------------------------------");
		for (int i = 0; i < tacGia.length; i++) {
			tacGia[i].xuat();
		}
	}

	public void NhapDSTheLoai() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so luong the loai: ");
		int soLuongTheLoai = sc.nextInt();
		sc.nextLine();
		theLoai = new TheLoai[soLuongTheLoai];
		for (int i = 0; i < soLuongTheLoai; i++) {
			theLoai[i] = new TheLoai();
			theLoai[i].nhap();
		}
	}

	public void XuatDSTheLoai() {
		System.out.printf("%-15s %-25s\n", "ID Thể Loại", "Tên Thể Loại");
		System.out.println("----------------------------------------------");
		for (int i = 0; i < theLoai.length; i++) {
			theLoai[i].xuat();
		}
	}
}
