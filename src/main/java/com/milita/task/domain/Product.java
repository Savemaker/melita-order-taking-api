package com.milita.task.domain;

import com.milita.task.application.validation.*;
import com.milita.task.domain.internet.InternetPackage;
import com.milita.task.domain.mobile.MobilePackage;
import com.milita.task.domain.telephony.TelephonyPackage;
import com.milita.task.domain.tv.TVPackage;
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
