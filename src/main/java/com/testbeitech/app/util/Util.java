package com.testbeitech.app.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.testbeitech.app.dto.RequestDTO;
import com.testbeitech.app.entity.ProductEntity;

public class Util {
	
	public static List<Map<String, Integer>> validationProductAvailable(List<Integer> availableProduct, RequestDTO request) 
	{
		/*
	    Cross the available products of the customer with the products of the new order
	    @param availableProduct
	    @param request
	    @return List<Map<String, Integer>>
	    */
		
		List<Map<String,Integer>> productsOrder = (List<Map<String, Integer>>) request.getProducts();
		
		for(int i =0; i<productsOrder.size();i++)
		{
			if(!availableProduct.contains(Integer.parseInt(productsOrder.get(i).get("product_id").toString())))
			{
				productsOrder.remove(i);
				i--;
			}
		}
		
		return productsOrder;
	}
	
	public static List<Integer> getProductsById(List<Map<String, Integer>> productsAvailableForOrder)
	{
		/*
	    Get the order products
	    @param productsAvailableForOrder
	    @return List<Integer>
	    */
		
		List<Integer> listProductId = new ArrayList<Integer>();
		for(int i=0; i < productsAvailableForOrder.size(); i++)
		{
			listProductId.add(Integer.parseInt(productsAvailableForOrder.get(i).get("product_id").toString()));
		}
		return listProductId;
	}

	public static Double getTotalQuantity(List<ProductEntity> productsNew, List<Map<String, Integer>> productsAvailableForOrder) {
		/*
	    Calculate the order total
	    @param productsNew
	    @param productsAvailableForOrder
	    @return Double
	    */
		
		Double totalQuantity = 0.0;
		for(int i=0; i < productsNew.size(); i++)
		{
			totalQuantity = ((Double.parseDouble(productsAvailableForOrder.get(i).get("quantity").toString()) * productsNew.get(i).getPrice())) + totalQuantity;
		}
		return totalQuantity;
	}

	public static boolean getValidationQuantity(List<Map<String, Integer>> productsAvailableForOrder) {
		/*
	    Validate if the quantity are less than zero
	    @param productsAvailableForOrder
	    @return: boolean
	    */
		
		for(int i=0; i < productsAvailableForOrder.size(); i++)
		{
			if((Double.parseDouble(productsAvailableForOrder.get(i).get("quantity").toString())) <= 0)
			{
				return false;
			}
		}
		return true;		
	}

}
