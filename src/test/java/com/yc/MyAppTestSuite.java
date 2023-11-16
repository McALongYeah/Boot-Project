package com.yc;

import com.yc.bean.ProductTest;
import com.yc.bean.StudentTest;
import com.yc.service.CalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 测试套件 用于所有一起执行
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({StudentTest.class, CalculatorTest.class, ProductTest.class})
public class MyAppTestSuite {
}
