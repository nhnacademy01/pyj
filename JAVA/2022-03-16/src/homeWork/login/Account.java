package login;

public class Account {
    private String id;
    private String pwd;
    private String name;
    private String grant; // 1 관리자 , 2 일반

    public Account() {
        this.id = "";
        this.pwd = "";
        this.name = "";
        this.grant = "";
    }

    public Account(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public Account(String id, String pwd, String name, String grant) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.grant = grant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrant() {
        return grant;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }
}