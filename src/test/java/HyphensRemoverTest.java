import com.Matcher.Interfaces.HyphenRemover;
import com.Matcher.Services.HyphensRemoverImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HyphensRemoverTest {
    @Test
    public void removeHyphensTest(){
        String input = "---- some - td -";
        HyphenRemover  hyphenRemover = new HyphensRemoverImpl();
        String result = hyphenRemover.removeHyphens(input);
        assertEquals(" some  td ", result);
    }
}
