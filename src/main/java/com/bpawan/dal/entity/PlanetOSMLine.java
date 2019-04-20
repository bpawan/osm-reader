package com.bpawan.dal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity(name = "planet_osm_line")
public class PlanetOSMLine {
    @Id
    @Column(name = "osm_id")
    private BigInteger id;

    private String access;

    @Column(name = "\"addr:housename\"")
    private String addressHouseName;

    @Column(name = "\"addr:housenumber\"")
    private String addressHouseNumber;

    @Column(name = "\"addr:interpolation\"")
    private String addressInterpolation;

    @Column(name = "admin_level")
    private String adminLevel;

    private String aerialway;

    private String amenity;

    private String area;

    private String barrier;

    private String bicycle;

    private String brand;

    private String bridge;

    private String boundary;

    private String building;

    private String construction;

    private String covered;

    private String culvert;

    private String cutting;

    private String denomination;

    private String disused;

    private String embankment;

    private String foot;

    @Column(name = "\"generator:source\"")
    private String generatorSource;

    private String harbour;

    private String highway;

    private String historic;

    private String horse;

    private String intermittent;

    private String junction;

    private String landuse;

    private String layer;

    private String leisure;

    private String lock;

    @Column(name = "man_made")
    private String manMade;

    private String military;

    private String motorcar;

    private String name;

    private String natural;

    private String office;

    private String oneway;

    private String operator;

    private String place;

    private String population;

    private String power;

    @Column(name = "power_source")
    private String powerSource;

    @Column(name = "public_transport")
    private String publicTransport;

    private String railway;

    private String ref;

    private String religion;

    private String route;

    private String service;

    private String shop;

    private String sport;

    private String surface;

    private String toll;

    private String tourism;

    @Column(name = "\"tower:type\"")
    private String towerType;

    private String tracktype;

    private String tunnel;

    private String water;

    private String waterway;

    private String wetland;

    private String width;

    private String wood;

    @Column(name = "z_order")
    private Integer zOrder;

    @Column(name = "way_area")
    private Float wayArea;

    private String way;

    public PlanetOSMLine(){

    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getAddressHouseName() {
        return addressHouseName;
    }

    public void setAddressHouseName(String addressHouseName) {
        this.addressHouseName = addressHouseName;
    }

    public String getAddressHouseNumber() {
        return addressHouseNumber;
    }

    public void setAddressHouseNumber(String addressHouseNumber) {
        this.addressHouseNumber = addressHouseNumber;
    }

    public String getAddressInterpolation() {
        return addressInterpolation;
    }

    public void setAddressInterpolation(String addressInterpolation) {
        this.addressInterpolation = addressInterpolation;
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    public String getAerialway() {
        return aerialway;
    }

    public void setAerialway(String aerialway) {
        this.aerialway = aerialway;
    }

    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBarrier() {
        return barrier;
    }

    public void setBarrier(String barrier) {
        this.barrier = barrier;
    }

    public String getBicycle() {
        return bicycle;
    }

    public void setBicycle(String bicycle) {
        this.bicycle = bicycle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBridge() {
        return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge;
    }

    public String getBoundary() {
        return boundary;
    }

    public void setBoundary(String boundary) {
        this.boundary = boundary;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public String getCovered() {
        return covered;
    }

    public void setCovered(String covered) {
        this.covered = covered;
    }

    public String getCulvert() {
        return culvert;
    }

    public void setCulvert(String culvert) {
        this.culvert = culvert;
    }

    public String getCutting() {
        return cutting;
    }

    public void setCutting(String cutting) {
        this.cutting = cutting;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getDisused() {
        return disused;
    }

    public void setDisused(String disused) {
        this.disused = disused;
    }

    public String getEmbankment() {
        return embankment;
    }

    public void setEmbankment(String embankment) {
        this.embankment = embankment;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getGeneratorSource() {
        return generatorSource;
    }

    public void setGeneratorSource(String generatorSource) {
        this.generatorSource = generatorSource;
    }

    public String getHarbour() {
        return harbour;
    }

    public void setHarbour(String harbour) {
        this.harbour = harbour;
    }

    public String getHighway() {
        return highway;
    }

    public void setHighway(String highway) {
        this.highway = highway;
    }

    public String getHistoric() {
        return historic;
    }

    public void setHistoric(String historic) {
        this.historic = historic;
    }

    public String getHorse() {
        return horse;
    }

    public void setHorse(String horse) {
        this.horse = horse;
    }

    public String getIntermittent() {
        return intermittent;
    }

    public void setIntermittent(String intermittent) {
        this.intermittent = intermittent;
    }

    public String getJunction() {
        return junction;
    }

    public void setJunction(String junction) {
        this.junction = junction;
    }

    public String getLanduse() {
        return landuse;
    }

    public void setLanduse(String landuse) {
        this.landuse = landuse;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getLeisure() {
        return leisure;
    }

    public void setLeisure(String leisure) {
        this.leisure = leisure;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public String getManMade() {
        return manMade;
    }

    public void setManMade(String manMade) {
        this.manMade = manMade;
    }

    public String getMilitary() {
        return military;
    }

    public void setMilitary(String military) {
        this.military = military;
    }

    public String getMotorcar() {
        return motorcar;
    }

    public void setMotorcar(String motorcar) {
        this.motorcar = motorcar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNatural() {
        return natural;
    }

    public void setNatural(String natural) {
        this.natural = natural;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOneway() {
        return oneway;
    }

    public void setOneway(String oneway) {
        this.oneway = oneway;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }

    public String getPublicTransport() {
        return publicTransport;
    }

    public void setPublicTransport(String publicTransport) {
        this.publicTransport = publicTransport;
    }

    public String getRailway() {
        return railway;
    }

    public void setRailway(String railway) {
        this.railway = railway;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getToll() {
        return toll;
    }

    public void setToll(String toll) {
        this.toll = toll;
    }

    public String getTourism() {
        return tourism;
    }

    public void setTourism(String tourism) {
        this.tourism = tourism;
    }

    public String getTowerType() {
        return towerType;
    }

    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }

    public String getTracktype() {
        return tracktype;
    }

    public void setTracktype(String tracktype) {
        this.tracktype = tracktype;
    }

    public String getTunnel() {
        return tunnel;
    }

    public void setTunnel(String tunnel) {
        this.tunnel = tunnel;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getWaterway() {
        return waterway;
    }

    public void setWaterway(String waterway) {
        this.waterway = waterway;
    }

    public String getWetland() {
        return wetland;
    }

    public void setWetland(String wetland) {
        this.wetland = wetland;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    public Integer getzOrder() {
        return zOrder;
    }

    public void setzOrder(Integer zOrder) {
        this.zOrder = zOrder;
    }

    public Float getWayArea() {
        return wayArea;
    }

    public void setWayArea(Float wayArea) {
        this.wayArea = wayArea;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
}
