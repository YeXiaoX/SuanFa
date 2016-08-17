/**
 * Created by Zhanghui on 2016/8/17.
 */
public class Test {
    public static void main(String args[]){
       //final Singleton s = Singleton.getSingleton();
        Thread thread = new Thread(){
            @Override
            public void run() {
                Singleton ss = Singleton.getSingleton();
                ss.setName("name");
                System.out.println(ss);
            }
        };
        thread.start();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                Singleton ss = Singleton.getSingleton();
                System.out.println(ss);
                System.out.println(ss.getName());
            }
        };
        thread1.start();
    }
}
