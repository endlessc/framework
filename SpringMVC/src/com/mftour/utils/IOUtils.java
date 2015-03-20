package com.mftour.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class IOUtils {
	
	private static final Logger logger = Logger.getLogger(IOUtils.class);
	/**
	 * 读取json文件
	 * 
	 * @param path
	 * @return
	 */
	public static String ReadFile(String path) {
		BufferedReader reader = null;
		String laststr = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(
					fileInputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				laststr += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return laststr;
	}

	 public static boolean copyFile(File sourcefile,File targetFile) {
		 System.out.println("==================================================复制文件  "+sourcefile+"到"+targetFile);
		 boolean bool=true;
	        //新建文件输入流并对它进行缓冲
			try {
				FileInputStream input = new FileInputStream(sourcefile);
	        BufferedInputStream inbuff=new BufferedInputStream(input);
	        //新建文件输出流并对它进行缓冲
	        FileOutputStream out=new FileOutputStream(targetFile);
	        BufferedOutputStream outbuff=new BufferedOutputStream(out);
	        //缓冲数组
	        byte[] b=new byte[1024*5];
	        int len=0;
	        while((len=inbuff.read(b))!=-1){
	            outbuff.write(b, 0, len);
	        }
	        //刷新此缓冲的输出流
	        outbuff.flush();
	        //关闭流
	        inbuff.close();
	        outbuff.close();
	        out.close();
	        input.close();
	        
			} catch (Exception e) {
				// TODO Auto-generated catch block
				bool = false;
				e.printStackTrace();
			}
			return bool;
	        	
	    }
	    
	    public static boolean copyDirectiory(String sourceDir,String targetDir) {
	    	System.out.println("============================进入文件夹拷贝===========================");
	    	System.out.println("============================源地址:"+sourceDir);
	    	System.out.println("============================目标地址:"+targetDir);
	    	boolean bool = true;
	        //新建目标目录
	        (new File(targetDir)).mkdirs();
	        //获取源文件夹当下的文件或目录
	        String[] file=(new File(sourceDir)).list();
	        if(file == null) file = new String[]{};
	        System.out.print("原文件夹下的内容数目" + file.length );
	        for (int i = 0; i < file.length; i++) {
	        	
	            if(new File(sourceDir + "/" + file[i]).isFile()){
	            	System.out.println("============================目录下的内容是文件，进行文件复制===========================");
	                //源文件
	                File sourceFile= new File(sourceDir +"/" + file[i]);
	                    //目标文件
	                File targetFile=new File(new File(targetDir).getAbsolutePath()+File.separator+new File(sourceDir+"/" + file[i]).getName());
	                try {
						copyFile(sourceFile, targetFile);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						bool = false;
						System.out.println("============================文件复制出错===========================");
						e.printStackTrace();
					}
	            }
	            if(new File(sourceDir+"/"+file[i]).isDirectory()){
	            	System.out.println("============================目录下的内容是文件夹，进行文件复制===========================");
	                //准备复制的源文件夹
	                String dir1=sourceDir+"/"+new File(sourceDir +"/" + file[i]).getName();
	                //准备复制的目标文件夹
	                String dir2=targetDir+"/"+new File(sourceDir +"/" + file[i]).getName();
	                copyDirectiory(dir1, dir2);
	            }
	        }
	        return bool;
	        
	    }

	/**
	 * 删除单个文件
	 * 
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String sPath) {
		boolean flag = false;
		flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param sPath
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public static boolean deleteDirectory(String sPath) {
		System.out.println("============================进入删除文件目录 ，源文件目录："+sPath);
		boolean flag = false;
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			System.out.println("文件或目录无效");
			return true;
		}
		flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} // 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}
}
