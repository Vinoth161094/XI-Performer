package com.XIPerformer.pageobject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

import com.XIPerformer.util.Commonmethods;
import com.automation.base.BaseClass;

public class UserRegister extends BaseClass {
	
	Commonmethods Common = new Commonmethods(); ;

	public UserRegister() {
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
	
	@FindBy(xpath = "//button[@aria-label='Back']")
	WebElement backButton;
	
	
	
	

public void userCoachDetails(String fname, String lname, String Gender, String BloodGroup, String Email, String mobilenumber, String username, String password, String Country, String State, String Address, String Role, String dob, String Degree, String Certification, String Event, String EventType, String SubEvent) throws InterruptedException {
	
	Thread.sleep(5000);
	newUser.click();
	
	firstName.sendKeys(Keys.CONTROL + "a");
	firstName.sendKeys(Keys.DELETE);
	firstName.sendKeys(fname);
	
	Lastname.sendKeys(Keys.CONTROL + "a");
	Lastname.sendKeys(Keys.DELETE);

	Lastname.sendKeys(lname);
	
	gender.click();
	
	dropdownClick(listValue, Gender);
	
	bloodGroup.click();
	
	dropdownClick(listValue, BloodGroup);
	
	email.sendKeys(Keys.CONTROL + "a");
	email.sendKeys(Keys.DELETE);
	email.sendKeys(Email);
	
	mobileNumber.sendKeys(Keys.CONTROL + "a");
	mobileNumber.sendKeys(Keys.DELETE);
	mobileNumber.sendKeys(mobilenumber);
	

	uname.sendKeys(Keys.CONTROL + "a");
	uname.sendKeys(Keys.DELETE);
	uname.sendKeys(username);
	
	
	pword.sendKeys(Keys.CONTROL + "a");
	pword.sendKeys(Keys.DELETE);
	pword.sendKeys(password);
	
	country.click();
	dropdownClick(listValue, Country);
	
	state.click();;
	dropdownClick(listValue, State);
	
	address.sendKeys(Keys.CONTROL + "a");
	address.sendKeys(Keys.DELETE);

	address.sendKeys(Address);
	
	role.click();
	dropdownClick(listValue, Role);
	
	Dob.sendKeys(dob);
	
	degree.click();
	dropdownClick(listValue, Degree);
	
	
	certification.click();
	dropdownClick(listValue, Certification);
	
	String[] events      = Event.split(",");
	String[] eventTypes  = EventType.split(",");
	String[] subEvents   = SubEvent.split(",");

	int max = Math.max(events.length, Math.max(eventTypes.length, subEvents.length));

	for (int i = 0; i < max; i++) {

	    event.click();
	    if (i < events.length) {
	        dropdownClick(listValue, events[i].trim());
	    }

	    eventtype.click();
	    if (i < eventTypes.length) {
	        dropdownClick(listValue, eventTypes[i].trim());
	    }

	    subevent.click();
	    if (i < subEvents.length) {
	        dropdownClick(listValue, subEvents[i].trim());
	    }

	    eventAddButton.click();

	    Thread.sleep(2000);
	}



//	event.click();
//	String[] split = Event.split(",");
//	for (int i = 0; i < split.length; i++) {
//		dropdownClick(listValue, split[i]);
//	
//	}
//	
//	eventtype.click();
//	dropdownClick(listValue, EventType);
//	
//	subevent.click();
//	dropdownClick(listValue, SubEvent);
//	
//	Thread.sleep(2000);
//
//
//	eventAddButton.click();
//	
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



	if (Message.getText().equals("The Coach Has Been Created Successfully!")) {
		System.out.println("coach Created Successfully");
		okButton.click();

	} else {
		System.out.println("Coach not created — it may already exist or Duplicate Value!");
		okButton.click();
		Thread.sleep(2000);
		Common.scrollToTop();
		Thread.sleep(5000);
		backButton.click();

	}
}

public void userPlayerDetails(String fname, String lname, String Gender, String BloodGroup, String Email, String mobilenumber, String username, String password, String Country, String State, String Address, String Role, String dob, String Relationship, String Parentname, String parentmobilenum, String Education, String Edegree, String Height, String Weight, String coachname, String Event, String EventType, String SubEvent) throws InterruptedException {
	
	Thread.sleep(7000);
	newUser.click();
	
	firstName.sendKeys(Keys.CONTROL + "a");
	firstName.sendKeys(Keys.DELETE);
	firstName.sendKeys(fname);
	
	Lastname.sendKeys(Keys.CONTROL + "a");
	Lastname.sendKeys(Keys.DELETE);

	Lastname.sendKeys(lname);
	
	gender.click();
	
	dropdownClick(listValue, Gender);
	
	bloodGroup.click();
	
	dropdownClick(listValue, BloodGroup);
	
	email.sendKeys(Keys.CONTROL + "a");
	email.sendKeys(Keys.DELETE);
	email.sendKeys(Email);
	
	mobileNumber.sendKeys(Keys.CONTROL + "a");
	mobileNumber.sendKeys(Keys.DELETE);
	mobileNumber.sendKeys(mobilenumber);
	

	uname.sendKeys(Keys.CONTROL + "a");
	uname.sendKeys(Keys.DELETE);
	uname.sendKeys(username);
	
	
	pword.sendKeys(Keys.CONTROL + "a");
	pword.sendKeys(Keys.DELETE);
	pword.sendKeys(password);
	
	country.click();
	dropdownClick(listValue, Country);
	
	state.click();;
	dropdownClick(listValue, State);
	
	address.sendKeys(Keys.CONTROL + "a");
	address.sendKeys(Keys.DELETE);

	address.sendKeys(Address);
	
	role.click();
	dropdownClick(listValue, Role);
	
	Dob.sendKeys(dob);
	
	relationship.click();
	dropdownClick(listValue, Relationship);
	
	
	parentname.sendKeys(Parentname);

	parentmobileNumber.sendKeys(parentmobilenum);
	
	nextButton.click();
	
	Thread.sleep(3000);

	Common.scrollToTop();
	education.click();
	dropdownClick(listValue, Education);


	pdegree.click();
	dropdownClick(listValue, Edegree);

	height.sendKeys(Height);
	weight.sendKeys(Weight);
	
	coachName.click();
	dropdownClick(listValue, coachname);
	
	event.click();
	Thread.sleep(2000);

	dropdownClick(listValue, Event);
	
	eventtype.click();
	
	Thread.sleep(3000);

	dropdownClick(listValue, EventType);
	
	subevent.click();
	
	Thread.sleep(2000);

	dropdownClick(listValue, SubEvent);
	
	Thread.sleep(2000);

	eventAddPButton.click();

	
	Thread.sleep(2000);
	
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

	} else {
		System.out.println("Player not created — it may already exist or Duplicate Value!");
		okButton.click();
		Thread.sleep(2000);
		Common.scrollToTop();
		Thread.sleep(3000);
		backButton.click();

	}


	



}

	
}
