package kr.co.Kmarket.utils;

public class Sql_admin {
	
	public static final String INSERT_PRODUCT = "insert into `km_product` set "
												+ "`cate1`=?,"
												+ "`cate2`=?,"
												+ "`prodName`=?,"
												+ "`descript`=?,"
												+ "`company`=?,"
												+ "`price`=?,"
												+ "`discount`=?,"
												+ "`point`=?,"
												+ "`stock`=?,"
												+ "`delivery`=?,"
												+ "`thumb1`=?,"
												+ "`thumb2`=?,"
												+ "`thumb3`=?,"
												+ "`detail`=?,"
												+ "`prodNo`=?,"
												+ "`status`=?,"
												+ "`duty`=?,"
												+ "`receipt`=?,"
												+ "`bizType`=?,"
												+ "`brand`=?,"
												+ "`origin`=?,"
												+ "`material`=?,"
												+ "`color`=?,"
												+ "`size`=?,"
												+ "`manufacturer`=?,"
												+ "`country`=?,"
												+ "`precautions`=?,"
												+ "`date`=?,"
												+ "`standard`=?,"
												+ "`as`=?,"
												+ "`delivery_date`=?";

	
	public static final String INSERT_FILE = "insert into `km_product_file` set "
										+ "`prodNo`=?,"
										+ "`newName`=?,"
										+ "`oriName`=?,"
										+ "`rdate`=NOW()";
	
	
}
