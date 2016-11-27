package com.cm.project.basic.personalinfo.entity;

import com.cm.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.personalinfo.entity
 * @类名： AddressEntity
 * @类描述：
 * @时间： 2016-11-25
 * @编写者： 修峻青
 */
@Entity
@Table(name = "ADDRESS_INFO")
public class AddressEntity extends BaseEntity{

    @Column(name = "COUNTRY_CODE", length = 4, nullable = false)
    private String CountryCode;
    @Column(name = "PROVINCE_CODE", length = 4, nullable = false)
    private String ProvinceCode;
    @Column(name = "CITY_CODE", length = 4, nullable = false )
    private String CityCode;
    @Column(name = "STREET")
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
