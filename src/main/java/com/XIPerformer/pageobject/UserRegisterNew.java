package com.XIPerformer.pageobject;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.XIPerformer.util.Commonmethods;
import com.XIPerformer.util.ExtentTestManager;
import com.automation.base.BaseClass;
import java.util.function.Function;


public class UserRegisterNew extends BaseClass {
	
	Commonmethods c = new Commonmethods(); ;

	public UserRegisterNew() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[@type='button'])[4]")
	WebElement newUser;

	@FindBy(name = "demographics.firstName")
	WebElement firstName;

	@FindBy(name = "demographics.lastName")
	WebElement Lastname;
	
	@FindBy(name = "demographics.dateOfBirth")
	WebElement Dob;
	
	@FindBy(id = "mui-component-select-demographics.gender")
	WebElement gender;
	
	@FindBy(xpath = "	//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li")
	List<WebElement> listValue;
	
	
	@FindBy(id = "mui-component-select-demographics.bloodGroup")
	WebElement bloodGroup;
	
	@FindBy(name = "demographics.email")
	WebElement email;
	
	@FindBy(name = "demographics.mobileNumber")
	WebElement mobileNumber;
	
	
	@FindBy(name = "demographics.username")
	WebElement uname;
	
	@FindBy(name = "demographics.password")
	WebElement pword;
	
	
	@FindBy(id = "mui-component-select-demographics.address.country")
	WebElement country;
	
	@FindBy(id = "mui-component-select-demographics.address.state")
	WebElement state;
	
	
	@FindBy(name = "demographics.address.addressLine1")
	WebElement address;
	
	@FindBy(id = "mui-component-select-role")
	WebElement role;
	
	@FindBy(id = "mui-component-select-demographics.contacts.relationship")
	WebElement relationship;
	
	@FindBy(name = "demographics.contacts.name")
	WebElement parentname;
	
	@FindBy(name = "demographics.contacts.mobileNumber")
	WebElement parentmobileNumber;
	
	@FindBy(id = "mui-component-select-qualifications.education")
	WebElement degree;
	
	@FindBy(id = "mui-component-select-qualifications.degree")
	WebElement pdegree;
	
	@FindBy(name = "demographics.physicalAttribute.height")
	WebElement height;
	
	@FindBy(name = "demographics.physicalAttribute.weight")
	WebElement weight;
	
	@FindBy(id = "mui-component-select-qualifications.certification")
	WebElement certification;
	
	@FindBy(id = "mui-component-select-coachId")
	WebElement coachName;
	
	@FindBy(id = "mui-component-select-type")
	WebElement event;
	
	
	@FindBy(id = "mui-component-select-eventType")
	WebElement eventtype;
	
	@FindBy(id = "mui-component-select-subEvent")
	WebElement subevent;
	
		
	@FindBy(xpath = "//div[@class='_child-2_9o1yq_219 _UCIconCon_9o1yq_323 MuiBox-root css-0']/button[@type='button']")
	WebElement eventAddButton;
	
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium _UCIconBtn_9o1yq_325 css-1yxmbwk']")
	WebElement eventAddPButton;
	
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	WebElement submit;

	@FindBy(xpath = "//div[@class='swal2-html-container']")
	WebElement Message;
	
	@FindBy(id = "swal2-title")
	WebElement eventmailexits;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement okButton;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement nextButton;
	
	@FindBy(id = "mui-component-select-qualifications.type")
	WebElement education;
	
	@FindBy(xpath = "//button[@class='swal2-confirm _confirmButton_vrom6_139 swal2-styled']")
	WebElement oktButton;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;
	
	@FindBy(xpath = "//button[@aria-label='Back']")
	WebElement backButton;
	
	@FindBy(xpath = "//button[@aria-label='Go to next page']]")
	WebElement lastpage;
	
	@FindBy(xpath = "//div[@class='_ULRoleCon_sc8ji_183  MuiBox-root css-0']/p[contains(text(),'Player')]")
	WebElement playerbutton;
	
	
	

	public void userCoachDetails(Map<String, String> data) throws InterruptedException {

	    Thread.sleep(5000);
	    newUser.click();

	    Function<String, String> get = (key) -> data.getOrDefault(key, "").trim();

	    firstName.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    firstName.sendKeys(get.apply("FIrst Name"));

	    Lastname.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    Lastname.sendKeys(get.apply("Last Name"));

	    email.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    email.sendKeys(get.apply("Email ID (For Login)"));
	    
	    role.click();
	    c.dropdownClick(listValue, "Coach");

	    mobileNumber.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    mobileNumber.sendKeys(get.apply("Mobile Number"));

	    uname.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    String email = data.get("FIrst Name");
	    uname.sendKeys(email);

	    pword.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    pword.sendKeys("Welcome@2k25");

	    address.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    address.sendKeys(get.apply("Address"));

	    Dob.sendKeys(get.apply("Date of Birth"));

	    if (!get.apply("Gender").isEmpty()) {
	        gender.click();
	        c.dropdownClick(listValue, get.apply("Gender"));
	    }

	    if (!get.apply("bloodgroup").isEmpty()) {
	        bloodGroup.click();
	        c.dropdownClick(listValue, get.apply("bloodgroup"));
	    }

	    if (!get.apply("Country").isEmpty()) {
	        country.click();
	        c.dropdownClick(listValue, get.apply("Country"));
	    }

	    if (!get.apply("State").isEmpty()) {
	        state.click();
	        c.dropdownClick(listValue, get.apply("State"));
	    }


	    if (!get.apply("Educational Qualification").isEmpty()) {
	        degree.click();
	        c.dropdownClick(listValue, get.apply("Educational Qualification"));
	    }

	    if (!get.apply("Certification").isEmpty()) {
	        certification.click();
	        c.dropdownClick(listValue, get.apply("Certification"));
	    }
	    
	    c.scrollDownBy();
	    Thread.sleep(1000);


	    Map<String, String[]> subEventMap = new HashMap<>();

	    // Track → Sprint
	    subEventMap.put("60 m", new String[]{"Track", "Sprint"});
	    subEventMap.put("100 m", new String[]{"Track", "Sprint"});
	    subEventMap.put("200 m", new String[]{"Track", "Sprint"});
	    subEventMap.put("400 m", new String[]{"Track", "Sprint"});

	    // Track → Middle Distance
	    subEventMap.put("800 m", new String[]{"Track", "Middle Distance"});
	    subEventMap.put("1500 m", new String[]{"Track", "Middle Distance"});

	    // Track → Long Distance
	    subEventMap.put("5000 m", new String[]{"Track", "Long Distance"});
	    subEventMap.put("10000 m", new String[]{"Track", "Long Distance"});
	    subEventMap.put("3000 m", new String[]{"Track", "Long Distance"});

	    // Track → Hurdles
	    subEventMap.put("60 m Hurdles", new String[]{"Track", "Hurdles"});
	    subEventMap.put("100 m Hurdles", new String[]{"Track", "Hurdles"});
	    subEventMap.put("110 m Hurdles", new String[]{"Track", "Hurdles"});
	    subEventMap.put("400 m Hurdles", new String[]{"Track", "Hurdles"});

	    // Track → Relay
	    subEventMap.put("4x100 m Relay", new String[]{"Track", "Relay"});
	    subEventMap.put("4x400 m Relay", new String[]{"Track", "Relay"});

	    // Field → Jump
	    subEventMap.put("Long Jump", new String[]{"Field", "Jump"});
	    subEventMap.put("Triple Jump", new String[]{"Field", "Jump"});
	    subEventMap.put("High Jump", new String[]{"Field", "Jump"});
	    subEventMap.put("Pole Vault", new String[]{"Field", "Jump"});

	    // Field → Throw
	    subEventMap.put("Shot Put", new String[]{"Field", "Throw"});
	    subEventMap.put("Discus Throw", new String[]{"Field", "Throw"});
	    subEventMap.put("Javelin Throw", new String[]{"Field", "Throw"});
	    subEventMap.put("Hammer Throw", new String[]{"Field", "Throw"});

	    // Team Sport → Team Event
	    subEventMap.put("Cricket", new String[]{"Team Sport", "Team Event"});


	    String[] subEvents = get.apply("Specialized in").isEmpty() ? new String[0] : get.apply("Specialized in").split(",");

	    for (String sub : subEvents) {
	        if (sub.trim().isEmpty()) 
	        	continue;

	        String[] eventInfo = subEventMap.get(sub.trim());
	        if (eventInfo == null) {
	            System.out.println("Mapping not found for Sub Event: " + sub);
	            continue;
	        }

	        String mainEvent = eventInfo[0];   // Track, Field, Team Sport
	        String eventType = eventInfo[1];   // Sprint, Middle Distance, Jump, Throw, Team Event

		    Thread.sleep(3000);

	    
	        event.click();
	        c.dropdownClick(listValue, mainEvent);

	        eventtype.click();
	        c.dropdownClick(listValue, eventType);

	        
	        subevent.click();
	        Thread.sleep(2000);

	        c.dropdownClick(listValue, sub.trim());

		    Thread.sleep(2000);

		    eventAddButton.click();
	        Thread.sleep(2000);
	    }


	    try {
	        if (eventmailexits.isDisplayed() &&
	                eventmailexits.getText().equals("Email Already Exists")) {

	            System.out.println("Email Already Exists");
	            oktButton.click();
	        }
	    } catch (NoSuchElementException ignored) {}
	    
	    checkbox.click();
	    Thread.sleep(3000);
	    submit.click();
	    Thread.sleep(3000);

	    if (Message.getText().equals("The Coach Has Been Created Successfully!")) {
	        System.out.println("Coach Created Successfully");
	        okButton.click();
		    Thread.sleep(3000);


		 while (true) {
		     WebElement nextBtn = driver.findElement(By.xpath("//button[@aria-label='Go to next page']"));

		     if (nextBtn.getAttribute("disabled") != null) {
		         break;
		     }

		     nextBtn.click();
		     Thread.sleep(500);   
		 }

		 List<WebElement> rows = driver.findElements(By.xpath("//div[@role='row' and @data-rowindex]"));
		 int lastIndex = rows.size();
		 
		 System.out.println(lastIndex);

		 String latestUserId = driver.findElement(
		         By.xpath("//div[@role='row'][" + lastIndex + "]//div[@data-field='userId']")
		 ).getText();
		 
		 ExtentTestManager.getTest().info(" User ID: " + latestUserId);

		 System.out.println(" User ID = " + latestUserId);

	        
	    } else {
	        System.out.println("Coach not created (duplicate or error)");
	        okButton.click();
	        Thread.sleep(2000);
	        c.scrollToTop();
	        Thread.sleep(2000);
	        backButton.click();

	        
	       
	    }
	    
	}




	public void userPlayerDetails(Map<String, String> data) throws InterruptedException {

	    Thread.sleep(5000);
	    newUser.click();

	    Function<String, String> get = (key) -> data.getOrDefault(key, "").trim();

	    firstName.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    firstName.sendKeys(get.apply("First Name"));

	    Lastname.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    Lastname.sendKeys(get.apply("Last Name"));

	    email.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    email.sendKeys(get.apply("Email ID (For Login)"));

	    role.click();
	    c.dropdownClick(listValue, "Player");

	    mobileNumber.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    mobileNumber.sendKeys(get.apply("Mobile Number"));

	    Thread.sleep(3000);

	    uname.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    String generatedEmail = get.apply("First Name");
	    uname.sendKeys(generatedEmail);

	    pword.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    pword.sendKeys("Welcome@2k25");

	    address.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    address.sendKeys(get.apply("Address"));

	    Dob.sendKeys(get.apply("Date of Birth"));

	    if (!get.apply("Gender").isEmpty()) {
	        gender.click();
	        c.dropdownClick(listValue, get.apply("Gender"));
	    }

	    if (!get.apply("BloodGroup").isEmpty()) {
	        bloodGroup.click();
	        c.dropdownClick(listValue, get.apply("BloodGroup"));
	    }

	    if (!get.apply("Country").isEmpty()) {
	        country.click();
	        c.dropdownClick(listValue, get.apply("Country"));
	    }

	    if (!get.apply("State").isEmpty()) {
	        state.click();
	        c.dropdownClick(listValue, get.apply("State"));
	    }

	    if (!get.apply("Parental Relatonship").isEmpty()) {
	        relationship.click();
	        c.dropdownClick(listValue, get.apply("Parental Relatonship"));
	    }

	    if (!get.apply("Certification").isEmpty()) {
	        certification.click();
	        c.dropdownClick(listValue, get.apply("Certification"));
	    }

	    parentname.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    parentname.sendKeys(get.apply("Parent / Guardian Name"));

	    parentmobileNumber.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    parentmobileNumber.sendKeys(get.apply("Parent Mobile Number"));

	    nextButton.click();
	    Thread.sleep(3000);
	    c.scrollToTop();

	    if (!get.apply("Education").isEmpty()) {
	        education.click();
	        c.dropdownClick(listValue, get.apply("Education"));
	    }

	    if (!get.apply("Degree (If College)").isEmpty()) {
	        pdegree.click();
	        c.dropdownClick(listValue, get.apply("Degree (If College)"));
	    }

	    height.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    height.sendKeys(get.apply("Height"));

	    weight.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	    weight.sendKeys(get.apply("Weight"));

	    if (!get.apply("Coach Name").isEmpty()) {
	        coachName.click();
	        c.dropdownClick(listValue, get.apply("Coach Name"));
	    }
	    
	    c.scrollDownBy();
	    Thread.sleep(1000);

	 // Map of Sub Event → [Event, EventType]
	    Map<String, String[]> subEventMap = new HashMap<>();

	    // Track → Sprint
	    subEventMap.put("60 m", new String[]{"Track", "Sprint"});
	    subEventMap.put("100 m", new String[]{"Track", "Sprint"});
	    subEventMap.put("200 m", new String[]{"Track", "Sprint"});
	    subEventMap.put("400 m", new String[]{"Track", "Sprint"});

	    // Track → Middle Distance
	    subEventMap.put("800 m", new String[]{"Track", "Middle Distance"});
	    subEventMap.put("1500 m", new String[]{"Track", "Middle Distance"});

	    // Track → Long Distance
	    subEventMap.put("5000 m", new String[]{"Track", "Long Distance"});
	    subEventMap.put("10000 m", new String[]{"Track", "Long Distance"});
	    subEventMap.put("3000 m", new String[]{"Track", "Long Distance"});

	    // Track → Hurdles
	    subEventMap.put("60 m Hurdles", new String[]{"Track", "Hurdles"});
	    subEventMap.put("100 m Hurdles", new String[]{"Track", "Hurdles"});
	    subEventMap.put("110 m Hurdles", new String[]{"Track", "Hurdles"});
	    subEventMap.put("400 m Hurdles", new String[]{"Track", "Hurdles"});

	    // Track → Relay
	    subEventMap.put("4x100 m Relay", new String[]{"Track", "Relay"});
	    subEventMap.put("4x400 m Relay", new String[]{"Track", "Relay"});

	    // Field → Jump
	    subEventMap.put("Long Jump", new String[]{"Field", "Jump"});
	    subEventMap.put("Triple Jump", new String[]{"Field", "Jump"});
	    subEventMap.put("High Jump", new String[]{"Field", "Jump"});
	    subEventMap.put("Pole Vault", new String[]{"Field", "Jump"});

	    // Field → Throw
	    subEventMap.put("Shot Put", new String[]{"Field", "Throw"});
	    subEventMap.put("Discus Throw", new String[]{"Field", "Throw"});
	    subEventMap.put("Javelin Throw", new String[]{"Field", "Throw"});
	    subEventMap.put("Hammer Throw", new String[]{"Field", "Throw"});

	    // Team Sport → Team Event
	    subEventMap.put("Cricket", new String[]{"Team Sport", "Team Event"});


	    String[] subEvents = get.apply("Sub Events").isEmpty() ? new String[0] : get.apply("Sub Events").split(",");

	    for (String sub : subEvents) {
	        if (sub.trim().isEmpty()) 
	        	continue;

	        String[] eventInfo = subEventMap.get(sub.trim());
	        if (eventInfo == null) {
	            System.out.println("Mapping not found for Sub Event: " + sub);
	            continue;
	        }

	        String mainEvent = eventInfo[0];   // Track, Field, Team Sport
	        String eventType = eventInfo[1];   // Sprint, Middle Distance, Jump, Throw, Team Event

		    Thread.sleep(3000);

	    
	        event.click();
	        c.dropdownClick(listValue, mainEvent);

	        eventtype.click();
	        c.dropdownClick(listValue, eventType);

	        subevent.click();
	        c.dropdownClick(listValue, sub.trim());

		    Thread.sleep(2000);

		    eventAddPButton.click();
	        Thread.sleep(2000);
	    }

	    
	    try {
	        if (eventmailexits.isDisplayed() && eventmailexits.getText().equals("Email Already Exists")) {
	            System.out.println("Email Already Exists");
	            oktButton.click();
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Event added successfully!");
	    }

	    Thread.sleep(5000);

	    submit.click();
	    Thread.sleep(5000);

	    if (Message.getText().equals("The Player Has Been Created Successfully!")) {
	        System.out.println("Player Created Successfully");
	        okButton.click();
	        
		    Thread.sleep(2000);
  
	        playerbutton.click();
	        
	        while (true) {
			     WebElement nextBtn = driver.findElement(By.xpath("//button[@aria-label='Go to next page']"));

			     if (nextBtn.getAttribute("disabled") != null) {
			         break;
			     }

			     nextBtn.click();
			     Thread.sleep(500);   
			 }

			 List<WebElement> rows = driver.findElements(By.xpath("//div[@role='row' and @data-rowindex]"));
			 int lastIndex = rows.size();
			 
			 System.out.println(lastIndex);

			 String latestUserId = driver.findElement(
			         By.xpath("//div[@role='row'][" + lastIndex + "]//div[@data-field='userId']")
			 ).getText();
			 
			 ExtentTestManager.getTest().info("User ID: " + latestUserId);

			 System.out.println(" User ID = " + latestUserId);

	    } else {
	        System.out.println("Player not created — it may already exist or Duplicate Value!");
	        okButton.click();
	        Thread.sleep(2000);
	        c.scrollToTop();
	        Thread.sleep(3000);
	        backButton.click();
	    }
	}

}




