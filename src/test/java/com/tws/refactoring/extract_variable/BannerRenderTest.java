package com.tws.refactoring.extract_variable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BannerRenderTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void should_render_banner_with_mac_and_ie() {
        final BannerRender bannerRender = new BannerRender();
        final String platform = "MAC01234";
        final String browser = "IE-7";

        final String expected = "Banner rendered\r\n";
        bannerRender.renderBanner(platform, browser);
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void should_not_render_banner_with_not_mac_and_ie() {
        final BannerRender bannerRender = new BannerRender();
        final String platform = "APPLE01234";
        final String browser = "IE-7";

        final String expected = "";
        bannerRender.renderBanner(platform, browser);
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void should_not_render_banner_with_mac_and_not_ie() {
        final BannerRender bannerRender = new BannerRender();
        final String platform = "MAC01234";
        final String browser = "Chrome-7";

        final String expected = "";
        bannerRender.renderBanner(platform, browser);
        assertEquals(expected, outContent.toString());
    }

    @Test
    public void should_not_render_banner_with_not_mac_and_not_ie() {
        final BannerRender bannerRender = new BannerRender();
        final String platform = "APPLE01234";
        final String browser = "Chrome-7";

        final String expected = "";
        bannerRender.renderBanner(platform, browser);
        assertEquals(expected, outContent.toString());
    }
}
