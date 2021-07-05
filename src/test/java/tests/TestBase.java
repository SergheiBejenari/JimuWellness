package tests;

import POM.Application;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected Application app;

    @BeforeSuite
    public void getApp() {
        app = new Application();
    }

    @AfterSuite
    public void quitDriver() {
        app.quitDriver();
    }
}
