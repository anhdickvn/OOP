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
            // tìm gần đúng theo id hoặc tên thể loại (bỏ qua hoa thường)
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
                break; // sách này đã khớp, không cần kiểm tra thêm thể loại khác
            }
        }
    }

    if (!timThay) {
        System.out.println("Không tìm thấy sách có thể loại gần đúng với: " + tuKhoa);
    }
}
