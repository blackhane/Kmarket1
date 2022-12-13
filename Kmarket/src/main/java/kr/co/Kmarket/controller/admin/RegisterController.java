package kr.co.Kmarket.controller.admin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.Kmarket.DAO.admin.AdminDAO;
import kr.co.Kmarket.VO.ProductVO;

@WebServlet("/admin/register.do")
public class RegisterController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispathcer = req.getRequestDispatcher("/_admin/_product/register.jsp");
		dispathcer.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// multipart 전송 데이터 수신
		
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/file");
		int maxSize = 1024 * 1024 * 10; // 최대 파일 업로드 허용량 10MB
		MultipartRequest mr = new MultipartRequest(req, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());

		// 데이터 수신
		String cate1 = mr.getParameter("cate1");
		String cate2 = mr.getParameter("cate2");
		String prodName = mr.getParameter("prodName");
		String descript = mr.getParameter("descript");
		String company = mr.getParameter("company");
		String price = mr.getParameter("price");
		String discount = mr.getParameter("discount");
		String point = mr.getParameter("point");
		String stock = mr.getParameter("stock");
		String delivery = mr.getParameter("delivery");
		String thumb1 = mr.getParameter("thumb1");
		String thumb2 = mr.getParameter("thumb2");
		String thumb3 = mr.getParameter("thumb3");
		String detail = mr.getParameter("detail");
		String prodNo = mr.getParameter("prodNo");
		String status = mr.getParameter("status");
		String duty = mr.getParameter("duty");
		String recript = mr.getParameter("recript");
		String bizType = mr.getParameter("bizType");
		String brand = mr.getParameter("brand");
		String origin = mr.getParameter("origin");
		String material = mr.getParameter("material");
		String color = mr.getParameter("color");
		String size = mr.getParameter("size");
		String manufacturer = mr.getParameter("manufacturer");
		String country = mr.getParameter("country");
		String precautions = mr.getParameter("precautions");
		String date = mr.getParameter("date");;
		String standard = mr.getParameter("standard");;
		String as = mr.getParameter("as");
		String delivery_date = mr.getParameter("delivery_date");
		String fname = mr.getFilesystemName("fname");
		String regip   = req.getRemoteAddr();

		// VO 데이터 생성
		ProductVO vo = new ProductVO();
		vo.setCate1(cate1);
		vo.setCate2(cate2);
		vo.setProdName(prodName);
		vo.setDescript(descript);
		vo.setCompany(company);
		vo.setPrice(price);
		vo.setDiscount(discount);
		vo.setPoint(point);
		vo.setStock(stock);
		vo.setDelivery(delivery);
		vo.setThumb1(thumb1);
		vo.setThumb2(thumb2);
		vo.setThumb3(thumb3);
		vo.setDetail(detail);
		vo.setProdNo(prodNo);
		vo.setStatus(status);
		vo.setDuty(duty);
		vo.setReceipt(recript);
		vo.setBizType(bizType);
		vo.setBrand(brand);
		vo.setOrigin(origin);
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
		AdminDAO dao = AdminDAO.getInstance();
		dao.insertProduct(vo);
		
		for(int i=0; i<3; i++) {
			String thumb = "thumb" + i;
			if(thumb != null) {
				
				int idx = thumb1.lastIndexOf(".");
				String ext = thumb1.substring(idx);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss_");
				String now = sdf.format(new Date());
				String newName = now+prodNo+ext; // 20221026111323_chhak0503.txt 
				
				File oriFile = new File(path+"/"+thumb1);
				File newFile = new File(path+"/"+newName);
				
				oriFile.renameTo(newFile);
				
				// 파일 테이블 저장
				dao.insertFile(prodNo, newName, fname);
			}
		}
		
		if(detail != null){
			// 파일명 수정
			int idx = thumb1.lastIndexOf(".");
			String ext = thumb1.substring(idx);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss_");
			String now = sdf.format(new Date());
			String newName = now+prodNo+ext; // 20221026111323_chhak0503.txt 
			
			File oriFile = new File(path+"/"+thumb1);
			File newFile = new File(path+"/"+newName);
			
			oriFile.renameTo(newFile);
			
			// 파일 테이블 저장
			dao.insertFile(prodNo, newName, fname);
		}
		
		// 리다이렉트
		resp.sendRedirect("/Kmarket/_admin/list.do");
		
	}

}
