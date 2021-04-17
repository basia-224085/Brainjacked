package com.hackaton.brainjacked.DTO;

public class Login {
    String chip_code;
    String password;

    public Login() {
    }

    public Login(String chip_code, String password) {
        this.chip_code = chip_code;
        this.password = password;
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
}
