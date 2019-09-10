import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;

import java.text.Normalizer;

import static org.junit.Assert.assertEquals;

public class AzEnIcomparator {
    @Test
    public void test(){
        String str1 = "Isa";
        String str2 = "İsa";

        str1 = Normalizer.normalize(str1, Normalizer.Form.NFD).replaceAll("[\\u0300-\\u036F]", "");
        str2 = Normalizer.normalize(str2, Normalizer.Form.NFD).replaceAll("[\\u0300-\\u036F]", "");

        //System.out.println((int)str1.toLowerCase().charAt(1));
        System.out.println((int)str2.toLowerCase().charAt(1));
        assertEquals(str1,str2);
    }
}
