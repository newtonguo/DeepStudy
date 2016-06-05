//
//import com.umetrip.infocenter.hystrix.JettyServer;
//import net.shaneconnolly.jmeter.JmeterManager;
//import org.apache.jorphan.collections.HashTree;
//import org.junit.Test;
//
//public class JmeterTest
//{
//    JmeterManager jmeterManager;
//
//    @Test
//    public void testJmeterExample()
//    {
//        new JettyServer(28080).init();
//
//
//        jmeterManager = new JmeterManager();
//
//        HashTree testPlanTree = jmeterManager.generateTestPlan("TestPlanName", "WhateverThreadGroup");
//
//        jmeterManager.runSuite(testPlanTree);
//    }
//
//
//}