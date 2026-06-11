package refactoring;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

public class FizzBuzzHexDecoder {

    private int startingIndex;
    private int fizz;
    private int buzz = 5;

    String decodeFizzBuzFromHexCode() {
        StringBuilder result = new StringBuilder();
        for (; startingIndex < 100; startingIndex++) result.append(getFizzBuzz(startingIndex)).append(" ");
        return result.substring(0, result.length() - 1);
    }

    private String getFizzBuzz(int integerInSequence) {
        fizz++;
        buzz--;
        boolean isFizzBuzz = fizz == 3 || buzz == 0;
        String result = isFizzBuzz ? "" : String.valueOf(integerInSequence + 1);
        if (fizz == 3) {
            fizz = 0;
            result += "Fizz";
        }
        if (buzz == 0) {
            buzz = 5;
            result += "Buzz";
        }
        return result;
    }
}