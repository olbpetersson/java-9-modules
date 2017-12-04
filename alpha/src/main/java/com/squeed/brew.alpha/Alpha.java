package com.squeed.brew.alpha;

import com.squeed.brew.alpha.internal.AlphaSecret;

public class Alpha
{
    public String alpha() {
        return "alpha " + AlphaSecret.getAlphaSecret();
    }
}
