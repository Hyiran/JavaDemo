package com.Excel����.demo;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * excel��ȡ�࣬���ڶ�ȡexcel����
 * 
 * @author Administrator
 * 
 */
public class ExcelReadUtil {
	/**
	 * 
	 * @param sheet_id
	 *            ������ID��0��ʼ
	 * @param start_row
	 *            ��ʼ�д�0��ʼ
	 * @param end_row
	 *            ������ ��0��ʼ
	 * @param start_col
	 *            ��ʼ�У���0��ʼ
	 * @param end_col
	 *            �����д�0��ʼ
	 * @return Object[][]
	 */
	public static Object[][] case_data_excel(int sheet_id, int start_row,int end_row, int start_col, int end_col, String sourcefile){
		String cell_value = null;
		Cell cell = null;
		ArrayList<Object> testcase_data_list = new ArrayList<Object>();
		String[][] testcase_data_array = new String[end_row - start_row + 1][end_col - start_col + 1]; // ������ά���鱣���Ӧ������
		Workbook testcase_data_workbook = null;
		try {

			testcase_data_workbook = Workbook.getWorkbook(new File(sourcefile));
			Sheet testcase_data_sheet = testcase_data_workbook.getSheet(sheet_id);
			int rows = testcase_data_sheet.getRows();
			int cols = testcase_data_sheet.getColumns();
			if (end_row - start_row + 1 > rows) {
				System.out.println("ѡ�����������ʵ�����ݷ�Χ��");
			}
			if (end_col - start_col + 1 > cols) {
				System.out.println("ѡ���������������ʵ�����ݷ�Χ��");
			}
			if (end_row > rows - 1) {
				System.out.println("�б곬��ʵ��������");
			}
			if (end_col > cols - 1) {
				System.out.println("�б곬��ʵ��������");
			}
			// ��ȡÿ����������
			for (int row = start_row, i = 0; row <= end_row	|| i < testcase_data_array.length; row++, i++) {
				// ��һ�����飬���ÿ�����ݡ�
				// ÿѭ��һ�У���ʼ��һ�����飬��ԭ�������ڴ��ͷ�
				// �ر�ע�⣬ֻȡһ������ļ������ݵ�ʱ������ĳ���һ��Ҫ��ʼ����ȷ
				String[] row_array = new String[end_col - start_col + 1];
				for (int col = start_col, j = 0; col <= end_col
						|| j < row_array.length; col++, j++) {
					cell = testcase_data_sheet.getCell(col, row);
					if (cell.getType() == CellType.DATE) {
						DateCell dc = (DateCell) cell;
						Date date = dc.getDate(); // ��ȡ��Ԫ���date����
						cell_value = formatDate(date, "yyyy-MM-dd");
					} else {
						cell_value = testcase_data_sheet.getCell(col, row)
								.getContents();
					}

					// ��ÿһ�е�ÿһ����ֵ��ֵ�������飬ѭ�������鸳ֵ
					row_array[j] = cell_value;
				}
				// ÿ���һ�����ݾͽ�����룬����LIST�б���
				testcase_data_list.add(row_array);

			}

			String[][] testcase_data_array_try = new String[testcase_data_list
					.size()][end_col - start_col + 1];
			testcase_data_array_try = testcase_data_list
					.toArray(testcase_data_array_try);
			testcase_data_array = testcase_data_array_try;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Object[][] testcase_data_object = (Object[][]) testcase_data_array;
		return testcase_data_object;

	}

	/**
	 * 
	 * @param sheet_id
	 *            ������ID��0��ʼ
	 * @param start_row
	 *            ��ʼ�д�0��ʼ
	 * @param end_row
	 *            ������ ��0��ʼ
	 * @param start_col
	 *            �����У���0��ʼ
	 * @param end_col
	 *            �����д�0��ʼ
	 * @return ���� Object[][]
	 */
	public static Object[][] case_data_excel(int sheet_id, int start_row,
			int end_row, int start_col, int end_col,
			InputStream SourceInputStream

	) {
		String cell_value = null;
		Cell cell = null;
		ArrayList<Object> testcase_data_list = new ArrayList<Object>();
		String[][] testcase_data_array = new String[end_row - start_row + 1][end_col
				- start_col + 1];
		// System.out.println(SourceInputStream);
		try {
			Workbook testcase_data_workbook = Workbook
					.getWorkbook(SourceInputStream);
			Sheet testcase_data_sheet = testcase_data_workbook
					.getSheet(sheet_id);
			int rows = testcase_data_sheet.getRows();
			int cols = testcase_data_sheet.getColumns();
			if (end_row - start_row + 1 > rows) {
				System.out.println("ѡ�����������ʵ�����ݷ�Χ��");
			}
			if (end_col - start_col + 1 > cols) {
				System.out.println("ѡ���������������ʵ�����ݷ�Χ��");
			}
			if (end_row > rows - 1) {
				System.out.println("�б곬��ʵ��������");
			}
			if (end_col > cols - 1) {
				System.out.println("�б곬��ʵ��������");
			}
			// ��ȡÿ����������
			for (int row = start_row, i = 0; row <= end_row
					|| i < testcase_data_array.length; row++, i++) {
				// ��һ�����飬���ÿ�����ݡ�//ÿѭ��һ�У���ʼ��һ�����飬��ԭ�������ڴ��ͷ�
				// �ر�ע�⣬ֻȡһ������ļ������ݵ�ʱ������ĳ���һ��Ҫ��ʼ����ȷ
				String[] row_array = new String[end_col - start_col + 1];
				for (int col = start_col, j = 0; col <= end_col
						|| j < row_array.length; col++, j++) {
					cell = testcase_data_sheet.getCell(col, row);
					if (cell.getType() == CellType.DATE) {
						DateCell dc = (DateCell) cell;
						Date date = dc.getDate(); // ��ȡ��Ԫ���date����
						cell_value = formatDate(date, "yyyy-MM-dd");
					} else {
						cell_value = testcase_data_sheet.getCell(col, row)
								.getContents();
					}

					// ��ÿһ�е�ÿһ����ֵ��ֵ�������飬ѭ�������鸳ֵ
					row_array[j] = cell_value;
				}
				// ÿ���һ�����ݾͽ�����룬����LIST�б���
				testcase_data_list.add(row_array);

			}

			String[][] testcase_data_array_try = new String[testcase_data_list
					.size()][end_col - start_col + 1];
			testcase_data_array_try = testcase_data_list
					.toArray(testcase_data_array_try);
			testcase_data_array = testcase_data_array_try;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Object[][] testcase_data_object = (Object[][]) testcase_data_array;
		return testcase_data_object;

	}

	/**
	 * 
	 * @param sheet_id
	 *            ������ID��0��ʼ
	 * @return Object[][]
	 */
	public static Object[][] case_data_excel(int sheet_id, String sourcefile) {
		String cell_value = null;
		Cell cell = null;
		ArrayList<Object> testcase_data_list = new ArrayList<Object>();
		String[][] testcase_data_array = null;
		Workbook testcase_data_workbook = null;
		try {
			testcase_data_workbook = Workbook.getWorkbook(new File(sourcefile));
			Sheet testcase_data_sheet = testcase_data_workbook.getSheet(sheet_id);
			int rows = testcase_data_sheet.getRows();
			int cols = testcase_data_sheet.getColumns();
			System.out.println("������ " + rows + "������ " + cols);
			testcase_data_array = new String[rows][cols];
			// ��ȡÿ����������
			for (int row = 0, i = 0; row <= rows - 1|| i < testcase_data_array.length; row++, i++) {
				// ��һ�����飬���ÿ�����ݡ�//ÿѭ��һ�У���ʼ��һ�����飬��ԭ�������ڴ��ͷ�
				// �ر�ע�⣬ֻȡһ������ļ������ݵ�ʱ������ĳ���һ��Ҫ��ʼ����ȷ
				String[] row_array = new String[cols];
				for (int col = 0, j = 0; col <= cols - 1 || j < row_array.length; col++, j++) {
					cell = testcase_data_sheet.getCell(col, row);
					if (cell.getType() == CellType.DATE) {
						DateCell dc = (DateCell) cell;
						Date date = dc.getDate(); // ��ȡ��Ԫ���date����
						cell_value = formatDate(date, "yyyy-MM-dd");
					} else {
						cell_value = testcase_data_sheet.getCell(col, row).getContents();
					}

					// ��ÿһ�е�ÿһ����ֵ��ֵ�������飬ѭ�������鸳ֵ
					row_array[j] = cell_value;
				}
				// ÿ���һ�����ݾͽ�����룬����LIST�б���
				testcase_data_list.add(row_array);
			}

			String[][] testcase_data_array_try = new String[testcase_data_list
					.size()][cols];
			testcase_data_array_try = testcase_data_list
					.toArray(testcase_data_array_try);
			testcase_data_array = testcase_data_array_try;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Object[][] testcase_data_object = (Object[][]) testcase_data_array;
		return testcase_data_object;
	}

	private static String formatDate(Date date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		System.out.println(formatter.format(date).toString());
		return formatter.format(date).toString();
	}

	public static void main(String[] args) {
		String filePath = "hospital_id_list_gw.xls";
		Object[][] excel = ExcelReadUtil.case_data_excel(0, filePath);
		System.out.println(excel.length);
		for (int i = 0; i < excel.length; i++) {
			Object[] excel2 = excel[i];
			for (int j = 0; j < excel2.length; j++) {
				System.out.println(excel2[j]);
			}
		}
	}
}
