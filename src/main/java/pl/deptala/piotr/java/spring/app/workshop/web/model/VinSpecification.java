package pl.deptala.piotr.java.spring.app.workshop.web.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "vin",
        "year",
        "make",
        "model",
        "trim_level",
        "engine",
        "style",
        "made_in",
        "steering_type",
        "anti_brake_system",
        "tank_size",
        "overall_height",
        "overall_length",
        "overall_width",
        "standard_seating",
        "optional_seating",
        "highway_mileage",
        "city_mileage"
})
@Generated("jsonschema2pojo")
public class VinSpecification {

    @JsonProperty("vin")
    private String vin;
    @JsonProperty("year")
    private String year;
    @JsonProperty("make")
    private String make;
    @JsonProperty("model")
    private String model;
    @JsonProperty("trim_level")
    private String trimLevel;
    @JsonProperty("engine")
    private String engine;
    @JsonProperty("style")
    private String style;
    @JsonProperty("made_in")
    private String madeIn;
    @JsonProperty("steering_type")
    private String steeringType;
    @JsonProperty("anti_brake_system")
    private String antiBrakeSystem;
    @JsonProperty("tank_size")
    private String tankSize;
    @JsonProperty("overall_height")
    private String overallHeight;
    @JsonProperty("overall_length")
    private String overallLength;
    @JsonProperty("overall_width")
    private String overallWidth;
    @JsonProperty("standard_seating")
    private String standardSeating;
    @JsonProperty("optional_seating")
    private Object optionalSeating;
    @JsonProperty("highway_mileage")
    private String highwayMileage;
    @JsonProperty("city_mileage")
    private String cityMileage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("vin")
    public String getVin() {
        return vin;
    }

