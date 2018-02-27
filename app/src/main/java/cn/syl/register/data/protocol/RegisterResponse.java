package cn.syl.register.data.protocol;

/**
 * @author: syl  Date: 2018/2/26  Email:nerosyl@live.com
 */
public class RegisterResponse {
    private String mobile;
    private String pwd;
    private String verifyCode;

    public RegisterResponse(String mobile, String pwd, String verifyCode) {
        this.mobile = mobile;
        this.pwd = pwd;
        this.verifyCode = verifyCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}