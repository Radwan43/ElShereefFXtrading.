package io.pi.ElShereefFxTrading.Models;

public class SplashPrefrences {

    private String message;
    private String bgURL;

    public SplashPrefrences() {
    }

    public SplashPrefrences(String message, String bgURL) {
        this.message = message;
        this.bgURL = bgURL;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBgURL() {
        return bgURL;
    }

    public void setBgURL(String bgURL) {
        this.bgURL = bgURL;
    }


}
