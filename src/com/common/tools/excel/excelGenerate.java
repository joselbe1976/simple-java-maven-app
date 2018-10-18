/*
 * 2018. Equilibrha. Generate Auto a Excel from Data MAP of SQL sentence
 */

package com.common.tools.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.common.config.ParamsApp;
import com.common.tools.interfaces.iDisposable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class excelGenerate  implements iDisposable{

	//generate Excel and Return Path to the File
	@SuppressWarnings("rawtypes")
	public String generateExcelFile(String key, List<?> data, List<String> Columns) throws IOException {
		
		String MimeType = "xls";
		String file = new ParamsApp().GetFichTemporal(key,MimeType); 
		String sheetName = "query";//name of sheet

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName) ;
		Map rowd =null;
		
		
		
		try {
		
				int RowExcel = 0; //file to print
				
				//iterating r number of rows
				for (int r=0;r < data.size(); r++ )
				{
					HSSFRow row = sheet.createRow(RowExcel);
					
					rowd = (Map)data.get(r);
					
					//print Column names
					if (r == 0) {
				
						for (int i = 0; i < Columns.size(); i++) {
							HSSFCell cell = row.createCell(i);
							cell.setCellValue(Columns.get(i));
						}
						RowExcel++;
						row = sheet.createRow(RowExcel);
					}
				
					
					//print data of the row
					for (int i = 0; i < Columns.size(); i++) {
						HSSFCell cell = row.createCell(i);
						String columnaID = Columns.get(i).toString().trim();
						
					
						try {
							if (rowd.get(columnaID) != null) {
								cell.setCellValue(rowd.get(columnaID).toString());
							}
						}
						catch(Exception e) {
							System.out.println("\n Error: " + columnaID + " y  r =  " +  r);
						}
					}
					RowExcel++;
				
				
				}
				
				FileOutputStream fileOut = new FileOutputStream(file);
				
				//write this workbook to an Outputstream.
				wb.write(fileOut);
				fileOut.flush();
				fileOut.close();
	
		}
		catch(Exception ee) {
			
		}
		finally {
			
		}
		
		return file;
	}

	
	
	
	@Override
	public void Dispose() {

		
	}
	
	
	
	
}
