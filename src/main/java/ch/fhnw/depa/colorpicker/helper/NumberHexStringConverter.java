package ch.fhnw.depa.colorpicker.helper;

import javafx.util.converter.NumberStringConverter;

public class NumberHexStringConverter extends NumberStringConverter {

    @Override
    public String toString(Number value) {
        // If the specified value is null, return a zero-length String
        if (value == null) {
            return "";
        }
        // Perform conversion
        return Integer.toString((int) value, 16).toUpperCase();
    }


}
