package com.hackaton.brainjacked.DTO;

public class Register {
    String first_name;
    String last_name;
    String chip_code;
    String password;
    String dominantHalf;
    String personalityType;
    Skills skills;

    public Register() {
    }

    public Register(String first_name, String last_name, String chip_code, String password, String dominantHalf, String personalityType, Skills skills) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.chip_code = chip_code;
        this.password = password;
        this.dominantHalf = dominantHalf;
        this.personalityType = personalityType;
        this.skills = skills;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getChip_code() {
        return chip_code;
    }

    public void setChip_code(String chip_code) {
        this.chip_code = chip_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDominantHalf() {
        return dominantHalf;
    }

    public void setDominantHalf(String dominantHalf) {
        this.dominantHalf = dominantHalf;
    }

    public String getPersonalityType() {
        return personalityType;
    }

    public void setPersonalityType(String personalityType) {
        this.personalityType = personalityType;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }
}
