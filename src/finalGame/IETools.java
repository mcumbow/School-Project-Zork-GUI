/*
* File name: IETools.java
 * Project name: CISP1020
 * -------------------------------------------------
 * Creator's name: Michael Cumbow
 * Email: mcumbow@comcast.net
 */
package finalGame;

import java.util.*;

/**
 *Interface of Jewels
 *
 */
public interface IETools {
	
	public void pickup(String jewel) throws inputErrorException;
	
	public void drop(String jewel) throws inputErrorException;
	
}//end IEdible interface class
