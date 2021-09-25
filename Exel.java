import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exel {
    public static ArrayList<String> dateList = new ArrayList<String>();
    public static ArrayList<String> formatList = new ArrayList<String>();


    public static ArrayList<String> getDateList() {
        return dateList;
    }

    public static ArrayList<String> getFormatList() {
        return formatList;
    }

    public static void setDateList(ArrayList<String> dateList) {
        Exel.dateList = dateList;
    }

    public static void setFormatList(ArrayList<String> formatList) {
        Exel.formatList = formatList;
    }

    public static void parsToJava(){
        try {

            FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\Bot\\Бот.xlsx")); //путь к файлу
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile); //Объект для файла
            XSSFSheet sheet = workbook.getSheetAt(0); //берем страницу файла. Индекс страницы = 0
            Iterator<Row> rowIterator = sheet.iterator(); // Создаем итератор для перебора строк
            while (rowIterator.hasNext()){ //до тех пор пока существует следующая строка...
                Row row = rowIterator.next(); //объект для строки
                Iterator<Cell> cellIterator = row.cellIterator();

                Cell cellOfDate = cellIterator.next();
                Cell cellOfFormat = cellIterator.next();
                dateList.add(cellOfDate.getStringCellValue());
                formatList.add(cellOfFormat.getStringCellValue());
            }
            System.out.print("\n");

            excelFile.close();
            System.out.println(dateList.toString());
            System.out.println(formatList.toString());

        }catch (Exception e){
            System.out.println("Error");
        }
    }
}