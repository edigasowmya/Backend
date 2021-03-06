package com.niit2.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit2.model.UsersDetails;
import com.niit2.service.UsersService;


@Ignore
public class UsersTest {

	
	@Autowired
	private static UsersService usersService;
	
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize(){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.linkin.*");
		context.refresh();
		
		usersService = (UsersService) context.getBean("usersService");
		
	}
	
	
	@Test
	public void createUserTest(){
		
		UsersDetails user = new UsersDetails();
		
		user.setFirstName("Geeta");
		user.setLastName("Arora");
		user.setUserName("Geeta12");
		user.setEmail("geeta@gmail.com");
		user.setPassword("123456");
		user.setContact("9826245622");
		user.setRole("STUDENT");
		user.setEnable(true);
		user.setIsonline(false);
		
		assertTrue("Problem in storing user details",usersService.saveOrUpdate(user));
		
	}
	@Ignore
	@Test
	public void retrieveUserTest(){
		
		UsersDetails user =usersService.getUser("geeta@gmail.com");
		assertNotNull("Problem in retrieving user details",user);
		System.out.println(" First Name : "+user.getFirstName()+" Last Name :  "+user.getLastName()+"\n Email : "+user.getEmail()+"  User Role : "+user.getRole());
		
	}
	@Ignore
	@Test
	public void updateUserTest(){
		
		UsersDetails user = new UsersDetails();
		user.setUser_id(45);
		user.setFirstName("Geeta");
		user.setLastName("Arora");
		user.setUserName("Geeta12");
		user.setEmail("geeta@gmail.com");
		user.setPassword("112233");
		user.setContact("9826245622");
		user.setRole("STUDENT");
		user.setEnable(true);
		user.setIsonline(false);
		
		assertTrue("Problem in storing user details",usersService.saveOrUpdate(user));
		
		
	}
	
	
	/*@Test
	public void deleteUserTest(){
		
		UsersDetails user = new UsersDetails();
		user.setUser_id(2);
		
		
		assertTrue("Problem in storing user details",usersService.deleteUser(user));
	}
	
	@Test
	public void retrieveAllUsersTest(){
		
		List<UsersDetails> userList =usersService.getAllUsers();
		assertNotNull("Problem in retrieving user details",userList);
		showUserList(userList);
		*/
	

	private void showUserList(List<UsersDetails> userList) {
	
		for (UsersDetails usersDetails : userList) {
			
			System.out.println("User Id: "+usersDetails.getUser_id());
			System.out.println("User First Name: "+usersDetails.getFirstName());
			System.out.println("User LastName: "+usersDetails.getLastName());
			System.out.println("User Email Id: "+usersDetails.getEmail());
			System.out.println("User UserName: "+usersDetails.getUserName());
			System.out.println("User contact: "+usersDetails.getContact());
			System.out.println("User Role: "+usersDetails.getRole());
			System.out.println();
		}
		
	}
	
}
