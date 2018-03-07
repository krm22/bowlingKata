import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class BowlingTest extends TestCase {

    private Bowling b;

    protected void setUp() throws Exception {
        b = new Bowling();
    }

    @Test
    public void rollMany(int number, int pins) throws Exception{
        for(int i=0; i < number; i++){
            b.roll(pins);
        }
    }

    @Test
    public void testGutterGame() throws Exception{
          rollMany(20,0);
          assertEquals(0, b.score());
    }

    @Test
    public void testForAllOnes() throws Exception{
       rollMany(20, 1);
       assertEquals(20, b.score());
    }
    @Test
    public void testOneSpareThen3then0() throws Exception{
        rollStrike();
        b.roll(3);
        rollMany(17, 0);
        assertEquals(16, b.score());
    }
    @Test
    public void testOneSpareThen3then4Then0() throws Exception{
        b.roll(10);
        b.roll(3);
        b.roll(4);
        rollMany(16, 0);
        assertEquals(24, b.score());
    }

    public void testPerfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, b.score());
    }

    private void rollStrike(){
        b.roll(10);
    }

    private void rollSpare() {
        b.roll(5);
        b.roll(5);
    }
}