import com.Matcher.Interfaces.OtherWordsRemover;
import com.Matcher.Services.OtherWordsRemoverImpl;

import static org.junit.Assert.assertEquals;

public class OtherWordsRemoverTest {
    OtherWordsRemover otherWordsRemover = new OtherWordsRemoverImpl();

    public void removeOtherWordsTest(){
        String word = "Saleh ogli";
        String result = otherWordsRemover.removeOtherWords(word);
        assertEquals("Saleh ", result);
    }
}
