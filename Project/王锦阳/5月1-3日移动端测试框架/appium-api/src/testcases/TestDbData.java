package testcases;

import org.testng.annotations.Test;

import java.util.Map;
import utils.DbDataHeleper;

public class TestDbData extends DbDataHeleper {

    @Test(dataProvider = "dbDataMethod")
    public void testmethod1(Map<?, ?> param) {
        //System.out.println(param.get("name") + "\t" + param.get("phone") + "\t" + param.get("pwd"));
    	System.out.println(param.get("phone") + "\t" + param.get("pwd"));
    
    }
}
