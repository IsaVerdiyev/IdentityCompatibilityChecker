import com.Matcher.Interfaces.WordTransformer;
import com.Matcher.Main;
import com.Matcher.Services.SymbolsReplacer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Main.class)
/*
@PropertySource("classpath:application.properties")
*/
public class SymbolsReplacerTest {

    @Autowired
   private WordTransformer autoWiredSymbolsReplacer;

    @Test
    public void recieveTransformedWordTest1() {

        String input = "Orkhan";
        String output = autoWiredSymbolsReplacer.recieveTransformedWord(input);

        assertEquals("örxax", output);
    }

    @Test
    public void recieveTransformedWordTest2() {

        String input = "Orkhankh";
        String output = autoWiredSymbolsReplacer.recieveTransformedWord(input);

        assertEquals("örxax", output);
    }


    @Test
    public void recieveTransformedWordTest3() {

        String input = "Əzizova Shəhnizə";
        String output = autoWiredSymbolsReplacer.recieveTransformedWord(input);

        assertEquals("azizöva waxiza", output);
    }

    @Test
    public void recieveTransformedWordTest4() {

        String input = "Xeyrəddin Alıyev";
        String output = autoWiredSymbolsReplacer.recieveTransformedWord(input);

        assertEquals("xayradix aliyav", output);
    }

    @Test
    public void recieveTransformedWordTest5(){
        String input1 = "Ahmadova Saadat Zakir";
        String input2 = "Əhmədova Səadət Zakir";
        String output1 = autoWiredSymbolsReplacer.recieveTransformedWord(input1);
        String output2 = autoWiredSymbolsReplacer.recieveTransformedWord(input2);

        assertEquals(output1, output2);
    }

    @Test
    public void recieveTransformedWordTest6(){
        String input1 = "Abbasov Aliqulu Shoyub";
        String input2 = "Abbasov Əliqulu Şöyüb";
        String output1 = autoWiredSymbolsReplacer.recieveTransformedWord(input1);
        String output2 = autoWiredSymbolsReplacer.recieveTransformedWord(input2);

        assertEquals(output1, output2);
    }

    @Test
    public void recieveTransformedWordTest7(){
        String input1 = "Rahimova. Sabina Celil";
        String input2 = "Rəhimova Səbinə Cəlil";
        String output1 = autoWiredSymbolsReplacer.recieveTransformedWord(input1);
        String output2 = autoWiredSymbolsReplacer.recieveTransformedWord(input2);

        assertEquals(output1, output2);
    }


    @Test
    public void recieveTransformedWordTest8(){
        String input1 = "Abasova Minara -----";
        String input2 = "Abasova Minara ";
        String output1 = autoWiredSymbolsReplacer.recieveTransformedWord(input1);
        String output2 = autoWiredSymbolsReplacer.recieveTransformedWord(input2);

        assertEquals(output1, output2);
    }
}
