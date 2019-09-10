import com.Matcher.Interfaces.DublicateCharRemover;
import com.Matcher.Services.DublicatesRemoverImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

public class DublicatesRemoverTest {
    @Test
    public void removeDublicatesTest(){
        String str = "Mammmadov";

        DublicateCharRemover dublicateCharRemover = new DublicatesRemoverImpl();
        String result = dublicateCharRemover.removeDublicates(str);
        Assert.assertEquals("Mamadov", result);
    }

}
