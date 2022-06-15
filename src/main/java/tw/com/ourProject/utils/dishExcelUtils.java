package tw.com.ourProject.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import tw.com.ourProject.model.dishExcelBean;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * 操作excel
 * */
public class dishExcelUtils {

    public static List<dishExcelBean> excelToShopIdList(InputStream inputStream) {
        List<dishExcelBean> list = new ArrayList<>();
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
            //工作表对象
            Sheet sheet = workbook.getSheetAt(0);
            //总行数
            int rowLength = sheet.getLastRowNum();
            //            System.out.println("总行数有多少行" + rowLength);
            //工作表的列
            Row row = sheet.getRow(0);

            //总列数
            int colLength = row.getLastCellNum();
            //            System.out.println("总列数有多少列" + colLength);
            //得到指定的单元格
            Cell cell = row.getCell(0);
            for (int i = 1; i <= rowLength; i++) {
                dishExcelBean jiFenExcel = new dishExcelBean();
                row = sheet.getRow(i);
                for (int j = 0; j < colLength; j++) {
                    //列： 0項次 1品項 2組合內容 3菜單照片 4單價 5餐廳編號
                    cell = row.getCell(j);
                    //                    System.out.print(cell + ",");
                    if (cell != null) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String data = cell.getStringCellValue();
                        data = data.trim();
                        //                        System.out.print(data);
                        //                        if (StringUtils.isNumeric(data)) {
                        if (j == 0) {
                            jiFenExcel.setNum(data);
                        } else if (j == 1) {
                            jiFenExcel.setDishnum(data);
                        } else if (j == 2) {
                            jiFenExcel.setSetcontent(data);
                        } else if (j == 3) {
                            jiFenExcel.setDishphoto(data);
                        } else if (j == 4) {
                            jiFenExcel.setPrice(Integer.parseInt(data));
                        } else if (j == 5) {
                            jiFenExcel.setRestnum(data);
                        }
                    }
                }
                list.add(jiFenExcel);
                //                System.out.println("====");
            }
        } catch (Exception e) {
        }
        return list;
    }
}