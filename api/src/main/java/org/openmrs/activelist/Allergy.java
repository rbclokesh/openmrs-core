/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.activelist;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.openmrs.Concept;
import org.openmrs.Patient;

/**
 * This keeps track of patient's allergies. Each medicine that is ordered must be carefully checked against the patient's allergy list to avoid harming the patient.
 * Since OpenMRS 1.7
 */
public class Allergy extends ActiveListItem {
	
	public static final ActiveListType ACTIVE_LIST_TYPE = new ActiveListType(1);
	
	private AllergyType allergyType;
	
	private Concept reaction; // must be of class=Symptom
	
	private AllergySeverity severity;
	/**
	 * no argument constructor
	 */
	public Allergy() {
		this.activeListType = new ActiveListType(1);
	}
	/**
	 * one argument constructor
	 * @param activeListId the activeListId to set
	 */
	public Allergy(Integer activeListId) {
		super(activeListId);
		this.activeListType = new ActiveListType(1);
	}
	/**
	 * six argument constructor
	 * @param person the person to set
	 * @param concept the concept to set
	 * @param startDate the startDate to set
	 * @param allergyType the allergyType to set
	 * @param reaction the reaction to set
	 * @param severity the severity to set
	 */
	public Allergy(Patient person, Concept concept, Date startDate, AllergyType allergyType, Concept reaction,
	    AllergySeverity severity) {
		super(person, new ActiveListType(1), concept, startDate);
		this.allergyType = allergyType;
		this.reaction = reaction;
		this.severity = severity;
	}
	
	/**
	 * @return the allergyType
	 */
	public AllergyType getAllergyType() {
		return allergyType;
	}
	
	/**
	 * set the allergyType
	 * @param allergyType the allergyType to set
	 */
	public void setAllergyType(AllergyType allergyType) {
		this.allergyType = allergyType;
	}
	/**
	 * set the allergyType
	 * @param type the type to set
	 */
	public void setAllergyType(String type) {
		this.allergyType = StringUtils.isBlank(type) ? null : AllergyType.valueOf(type);
	}
	
	/**
	 * @return the reaction
	 */
	public Concept getReaction() {
		return reaction;
	}
	
	/**
	 * must be of class=Symptom
	 * 
	 * @param reaction the reaction to set
	 */
	public void setReaction(Concept reaction) {
		this.reaction = reaction;
	}
	
	/**
	 * @return the severity
	 */
	public AllergySeverity getSeverity() {
		return severity;
	}
	
	/**
	 * Set the severity of the allergy
	 * @param severity the severity to set
	 */
	public void setSeverity(AllergySeverity severity) {
		this.severity = severity;
	}
	/**
	 * Set the severity of the allergy
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = StringUtils.isBlank(severity) ? null : AllergySeverity.valueOf(severity);
	}
	
	/**
	 * Get the allergen concept
	 * @return the allergen
	 */
	public Concept getAllergen() {
		return getConcept();
	}
	
	/**
	 * Set the allergen concept
	 * 
	 * @param allergen
	 */
	public void setAllergen(Concept allergen) {
		setConcept(allergen);
	}
}
