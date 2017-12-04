package com.squeed.brew.charlie;

import com.squeed.brew.beta.Beta;
import com.squeed.brew.charlie.internal.CharlieSecret;

import java.lang.reflect.Field;

public class Charlie {
    public String charlie() {

        return String.format("Charlie secret: %s\nBeta: %s (via public API) \nAlpha secret via reflection %s",
                CharlieSecret.getCharlieSecret(), new Beta().beta(), getAlphaSecretViaReflection());
    }

    private String getAlphaSecretViaReflection() {
        String aSecret;
        try {
            Class<?> clazz = Class.forName("com.squeed.brew.alpha.internal.AlphaSecret");
            Field secret = clazz.getDeclaredField("secret");
            secret.setAccessible(true);
            aSecret = (String) secret.get(null);
        } catch (Exception|Error e) {
            e.printStackTrace();
            aSecret = "Secret not obtainable";
        }
        return aSecret;
    }

}
