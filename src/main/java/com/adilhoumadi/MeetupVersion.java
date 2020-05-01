package com.adilhoumadi;

public class MeetupVersion {

    private MeetupVersion() {
        // Nothing to do
    }

    public static String getCurrentVersion() {
        try {
            return MeetupVersion.class.getPackage().getImplementationVersion();
        } catch (Exception e) {
            return "Unable to fetch the version for this package";
        }
    }
}
