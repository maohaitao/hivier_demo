package com.bikemanage.common.tools;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述：
 * 创建时间：15/5/11
 * 作者：yanghui
 */
public class DateRangeEditor extends PropertiesEditor {
    public static final String DELIMITER = "至";
    private static final DateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
    private static final DateFormat DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private DateFormat dateFormat;
    private boolean allowEmpty = true;

    public DateRangeEditor() {
    }

    public DateRangeEditor(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DateRangeEditor(DateFormat dateFormat, boolean allowEmpty) {
        this.dateFormat = dateFormat;
        this.allowEmpty = allowEmpty;
    }

    private Date getTextValue(String text) {
        try {
            if (this.dateFormat != null)
                return this.dateFormat.parse(text);
            else {
                if (text.contains(":"))
                    return DATETIME.parse(text);
                else
                    return DATE.parse(text);
            }
        } catch (ParseException e) {
            return null;
        }

    }

    /**
     * Format the Date as String, using the specified DateFormat.
     */
    @Override
    public String getAsText() {
        DateRange value = (DateRange) getValue();
        DateFormat dateFormat = this.dateFormat;
        if (dateFormat == null)
            dateFormat = DATETIME;
        String startDate = (value != null && value.getStartDateTime() != null ? dateFormat.format(value.getStartDateTime()) : "");
        String endDate = (value != null && value.getEndDateTime() != null ? dateFormat.format(value.getEndDateTime()) : "");
        return startDate + DELIMITER + endDate;
    }

    /**
     * Parse the Date from the given text, using the specified DateFormat.
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (this.allowEmpty && !StringUtils.hasText(text)) {
            // Treat empty String as null value.
            setValue(null);
        } else {

            if (text.contains(DELIMITER)) {
                String[] textRange = text.split(DELIMITER);
                setValue(new DateRange(getTextValue(textRange[0]), getTextValue(textRange[1]), text));
            } else {
                setValue(new DateRange(getTextValue(text), null, text));
            }


        }
    }
}
