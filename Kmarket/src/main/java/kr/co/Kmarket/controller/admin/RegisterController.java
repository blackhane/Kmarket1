package kr.co.Kmarket.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.VO.CateVO;
import kr.co.Kmarket.VO.ProductVO;

@WebServlet("/admin/product/register.do")
public class RegisterController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_product/register.jsp");
		dispathcer.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// multipart 전송 데이터 수신
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/file/");
		int maxSize = 1024 * 1024 * 10; // 최대 파일 업로드 허용량 10MB
		MultipartRequest mr = new MultipartRequest(req, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());

		// 데이터 수신
		String cate1 = mr.getParameter("cate1");
		String cate2 = mr.getParameter("cate2");
		String prodName = mr.getParameter("prodName");
		String descript = mr.getParameter("descript");
		String company = mr.getParameter("company");
		String seller = mr.getParameter("seller");
		String price = mr.getParameter("price");
		String discount = mr.getParameter("discount");
		String point = mr.getParameter("point");
		String stock = mr.getParameter("stock");
		String delivery = mr.getParameter("delivery");
		String thumb1 = mr.getFilesystemName("thumb1");
		String thumb2 = mr.getFilesystemName("thumb2");
		String thumb3 = mr.getFilesystemName("thumb3");
		String detail = mr.getFilesystemName("detail");
		String prodNo = mr.getParameter("prodNo");
		String status = mr.getParameter("status");
		String duty = mr.getParameter("duty");
		String receipt = mr.getParameter("receipt");
		String bizType = mr.getParameter("bizType");
		String brand = mr.getParameter("brand");
		String origin = mr.getParameter("origin");
		String material = mr.getParameter("material");
		String color = mr.getParameter("color");
		String size = mr.getParameter("size");
		String manufacturer = mr.getParameter("manufacturer");
		String country = mr.getParameter("country");
		String precautions = mr.getParameter("precautions");
		String date = mr.getParameter("date");
		String standard = mr.getParameter("standard");
		String as = mr.getParameter("as");
		String delivery_date = mr.getParameter("delivery_date");
		String fname = mr.getFilesystemName("fname");
		String regip = req.getRemoteAddr();
		
		String randName1 = getRandomString(thumb1);
		String randName2 = getRandomString(thumb2);
		String randName3 = getRandomString(thumb3);
		String randName4 = getRandomString(detail);
		
		String name1 = renameImage(path, thumb1, randName1);
		String name2 = renameImage(path, thumb2, randName2);
		String name3 = renameImage(path, thumb3, randName3);
		String name4 = renameImage(path, detail, randName4);
		
		// VO 데이터 생성
		ProductVO vo = new ProductVO();
		vo.setCate1(cate1);
		vo.setCate2(cate2);
		vo.setProdName(prodName);
		vo.setDescript(descript);
		vo.setCompany(company);
		vo.setSeller(seller);
		vo.setPrice(price);
		vo.setDiscount(discount);
		vo.setPoint(point);
		vo.setStock(stock);
		vo.setDelivery(delivery);
		vo.setThumb1(name1);
		vo.setThumb2(name2);
		vo.setThumb3(name3);
		vo.setDetail(name4);
		vo.setStatus(status);
		vo.setDuty(duty);
		vo.setReceipt(receipt);
		vo.setBizType(bizType);
		vo.setBrand(brand);
		vo.setOrigin(origin);
		vo.setIp(regip);
		vo.setMaterial(material);
		vo.setColor(color);
		vo.setSize(size);
		vo.setManufacturer(manufacturer);
		vo.setCountry(country);
		vo.setPrecautions(precautions);
		vo.setDate(date);
		vo.setStandard(standard);
		vo.setAs(as);
		vo.setDelivery_date(delivery_date);
		
		//파일첨부 데이터 수신
		vo.setFname(fname);
		
		// 데이터베이스 처리
		logger.debug(vo.getProdName());
		AdminDAO dao = AdminDAO.getInstance();
		dao.insertProduct(vo);
		
		// 리다이렉트
		resp.sendRedirect("/Kmarket/admin/product/list.do");
		
	}
	
	
	public String getRandomString(String fname) {
		UUID randName = UUID.randomUUID();
		return randName.toString();
	}
	
	public String renameImage(String path, String oriName, String randName) {
		int idx = oriName.lastIndexOf(".");
		String ext = oriName.substring(idx);
		
		String newName = randName+ext; 
		
		File oriFile = new File(path+"/"+oriName);
		File newFile = new File(path+"/"+newName);
		
		oriFile.renameTo(newFile);
		
		return newName;
	}

}
