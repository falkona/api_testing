package ddnTesting.utils;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class DateUtils {

    public String currentDateToString(String pattern, Locale locale) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern, locale));
    }
}
