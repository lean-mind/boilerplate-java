package es.leanmind.boilerplace.helpers

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

class WebDriverProvider {
    val foo: OSUtils = OSUtils()


    companion object{
        fun getChromeDriver(path: String): WebDriver {
            System.setProperty("webdriver.chrome.driver", path)
            return ChromeDriver()
        }

        fun getFirefoxDriver(path: String): WebDriver {
            System.setProperty("webdriver.gecko.driver", path)
            return FirefoxDriver()
        }
    }
}