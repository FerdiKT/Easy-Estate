package com.milyonbit.easyestate;

/**
 * Created by FerdiKT on 12/12/15.
 */
public class Data {
    CharSequence type, price, moneyType, meter, roomCount, credit, desc;

    public CharSequence getPrice() {
        return price;
    }

    public void setPrice(CharSequence price) {
        this.price = price;
    }

    public CharSequence getMeter() {
        return meter;
    }

    public void setMeter(CharSequence meter) {
        this.meter = meter;
    }

    public CharSequence getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(CharSequence roomCount) {
        this.roomCount = roomCount;
    }

    public CharSequence getCredit() {
        return credit;
    }

    public void setCredit(CharSequence credit) {
        this.credit = credit;
    }

    public CharSequence getDesc() {
        return desc;
    }

    public void setDesc(CharSequence desc) {
        this.desc = desc;
    }

    public CharSequence getType() {
        return type;
    }

    public void setType(CharSequence type) {
        this.type = type;
    }

    public CharSequence getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(CharSequence moneyType) {
        this.moneyType = moneyType;
    }
}
