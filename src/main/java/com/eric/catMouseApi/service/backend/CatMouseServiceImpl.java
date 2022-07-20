package com.eric.catMouseApi.service.backend;

import org.springframework.stereotype.Component;

import com.eric.catMouseApi.models.Animals;
import com.eric.catMouseApi.service.CatMouseService;

@Component
public class CatMouseServiceImpl implements CatMouseService{
	
	/***********************************************/
	/* 
	 * This method determines the location of the cat, mouse and dog.
	 * returns of type String
	 * 
	 * Responses: 
	 * 		boring without all three <-- will return if no animal is present
	 *      Caught! <-- will return if the cat can catch the mouse
	 *      Protected! <-- will return if the cat cannot catch the mouse due to the dog being between them
	 *      Escaped! <-- will return if the cat cannot catch the mouse due to the distance between the cat and mouse being larger than the distance the cat can jump.
	 * 	
	 * Assumptions: 
	 * 		The string passed only contains characters 'C','D','m', or '.'
	 *		The distance the cat can jump that is passed is a non-negative number.
	 *		The string passed will at most contain only one of each character, C, D, m.
	 *		The string passed will always contain the characters C, m, but may not contain D.
	 *		The integer passed for j will not be larger or less than integer max and minimum values
	 **********************************************************************************************************/
	
	public String isCaught(String x, int j) {
		try {
			Animals animalScenario = new Animals(x, j);
			
			//This checks if there is animals in the scenario, if not we return out of this method with appropriate message
			if(!animalScenario.hasAnimals()) {
				return "boring without all three";
			}
			
			//This checks if the spaces the cat can jump are equal to or greater than the distance between the cat and mouse
			if(animalScenario.jumpedFarEnough()) {
				//This checks if there is a dog between the cat and mouse
				if(animalScenario.dogBetween()) {
					return "Protected!\n";
				}
				return "Caught!\n";
			}
			else {
				return "Escaped!\n"; //Return Escaped in all other scenarios
			}
		} catch (Exception ex) {
			return ex.getLocalizedMessage();
		}
	}
}
