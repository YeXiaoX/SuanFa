/**
 * Created by Zhanghui on 2016/8/17.
 */
public class Singleton {
    private static Singleton singleton;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Singleton() {
        System.out.println("aa");
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Singleton getSingleton() {
        System.out.println("bb");
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
