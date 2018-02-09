package Login;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;



public class ConnectionManagerTest {

	@Test
	public void testGetConnection() throws SQLException 
	{
		Connection con = ConnectionManager.getConnection();
		Assert.assertNotNull(con);
        Assert.assertTrue(con.isValid(0));
        con.close();
	}

}
