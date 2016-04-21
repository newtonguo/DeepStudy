import com.umetrip.infocenter.hystrix.JettyServer;
import net.shaneconnolly.jmeter.JmeterManager;
import org.apache.jorphan.collections.HashTree;
import org.junit.Test;

public class JmeterTest2
{
    JmeterManager jmeterManager;

    @Test
    public void testJmeterExample()
    {
        new JettyServer(28081).init();


        jmeterManager = new JmeterManager();

        HashTree testPlanTree = jmeterManager.generateTestPlan("TestPlanName", "WhateverThreadGroup");

        jmeterManager.runSuite(testPlanTree);
    }


}