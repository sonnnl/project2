package com.java_web_test.builder;

import java.util.List;

public class BuildingSearchBuilder {
	private String name;
    private Integer districtId;
    private String street;
    private String ward;
    private String managerName;
    private String managerPhoneNumber;
    private Integer numberOfBasement;
    private Integer floorArea;
    private Integer rentPriceMin;
    private Integer rentPriceMax;
    private Integer rentAreaMin;
    private Integer rentAreaMax;
    private Integer staffId;
    private List<String> typeCode;

    public String getName() {
		return name;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public String getStreet() {
		return street;
	}

	public String getWard() {
		return ward;
	}

	public String getManagerName() {
		return managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public Integer getFloorArea() {
		return floorArea;
	}

	public Integer getRentPriceMin() {
		return rentPriceMin;
	}

	public Integer getRentPriceMax() {
		return rentPriceMax;
	}

	public Integer getRentAreaMin() {
		return rentAreaMin;
	}

	public Integer getRentAreaMax() {
		return rentAreaMax;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public List<String> getTypeCode() {
		return typeCode;
	}

	private BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.districtId = builder.districtId;
        this.street = builder.street;
        this.ward = builder.ward;
        this.managerName = builder.managerName;
        this.managerPhoneNumber = builder.managerPhoneNumber;
        this.numberOfBasement = builder.numberOfBasement;
        this.floorArea = builder.floorArea;
        this.rentPriceMin = builder.rentPriceMin;
        this.rentPriceMax = builder.rentPriceMax;
        this.rentAreaMin = builder.rentAreaMin;
        this.rentAreaMax = builder.rentAreaMax;
        this.staffId = builder.staffId;
        this.typeCode = builder.typeCode;
    }

    public static class Builder {
        private String name;
        private Integer districtId;
        private String street;
        private String ward;
        private String managerName;
        private String managerPhoneNumber;
        private Integer numberOfBasement;
        private Integer floorArea;
        private Integer rentPriceMin;
        private Integer rentPriceMax;
        private Integer rentAreaMin;
        private Integer rentAreaMax;
        private Integer staffId;
        private List<String> typeCode;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDistrictId(Integer districtId) {
            this.districtId = districtId;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder setManagerPhoneNumber(String managerPhoneNumber) {
            this.managerPhoneNumber = managerPhoneNumber;
            return this;
        }

        public Builder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder setFloorArea(Integer floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public Builder setRentPriceMin(Integer rentPriceMin) {
            this.rentPriceMin = rentPriceMin;
            return this;
        }

        public Builder setRentPriceMax(Integer rentPriceMax) {
            this.rentPriceMax = rentPriceMax;
            return this;
        }

        public Builder setRentAreaMin(Integer rentAreaMin) {
            this.rentAreaMin = rentAreaMin;
            return this;
        }

        public Builder setRentAreaMax(Integer rentAreaMax) {
            this.rentAreaMax = rentAreaMax;
            return this;
        }

        public Builder setStaffId(Integer staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setTypeCode(List<String> typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }
    }
	
}