//Map<String, String> subEventToEvent = new HashMap<>();
//subEventToEvent.put("60 m", "Track");
//subEventToEvent.put("100 m", "Track");
//subEventToEvent.put("200 m", "Track");
//subEventToEvent.put("400 m", "Track");
//subEventToEvent.put("800 m", "Track");
//subEventToEvent.put("1500 m", "Track");
//subEventToEvent.put("5000 m", "Track");
//subEventToEvent.put("10000 m", "Track");
//subEventToEvent.put("3000 m Steeplechase", "Track");
//subEventToEvent.put("60 m Hurdles", "Track");
//subEventToEvent.put("100 m Hurdles", "Track");
//subEventToEvent.put("110 m Hurdles", "Track");
//subEventToEvent.put("400 m Hurdles", "Track");
//subEventToEvent.put("4x100 m Relay", "Track");
//subEventToEvent.put("4x400 m Relay", "Track");
//
//subEventToEvent.put("Long Jump", "Field");
//subEventToEvent.put("Triple Jump", "Field");
//subEventToEvent.put("High Jump", "Field");
//subEventToEvent.put("Pole Vault", "Field");
//subEventToEvent.put("Shot Put", "Field");
//subEventToEvent.put("Discus Throw", "Field");
//subEventToEvent.put("Javelin Throw", "Field");
//subEventToEvent.put("Hammer Throw", "Field");
//
//subEventToEvent.put("25 m", "Track");
//subEventToEvent.put("40 m", "Track");
//subEventToEvent.put("75 m", "Track");
//subEventToEvent.put("Hoops Run", "Track");
//subEventToEvent.put("3000 m", "Track");
//
//subEventToEvent.put("Cricket", "Team Sport");
//
//String[] subEvents = get.apply("SubEvent").isEmpty() ? new String[0] : get.apply("Sub Events").split(",");
//
//for (String sub : subEvents) {
//    if (sub.trim().isEmpty()) 
//    	continue;
//
//    String parentEvent = subEventToEvent.get(sub.trim());
//    if (parentEvent == null) {
//        System.out.println("Parent Event not found for Sub Event: " + sub);
//        continue;
//    }
//
//    event.click();
//    dropdownClick(listValue, parentEvent);
//
//    subevent.click();
//    dropdownClick(listValue, sub.trim());
//
//    eventAddButton.click();
//    Thread.sleep(1000);
//}
//
//
//
