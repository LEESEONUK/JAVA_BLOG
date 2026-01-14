package iducs202012068.javaweb.fundmentals.model;

public class Member { // DTO 객체 데이터 전송 객체(Data Transfer Object)
    //숫자, 문자열, 날짜시간
    private long id; //long : 기본 자료형 64bit 정수형, Long : long 자료를 효과적으로 다루기 위한 Wrapper Class,
    private  String email;
    private  String pw;
    private String name;
    private String phone;
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    /*    try {
            if (id < 10000)
                throw new Exception("id 오류");
            else
                this.id = id;
        }catch (Exception e){
            e.printStackTrace();
        }

     */
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
