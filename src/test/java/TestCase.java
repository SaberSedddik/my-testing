import org.junit.Test;
public class TestCase {
    String string = "Begin:\uFFFF\uFFDA\uFFA0:End";
    @Test
    public void test1() throws InterruptedException {
        System.out.println("test1 startup");
        Thread.sleep(3000);
        System.out.println("test1 shutdown");
    }
    @Test
    public void test2() throws InterruptedException {
        System.out.println("test2 startup");
        Thread.sleep(3000);
        System.out.println("test2 shutdown");
    }
}
