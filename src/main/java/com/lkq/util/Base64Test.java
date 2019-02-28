package com.lkq.util;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



public class Base64Test {
	
	
	// ͼƬת����base64�ַ���
	public static String encodeToString(String imagePath) throws IOException {
	    String type = StringUtils.substring(imagePath, imagePath.lastIndexOf(".") + 1);
	    BufferedImage image = ImageIO.read(new File(imagePath));
	    String imageString = null;
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    try {
	        ImageIO.write(image, type, bos);
	        byte[] imageBytes = bos.toByteArray();
	        BASE64Encoder encoder = new BASE64Encoder();
	        imageString = encoder.encode(imageBytes);
	        bos.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return imageString;
	}
	
	
	// ͼƬת����base64�ַ���  ����������� ������ʹ��
	public static String GetImageStr(String imageUrl) {// ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
		InputStream in = null;
		byte[] data = null;
		// ��ȡͼƬ�ֽ�����
		try {
			in = new FileInputStream(imageUrl);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ���ֽ�����Base64����
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// ����Base64��������ֽ������ַ���
	}

	// base64�ַ���ת����ͼƬ
	public static boolean GenerateImage(String base64,String imgSrc) { // ���ֽ������ַ�������Base64���벢����ͼƬ
		if (base64 == null) // ͼ������Ϊ��
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64����
			byte[] b = decoder.decodeBuffer(base64);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// �����쳣����
					b[i] += 256;
				}
			}
			// ����jpegͼƬ
			String imgFilePath = imgSrc;// �����ɵ�ͼƬd://222.jpg
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
