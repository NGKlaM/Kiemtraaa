public class DanhsachSV {
    private String MaSv;
    private String Username;
    private int year;
    private float DTB;

    public DanhsachSV(String maSv, String username, int year, float DTB) {
        MaSv = maSv;
        Username = username;
        this.year = year;
        this.DTB = DTB;
    }

    public String getMaSv() {
        return MaSv;
    }

    public void setMaSv(String maSv) {
        MaSv = maSv;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getDTB() {
        return DTB;
    }

    public void setDTB(float DTB) {
        this.DTB = DTB;
    }
    public void inttSV(){
        System.out.println("Thông tin sinh viên là: ");
        System.out.println("Mã SV: " + this.MaSv);
        System.out.println("Họ tên: " + this.Username);
        System.out.println("Năm sinh: " + this.year);
        System.out.println("Điểm trung bình: " + this.DTB);
    }
}
