package DoAn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

class Sach {
	private String idSach;
	private String tenSach;
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

	

	public Sach() {}

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

	public static Sach[] docKho() {
		Sach[] ds = new Sach[0];
		try {
			BufferedReader br = new BufferedReader(new FileReader("test.txt"));
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
	public static void ghiFileSach(Sach[] danhSach) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("Sach.txt"))) {
        for (Sach s : danhSach) {
            
            String idTGs = "";
            String tenTGs = "";
            for (int i = 0; i < s.getTacGia().length; i++) {
                idTGs += s.getTacGia()[i].getIdTacGia();
                tenTGs += s.getTacGia()[i].getTenTacGia();
                if (i != s.getTacGia().length - 1) {
                    idTGs += ",";
                    tenTGs += ",";
                }
            }

            
            String idTLs = "";
            String tenTLs = "";
            for (int i = 0; i < s.getTheLoai().length; i++) {
                idTLs += s.getTheLoai()[i].getIdTheLoai();
                tenTLs += s.getTheLoai()[i].getTenTheLoai();
                if (i != s.getTheLoai().length - 1) {
                    idTLs += ",";
                    tenTLs += ",";
                }
            }

           
            String line = s.getIdSach() + ";" +
                          s.getTenSach() + ";" +
                          s.getGia() + ";" +
                          s.getNamXuatBan() + ";" +
                          s.getSoLuong() + ";" +
                          s.getNhaXuatBan().getIdNhaXuatBan() + ";" +
                          s.getNhaXuatBan().getTenNhaXuatBan() + ";" +
                          
                          idTGs + ";" +
                          tenTGs + ";" +
                          idTLs + ";" +
                          tenTLs;

            
            bw.write(line);
            bw.newLine();
        }

        System.out.println("✅ Ghi file Sach.txt thành công!");
    } catch (Exception e) {
        System.out.println("❌ Lỗi khi ghi file: " + e.getMessage());
    }
}

	
	public static Sach[] themSach(){
        Scanner sc = new Scanner(System.in);
		Sach[] ds = docKho();
        System.out.print("Nhập số lượng sách muốn thêm: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\n===== NHẬP THÔNG TIN SÁCH THỨ " + (i + 1) + " =====");

            System.out.print("ID Sách: ");
            String idSach = sc.nextLine();

            System.out.print("Tên Sách: ");
            String tenSach = sc.nextLine();

            System.out.print("Giá: ");
            double gia = Double.parseDouble(sc.nextLine());

            System.out.print("Năm xuất bản: ");
            int namXB = Integer.parseInt(sc.nextLine());

            System.out.print("Số lượng: ");
            int soLuong = Integer.parseInt(sc.nextLine());

            System.out.println("Nhập thông tin Nhà Xuất Bản:");
            System.out.print("ID NXB: ");
            String idNXB = sc.nextLine();
            System.out.print("Tên NXB: ");
            String tenNXB = sc.nextLine();
            System.out.print("Địa chỉ NXB: ");
            String diaChiNXB = sc.nextLine();
            NhaXuatBan nxb = new NhaXuatBan(idNXB, tenNXB, diaChiNXB);

            System.out.print("Số lượng tác giả: ");
            int soTG = Integer.parseInt(sc.nextLine());
            TacGia[] tacGiaArr = new TacGia[soTG];
            for (int j = 0; j < soTG; j++) {
                System.out.println("Tác giả " + (j + 1) + ":");
                System.out.print("  ID Tác Giả: ");
                String idTG = sc.nextLine();
                System.out.print("  Tên Tác Giả: ");
                String tenTG = sc.nextLine();
                tacGiaArr[j] = new TacGia(idTG, tenTG);
            }

            System.out.print("Số lượng thể loại: ");
            int soTL = Integer.parseInt(sc.nextLine());
            TheLoai[] theLoaiArr = new TheLoai[soTL];
            for (int k = 0; k < soTL; k++) {
                System.out.println("Thể loại " + (k + 1) + ":");
                System.out.print("  ID Thể Loại: ");
                String idTL = sc.nextLine();
                System.out.print("  Tên Thể Loại: ");
                String tenTL = sc.nextLine();
                theLoaiArr[k] = new TheLoai(idTL, tenTL);
            }

            Sach s = new Sach(idSach, tenSach, gia, namXB, soLuong, nxb, tacGiaArr, theLoaiArr);

            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = s;
        }

        ghiFileSach(ds);
        return ds;
    }
	public void SuaSach(){
		Sach[] ds = docKho();
		Scanner sc = new Scanner(System.in);
        System.out.print("🔧 Nhập ID sách cần chỉnh sửa: ");
        String id = sc.nextLine();
        boolean timThay = false;

        for (Sach s : ds) {
            if (s.getIdSach().equalsIgnoreCase(id)) {
                timThay = true;
                int choice;
                do {
                    System.out.println("\n===== CHỈNH SỬA SÁCH =====");
                    System.out.println("1. Tên sách (" + s.getTenSach() + ")");
                    System.out.println("2. Giá (" + s.getGia() + ")");
                    System.out.println("3. Năm XB (" + s.getNamXuatBan() + ")");
                    System.out.println("4. Số lượng (" + s.getSoLuong() + ")");
                    System.out.println("0. Lưu và thoát");
                    System.out.print("Chọn mục muốn sửa: ");
                    choice = Integer.parseInt(sc.nextLine());

                    switch (choice) {
                        case 1:
                            System.out.print("Nhập tên mới: ");
                            s.setTenSach(sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhập giá mới: ");
                            s.setGia(Double.parseDouble(sc.nextLine()));
                            break;
                        case 3:
                            System.out.print("Nhập năm XB mới: ");
                            s.setNamXuatBan(Integer.parseInt(sc.nextLine()));
                            break;
                        case 4:
                            System.out.print("Nhập số lượng mới: ");
                            s.setSoLuong(Integer.parseInt(sc.nextLine()));
                            break;
                        case 0:
                            ghiFileSach(ds);
                            System.out.println("✅ Cập nhật thành công!");
                            break;
                        default:
                            System.out.println("❌ Lựa chọn không hợp lệ!");
                    }
                } while (choice != 0);
                break;
            }
        }

        if (!timThay) {
            System.out.println("❌ Không tìm thấy sách có ID: " + id);
        }
    }

	public void timKiemGanDung() {	
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Nhập thông tin muốn tìm (ID / Tên sách / Tác giả / Thể loại): ");
    	String tuKhoa = sc.nextLine().toLowerCase();
		Sach[] ds = docKho();

    	boolean timThay = false;

    	for (Sach s : ds) {
			boolean timTen = false;
         	if(s.getIdSach().equalsIgnoreCase(tuKhoa)||s.getTenSach().toLowerCase().contains(tuKhoa)){
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
        	System.out.println("❌ Không tìm thấy sách phù hợp với từ khóa: " + tuKhoa);
    	}	
	}
	 public int thongKeSoLuongBanTheoHoaDon(int thang, int nam) {
    int tongSoLuongBan = 0;
    try (BufferedReader br = new BufferedReader(new FileReader("hoadon.txt"))) {
        String line;
        boolean dungThangNam = false; // kiểm tra hóa đơn có thuộc tháng/năm cần tìm không
        boolean docChiTietSach = false; // bắt đầu đọc chi tiết sách

        while ((line = br.readLine()) != null) {
            // Kiểm tra ngày in hóa đơn
            if (line.startsWith("NGÀY IN:")) {
                String date = line.substring(8).trim(); // yyyy-MM-dd
                java.time.LocalDate d = java.time.LocalDate.parse(date);
                dungThangNam = (d.getMonthValue() == thang && d.getYear() == nam);
                docChiTietSach = false;
            }

            // Khi gặp dòng bắt đầu chi tiết sách
            if (dungThangNam && line.startsWith("CHI TIẾT SÁCH")) {
                docChiTietSach = true;
                continue;
            }

            // Đọc chi tiết sách
            if (docChiTietSach && line.contains(";")) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    String idSachTrongHD = parts[0].trim();
                    int soLuongBan = Integer.parseInt(parts[2].trim());
                    if (idSachTrongHD.equalsIgnoreCase(this.idSach)) {
                        tongSoLuongBan += soLuongBan;
                    }
                }
            }

            // Kết thúc hóa đơn
            if (line.contains("=========================================")) {
                dungThangNam = false;
                docChiTietSach = false;
            }
        }
    } catch (Exception e) {
        System.out.println("⚠️ Lỗi đọc file hóa đơn: " + e.getMessage());
    }
    return tongSoLuongBan;
}


