package com.topcoder.srm;

/**
 * Rookie SRM 4
 *
 * Your lab has several containers of a certain type of chemical, each with varying volume, and varying quantity of dissolved solute.
 * The strength of any container can be calculated as solute / volume. volume[i] and solute[i] represent the volume and quantity of solvent in container i.
 * You now wish to mix a batch of the chemical, and can do so only by using the entirety of some subset of the available containers.
 * That is, you cannot use part of what is left in any container, you must use all or none of each container. You need to produce at least
 * minQuantity volume total after mixing, and you want the end result to have a strength as close as possible to desiredStrength.
 * Compute the absolute difference between the desired strength and the closest strength you can create by mixing checmicals to obtain the minimum required volume.
 *
 * Notes
 * -	* A return value that is within 1e-9 of the actual result is considered correct.
 *
 * Constraints
 * -	volume will have between 1 and 50 elements, inclusive.
 * -	Each element of volume will be between 1 and 100, inclusive.
 * -	solute will have the same number of elements as volume.
 * -	Each element of solute will be between 0 and 20, inclusive.
 * -	minVolume will be between 1 and the sum of all elements of volume.
 * -	desiredStrength will be between 0 and 10, inclusive.
 *
 */
public class ChemicalMixing {
}
