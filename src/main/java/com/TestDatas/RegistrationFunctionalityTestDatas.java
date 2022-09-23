package com.TestDatas;

import org.testng.annotations.DataProvider;

public class RegistrationFunctionalityTestDatas {
	@DataProvider
	public Object[][] positiveRegistrationData() {
	Object[][]data = {{"ram","thap","1234567890","123@gmail.com","234 Main st","vallejo","CA","94590","ram123@yahoo.com","ramu123","ramu123"},{"Peter","Anderson","4153453456","peterand12@yahoo.com","3452Delphi St","Antioch","CA","94530","peter123@yahoo.com","peterD","peterD"},{"David","Murphy","7098799089","dmurphy1960@gmail.com","1975 Old Town Road","San Jose","CA","95410","david1965@yahoo.com","davidus","davidus"}};

	return data;
	}
	@DataProvider
	public Object[][] NegativeRegistrationDataWithDuplicateDatas() {
	Object[][]data = {{"rambaba","thapti","01234567890","123gf@gmail.com","4234 Main st","antioch","CA","94590","ram123@yahoo.com","ramu123","ramu123"},{"rambaba","thapti","01234567890","123gf@gmail.com","4234 Main st","antioch","CA","94590","ram123@yahoo.com","ramu123","ramu123"},{"rambaba","thapti","01234567890","123gf@gmail.com","4234 Main st","antioch","CA","94590","ram123@yahoo.com","ramu123","ramu123"}};

	return data;
	}
	
	
	@DataProvider (name = "Negative Registration SeperatePasswords")
	public Object[][] negativetiveRegistrationData() {
	Object[][]data = {{"ram","thap","1234567890","123@gmail.com","234 Main st","vallejo","CA","94590","ram123@yahoo.com","ramu123","rambo11"},{"Peter","Anderson","4153453456","peterand12@yahoo.com","3452Delphi St","Antioch","CA","94530","peter123@yahoo.com","peterD","antioch11"},{"David","Murphy","7098799089","dmurphy1960@gmail.com","1975 Old Town Road","San Jose","CA","95410","david1965@yahoo.com","davidus","davidus11"}};

	return data;
	}
	
	@DataProvider(name = "Negativetive Registration Test")
	public Object[][] negativeRegistrationDataWithAllNumericAndSpecialCharacter() {
	Object[][]data = {{"3546#$@31","@$%^545sdE","58767@321ds","123@&*&^%$907.*&^","234 %^$98 12^st!","$#$3217HgtE4"," )(}"
			+ "","&^%[})","%6$#123@_)|?.$$$","$%#@!@#","#$@!123"},{"_+)(UJH^%$56","^&%XZAQ{|",")(IH^%$#*","6yhfdtye5444#$%.)({","3452><?}{+_ *&","^&*&^65544","()","*$##$*","^%<>{}[]@0987.com","&*&(*","(*&&^Tgftr"},{"<>?)(","^&&^5)(Jiuy","$#@!*&^%","_+(*)&^%$@)(*&.com","1^%$#) Old Town Road","San Jose","CA","95410","david19"
			+ "				!5@()*&kj.cm","UHGT^%","^&%$"}};

	return data;
	}
	
	@DataProvider(name = "Blank Form Nagativetive Registration Test")
	public Object[][] blankRegistrationData() {
	Object[][]data = {{"","","","","","","","","","",""},{"","","","","","","","","","",""},{"","","","","","","","","","",""}};

	return data;
	}
}
