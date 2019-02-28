package com.lkq.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class ExcelUtil {
	
	public static void main(String[] args) throws IOException {
		get();
	}
	
	public static void get() throws IOException {
		String arg0 = "C:\\1.xls";
		Map<String, String> map = new HashMap<String, String>();
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(arg0));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet hssfSheet = wb.getSheetAt(0);// ȡ�õ�1ҳ
		int Count = 0;
		if (hssfSheet != null) {
			//hssfSheet.getLastRowNum()��ʾ���һ��  �����ж�����
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow row = hssfSheet.getRow(rowNum);
				if (row == null) {
					continue;
				}
				String name = formatCell(row.getCell(0));
				String phone = formatCell(row.getCell(1));
				map.put(phone, name);
				// System.out.println(name+"___"+phone);
				Count++;
			}
		}
		
		System.out.println(Count);
		System.out.println(map.size());
		
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("������ " +entry.getValue()  + " ___�绰 " + entry.getKey());
		}
	}

	/**
	 * ��ʽ����Ԫ�񷵻�������
	 * @param cell
	 * @return
	 */
	public static String formatCell(HSSFCell cell) {
		if (cell == null) {
			return "";
		} else {
			if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(cell.getBooleanCellValue());
			} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			} else {
				return String.valueOf(cell.getStringCellValue());
			}
		}
	}

}
