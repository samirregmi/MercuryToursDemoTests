package com.TestDatas;

import org.testng.annotations.DataProvider;

public class LoginFunctionalityTestDatas {

	@DataProvider(name= "positive login Data")
public Object[][]validUsernameValidPasswordPositiveLoginData(){
	Object data[][] = {{"david1965@yahoo.com","davidus"},{"ram123@yahoo.com","ramu123"},{"peter123@yahoo.com","peterD"}};
	return data;
}


@DataProvider
public Object[][] InvalidUsernameAndValidPasswordData() {
	Object data [][] = {{"123@gmail.com","ss123"},{"samsi@123","nep111"},{"sushi","japan12"}};
	return data;
}


@DataProvider(name = "BlankUsernameAndPasswordNegativeLoginData")
public Object[][] ValidUsernameAndInvalidPasswordData() {
	Object data [][] = {{"",""},{"",""},{"",""}};
	return data;
}


@DataProvider
public Object [][]ValidUsernameInvalidPassword(){
	Object[][] data = {{"sam123","ss122"},{"test123","teste111"},{"nep1123","keto111"}};
	return data;
}
@DataProvider(name= "Negative Login Data")
public Object [][]InValidUsernameInvalidPassword(){
	Object[][] data = {{"sam123","ss122"},{"test123","teste111"},{"nep1123","keto111"}};
	return data;
}
}
