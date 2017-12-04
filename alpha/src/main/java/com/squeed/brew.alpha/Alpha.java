package com.squeed.brew.alpha;

import com.squeed.brew.alpha.internal.AlphaSecret;

public class Alpha
{
    public String alpha() {
        return String.format("\n\n---- Alpha ---- %s \n\n---- Alpha End ----", AlphaSecret.getAlphaSecret());
    }
}
