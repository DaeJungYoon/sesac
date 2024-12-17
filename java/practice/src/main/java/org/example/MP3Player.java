package org.example;

public class MP3Player {

    String name;
    int volume;
    Boolean isOnOff;

    public MP3Player(String name) {
        this.name = name;
    }

    void turnOn(){
        this.volume = 40;
        this.isOnOff = true;
    }

    void turnOff(){
        this.volume = 0;
        this.isOnOff = false;

    }

    void volumeUp(){
//        volume = Math.max(100, volume+20);
        if(this.volume < 100){
        this.volume += 20;
        }

    }
    void volumeDown(){
        if (this.volume>0){
            this.volume -= 20;
        }
    }
    void getMp3(){
        System.out.println(this.name);
        System.out.println(this.volume);
        System.out.println(this.isOnOff);
    }
}
