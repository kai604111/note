package dao_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class MD5TestCase {

	@Test
	public void testMD5() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String str = "123";
//		创建消息摘要算法对象
//		参数是算法名:MD5,sha1 sha256
		MessageDigest md5 = MessageDigest.getInstance("MD5");
//		将数据提价到md5
		byte[] data = str.getBytes("UTF-8");
		md5.update(data);
		byte[] md = md5.digest();
		String hex = Hex.encodeHexString(md);
		System.out.println(hex);
	}
	
	@Test
	public void test3(){
		String md5 = DigestUtils.md5Hex("你今天吃了么123");
		System.out.println(md5);
	}
	
	@Test
	public void test4() throws IOException{
		FileInputStream in = new FileInputStream("MD5.txt");
		String hex = DigestUtils.md5Hex(in);
		in.close();
		System.out.println(hex);
	}
	
	/**
	 * 将2进制转换为16进制字符串
	 * @param ary 要转换的byte[] 数组
	 * @return 返回的16进制结果
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 */
//	public String hex(byte[] ary){
//		String digi = "0123456789abcdef";
//		char[] hex = new char[ary.length*2];
//		int i = 0;//代表数组下标
//		for (int b : ary) {
//			int b1 = (b>>>4) & 0xf;
//			int b2 = b & 0xf;
//			char c1 = digi.charAt(b1);
//			char c2 = digi.charAt(b2);
//			hex[i++] = c1;
//			hex[i++] = c2;
//		}
//		return new String(hex);
//	}
	
	@Test
	public void testFileMD5() throws NoSuchAlgorithmException, IOException{
		FileInputStream in = new FileInputStream("MD5.txt");
		byte[] buf = new byte[1024];
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		int n;
		while((n=in.read(buf)) != -1){
			md5.update(buf,0,n);
		}
		in.close();
		byte[] md = md5.digest();
		String hex = Hex.encodeHexString(md);
		System.out.println(hex);
	}
	
	@Test
	public void testSalt(){
		String salt = "今天你吃了么?";
		String pwd = "123";
		String hex = DigestUtils.md5Hex(pwd+salt);
		System.out.println(hex);
	}
}
