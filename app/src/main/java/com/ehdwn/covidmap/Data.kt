package com.ehdwn.covidmap

import com.google.gson.annotations.SerializedName

data class CovidBody(
    @SerializedName("currentCount") val currentCount:Int,   // 현재 검색된 데이터 수
    @SerializedName("data") val data:List<Covid>,         // 백신 현황 데이터
    @SerializedName("matchCount") val matchCount:Int,       // 검색과 일치하는 데이터 수
    @SerializedName("page") val page:Int,                   // 데이터 페이지
    @SerializedName("perPage") val perPage:Int,             // 한번에 불러올 데이터
    @SerializedName("totalCount") val totalCount:Int        // 데이터 전체 개수
){
    override fun toString(): String {
        return "$data\n\n" +
                "currentCount : $currentCount\n" +
                "matchCount : $matchCount\n" +
                "page : $page\n" +
                "perPage : $perPage\n" +
                "totalCount : $totalCount"
    }
}

data class Covid(
    @SerializedName("id") val id:Int,
    @SerializedName("centerName") val centerName:String,
    @SerializedName("sido") val sido:String,
    @SerializedName("sigungu") val sigungu:String,
    @SerializedName("facilityName") val facilityName:String,
    @SerializedName("zipCode") val zipCode:String,
    @SerializedName("address") val address:String,
    @SerializedName("lat") val lat:String,
    @SerializedName("lng") val lng:String,
    @SerializedName("createdAt") val createdAt:String,
    @SerializedName("updatedAt") val updatedAt:String,
    @SerializedName("centerType") val centerType:String,
    @SerializedName("org") val org:String,
    @SerializedName("phoneNumber") val phoneNumber:String
){
    override fun toString(): String {
        return "Covid : [\n" +
                "    id : ${id}\n" +
                "    centerName : ${centerName}\n" +
                "    sido : ${sido}\n" +
                "    sigungu : ${sigungu}\n" +
                "    facilityName : ${facilityName}\n" +
                "    zipCode : ${zipCode}\n" +
                "    address : ${address}\n" +
                "    lat : ${lat}\n" +
                "    lng : ${lng}\n" +
                "    createdAt : ${createdAt}\n" +
                "    updatedAt : ${updatedAt}\n" +
                "    centerType : ${centerType}\n" +
                "    org : ${org}\n" +
                "    phoneNumber : ${phoneNumber}]\n\n"
    }
}
