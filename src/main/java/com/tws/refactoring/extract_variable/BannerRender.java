package com.tws.refactoring.extract_variable;

public class BannerRender {
    private String macString = "MAC";
    private String ieString = "IE";

    void renderBanner(String platform, String browser) {
        if (platformIsMac(platform) && browserIsIE(browser)) {
            // do something
            System.out.println("Banner rendered");
        }
    }

    private boolean platformIsMac(String platform) {
        return (platform.toUpperCase().indexOf(macString) > -1);
    }

    private boolean browserIsIE(String browser) {
        return (browser.toUpperCase().indexOf(ieString) > -1);
    }
}
