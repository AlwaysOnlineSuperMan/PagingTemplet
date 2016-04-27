package com.nings.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


/**
 * Bean的序列化工具类，目前僅提供序列化成xml的方法
 * @author Edison
 *
 */
public class SerializationUtils {
	/*private static Transformer extern = StaticExternTransformerFactory.getTransformer();
	
	private SerializationUtils(){
		
	}
	*//**
	 * 将对象序列化成xml
	 * @param obj
	 * @return byte数组
	 * @throws TransformException
	 *//*
	public static byte[] serialize2Xml(Object obj) throws TransformException{
		 byte externData[] = (byte[])extern.format(obj, null);
		 byte xmlData[] = new byte[externData.length];
		 System.arraycopy(externData, 0, xmlData, 0, externData.length);
		 return xmlData;
	}
	
	*//**
	 * 将对象序列化成xml的byte数组后，进行压缩。返回base64的字串
	 * @param obj
	 * @return 返回base64的字串
	 * @throws TransformException
	 * @throws IOException 
	 *//*
	public static String serialize2GZIPXml(Object obj) throws TransformException, IOException {
		
		StringBuffer resultBuffer = new StringBuffer();
		byte xmlData[] = serialize2Xml(obj);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
        GZIPOutputStream gzout = new GZIPOutputStream(bout);
        gzout.write(xmlData);
        gzout.finish();
        byte result[] = bout.toByteArray();
        resultBuffer.append(Base64.byteArrayToBase64(result));
		return resultBuffer.toString();
		
	}
	
	*//**
	 * 將壓縮后的xml base64字串 進行解壓
	 * @param base64Str
	 * @return xml Byte數組
	 * @throws Exception
	 *//*
	public static byte[] deserializeGZIPXml2ByteArray(String base64Str) throws Exception{
		byte rawBuffer[] = Base64.base64ToByteArray(base64Str);
		InputStream is = new GZIPInputStream(new ByteArrayInputStream(rawBuffer));
		byte[] result = IOUtil.read(is);
		is.close();
		return result;
	}
	
	*//**
	 * 將壓縮后的xml base64字串轉換成Bean對象
	 * @param base64Str 壓縮過的xml
	 * @return Object對象
	 * @throws Exception
	 *//*
	public static Object deserializeGZIPXml2Bean(String base64Str) throws Exception{
		byte[] result = deserializeGZIPXml2ByteArray(base64Str);
		try{
            Object object = extern.parse(new ByteArrayInputStream(result), null);
            return object;
        }catch(Exception e){
        	throw new Exception("can't parse externalized data");
        }
		
	} 
	*/
	
	
}
