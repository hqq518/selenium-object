package com.hqq.web;

import com.hqq.driver.Chrome;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 服务启动类
 */
public class Bootstrap {

    public static void start(String startUrl, Chrome chrome) throws InterruptedException {
        if (StringUtils.isNotBlank(startUrl)){
            chrome.open(startUrl);

            // 身份证输入框
            chrome.findElementByTagName("input").sendKeys("452631198511104434");

            TimeUnit.SECONDS.sleep(1);

            // 点击“查询”按钮
            chrome.findElementByXpath("//*[@id=\"app\"]/div/div[2]/div[2]/button").click();

            TimeUnit.SECONDS.sleep(3);

            // 点击“文化程度”
            chrome.findElementByXpath("//*[@id=\"app\"]/div/div[1]/div[1]/div/div[7]/div").click();
            // 获取“文化程度”下拉框内容滚动区
            List<WebElement> scrollList = chrome.findElementsByCssSelector(".scroller-content");

            Actions action = new Actions(chrome.getDriver());
            if (scrollList != null && scrollList.size() > 0){
                //鼠标拖动向上移动“小学”街区,之后释放鼠标
                //action.dragAndDropBy(scrollList.get(5), 0, -136).perform();
                //action.clickAndHold(scrollList.get(5)).moveByOffset(0, -136);

                JavascriptExecutor jsExecutor = (JavascriptExecutor) chrome.getDriver();
                jsExecutor.executeScript("document.getElementsByClassName(\"scroller-content\")[5].style = \"transform: translate3d(0px, -136px, 0px)\";");
                //action.clickAndHold(scrollList.get(5)).perform();
            }
        }
    }

    public static void main(String[] args) {
        String startUrl = "https://baise-llcj.e-tecsun.com/#/search";

        Chrome chrome = new Chrome("G:\\JAVA\\selenium-webdriver\\chromedriver_win32\\chromedriver.exe");
        try {
            start(startUrl, chrome);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //chrome.quit();
        }
    }
}
