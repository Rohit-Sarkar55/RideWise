package com.airtribe.ridewise.enums;

public enum LocationEnum {
    //Some Locations of City Bengaluru

    MG_ROAD(12.9716, 77.5946),
    KORAMANGALA(12.9352, 77.6245),
    WHITEFIELD(12.9698, 77.7499),
    INDIRANAGAR(12.9784, 77.6408),
    ELECTRONIC_CITY(12.8452, 77.6600),
    RAJAJINAGAR(12.9915, 77.5545),
    BASAVANAGUDI(12.9410, 77.5753),
    BANASHANKARI(12.9251, 77.5468),
    JP_NAGAR(12.9077, 77.5858),
    YELAHANKA(13.1007, 77.5963),
    KENGERI(12.9141, 77.4871),
    MAGADI_ROAD(12.9784, 77.5068),
    HENNUR(13.0252, 77.6433),
    NAGAWARA(13.0350, 77.6245),
    CV_RAMAN_NAGAR(12.9854, 77.6639),
    ULSOOR(12.9794, 77.6246),
    DOMLUR(12.9609, 77.6387),
    BANASWADI(13.0142, 77.6519),
    KALYAN_NAGAR(13.0222, 77.6408),
    KR_PURAM(13.0080, 77.6955),
    JAKKUR(13.0770, 77.5977);

    private final double latitude;
    private final double longitude;

    LocationEnum(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    } 
}