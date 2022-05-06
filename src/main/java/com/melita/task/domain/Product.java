package com.melita.task.domain;

import com.melita.task.application.validation.*;
import com.melita.task.domain.internet.InternetPackage;
import com.melita.task.domain.mobile.MobilePackage;
import com.melita.task.domain.telephony.TelephonyPackage;
import com.melita.task.domain.tv.TVPackage;
import lombok.Data;

@Data
@AtLeastOneProductRequired
public class Product {
    @InternetPackageSubset(anyOf = {InternetPackage.INTERNET_1_GBPS, InternetPackage.INTERNET_250_MBPS})
    private InternetPackage internetPackage;
    @TVPackageSubset(anyOf = {TVPackage.TV_90_CHANNELS, TVPackage.TV_140_CHANNELS})
    private TVPackage tvPackage;
    @TelephonyPackageSubset(anyOf = {TelephonyPackage.TELEPHONY_FREE_ON_NET_CALLS, TelephonyPackage.TELEPHONY_UNLIMITED_CALLS})
    private TelephonyPackage telephonyPackage;
    @MobilePackageSubset(anyOf = {MobilePackage.MOBILE_POSTPAID, MobilePackage.MOBILE_PREPAID})
    private MobilePackage mobilePackage;
}
