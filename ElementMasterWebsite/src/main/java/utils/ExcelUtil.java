package utils;

	import java.io.FileInputStream;
	import org.apache.poi.xssf.usermodel.*;

	public class ExcelUtil {

	    public static Object[][] getData(String sheetName) {

	        try {
	            FileInputStream fis = new FileInputStream("src/test/resources/testdata/testdata.xlsx");
	            XSSFWorkbook wb = new XSSFWorkbook(fis);
	            XSSFSheet sheet = wb.getSheet(sheetName);

	            int rows = sheet.getPhysicalNumberOfRows();
	            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

	            Object[][] data = new Object[rows - 1][cols];

	            for (int i = 1; i < rows; i++) {
	                for (int j = 0; j < cols; j++) {
	                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
	                }
	            }

	            wb.close();
	            return data;

	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	}

