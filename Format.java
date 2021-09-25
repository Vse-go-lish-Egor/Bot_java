import java.util.ArrayList;

public class Format {
    public static ArrayList<String> date = new ArrayList<String>();
    public static ArrayList<String> format = new ArrayList<String>();
    public static ArrayList<String> dateByFormat = new ArrayList<String>();

    public Format() {
    }

    public static ArrayList<String> getDate() {
        return date;
    }

    public static ArrayList<String> getFormat() {
        return format;
    }

    public static void setDate(ArrayList<String> date) {
        Format.date = date;
    }

    public static void setFormat(ArrayList<String> format) {
        Format.format = format;
    }

    public static void setDateByFormat(ArrayList<String> dateByFormat) {
        Format.dateByFormat = dateByFormat;
    }

    public static ArrayList<String> getDateByFormat() {
        return dateByFormat;
    }

    public static void formatChoose(String wordFormat){

        for(int i=0; format.size()>i;i++){
            if(wordFormat.equals(format.get(i))){
                dateByFormat.add(date.get(i));
            }
        }


    }
}
