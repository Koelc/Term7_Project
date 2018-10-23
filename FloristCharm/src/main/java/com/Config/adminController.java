package com.Config;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Category;
import com.model.*;

@Controller
@RequestMapping("/admin")
public class adminController
{
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	@Autowired 
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	
	@RequestMapping(value="/saveCat", method=RequestMethod.POST)
	public ModelAndView saveCategory(@RequestParam("cid")int cid, @RequestParam("name")String name)
	{
		ModelAndView mv = new ModelAndView();
		Category c = new Category();
		c.setCid(cid);
		c.setName(name);
		categoryDaoImpl.insertCategory(c);
		mv.setViewName("home");
		return mv;
	}
	
	

	@RequestMapping(value="/saveSupp", method=RequestMethod.POST)
	public ModelAndView saveSupplier(@RequestParam("sid")int sid, @RequestParam("supplierName")String name)
	{
		ModelAndView mv = new ModelAndView();
		Supplier c = new Supplier();
		c.setSid(sid);c.setSupplierName(name);
		supplierDaoImpl.insertSupplier(c);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="/saveProduct", method=RequestMethod.POST)
	public String saveProduct(HttpServletRequest request,@RequestParam("file")MultipartFile file)
	{
	
		Product prod = new Product();
		
		prod.setName(request.getParameter("pName"));
		prod.setPrice(request.getParameter("pPrice"));
		prod.setDescription(request.getParameter("pDescription"));
		prod.setStock(Integer.parseInt(request.getParameter("pStock")));
		prod.setCategory(categoryDaoImpl.findById(Integer.parseInt(request.getParameter("pCategory"))));
		prod.setSupplier(supplierDaoImpl.findById(Integer.parseInt(request.getParameter("pSupplier"))));
		
		String filepath = request.getSession().getServletContext().getRealPath("/");
		
		String filename = file.getOriginalFilename();
		
		productDaoImpl.insertProduct(prod);
		
		try
		{
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath+"/resources"+ filename));
			fos.write(imagebyte);
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "home";

	}
	
	@ModelAttribute
	public void addAttributes(Model m)
	{
		m.addAttribute("prodList",productDaoImpl.retrieve() );
		m.addAttribute("catList", categoryDaoImpl.retrieve());
		m.addAttribute("satList", supplierDaoImpl.retrieve());
	}
	
}

















