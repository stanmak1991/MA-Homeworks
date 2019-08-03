package Homework10;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    private byte[] charsSequence;

    public AsciiCharSequence(byte[] sequence) {
        charsSequence = Arrays.copyOf(sequence, sequence.length);
    }

    @Override
    public int length() {
        return charsSequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char) charsSequence[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] byteSubSequence = Arrays.copyOfRange(charsSequence, start, end);
        AsciiCharSequence result = new AsciiCharSequence(byteSubSequence);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (byte b : charsSequence) {
            result.append((char) b);
        }
        return result.toString();
    }
}
