package cn.tedu.note.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 利用工具类封装 通用算法
 */
public class Utils {

	private static final String SALT = "今天你吃了么";
	
	public static String md5salt(String pwd){
		System.out.println("note2.0");
		return DigestUtils.md5Hex(pwd+SALT);
	}
}
