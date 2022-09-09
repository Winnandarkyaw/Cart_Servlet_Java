package com.jdc.controller;

import java.io.IOException;
import java.util.List;

import com.jdc.shop.model.SaleModel;
import com.jdc.shop.model.ShoppingCart;
import com.jdc.shop.model.entity.Voucher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/sale-history","/sale-details","/checkout"})
public class SaleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private SaleModel model;
    @Override
    public void init() throws ServletException{
    	var application=getServletContext();
    	model= (SaleModel) application.getAttribute("sale.model");
    }
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       switch(req.getServletPath()) {
       case "/sale-history":
    	   showSaleHistory(req,resp);
    	   break;
       case "/sale-details":
    	   showDetails(req,resp);
    	   break;
       }
    }
    private void showDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //get id from request Parameter
    	var str=req.getParameter("id");
    	var id=Integer.parseInt(str);
    	//get target Voucher from model
    	var voucher=model.findById(id);
    	//set voucher to request scope
    	req.setAttribute("data", voucher);
    	getServletContext().getRequestDispatcher("/sale-details.jsp").forward(req, resp);
	}
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //get Customer Name
    	var customer=req.getParameter("customer");
    	
    	//get Sales item from Shopping Card
    	var cart=(ShoppingCart)req.getSession().getAttribute("cart");
    	var sales=cart.items();
    	//Create Voucher
    	var voucherId=model.create(customer,sales);
    	//Restart Shopping Cart
    	req.getSession().removeAttribute("cart");
    	//Redirect to sale detail
    	resp.sendRedirect(getServletContext().getContextPath().concat("/sale-details?id=")+voucherId);
    }
   
	private void showSaleHistory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//get sale list from saleModel
		List<Voucher>list=model.getSaleHistory();
		//add sale list to request scope
		req.setAttribute("data", list);
		//forward to sale-list jsp
		getServletContext().getRequestDispatcher("/sale-list.jsp").forward(req, resp);
	}
}
