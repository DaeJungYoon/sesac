package org.example;

public class Practice {

        public static void main(String[] args) {

//            dog

//            Dog d1 = new Dog("dog", "jelly");
//            System.out.println(d1.kingOf);
//            System.out.println(d1.name);
//            d1.dogHandOrder();
//            d1.dogSitOrder();

//            triangle

//            Triangle t1 = new Triangle(4,3);
//            System.out.println(t1.height);
//            System.out.println(t1.width);
//            System.out.println(t1.triangleArea());
//            System.out.println(t1.trianglePerimeter());

//            Car

//            Car c1 = new Car("cyber_truck",0);
//            c1.speedIncrease();
//            c1.speedIncrease();
//            c1.speedIncrease();
//            c1.speedDecrease();
//            c1.carCurrent();
//            System.out.println(c1.speed);

//            mp3

//            MP3Player m1 = new MP3Player("iriver");
//            m1.turnOn();
//            m1.volumeUp();
//            m1.volumeUp();
//            m1.volumeUp();
//            m1.volumeDown();
//            m1.getMp3();

//            cal

//            Calc c1= new Calc(4,2);
//            System.out.println(c1.divi());
//            System.out.println(c1.decuct());
//            System.out.println(c1.mul());
//            System.out.println(c1.sum());

//            cal2

//            Circle cl = new Circle(3);
//            System.out.println(cl.radius);
//            System.out.println(cl.calclateArea());

            int value = 3;
            int[] array = new int[6];
            Rectangle rect1 = new Rectangle(10,30);
//            System.out.println(rect1.width);
//            System.out.println(rect1.calculateArea());


//            Rectangle rect2 = new Rectangle(10, 1000);
//            System.out.println(rect2.calculateArea());
//
//            String word = new String("hahahoho");
        }
    }

    class Rectangle{
        int width;
        int height;

        Rectangle(int width, int height){
            this.width = width;
            this.height = height;
        }

//        public Rectangle(int height, int width) {
//            this.height = height;
//            this.width = width;
//        }

        int calculateArea(){
            return width * height;
        }


}
