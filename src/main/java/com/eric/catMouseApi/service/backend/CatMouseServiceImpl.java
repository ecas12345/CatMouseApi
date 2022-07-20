package com.eric.catMouseApi.service.backend;

import org.springframework.stereotype.Component;

import com.eric.catMouseApi.models.Animals;
import com.eric.catMouseApi.service.CatMouseService;

@Component
public class CatMouseServiceImpl implements CatMouseService{
	
	/***********************************************/
	/* 
	 * Responses: 
	 * 		boring without all three <-- will return if no animal is present
	 *      Caught! <-- will return if the cat can catch the mouse
	 *      Protected! <-- will return if the cat cannot catch the mouse due to the dog being between them
	 *      Escaped! <-- will return if the cat cannot catch the mouse due to the distance between the cat and mouse being larger than the distance the cat can jump.
	 * 	
	 * Assumptions: 
	 * 		The string passed only contains characters 'C','D','m', or '.'
	 *		The distance the cat can jump that is passed is a non-negative number. Although this should be handled by logic already
	 *		The string passed will at most contain only one of each character, C, D, m.
	 *		The string passed will always contain the characters C, m, but may not contain D, for as long as some animals are present
	 *		The integer passed for j will not be larger or less than integer max and minimum values
	 *		We will return protected! even if the cat cant jump far enough to the mouse but collides with the dog because of the requirement "Also, the cat cannot jump over the dog."
	 **********************************************************************************************************/
	
	public String isCaught(String x, int j) {
		try {
			Animals animalScenario = new Animals(x, j);
			
			//This checks if there is animals in the scenario, if not we return out of this method with appropriate message
			if(!animalScenario.hasAnimals()) {
				return "boring without all three";
			}			
			/*
			 * This checks if there is a dog between the cat and mouse and if it collides with the dog. 
			 * The assumption is if the cat collides with the dog even if it cannot reach the mouse should return Protected!
			 */
			if(animalScenario.dogBetween() && animalScenario.collidesWithDog()) {
				return "Protected!";
			}
			//This checks if the spaces the cat can jump are equal to or greater than the distance between the cat and mouse
			if(animalScenario.jumpedFarEnough()) {
				return "Caught!";
			}
			else {
				return "Escaped!"; //Return Escaped in all other scenarios
			}
		} catch (Exception ex) {
			return ex.getLocalizedMessage();
		}
	}
}
