package tuan;

import java.util.Scanner;

public class b1 {
	    public static void main(String[] args) {
	    	Student st[]=new Student [4];
	    	for (int i = 1; i < st.length; i++) {
				st[i]=new Student();
				st[i].nhap();
			}
	    	for (int i = 1; i < st.length; i++) {
	    		System.out.println("Student"+i+":\n");
				st[i].xuat();
				System.out.println("----------------------------------");
			}
	    	System.out.println("Xep loai\n");
	    	for (int i = 1; i < st.length; i++) {
	    		System.out.println("Student"+i+":\n");
	    		 System.out.println(
	    	                "\t" + "Name: " + st[i].ten + "\n" +
	    	                "\t" + "Marks Average: " + st[i].dtb + "\n"+
	    	                "\t" + st[i].tinh() + "\n");
	    		 System.out.println("----------------------------------");
			}
	    	for (int i = 1; i < st.length; i++) {
				for (int j = 1; j < st.length; j++) {
					if(st[i].sosanh(st[j])==1) {
						Student tam=st[i];
						st[i]=st[j];
						st[j]=tam;
					}
				}
			}
	    	System.out.println("Student co diem tu cao den thap\n");
	    	for (int i = 1; i < st.length; i++) {
	    		System.out.println("Number"+i+" Math:\n"+
	    					"\t"+"Name:"+st[i].ten+"\n"+
	    					"\t"+"Mark:"+st[i].dtb+"\n");
	    		System.out.println("----------------------------------");
			}
	        
	}
}
class Student{
    public int tuoi;
    public String ten;
    public float dtb;
    float English;
    float Computer;
    float Math;
    String s;
    public void nhap(){
        Scanner sv = new Scanner(System.in);
            System.out.println("tenSV: ");
            ten = sv.nextLine();
            System.out.println("TuoiSV: ");
            tuoi = sv.nextInt();
            System.out.println("diem tieng anh: ");
            English = sv.nextFloat();
            System.out.println("diem tieng may tinh: ");
            Computer = sv.nextFloat();
            System.out.println("diem tieng toan: ");
            Math = sv.nextFloat();            
    }
    public void xuat() {
    	this.dtb = (English + Computer + Math)/3;
        System.out.println(
                "\t" + "Name: " + ten + "\n" +
                "\t" + "Age: " + tuoi + "\n" +
                "\t" + "Marks:" + "\n" +
                "\t" + "\t" + "English: " + English + "\n" +
                "\t" + "\t" + "Computer: " + Computer + "\n" +
                "\t" + "\t" + "math: " + Math + "\n" + 
                "\t" + "Marks Average: " + dtb + "\n");
    }
    public String tinh(){
        if(dtb >=8){
            s=("Level: Excellent");
        }
        else{
            if(dtb >= 6.5 & dtb < 8){
                s=("Level: Good");
            }
            else{
                if(dtb >= 5 & dtb < 6.5){
                    s=("Level: Average");
                }
                else{
                    if(5 < dtb & dtb <= 3.5){
                        s=("Level: Weak");
                    }
                    else{
                        s=("Level: Poor");
                    }
                }
            }
        }
        return s;
    }
    public int sosanh(Student d) {
		if (this.dtb < d.dtb) {
			return 1;
		} else
			return 0;
	}
}


