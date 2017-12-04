module com.alpha {
    exports com.squeed.brew.alpha;
    exports com.squeed.brew.alpha.internal to beta;
    opens com.squeed.brew.alpha to beta;
    opens com.squeed.brew.alpha.internal to beta;
}