/**
 * 
 */
package dataprovider;
import org.testng.annotations.DataProvider;

/**
 * @author Vishal Gupta
 * Data provider class 
 */

public class TestDataProvider{
	
  
  
  @DataProvider
  public Object[][] validUserDataProvider() {
	  
	  Object [][] validUserData=new Object[1][2];
    
	  validUserData[0][0]="friend";  // valid user name
	  validUserData[0][1]="mellon";  // valid password
    
      return validUserData;	  
   
  }
  
  //Invalid user name data provider
  @DataProvider
  public Object[][] invalidUserDataProvider() {
	  
	  Object [][] invalidUserData=new Object[1][2];
    
	  invalidUserData[0][0]="invalidUser";  // valid user name
	  invalidUserData[0][1]="invalidPassword";  // valid password
    
      return invalidUserData;	  
   
  }
}
