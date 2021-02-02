package com.thistosj.selectinfo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 浏览器驱动
 *
 * @author lgq
 */
public class DriverUtil {
    private DriverUtil() {
    }

    /**
     * 谷歌浏览器驱动
     */
    public static WebDriver chromeDriver(String url) {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get(url);
        return chromeDriver;
    }
}
