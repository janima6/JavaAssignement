package ca.sheridancollege.session;

import java.util.Random;

public class Enums {

	public enum group{
		
		SPORTINGDOG,HOUNDS,WORKINGDOGS,TERRIERS,TOYS,NONSPORTING,HERDINGS; 
		
		public static group getRandomGroup() {
	        Random random = new Random();
	        return values()[random.nextInt(values().length)];
	    }
	}
	
	public enum Breeds{
		BEAGLE,DACHSHUND,WHIPPET,AFGHAN,BORZOI,DEERHOUND,GREYHOUND,IRISHWOLF,BP,POMERANIAN,PUG,HAVANESE;
		
		public static Breeds getRandomBreed() {
	        Random random = new Random();
	        return values()[random.nextInt(values().length)];
	    }
	}
	
	public enum Owner{
		
		JONATHAN,JAMES,MALAV,POOJA,AMANY,CHINGIZ,SHEETAL,NIKOLAI,IDA,RESHMA,SARA,JULIA;
		
		public static Owner getRandomOwner() {
	        Random random = new Random();
	        return values()[random.nextInt(values().length)];
	    }
		
	}
	
	public enum name{
		ACE,APOLLO,BANDIT,TUFFY,JOHN,BLUE,BRADY,BRUNO,CHAMP,COCO,CODY,DUKE,COPPER,BO,BUBBA,ZIGGY,OSCAR,YOGA
		,MAX,MICKEY,TANK,LOKI,THOR,SIMBA,SAM;
		
		public static name getRandomName() {
	        Random random = new Random();
	        return values()[random.nextInt(values().length)];
	    }
	}
	
	public enum gender{
		MALE,FEMALE;
		
		public static gender getRandomGender() {
	        Random random = new Random();
	        return values()[random.nextInt(values().length)];
	    }
	}
	
	public enum ranking {
		CLASS,SPECIALTY;
		
		public static ranking getRandomGender() {
	        Random random = new Random();
	        return values()[random.nextInt(values().length)];
	    }
	}
	
	
	
}



