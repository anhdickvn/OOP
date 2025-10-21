package OOP;
class KhoSach {
	private Sach[] ds;
	private int soLuongSachKho;

	public KhoSach() {
	}

	public KhoSach(Sach[] ds, int soLuongSachKho) {
		this.ds = ds;
		this.soLuongSachKho = soLuongSachKho;
	}

	public Sach[] getDs() {
		return ds;
	}

	public void setDs(Sach[] ds) {
		this.ds = ds;
	}

	public int getSoLuongSachKho() {
		return soLuongSachKho;
	}

	public void setSoLuongSachKho(int soLuongSachKho) {
		this.soLuongSachKho = soLuongSachKho;
	}

	public void nhapDS() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong sach trong kho: ");
		int soLuongSachKho = sc.nextInt();
		ds = new Sach[soLuongSachKho];
		sc.nextLine();
		for (int i = 0; i < soLuongSachKho; i++) {
			System.out.println("Sach thu " + (i + 1) + ": ");
			ds[i] = new Sach();
			ds[i].nhap();
			ds[i].NhapDSTacGia();
			ds[i].NhapDSTheLoai();
		}
	}

	public void xuatDS() {
		System.out.println("\n==================== DANH SÁCH SÁCH TRONG KHO ====================");
		System.out.printf("%-10s %-25s %-15s %-15s %-15s %-10s %-10s %-15s %-15s \n", "ID Sách", "Tên Sách","ID Tác Giả", "ID Thể Loại", "ID NXB", "Năm XB", "Số Lượng", "Giá Gốc", "Giá sau thuế");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < ds.length; i++) {
			ds[i].xuat();
		}
	}
	 public void ThemSach(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so sach muon them: ");
        int sosachThem = sc.nextInt();
        Sach[] dsMoi = Arrays.copyOf(ds, ds.length + sosachThem);

        for(int i = ds.length; i < soLuongSachKho;i++){
            System.out.println("Sach moi thu: "+(i+1));
            dsMoi[i] = new Sach();
            dsMoi[i].nhap();
        }
    }
    public void SuaSach(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID sach can sua: ");
        String idSach = sc.nextLine();
        for(int i = 0; i < soLuongSachKho;i++){
            if(ds[i].getIdSach().equals(idSach)){
                System.out.println("Thong tin hien tai: ");
                ds[i].xuat();
                System.out.println("Thong tin moi: ");
                ds[i].nhap();
                return;
            }
        }
        System.out.println("Khong tim thay ID sach");
    }
    public void xoaSach(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma sach can xoa: ");
        String ID = sc.nextLine();
        
        for(int i = 0; i < soLuongSachKho;i++){
                if(ds[i].getIdSach().equals(ID)){
                    for(int j = i;j < soLuongSachKho-1;j++){
                        ds[j] = ds[j+1];
                    }
                    soLuongSachKho--;
            System.out.println("Da xoa sach co ID: "+ID);
            xuatDS();
            return;
            }
        }   
        System.out.println("Khong tim thay sach co ID: "+ID);
        xuatDS();
    }    

    public void timKiemGanDung() {
		Scanner sc = new Scanner(System.in);
		boolean timThay = false;
		System.out.println("Nhap the loai muon tim: ");
		String tuKhoa = sc.nextLine();
		tuKhoa = tuKhoa.toLowerCase().trim(); // chuẩn hóa từ khóa để dễ so sánh

    for (Sach s : ds) {
        for (TheLoai tl : s.getTheLoai()) {
            if (tl.getTenTheLoai().toLowerCase().contains(tuKhoa) || tl.getIdTheLoai().toLowerCase().contains(tuKhoa)) {

                System.out.println("Tìm thấy: " + s.getTenSach());
				System.out.println("TAC GIA: ");
				for (TacGia tg : s.getTacGia()) {
                    System.out.println("   - " + tg.getTenTacGia() + " (ID: " + tg.getIdTacGia() + ")");
                }

                System.out.println("The loại:");
                // Duyệt danh sách thể loại
                for (TheLoai tl2 : s.getTheLoai()) {
                    System.out.println("   - " + tl2.getTenTheLoai() + " (ID: " + tl2.getIdTheLoai() + ")");
                }
                timThay = true;
                break; 
            }
        }
    }

    if (!timThay) {
        System.out.println("Không tìm thấy sách có thể loại gần đúng với: " + tuKhoa);
    }
		public static void ThongKeHoaDon(HoaDon[] dsHoaDon, int soLuongHoaDon, KhoSach kho) {
    if (dsHoaDon == null || soLuongHoaDon == 0) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng hóa đơn: ");
        soLuongHoaDon = sc.nextInt();
        sc.nextLine();
        dsHoaDon = new HoaDon[soLuongHoaDon];
        for (int i = 0; i < soLuongHoaDon; i++) {
            System.out.println("=== Nhập hóa đơn thứ " + (i + 1) + " ===");
            dsHoaDon[i] = new HoaDon();
            dsHoaDon[i].nhapHoaDon(kho);
        }
    }

    Scanner sc = new Scanner(System.in);
    System.out.print("Nhập tháng cần thống kê (1-12): ");
    int thang = sc.nextInt();
    System.out.print("Nhập năm cần thống kê (ví dụ 2025): ");
    int nam = sc.nextInt();

    System.out.println("\n=== THỐNG KÊ SÁCH BÁN THÁNG " + thang + "/" + nam + " ===");
    System.out.printf("%-10s %-25s %-10s %-15s\n", "ID Sách", "Tên Sách", "SL Bán", "Doanh Thu");

    boolean coDuLieu = false;

    String[] idSachTK = new String[100];
    String[] tenSachTK = new String[100];
    int[] soLuongBanTK = new int[100];
    double[] doanhThuTK = new double[100];
    int dem = 0;

    for (int i = 0; i < soLuongHoaDon; i++) {
        HoaDon hd = dsHoaDon[i];
        if (hd.getNgayInPhieu() == null || hd.getNgayInPhieu().isEmpty()) continue;

        String[] parts = hd.getNgayInPhieu().split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);

        if (month == thang && year == nam) {
            coDuLieu = true;
            Sach[] dsSach = hd.getDsSach();
            int[] dsSoLuong = hd.getDsSoLuong();

            for (int j = 0; j < dsSach.length; j++) {
                String id = dsSach[j].getIdSach();
                String ten = dsSach[j].getTenSach();
                int sl = dsSoLuong[j];
                double tien = dsSach[j].getGia() * sl;

                boolean daCo = false;
                for (int k = 0; k < dem; k++) {
                    if (idSachTK[k].equals(id)) {
                        soLuongBanTK[k] += sl;
                        doanhThuTK[k] += tien;
                        daCo = true;
                        break;
                    }
                }

                if (!daCo) {
                    idSachTK[dem] = id;
                    tenSachTK[dem] = ten;
                    soLuongBanTK[dem] = sl;
                    doanhThuTK[dem] = tien;
                    dem++;
                }
            }
        }
    }

    if (!coDuLieu) {
        System.out.println("Không có dữ liệu hóa đơn trong tháng này!");
        return;
    }

    for (int i = 0; i < dem; i++) {
        System.out.printf("%-10s %-25s %-10d %-15.2f\n",
                idSachTK[i], tenSachTK[i], soLuongBanTK[i], doanhThuTK[i]);
    }
}



