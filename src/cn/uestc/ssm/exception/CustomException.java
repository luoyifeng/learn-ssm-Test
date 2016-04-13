package cn.uestc.ssm.exception;

/**
 * <p>Title: </p>
 * <p>Description: 自定义异常类，针对预期异常</p>
 * <p>School: UESTC</p>
 *
 * @version 1.0
 * @author 罗一峰
 * @date 2016/4/13/9:42
 */
public class CustomException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomException(String message) {
        super(message);
        this.message = message;
    }
}
