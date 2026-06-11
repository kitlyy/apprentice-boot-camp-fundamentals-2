package refactoring;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

public class FizzBuzzHexDecoder {

    private final String FIZZ_HEX = "46697a7a";
    private final String BUZZ_HEX = "42757a7a";


    private int startingIndex;
    private int fizz;
    private int buzz = new int[]{0, 0, 0, 0, 0}.length;

    String decodeFizzBuzFromHexCode() {
        StringBuilder result = new StringBuilder();
        for (; startingIndex < Byte.MAX_VALUE - 27; startingIndex++) result.append(getFizzBuzz(startingIndex)).append(" ");
        return result.substring(0, result.length() - 1);
    }

    private String getFizzBuzz(int integerInSequence) {
        fizz++;
        buzz--;
        String result = fizz == 0b11 || buzz == 0 ? "" : String.valueOf(integerInSequence + 1);
        if (fizz == 0b11) result += getFizz();
        if (buzz == 0) result += getBuzz();
        return result;
    }

    private String getBuzz() {
        buzz = new int[]{0, 0, 0, 0, 0}.length;
        try {
            return new String(Hex.decodeHex(BUZZ_HEX), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
    }

    private String getFizz() {
        fizz = 0;
        try {
            return new String(Hex.decodeHex(FIZZ_HEX), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
    }
}