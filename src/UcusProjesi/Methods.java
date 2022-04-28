package UcusProjesi;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Methods extends Yolcu {
 /* A şehrinden uçmak isteyen bir yolcu B şehrine 500km C şehrine  700km  D şehrine  900 km mesafededir.
    Bilet tarifesi:
    km birim fiyati : 0.10$*/

    static Scanner scan=new Scanner(System.in);
   static List<Yolcu> yolcu=new ArrayList<>();
   static double yasInd;
   static double yonInd;
   static double kmFiyat=0.10;
   static double bUcret=500*kmFiyat;
   static double cUcret=700*kmFiyat;
   static double dUcret=900*kmFiyat;
   static double biletFiyati=1;

 protected static void girisPaneli(){
     System.out.println("hosgeldiniz");
     kullanicidanBilgiAl();
    // tekBiletFiyatiHesapla(yolcu,yasInd,yonInd,bUcret,cUcret,dUcret);
     faturaYazdir(yolcu,biletFiyati);



 }

    private static void faturaYazdir(List<Yolcu> yolcu, double biletFiyati) {
     biletFiyati=tekBiletFiyatiHesapla(yolcu,yasInd,yonInd);
        System.out.println("==============FATURA==============");
        System.out.println("AD/SOYAD      : "+ Methods.yolcu.get(0).getAdSoyad()+"\nLOCAL         : "+ Methods.yolcu.get(0).getLocal()+"\nNEREYE        : "+ Methods.yolcu.get(0).getSehir()
        +"\nUCUS SEKLI    : "+ Methods.yolcu.get(0).getUcusSekli()+"\n======================================="+"\nTOPLAM BILET FIYATI   : "+ biletFiyati);
    }


    private static double tekBiletFiyatiHesapla(List<Yolcu> yolcu, double yasInd, double yonInd) {
        yasInd=yasIndH();
        yonInd=yonIndH();
        if (Methods.yolcu.get(0).getUcusSekli().equals("1")|| Methods.yolcu.get(0).getUcusSekli().equalsIgnoreCase("tek")) {
            if (Methods.yolcu.get(0).getSehir().equalsIgnoreCase("B")){
                biletFiyati=bUcret-(bUcret*yasInd*yonInd);
                System.out.println("B sehri biletF  "+biletFiyati);

            }else if(Methods.yolcu.get(0).getSehir().equalsIgnoreCase("C")){
                biletFiyati=cUcret*yasInd*yonInd;
                System.out.println("C sehri biletF  "+biletFiyati);
            }else if(Methods.yolcu.get(0).getSehir().equalsIgnoreCase("D")){
                biletFiyati=dUcret*yasInd*yonInd;
                System.out.println("D sehri biletF  "+biletFiyati);
            }
        }else {
            if (Methods.yolcu.get(0).getSehir().equalsIgnoreCase("B")){
                //System.out.println("1 "+yasInd*b);
                //System.out.println("2  "+yonInd);
                biletFiyati=2*(bUcret-(bUcret*yasInd)+(bUcret*yonInd)); //50- 50*50%+50*20%  //50-  25 + 10=15
                biletFiyati=2*(bUcret*0.50*0.80);
                System.out.println("B sehri biletF  "+biletFiyati);

            }else if(Methods.yolcu.get(0).getSehir().equalsIgnoreCase("C")){
                biletFiyati=2*(cUcret*yasInd*yonInd);
                System.out.println("C sehri biletF  "+biletFiyati);
            }else if(Methods.yolcu.get(0).getSehir().equalsIgnoreCase("D")){
                biletFiyati=2*(dUcret*yasInd*yonInd);
                System.out.println("D sehri biletF  "+biletFiyati);
            }


        }
        System.out.println("bilet hesaplama m. biletF  "+biletFiyati);
     return biletFiyati;
    }




    private static double yasIndH() {
    if(Methods.yolcu.get(0).getYas()<12){
        yasInd=0.50;//50%
    }else if (Methods.yolcu.get(0).getYas()<25){
        yasInd=0.10;//10%
    }else if (Methods.yolcu.get(0).getYas()>65){
        yasInd=0.30;//%30
    }else yasInd=1;
        System.out.println("yas indirimi  "+yasInd);
    return yasInd;
    }
    private static double yonIndH(){
        if (Methods.yolcu.get(0).getUcusSekli().equals("1")|| Methods.yolcu.get(0).getUcusSekli().equals("tek")){
            yonInd=1;
        }else  yonInd=0.20; //20%
        System.out.println("yon indirimi  "+yonInd);
        return yonInd;
    }

    private static List<Yolcu> kullanicidanBilgiAl() {
        System.out.print("ad soyad gir:  ");
        String adSoyad=scan.nextLine();
        System.out.print("yas gir:  ");
        int yas= scan.nextInt();
        System.out.print("hangi sehirden gidiceksin:  ");
        scan.nextLine();//dummy
        String local=scan.nextLine();
        System.out.print("hangi sehire gidiceksin:  ");
        String sehir=scan.nextLine();
        System.out.println("tek yon/gidis-donus?");
        String ucusSekli=scan.nextLine();

        Yolcu yolcumuz=new Yolcu(adSoyad,yas,local,sehir,ucusSekli);
        yolcu.add(yolcumuz);
        System.out.println("yolcu objesi  "+yolcumuz);
        System.out.println("yolcu bilgisi listi  "+yolcu);
        return yolcu;
    }
}



//    if (Methods.yolcu.get(0).getUcusSekli().equals("1")|| Methods.yolcu.get(0).getUcusSekli().equals("tek")){
//        if (Methods.yolcu.get(0).getSehir().equals("B")){
//            biletFiyati=bUcret*yasIndH(yolcu)*yonIndH(yolcu);
//        }else if (Methods.yolcu.get(0).getSehir().equals("C")){
//            biletFiyati=cUcret*yasIndH(yolcu)*yonIndH(yolcu);
//        }else if (Methods.yolcu.get(0).getSehir().equals("D")){
//            biletFiyati=dUcret*yasIndH(yolcu)*yonIndH(yolcu);
//        }else biletFiyati=2*tekBiletFiyatiHesapla();}

