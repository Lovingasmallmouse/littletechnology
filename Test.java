import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Test {
	public static void main(String[] args){
		 //��Ҫ���Ƶ�Ŀ���ļ���Ŀ���ļ��� 
	    String pathname = "E:/hjg.html"; 
	    File file = new File(pathname); 
	    //���Ƶ���λ�� 
	    String topathname = "D:/"; 
	    File toFile = new File(topathname); 
	    try { 
	      copy(file, toFile); 
	    } catch (Exception e) { 
	      // TODO Auto-generated catch block 
	      e.printStackTrace(); 
	    } 
	}
	
	 public static void copy(File file, File toFile) throws Exception { 
		    byte[] b = new byte[1024]; 
		    int a; 
		    FileInputStream fis; 
		    FileOutputStream fos; 
		    if (file.isDirectory()) { 
		      String filepath = file.getAbsolutePath(); 
		      filepath=filepath.replaceAll("\\\\", "/"); 
		      String toFilepath = toFile.getAbsolutePath(); 
		      toFilepath=toFilepath.replaceAll("\\\\", "/"); 
		      int lastIndexOf = filepath.lastIndexOf("/"); 
		      toFilepath = toFilepath + filepath.substring(lastIndexOf ,filepath.length()); 
		      File copy=new File(toFilepath); 
		      //�����ļ��� 
		      if (!copy.exists()) { 
		        copy.mkdir(); 
		      } 
		      //�����ļ��� 
		      for (File f : file.listFiles()) { 
		        copy(f, copy); 
		      } 
		    } else { 
		      if (toFile.isDirectory()) { 
		        String filepath = file.getAbsolutePath(); 
		        filepath=filepath.replaceAll("\\\\", "/"); 
		        String toFilepath = toFile.getAbsolutePath(); 
		        toFilepath=toFilepath.replaceAll("\\\\", "/"); 
		        int lastIndexOf = filepath.lastIndexOf("/"); 
		        toFilepath = toFilepath + filepath.substring(lastIndexOf ,filepath.length()); 
		          
		        //д�ļ� 
		        File newFile = new File(toFilepath); 
		        fis = new FileInputStream(file); 
		        fos = new FileOutputStream(newFile); 
		        while ((a = fis.read(b)) != -1) { 
		          fos.write(b, 0, a); 
		        } 
		      } else { 
		        //д�ļ� 
		        fis = new FileInputStream(file); 
		        fos = new FileOutputStream(toFile); 
		        while ((a = fis.read(b)) != -1) { 
		          fos.write(b, 0, a); 
		        } 
		      } 
		  
		    } 
		  } 
}
