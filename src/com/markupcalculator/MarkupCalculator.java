package com.markupcalculator;

public class MarkupCalculator {
	private static String [] materialType = {"pharmaceuticals", "food", "electronics"};
	private static double [] typeMarkup ={0.075, 0.13, 0.02};
		
	public static double Calculator(double basePrice, int staffnum, String material){
		double modifiedPrice = basePrice + flatMarkup(basePrice);
		double otherMarkups = workForceMarkup(modifiedPrice, staffnum) +
				              materialMarkup(modifiedPrice, material);
		double finalprice = modifiedPrice + otherMarkups; 
		
		return (double) (Math.round(finalprice * 100) / 100.00) ;
	}
	
	private static double flatMarkup (double basePrice){
		return (0.05 * basePrice); 
	}
	
	private static double workForceMarkup (double price, int staff){
		return (staff * 0.012 * price);
	}
	
	private static double materialMarkup (double price, String material){
		double markup = 0;
		
		for (int i = 0 ; i < materialType.length; i++){
			if ((materialType[i]).equalsIgnoreCase(material)){
				markup = typeMarkup[i];
				break;
			}
		}
		return markup * price;
	}
	
	public static void main (String [] args){
				
	}

	
}
