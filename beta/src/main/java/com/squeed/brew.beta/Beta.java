package com.squeed.brew.beta;

import com.squeed.brew.alpha.Alpha;
import com.squeed.brew.alpha.internal.AlphaSecret;
import com.squeed.brew.beta.internal.BetaSecret;

import java.lang.reflect.Field;

public class Beta
{

    public String beta() {

        return String.format("%s%s and %s \nWith reflection-secret: \nAnd ApiSecret: %s", "beta "
                ,BetaSecret.getBetaSecret(), new Alpha().alpha(), getAlphaSecretViaReflection(), AlphaSecret.getAlphaSecret());
    }

    private String getAlphaSecretViaReflection() {
        String aSecret;
        try {
            Class<?> clazz = Class.forName("com.squeed.brew.alpha.internal.AlphaSecret");
            Field secret = clazz.getDeclaredField("secret");
            secret.setAccessible(true);
            aSecret = (String) secret.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            aSecret = "Secret not obtainable";
        }
        return aSecret;
    }
}
