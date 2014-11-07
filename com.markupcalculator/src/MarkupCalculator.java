/** 
 * A class for solving the specified pricing problem.
 * @author Marina Tawfik
 */
public class MarkupCalculator {
	
	/** possible material involved in a project. **/
	private static String [] materialType = {"pharmaceuticals", "food", "electronics"};
	/** the mark up associated with each possible material involved in a project **/
	private static double [] typeMarkup ={0.075, 0.13, 0.02};
	
	/**
	 * returns the final cost of the project depending on the base price,
	 * the number of staff and material involved. 
	 * @param basePrice the project's base price.
	 * @param staffnum the number of staff required to work on the job.
	 * @param material the type of material involved.
	 * @return the final cost of the project.
	 */
	public double calculate (double basePrice, int staffnum, String material){
		double modifiedPrice = basePrice + flatMarkup(basePrice);
		double otherMarkups = workForceMarkup(modifiedPrice, staffnum) +
					          materialMarkup(modifiedPrice, material);
		double finalCost = modifiedPrice + otherMarkups;
		return (double) ( Math.round(finalCost * 100) / 100.00 );
	}
		
	/**
	 * returns the result of applying the 5% flat mark up to the base price.
	 * @param basePrice the project's base price.
	 * @return the result of applying the 5% flat mark up to the base price.
	 */
	double flatMarkup (double basePrice){
		return (0.05 * basePrice); 
	}
	
	/**
	 * returns the result of applying additional mark ups
	 * for each staff member working on the project.
	 * @param price the project's price after applying the flat mark up.
	 * @param staff number of staff member needed for the project.
	 * @return the the result of applying additional mark ups 
	 * for each staff member working on the project.
	 */
	double workForceMarkup (double price, int staff){
		return (staff * 0.012 * price);
	}
	
	/**
	 * returns the result of applying additional mark ups
	 * depending on the type of material involved.
	 * @param price the project's price after applying the flat mark up.
	 * @param material type of material involved in project.
	 * @return the result of applying additional mark ups
	 * depending on the type of material involved.
	 */
	double materialMarkup (double price, String material){
		double markup = 0;
			
		for (int i = 0 ; i < materialType.length; i++){
			if ((materialType[i]).equalsIgnoreCase(material)){
				markup = typeMarkup[i];
				break;
			}
		}
		return markup * price;
	}

	public static void main (String[] args){
	}
}
