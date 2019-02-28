package com.lkq.util;

import java.io.File;

public class FileUtil {
	
	/**
	 * ����һ���ļ���
	 * �������       ������ 
	 * ���������    ����
	 * @param filePath
	 * @return
	 */
	public static boolean makeDirs(String filePath) {
        File folder = new File(filePath);
        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
    }
	
	/**
     * ɾ�������ļ�
     * ·�� ��ȫ·��
     * c��ɶɶ��ȫ·��
     * @param fileName  Ҫɾ�����ļ����ļ���
     * @return �����ļ�ɾ���ɹ�����true�����򷵻�false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // ����ļ�·������Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ��
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                //System.out.println("ɾ�������ļ�" + fileName + "ʧ�ܣ�");
                return false;
            }
        } else {
            //System.out.println("ɾ�������ļ�ʧ�ܣ�" + fileName + "�����ڣ�");
            return false;
        }
    }
    
    
    
	
}
