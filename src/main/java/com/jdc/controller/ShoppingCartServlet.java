package com.jdc.controller;

import java.io.IOException;

import com.jdc.shop.model.ProductModel;
import com.jdc.shop.model.ShoppingCart;
import com.jdc.shop.model.entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/cart-add", "/cart-show", "/cart-clear" ,"/cart-plus","/cart-minus"})
public class ShoppingCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       switch (req.getServletPath()){
	case "/cart-add": 
		addToCart(req, resp);
		break;
	case "/cart-show":
		getServletContext().getRequestDispatcher("/my_cart.jsp").forward(req, resp);
		break;
	case "/cart-clear":
		clear(req,resp);
		break;
	case "/cart-plus":
	case "/cart-minus":
		changeCartItemCount(req,resp);
		break;
    }
}
	private void changeCartItemCount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		var cart=(ShoppingCart)req.getSession().getAttribute("cart");
		//Get product id from request scope
		var product=req.getParameter("product");
		//Get action from req 
		var plus="/cart-plus".equals(req.getServletPath());
		//update model
		cart.changeItemCount(plus, Integer.parseInt(product));
		//Navigate 
		var link=req.getContextPath().concat("/my_cart.jsp");
		resp.sendRedirect(link);
	}
	private void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//get session
		var session=req.getSession();
		
		//get shoppingCart
		if(null !=session)
		{
			var cart=(ShoppingCart)session.getAttribute("cart");
			cart.clear();
		}
		//clear cart
		//forward to index jsp
		getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
	}
	private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get Product Id
		var strId=req.getParameter("product");
		var productModel=(ProductModel)getServletContext().getAttribute("products");
		Product product=productModel.findById(Integer.parseInt(strId));
		//get Product Model from Application Scope
		//find Product from model by id
		//get shopping cart from session scope
		var session=req.getSession(true);
		var cart=(ShoppingCart)session.getAttribute("cart");
		//add product to cart
		if(null ==cart)
		{
			//create shopping cart
			cart=ShoppingCart.generate();
			//add cart to Session Scope
			session.setAttribute("cart",cart);
			//forward index.jsp
		}
		cart.add(product);
		//forward index.jsp
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
}