public void thongKeSachTheoSoLuongGiamDan() {
    if (ds == null || soLuongSachKho == 0) {
        System.out.println("Kho chua co sach de thong ke!");
        return;
    }

    for (int i = 0; i < soLuongSachKho - 1; i++) {
        for (int j = 0; j < soLuongSachKho - i - 1; j++) {
            if (ds[j].getSoLuong() < ds[j + 1].getSoLuong()) {
                Sach temp = ds[j];
                ds[j] = ds[j + 1];
                ds[j + 1] = temp;
            }
        }
    }
    System.out.println("=== THONG KE SACH THEO SO LUONG GIAM DAN ===");
    for (int i = 0; i < soLuongSachKho; i++) {
        System.out.println("Sach thu " + (i + 1) + ":");
        ds[i].xuat();
        System.out.println("---------------------------------");
    }
}


public static void ThongKeThangBanSach() {
    Scanner sc = new Scanner(System.in);

    KhoSach kho = new KhoSach();
    kho.nhapDS();

    System.out.print("Nhập số lượng hóa đơn cần nhập: ");
    int soHD = sc.nextInt();
    sc.nextLine();
    HoaDon[] dsHD = new HoaDon[soHD];

    for (int i = 0; i < soHD; i++) {
        System.out.println("\n=== Nhập hóa đơn thứ " + (i + 1) + " ===");
        dsHD[i] = new HoaDon();
        dsHD[i].nhapHoaDon(kho);
    }

    ThongKeHoaDon(dsHD, soHD, kho);
}
}
