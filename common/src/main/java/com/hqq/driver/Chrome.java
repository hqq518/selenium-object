package com.hqq.driver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 基于Chrome浏览器的驱动和解析网页
 */
public class Chrome {

    private WebDriver driver;

    /**
     * 构造器
     * @param chromeDriverExeFilePath chromedriver.exe文件路径
     */
    public Chrome(String chromeDriverExeFilePath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverExeFilePath);
        driver = new ChromeDriver();
    }

    /**
     * 打开网页
     * @param url 网页地址
     */
    public void open(String url) {
        if (StringUtils.isNotBlank(url)){
            this.driver.navigate().to(url);
        } else {
            throw new IllegalArgumentException("url不能为空");
        }
    }

    /**
     * 退出浏览器
     */
    public void quit(){
        this.driver.quit();
    }

    /**
     * 根据id查询元素
     * @param id 元素id
     * @return WebElement
     */
    public WebElement findElementById(String id){
        if (StringUtils.isNotBlank(id)){
            return this.driver.findElement(By.id(id));
        }
        throw new IllegalArgumentException("id不能为空");
    }

    /**
     * 根据id查询元素
     * @param xPath 元素xPath
     * @return WebElement
     */
    public WebElement findElementByXpath(String xPath){
        if (StringUtils.isNotBlank(xPath)){
            return this.driver.findElement(By.xpath(xPath));
        }
        throw new IllegalArgumentException("xPath不能为空");
    }

    /**
     * 根据className查询元素
     * @param className 元素className
     * @return WebElement
     */
    public WebElement findElementByClassName(String className){
        if (StringUtils.isNotBlank(className)){
            return this.driver.findElement(By.className(className));
        }
        throw new IllegalArgumentException("className不能为空");
    }

    /**
     * 根据tagName查询元素
     * @param tagName 元素tagName
     * @return WebElement
     */
    public WebElement findElementByTagName(String tagName){
        if (StringUtils.isNotBlank(tagName)){
            return this.driver.findElement(By.tagName(tagName));
        }
        throw new IllegalArgumentException("tagName不能为空");
    }

    /**
     * 根据cssSelector查询元素
     * @param cssSelector 元素cssSelector
     * @return List<WebElement>
     */
    public List<WebElement> findElementsByCssSelector(String cssSelector){
        if (StringUtils.isNotBlank(cssSelector)){
            return this.driver.findElements(By.cssSelector(cssSelector));
        }
        throw new IllegalArgumentException("cssSelector不能为空");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","G:\\JAVA\\selenium-webdriver\\chromedriver_win32\\chromedriver.exe");//驱动放置位置
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys(new  String[] {"百度公司"});
        WebElement element = driver.findElement(By.xpath("//*[@id='su']"));
        element.click();
        TimeUnit.SECONDS.sleep(1);
        //WebElement element2 = driver.findElement(By.linkText("百度在线网络技术(北京)有限公司_百度百科"));
        WebElement element2=driver.findElement(By.xpath("//*[@id='3']/h3/a"));
        element2.click();
        TimeUnit.SECONDS.sleep(1);
        //Actions action = new Actions(driver);
        //action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).perform();
    }
}
