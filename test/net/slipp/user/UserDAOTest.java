package net.slipp.user;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class UserDAOTest {
	private UserDAO userDao;
	
	@Before
	public void setup(){
		userDao = new UserDAO();	
	}
	
	@Test
	public void connection(){
		Connection con = userDao.getConnection();
		assertNotNull(con);
	}
	
	@Test
	public void addUser() throws Exception{
		userDao.addUser(UserTest.TEST_USER);
	}
	
	@Test
	public void findByUserId() throws Exception{
		User user = userDao.findUserById("thisisID");
		assertEquals(UserTest.TEST_USER, user);
	}
}
