package com.yanxi.anim.sys.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.yanxi.anim.sys.pojo.AnimDept;
import com.yanxi.anim.sys.pojo.AnimEmployee;
import com.yanxi.anim.sys.pojo.AnimRes;
import com.yanxi.anim.sys.pojo.AnimResCatagorty;
import com.yanxi.anim.sys.pojo.AnimRole;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class POIUtils {

	public List<AnimEmployee> readEmployeeDate(String filePath) {
		// 读取表格
		List<AnimEmployee> employeeos = readEmployeeExcel(filePath);
		return employeeos;
	}

	private List<AnimEmployee> readEmployeeExcel(String filePath) {
		File file = new File(filePath);
		List<AnimEmployee> employees = new ArrayList<>();
		if (file.exists()) {
			try {
				Workbook workboot = Workbook.getWorkbook(file);
				Sheet sheet = workboot.getSheet(0);
				int rows = sheet.getRows();
				int columns = sheet.getColumns();
				for (int row = 1; row < rows; row++) {
					AnimEmployee employee = new AnimEmployee();
					for (int column = 0; column < columns; column++) {
						Cell cell = sheet.getCell(column, row);
						String content = cell.getContents().trim();
						if (column == 0) {
							employee.setEmployeeName(content);
						} else if (column == 1) {
							employee.setEmployeeAge(Integer.parseInt(content));
						} else if (column == 2) {
							employee.setEmployeeBorn(content);
						} else if (column == 3) {
							employee.setEmployeeSex(content);
						} else if (column == 4) {
							employee.setEmployeeCardnum(content);
						} else if (column == 5) {
							employee.setEmployeeSchool(content);
						} else if (column == 6) {
							employee.setEmployeeMajor(content);
						} else if (column == 7) {
							employee.setEmployeeEducation(content);
						} else if (column == 8) {
							employee.setEmployeeFamilyAddress(content);
						} else if (column == 9) {
							employee.setEmployeeNowAddress(content);
						} else if (column == 10) {
							employee.setEmployeeTelephone(content);
						} else if (column == 11) {
							employee.setEmployeeQq(content);
						} else if (column == 12) {
							employee.setEmployeeWechant(content);
						} else if (column == 13) {
							employee.setEmployeeWorkedTime(content);
						} else if (column == 14) {
							if ("离职".equals(content.trim())) {
								employee.setIsleaved(true);
							} else {
								employee.setIsleaved(false);
							}
						} else if (column == 15) {
							AnimRole animRole = new AnimRole();
							animRole.setRoleName(content);
							employee.setAnimRole(animRole);
						} else if (column == 16) {
							AnimDept animDept = new AnimDept();
							animDept.setDeptName(content);
							employee.setAnimDept(animDept);
						}
					}
					String time = DateFormate.formateDateToString(new Date());
					employee.setEmployeeCreatetime(time);
					employee.setEmployeeUpdatetime(time);
					employees.add(employee);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (BiffException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

	public List<AnimDept> redDeptData(String filePath) {
		File file = new File(filePath);
		List<AnimDept> depts = new ArrayList<>();
		if (file.exists()) {
			try {
				Workbook workboot = Workbook.getWorkbook(file);
				Sheet sheet = workboot.getSheet(0);
				int rows = sheet.getRows();
				int columns = sheet.getColumns();
				for (int row = 1; row < rows; row++) {
					AnimDept animDept = new AnimDept();
					for (int column = 0; column < columns; column++) {
						Cell cell = sheet.getCell(column, row);
						String content = cell.getContents().trim();
						if (column == 0) {
							animDept.setDeptName(content);
						} else if (column == 1) {
							animDept.setDeptDesc(content);
						} else if (column == 2) {
							animDept.setDeptCreatetime(content);
						} else if (column == 3) {
							if ("是".equals(content)) {
								animDept.setIsdeleted(true);
							} else {
								animDept.setIsdeleted(false);
							}
						} else if (column == 4) {
							AnimDept parent = new AnimDept();
							parent.setDeptName(content);
							animDept.setParent(parent);
						}
						String time = DateFormate.formateDateToString(new Date());
						animDept.setDeptUpdatetime(time);
						depts.add(animDept);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (BiffException e) {
				e.printStackTrace();
			}
		}
		return depts;
	}

	public List<AnimResCatagorty> redResCatagortyData(String filePath) {
		File file = new File(filePath);
		List<AnimResCatagorty> resCatagorties = new ArrayList<>();
		if (file.exists()) {
			try {
				Workbook workboot = Workbook.getWorkbook(file);
				Sheet sheet = workboot.getSheet(0);
				int rows = sheet.getRows();
				int columns = sheet.getColumns();
				for (int row = 1; row < rows; row++) {
					AnimResCatagorty resCatagorty = new AnimResCatagorty();
					for (int column = 0; column < columns; column++) {
						Cell cell = sheet.getCell(column, row);
						String content = cell.getContents().trim();
						if (column == 0) {
							resCatagorty.setResCatagortyName(content);
						} else if (column == 1) {
							if ("是".equals(content)) {
								resCatagorty.setIsdeleted(true);
							} else {
								resCatagorty.setIsdeleted(false);
							}
						} else if (column == 2) {
							AnimResCatagorty parent = new AnimResCatagorty();
							parent.setResCatagortyName(content);
							resCatagorty.setParent(parent);
						}
						String time = DateFormate.formateDateToString(new Date());
						resCatagorty.setResCatagortyCreatetime(time);
						resCatagorty.setResCatagortyUpdatetime(time);
						resCatagorties.add(resCatagorty);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (BiffException e) {
				e.printStackTrace();
			}
		}
		return resCatagorties;
	}

	public List<AnimRes> redResData(String filePath) {
		File file = new File(filePath);
		List<AnimRes> res = new ArrayList<>();
		if (file.exists()) {
			try {
				Workbook workboot = Workbook.getWorkbook(file);
				Sheet sheet = workboot.getSheet(0);
				int rows = sheet.getRows();
				int columns = sheet.getColumns();
				for (int row = 1; row < rows; row++) {
					AnimRes animRes = new AnimRes();
					for (int column = 0; column < columns; column++) {
						Cell cell = sheet.getCell(column, row);
						String content = cell.getContents().trim();
						if (column == 0) {
							animRes.setResName(content);
						} else if (column == 1) {
							animRes.setResUrl(content);
						} else if (column == 2) {
							animRes.setResSize(content);
						} else if (column == 3) {
							if ("是".equals(content)) {
								animRes.setIsdeleted(true);
							} else {
								animRes.setIsdeleted(false);
							}
						} else if (column == 4) {
							AnimResCatagorty resCatagorty = new AnimResCatagorty();
							resCatagorty.setResCatagortyName(content);
							animRes.setAnimResCatagorty(resCatagorty);
						}
						String time = DateFormate.formateDateToString(new Date());
						animRes.setResCreatetime(time);
						animRes.setResUpdatetime(time);
						res.add(animRes);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (BiffException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	public List<AnimRole> redRoleData(String filePath) {
		File file = new File(filePath);
		List<AnimRole> roles = new ArrayList<>();
		if (file.exists()) {
			try {
				Workbook workboot = Workbook.getWorkbook(file);
				Sheet sheet = workboot.getSheet(0);
				int rows = sheet.getRows();
				int columns = sheet.getColumns();
				for (int row = 1; row < rows; row++) {
					AnimRole animRole = new AnimRole();
					for (int column = 0; column < columns; column++) {
						Cell cell = sheet.getCell(column, row);
						String content = cell.getContents().trim();
						if (column == 0) {
							animRole.setRoleName(content);
						} else if (column == 1) {
							animRole.setRoleDesc(content);
						} else if (column == 2) {
							animRole.setRoleDuty(content);
						} else if (column == 3) {
							AnimDept animDept = new AnimDept();
							animDept.setDeptName(content);
							animRole.setAnimDept(animDept);
						}
						String time = DateFormate.formateDateToString(new Date());
						animRole.setRoleCreatetime(time);
						animRole.setRoleUpdatetime(time);
						roles.add(animRole);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (BiffException e) {
				e.printStackTrace();
			}
		}
		return roles;
	}

}
