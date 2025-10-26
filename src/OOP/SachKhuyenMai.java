class SachKhuyenMai extends Sach implements IGiamGia {
    private double phanTramGiam;   
    private double giaSauGiam;     
	  private static SachKhuyenMai[] ds = new SachKhuyenMai[0];
    public SachKhuyenMai() {}

    public SachKhuyenMai(String idSach, String tenSach, double gia, int namXuatBan, int soLuong,NhaXuatBan nhaXuatBan, TacGia[] tacGia, TheLoai[] theLoai, double phanTramGiam) {
        super(idSach, tenSach, gia, namXuatBan, soLuong, nhaXuatBan, tacGia, theLoai);
        this.phanTramGiam = phanTramGiam;
        this.giaSauGiam = gia - tinhGiamGia();
    }

    @Override
    public double tinhGiamGia() {
        return getGia() * (phanTramGiam / 100);
    }

    public double getPhanTramGiam() {
        return phanTramGiam;
    }

    public double getGiaSauGiam() {
        return giaSauGiam;
    }

    
    public static void docFileSachKhuyenMai() {
        try {
			BufferedReader br = new BufferedReader(new FileReader("test1.txt"));
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

                
                double phanTramGiamGia = Double.parseDouble(st[12].replace("%", "").trim());
				SachKhuyenMai s = new SachKhuyenMai(st[0], st[1], Double.parseDouble(st[2]), Integer.parseInt(st[3]),Integer.parseInt(st[4]), nxb, tgArr, tlArr, phanTramGiamGia);
                ds = Arrays.copyOf(ds, ds.length + 1);
                ds[ds.length - 1] = s;
            }
			br.close();

        } catch (Exception e) {
            System.out.println("❌ Lỗi đọc file: " + e.getMessage());
        }
	}	

        public void XuatDSKM(){
			 
       		System.out.printf("%-5s | %-35s | %-55s | %-35s | %-10s | %-8s | %-5s | %-20s | %-8s | %-10s\n",
                "ID", "Tên Sách", "Tác Giả", "Thể Loại", "Giá", "NămXB", "SL", "NXB", "Giảm%", "Giá Sau");
        	System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        	for (SachKhuyenMai s : ds) {
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

            	System.out.printf("%-5s | %-35s | %-55s | %-35s | %-10.0f | %-8d | %-5d | %-20s | %-8.0f | %-10.0f\n",
                    s.getIdSach(), s.getTenSach(), tgStr, tlStr,
                    s.getGia(), s.getNamXuatBan(), s.getSoLuong(),
                    s.getNhaXuatBan().getTenNhaXuatBan(),
                    s.getPhanTramGiam(), s.getGiaSauGiam());
        }
    }
}
