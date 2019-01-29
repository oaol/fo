package com.fo.up;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

public class excelTest {
	@Test
	public void excelTest() {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("E:\\minsheng.xls"));
			// 解析每行结果在listener中处理
			ExcelListener listener = new ExcelListener();
			ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, listener);
			excelReader.read(new Sheet(1, 2, LoanInfo.class));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