    @JsonProperty("vin")
    public void setVin(String vin) {
        this.vin = vin;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("make")
    public String getMake() {
        return make;
    }

    @JsonProperty("make")
    public void setMake(String make) {
        this.make = make;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("trim_level")
    public String getTrimLevel() {
        return trimLevel;
    }

    @JsonProperty("trim_level")
    public void setTrimLevel(String trimLevel) {
        this.trimLevel = trimLevel;
    }

    @JsonProperty("engine")
    public String getEngine() {
        return engine;
    }

    @JsonProperty("engine")
    public void setEngine(String engine) {
        this.engine = engine;
    }

    @JsonProperty("style")
    public String getStyle() {
        return style;
    }

    @JsonProperty("style")
    public void setStyle(String style) {
        this.style = style;
    }

    @JsonProperty("made_in")
    public String getMadeIn() {
        return madeIn;
    }

    @JsonProperty("made_in")
    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    @JsonProperty("steering_type")
    public String getSteeringType() {
        return steeringType;
    }

    @JsonProperty("steering_type")
    public void setSteeringType(String steeringType) {
        this.steeringType = steeringType;
    }

    @JsonProperty("anti_brake_system")
    public String getAntiBrakeSystem() {
        return antiBrakeSystem;
    }

    @JsonProperty("anti_brake_system")
    public void setAntiBrakeSystem(String antiBrakeSystem) {
        this.antiBrakeSystem = antiBrakeSystem;
    }

    @JsonProperty("tank_size")
    public String getTankSize() {
        return tankSize;
    }

    @JsonProperty("tank_size")
    public void setTankSize(String tankSize) {
        this.tankSize = tankSize;
    }

    @JsonProperty("overall_height")
    public String getOverallHeight() {
        return overallHeight;
    }

    @JsonProperty("overall_height")
    public void setOverallHeight(String overallHeight) {
        this.overallHeight = overallHeight;
    }

    @JsonProperty("overall_length")
    public String getOverallLength() {
        return overallLength;
    }

    @JsonProperty("overall_length")
    public void setOverallLength(String overallLength) {
        this.overallLength = overallLength;
    }

    @JsonProperty("overall_width")
    public String getOverallWidth() {
        return overallWidth;
    }

    @JsonProperty("overall_width")
    public void setOverallWidth(String overallWidth) {
        this.overallWidth = overallWidth;
    }

    @JsonProperty("standard_seating")
    public String getStandardSeating() {
        return standardSeating;
    }

    @JsonProperty("standard_seating")
    public void setStandardSeating(String standardSeating) {
        this.standardSeating = standardSeating;
    }

    @JsonProperty("optional_seating")
    public Object getOptionalSeating() {
        return optionalSeating;
    }

    @JsonProperty("optional_seating")
    public void setOptionalSeating(Object optionalSeating) {
        this.optionalSeating = optionalSeating;
    }

    @JsonProperty("highway_mileage")
    public String getHighwayMileage() {
        return highwayMileage;
    }

    @JsonProperty("highway_mileage")
    public void setHighwayMileage(String highwayMileage) {
        this.highwayMileage = highwayMileage;
    }

    @JsonProperty("city_mileage")
    public String getCityMileage() {
        return cityMileage;
    }

    @JsonProperty("city_mileage")
    public void setCityMileage(String cityMileage) {
        this.cityMileage = cityMileage;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VinSpecification.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("vin");
        sb.append('=');
        sb.append(((this.vin == null) ? "<null>" : this.vin));
        sb.append(',');
        sb.append("year");
        sb.append('=');
        sb.append(((this.year == null) ? "<null>" : this.year));
        sb.append(',');
        sb.append("make");
        sb.append('=');
        sb.append(((this.make == null) ? "<null>" : this.make));
        sb.append(',');
        sb.append("model");
        sb.append('=');
        sb.append(((this.model == null) ? "<null>" : this.model));
        sb.append(',');
        sb.append("trimLevel");
        sb.append('=');
        sb.append(((this.trimLevel == null) ? "<null>" : this.trimLevel));
        sb.append(',');
        sb.append("engine");
        sb.append('=');
        sb.append(((this.engine == null) ? "<null>" : this.engine));
        sb.append(',');
        sb.append("style");
        sb.append('=');
        sb.append(((this.style == null) ? "<null>" : this.style));
        sb.append(',');
        sb.append("madeIn");
        sb.append('=');
        sb.append(((this.madeIn == null) ? "<null>" : this.madeIn));
        sb.append(',');
        sb.append("steeringType");
        sb.append('=');
        sb.append(((this.steeringType == null) ? "<null>" : this.steeringType));
        sb.append(',');
        sb.append("antiBrakeSystem");
        sb.append('=');
        sb.append(((this.antiBrakeSystem == null) ? "<null>" : this.antiBrakeSystem));
        sb.append(',');
        sb.append("tankSize");
        sb.append('=');
        sb.append(((this.tankSize == null) ? "<null>" : this.tankSize));
        sb.append(',');
        sb.append("overallHeight");
        sb.append('=');
        sb.append(((this.overallHeight == null) ? "<null>" : this.overallHeight));
        sb.append(',');
        sb.append("overallLength");
        sb.append('=');
        sb.append(((this.overallLength == null) ? "<null>" : this.overallLength));
        sb.append(',');
        sb.append("overallWidth");
        sb.append('=');
        sb.append(((this.overallWidth == null) ? "<null>" : this.overallWidth));
        sb.append(',');
        sb.append("standardSeating");
        sb.append('=');
        sb.append(((this.standardSeating == null) ? "<null>" : this.standardSeating));
        sb.append(',');
        sb.append("optionalSeating");
        sb.append('=');
        sb.append(((this.optionalSeating == null) ? "<null>" : this.optionalSeating));
        sb.append(',');
        sb.append("highwayMileage");
        sb.append('=');
        sb.append(((this.highwayMileage == null) ? "<null>" : this.highwayMileage));
        sb.append(',');
        sb.append("cityMileage");
        sb.append('=');
        sb.append(((this.cityMileage == null) ? "<null>" : this.cityMileage));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}