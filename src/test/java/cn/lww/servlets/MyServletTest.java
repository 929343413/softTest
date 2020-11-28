//package cn.lww.servlets;
//
//import static org.junit.Assert.*;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletInputStream;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.joda.time.DateTime;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.stubbing.Answer;
//
//import static org.mockito.Mockito.*;
//
//import cn.lww.bean.*;
//
//public class MyServletTest {
//
//	MyServlet temp = new MyServlet();
//	
//	
//	FileItem item = Mockito.mock(FileItem.class); 
//	
//	
//	private HttpServletRequest initRequest() throws IOException{
////		MockHttpServeltRequest req = new MockHttpServeltRequest();
//	    HttpServletRequest request = mock(HttpServletRequest.class);
//	    ServletInputStream in = mock(ServletInputStream.class);
//	    String boundary = "---------------------------" + DateTime.now().toString();
//	    when(request.getPathInfo()).thenReturn("/zjtv/service/news");
//	    when(request.getRequestURI()).thenReturn("/zjtv/service/news");
//	    when(request.getInputStream()).thenReturn(in);
//	    when(request.getContextPath()).thenReturn("/zjtv");
//	    when(request.getContentType()).thenReturn("multipart/form-data; boundary=" + boundary);
////	    when(request.).thenReturn("/zjtv");
////	        when(request.getSession()).thenReturn("/zjtv");
//	    when(request.getMethod()).thenReturn("POST");
//	    // 设置参数
//	    when(request.getParameter("a")).thenReturn("aaa");
//	    
//	    final Map<String, Object> hash = new HashMap<String, Object>();
//	    Answer<String> aswser = new Answer<String>() {  
//	        public String answer(InvocationOnMock invocation) {  
//	            Object[] args = invocation.getArguments();  
//	            return hash.get(args[0].toString()).toString();  
//	        }  
//	    };
//	    
//	    when(request.getAttribute("isRawOutput")).thenReturn(true);  
//	    when(request.getAttribute("errMsg")).thenAnswer(aswser);  
//	    when(request.getAttribute("msg")).thenAnswer(aswser);  
////	        doThrow(new Exception()).when(request).setAttribute(anyString(), anyString());
//	    
//	    doAnswer(new Answer<Object>() {
//	        public Object answer(InvocationOnMock invocation) {
//	            Object[] args = invocation.getArguments();
//	            // Object mock = invocation.getMock();  
//	            System.out.println(args[1]);
//	            hash.put(args[0].toString(), args[1]);
//	            return "called with arguments: " + args;
//	        }
//	    }).when(request).setAttribute(anyString(), anyString());
//	    
//	    return request;
//	}
//	
//	private HttpServletResponse initResponse() throws IOException{
//		HttpServletResponse response = mock(HttpServletResponse.class);
//		StubServletOutputStream servletOutputStream = new StubServletOutputStream() ;
//		try {
//			when(response.getOutputStream()).thenReturn(servletOutputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// 保存到磁盘文件 需要在 bs.doPost(request, response); 之后  writer.flush();
//		//	PrintWriter writer = new PrintWriter("d:\\somefile.txt");
//		StringWriter writer = new StringWriter();
//	    when(response.getWriter()).thenReturn(new PrintWriter(writer));
//		return response;
//	}
//	
//	 
//	@Before
//	public void setUp() throws Exception {
//		
//	}
//
//	
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void testUploadTXT() throws Exception {
//		
//		FileItem t = mock(FileItem.class);
//		FileItem s = null;
////		File file = new File("E:\\software\\eclipse\\eclipse-workplace\\apacheTest\\src\\main\\webapp\\WEB-INF\\TXT\\TXT.txt");
//		
//		doAnswer(new Answer<Object>() {
//			
//	        public Object answer(InvocationOnMock invocation) throws Exception {
////	            Object file = new File
//	        	Object args = invocation.getArguments();
////	        	File item = new FileItem()
//	        	t.write(args);
//	            return "called with arguments: " + args;
//	        }
//	    }).when(t).write(any(File.class));
//		
//		
//		MyServlet ser = new MyServlet();
//		
//		ser.uploadTXT(t);
//		
//		String filename = "TXT.txt";
//		String fileload = "E:\\software\\eclipse\\eclipse-workplace\\apacheTest\\src\\main\\webapp\\WEB-INF\\TXT";
//		File file1 = new File(fileload + "\\" + filename);
//		Assert.assertTrue(file1.exists());
//	}
//
////	@Test
////	public void testSaveJPG() {
////		File file = new File("E:\\software\\eclipse\\eclipse-workplace\\apacheTest\\src\\main\\webapp\\WEB-INF\\test\\JPG.jpg");
////		temp.saveJPG(file);
////		Assert.assertTrue(file.exists());
////		Assert.assertEquals(file.getName(), temp.fileForm.getName());
////		Assert.assertEquals(file.getPath(), temp.fileForm.getFilePath());
////		Assert.assertEquals("JPG", temp.fileForm.getContentType());
////		Assert.assertEquals(file.length(), temp.fileForm.getSize());
////	}
////
////	@Test
////	public void testSavePNG() {
////		File file = new File("E:\\software\\eclipse\\eclipse-workplace\\apacheTest\\src\\main\\webapp\\WEB-INF\\test\\PNG.png");
////		temp.savePNG(file);
////		Assert.assertTrue(file.exists());
////		Assert.assertEquals(file.getName(), temp.fileForm.getName());
////		Assert.assertEquals(file.getPath(), temp.fileForm.getFilePath());
////		Assert.assertEquals("PNG", temp.fileForm.getContentType());
////		Assert.assertEquals(file.length(), temp.fileForm.getSize());
////	}
//
//}
