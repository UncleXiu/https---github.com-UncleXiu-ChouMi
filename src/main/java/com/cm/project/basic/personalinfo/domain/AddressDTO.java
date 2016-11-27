package com.cm.project.basic.personalinfo.domain;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.personalinfo.domain
 * @类名： AddressDTO
 * @类描述：
 * @时间： 2016-11-25
 * @编写者： 修峻青
 */
public class AddressDTO {
    //国家代码
    private String CountryCode;
    //省份代码
    private String ProvinceCode;
    //城市代码
    private String CityCode;
    //街道信息
    private String Street;

    //CountryCode
    public String getCountryCode() {
        return CountryCode;
    }
    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }
    //ProvinceCode
    public String getProvinceCode() {
        return ProvinceCode;
    }
    public void setProvinceCode(String provinceCode) {
        ProvinceCode = provinceCode;
    }
    //CityCode
    public String getCityCode() {
        return CityCode;
    }
    public void setCityCode(String cityCode) {
        CityCode = cityCode;
    }
    //Street
    public String getStreet() {
        return Street;
    }
    public void setStreet(String street) {
        Street = street;
    }

}
