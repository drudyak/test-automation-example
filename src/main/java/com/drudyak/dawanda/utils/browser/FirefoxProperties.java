package com.drudyak.dawanda.utils.browser;


/**
 * Created by Denys_Rudiak on 3/1/2017.
 */
class FirefoxProperties {

    private String osName = System.getProperty("os.name").toLowerCase();
    private String osArch = System.getProperty("os.arch").toLowerCase();


    String osDetection() {
        if (osName.contains("linux") || osName.contains("nix")) {
            if (osArch.contains("64")) {
                return "/resources/geckodriver_linux64";
            }
            return "/resources/geckodriver_linux32";
        } else if (osName.contains("mac") || osName.contains("os x")) {
            return "/resources/geckodriver";
        } else if (osName.contains("windows") && osArch.contains("64")) {
            return "\\resources\\geckodriver_win64.exe";
        } else {
            return "\\resources\\geckodriver_win32.exe";
        }
    }

}