public static void thongKeBanSachTheoHoaDon() {
    Scanner sc = new Scanner(System.in);
    Sach[] ds = Sach.docKho();

    System.out.println("===== DANH SÁCH SÁCH =====");
    for (Sach s : ds) {
        System.out.println(s.getIdSach() + " - " + s.getTenSach());
    }

    System.out.print("\n👉 Nhập ID sách cần thống kê: ");
    String id = sc.nextLine();

    System.out.print("👉 Nhập tháng (ví dụ 10): ");
    int thang = Integer.parseInt(sc.nextLine());

    System.out.print("👉 Nhập năm (ví dụ 2025): ");
    int nam = Integer.parseInt(sc.nextLine());

    for (Sach s : ds) {
        if (s.getIdSach().equalsIgnoreCase(id)) {
            int soLuong = s.thongKeSoLuongBanTheoHoaDon(thang, nam);
            System.out.println("\n📊 KẾT QUẢ THỐNG KÊ");
            System.out.println("Sách: " + s.getTenSach());
            System.out.println("Tháng " + thang + "/" + nam + " đã bán: " + soLuong + " quyển.");
            return;
        }
    }
    System.out.println("❌ Không tìm thấy sách có ID: " + id);
}
	public static void chucNangSach() {
    Scanner sc = new Scanner(System.in);
    Sach[] ds = Sach.docKho();
    int choice;
    do {
        System.out.println("\n===== MENU QUẢN LÝ SÁCH =====");
        System.out.println("1. Thêm Sách Mới");
        System.out.println("2. Chỉnh Sửa Thông Tin Sách");
        System.out.println("3. Tìm Kiếm Sách");
        System.out.println("4. Xuất Danh Sách Kho");
        System.out.println("0. Thoát");
        System.out.print("👉 Chọn chức năng: ");
        choice = Integer.parseInt(sc.nextLine());

        Sach s = new Sach(); 

        switch (choice) {
            case 1:
                ds = themSach(); 
                break;
            case 2:
                s.SuaSach(); 
                break;
            case 3:
                s.timKiemGanDung(); 
                break;
            case 4:
                Sach.xuatKho();
                break;
            case 0:
                System.out.println("💾 Dữ liệu đã được lưu. Thoát chương trình!");
                break;
            default:
                System.out.println("❌ Lựa chọn không hợp lệ!");
        }
    } while (choice != 0);
}
}

public class OOP {
	public static void main(String[] args) {
        Sach.ChucNangSach();
    }
}


		
	
