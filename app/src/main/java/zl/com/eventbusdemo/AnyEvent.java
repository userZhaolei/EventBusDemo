package zl.com.eventbusdemo;

/**
 * create user zhaolei  代码无bug
 * 时间:2017/9/13
 */

public class AnyEvent {
    private String string;
    private int id;

    public AnyEvent(String string, int id) {
        this.string = string;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
