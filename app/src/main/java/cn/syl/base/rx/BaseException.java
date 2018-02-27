package cn.syl.base.rx;

/**
 * @author: syl  Date: 2018/2/26  Email:nerosyl@live.com
 */
public class BaseException extends  Throwable {
  private Integer status;
  private String msg;


    public BaseException(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
