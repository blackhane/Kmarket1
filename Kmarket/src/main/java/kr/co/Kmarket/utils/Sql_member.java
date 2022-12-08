package kr.co.Kmarket.utils;

public class Sql_member {

	public static String SELECT_USER = "SELECT * FROM `km_member` WHERE `uid`=? AND `pass`=SHA2(?,256);";
}
