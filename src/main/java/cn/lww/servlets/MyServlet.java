package cn.lww.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.io.FilenameUtils;

import cn.lww.bean.MyForm;
import cn.lww.bean.MyPicture;

/**
 * 继承HttpServlet
 */
public class MyServlet extends HttpServlet {
	//定义程序序列化ID
	private static final long serialVersionUID = 1L;
	
	MyForm form = new MyForm(); 
	MyPicture picture = new MyPicture();

	/**
	 * 默认构造函数
	 */
	public MyServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *      表单以post方式提交，则调用doPost方法
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try{
			//调用process
			System.out.println(request);
			 fileupload(request); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void fileupload(HttpServletRequest request) throws Exception {
		try {
			//创建一个解析器工厂
			DiskFileItemFactory factory=new DiskFileItemFactory();
			
			//文件上传解析器
	        ServletFileUpload upload=new ServletFileUpload(factory);
	        
	        //设置所有上传数据的最大值
	        upload.setSizeMax(1024*1024);
	        
	        //设置单个文件上传的最大值
	        upload.setFileSizeMax(1024*1024);
	        
	        //设置编码格式
	        upload.setHeaderEncoding("UTF-8");
	        
	        //解析请求，将表单中每个输入项封装成一个FileItem对象
	        List<FileItem> items = upload.parseRequest(request);
	        
			for (FileItem item : items) {
				//判断输入的类型是普通输入项还是文件
				if (item.isFormField()) 
				{
					//普通输入项 ,得到input中的name属性的值
                    String name = item.getFieldName();
                    
                    //得到输入项中的值
                    String value = item.getString("UTF-8");
                    
                    System.out.println("name="+name+"  value="+value);
				}
				else{
					//获取文件名称，包含后缀:
					String fileName = FilenameUtils.getName(item.getName());
					System.out.println("上传文件为 ：" + fileName);

					//用UUID生成伪随机字符串，作为文件名避免重复
					String prefix = UUID.randomUUID().toString() + ".";
					
					//获取文件的后缀:
					String suffix = FilenameUtils.getExtension(fileName);
					
					String uploadPath = "E:\\software\\eclipse\\eclipse-workplace\\apacheTest\\src\\main\\webapp\\WEB-INF\\";
					if(suffix.equals("txt"))
						uploadPath = uploadPath + "TXT";
					else if(suffix.equals("jpg"))
						uploadPath = uploadPath + "JPG";
					else if(suffix.equals("png"))
						uploadPath = uploadPath + "PNG";
					
					File file=new File(uploadPath);
					//如果文件不存在就创建一个
					if (!file.exists()) {
						   file.mkdir();
				    }
					System.out.println(file.getName());
					//在指定目录中创建一个新的空文件，使用给定的前缀和后缀字符串生成其名称
					String filename = prefix + suffix;
					File tempFile = new File(uploadPath,filename);
					//文件上传
					item.write(tempFile);
					
					//根据文件类型来保存文件相关信息
					if(suffix.equals("txt"))
						form = stoTXT(tempFile);
					else if(suffix.equals("jpg") || suffix.equals("png"))
						picture = stoPicture(tempFile);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw new Exception(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} 
	}
	
	
	public boolean isEmpty(File tempFile) {
		//***************错误注入（true和false交换）********************
		try {
			if(tempFile.exists())
				return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public MyPicture stoPicture(File picfile) throws Exception {
		if(!isEmpty(picfile))
		{
			MyPicture filepic = new MyPicture();
			try {
				ImageInfo pic = Imaging.getImageInfo(picfile);
				filepic.setWidth(pic.getWidth());
				filepic.setHeight(pic.getHeight());
				filepic.setColor(pic.getColorType());
				filepic.setDetail(pic.getFormatDetails());
				
			}catch (IOException e) {
				e.printStackTrace();
				throw new Exception(e);
			}
			System.out.println("图片宽度：" + filepic.getWidth());
			System.out.println("图片高度：" + filepic.getHeight());
			System.out.println("图片颜色类型：" + filepic.getColor());
			System.out.println("图片细节：" + filepic.getDetail());
			return filepic;
		}
		return null;
	}
	
	public MyForm stoTXT(File file) throws Exception {
		if(!isEmpty(file))
		{
			MyForm fileform = new MyForm(); 
			fileform.setName(file.getName());
			fileform.setFilePath(file.getPath());// 存放路径
			fileform.setContentType("TXT");// 数据格式
			fileform.setSize(file.length());// 文件大小
			System.out.println("文件名字：" + fileform.getName());
			System.out.println("文件路径：" + fileform.getFilePath());
			System.out.println("文件格式：" + fileform.getContentType());
			System.out.println("文件大小：" + fileform.getSize());
			return fileform;
		}
		return null;
	}
	
}
