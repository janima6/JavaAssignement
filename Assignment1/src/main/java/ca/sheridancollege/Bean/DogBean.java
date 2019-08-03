package ca.sheridancollege.Bean;

import lombok.*;

@Data
public class DogBean {
	

	private int EntryNumber;
	private String dogName;
	private String ownerName;
	private String breed;
	private String group;
	private String gender;
	private String ranking;
	private String error;
	private String bcount;
	private String male;
	private String female;
	private String smale;
	private String sfemale;
	/**
	 * @param entryNumber
	 * @param dogName
	 * @param ownerName
	 * @param breed
	 * @param group
	 * @param gender
	 * @param ranking
	 */
	public DogBean(int entryNumber, String dogName, String ownerName, String breed, String group, String gender,
			String ranking) {
		super();
		EntryNumber = entryNumber;
		this.dogName = dogName;
		this.ownerName = ownerName;
		this.breed = breed;
		this.group = group;
		this.gender = gender;
		this.ranking = ranking;
	}
	
	
	
	public DogBean() {}



	public DogBean(String searchByNumber) {
		// TODO Auto-generated constructor stub

		if (searchByNumber.matches("^[-+]?\\d*$"))
		{
		int entryNumber = Integer.parseInt(searchByNumber);
		this.EntryNumber=entryNumber;
		}
		
		if(!searchByNumber.matches("^[-+]?\\d*$")) {
			
			this.dogName=searchByNumber;
			this.ownerName=searchByNumber;
			this.breed=searchByNumber;
			this.group=searchByNumber;
			this.male=searchByNumber;
			this.female=searchByNumber;
			this.smale=searchByNumber;
			this.sfemale=searchByNumber;
			
		}
	}



	public DogBean(String breed2, String count) {
		
		this.breed = breed2;
		this.bcount=count;
		// TODO Auto-generated constructor stub
	}



	public DogBean(String count, String breed2, String male2, String female2, String sm, String fm) {
		// TODO Auto-generated constructor stub
		this.bcount=count;
		this.breed=breed2;
		this.male=male2;
		this.female=female2;
		this.smale=sm;
		this.sfemale=fm;
	}
	
	
	
	
	
}
