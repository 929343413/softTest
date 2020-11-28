package cn.lww.servlets;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.Imaging;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.lww.bean.MyForm;
import cn.lww.bean.MyPicture;
import junit.framework.Assert;

import static org.mockito.Mockito.*;

public class MyServletTest2 {

	MyServlet test = new MyServlet();
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsEmpty() {
		File file = new File("E:\\software\\eclipse\\eclipse-workplace\\apacheTest\\src\\main\\webapp\\WEB-INF\\TXT\\TXT.txt");
		Assert.assertTrue(test.isEmpty(file));
	}

	@Test
	public void testStoPicture() {
		File file = new File("E:\\software\\eclipse\\eclipse-workplace\\apacheTest\\src\\main\\webapp\\WEB-INF\\test\\JPG.jpg");
		try {
			MyPicture testpic = test.stoPicture(file);
			ImageInfo picfile = Imaging.getImageInfo(file);
			Assert.assertEquals(testpic.getWidth(), picfile.getWidth());
			Assert.assertEquals(testpic.getHeight(), picfile.getHeight());
			Assert.assertEquals(testpic.getColor(), picfile.getColorType());
			Assert.assertEquals(testpic.getDetail(), picfile.getFormatDetails());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void teststoTXT() {
		File file = new File("E:\\software\\eclipse\\eclipse-workplace\\apacheTest\\src\\main\\webapp\\WEB-INF\\test\\TXT.txt");
		try {
			MyForm testform = new MyForm();
			testform = test.stoTXT(file);
			Assert.assertEquals(file.getName(), testform.getName());
			Assert.assertEquals(file.getName(), testform.getName());
			Assert.assertEquals(file.getName(), testform.getName());
			Assert.assertEquals(file.getName(), testform.getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void sto_mock() {
		MyServlet servlet_mock = mock(MyServlet.class);
		File nullfile = new File("");
		File txtfile = new File("E:\\software\\eclipse\\eclipse-workplace\\apacheTest\\src\\main\\webapp\\WEB-INF\\test\\TXT.txt");
		File picfile = new File("E:\\software\\eclipse\\eclipse-workplace\\apacheTest\\src\\main\\webapp\\WEB-INF\\test\\JPG.jpg");
		when(servlet_mock.isEmpty(txtfile)).thenReturn(false);
		when(servlet_mock.isEmpty(picfile)).thenReturn(false);
		when(servlet_mock.isEmpty(nullfile)).thenReturn(true);
		try {
			MyPicture testpic = test.stoPicture(picfile);
			MyForm testform = new MyForm();
			testform.setName(txtfile.getName());
			testform.setFilePath(txtfile.getPath());// 存放路径
			testform.setContentType("TXT");// 数据格式
			testform.setSize(txtfile.length());// 文件大小
			Assert.assertEquals(testform.getContentType(), test.stoTXT(txtfile).getContentType());
			Assert.assertEquals(testpic.getDetail(), test.stoPicture(picfile).getDetail());
			Assert.assertEquals(null, test.stoTXT(nullfile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
