package cn.fenqing168.springboot.error;

public class UserNotExistException extends RuntimeException {

    public UserNotExistException(){
        super("用户不存在");
    }

}
