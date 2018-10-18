/*
 * https://github.com/junit-team/junit4/wiki/assertions
 */
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testUnitarios.class, testMeta4Peoplenet.class })

public class testSuite {
	
}
