package lad5;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.Scanner;
	public class QLSV2 {
		public static void main(String[] args) {
			int n;
			Scanner scanner = new Scanner(System.in);
			ArrayList<Student> arrayListStudent = new ArrayList<>();
			System.out.println("Nhap so sinh vien can nhap :");
			n = Integer.parseInt(scanner.nextLine());

			while(true) {

				int choice = Integer.parseInt(scanner.nextLine());

				if(choice==1) {
					for(int i = 0;i<n;i++) {
						Student sv = new Student();
						sv.input();
						arrayListStudent.add(sv);
					}
				}else if(choice==2) {
					for(Student sv:arrayListStudent) {
						sv.output();
					}

				}else if (choice==3) {

					Collections.shuffle(arrayListStudent);
					for(int i = 0 ; i<arrayListStudent.size() ; i++) {
						System.out.println("Sap xep ngau nhien :"+arrayListStudent.get(i).getHoTen());
					}
				}
				else if(choice==4) {
					Collections.sort(arrayListStudent, new Comparator<Student>() {

						@Override
						public int compare(Student o1, Student o2) {
							// TODO Auto-generated method stub
							if (o1.getHoTen().compareTo(o2.getHoTen()) > 0)
								return 1;
							else
								return -1;
						}
					});
					System.out.println("Danh sach sap xep theo ten :");
					for(int i=0;i<arrayListStudent.size();i++) {
						System.out.println("Ho va ten :"+arrayListStudent.get(i).getHoTen());
					}

				}else if (choice==5) {
					System.out.println("Nhap ten can tim :");
					String ten = scanner.nextLine();
					for(Student sv:arrayListStudent) {
						if(sv.getHoTen().equals(ten)) {
							System.out.println(sv.getHoTen());
							arrayListStudent.remove(sv);
							System.out.println("Xoa sinh vien vua tim :" + arrayListStudent.size());
							break;
						}
						
						
					}
					
					
				}
				else if(choice==6) {
					System.exit(choice);
				}
			}

		}

		public static void menu() {
			System.out.println(">>       Chon Menu      <<");
			System.out.println("+ ---------------------------------+");
			System.out.println("| 1 . Nhap danh sach ho ten ");
			System.out.println("| 2 . Xuat danh sach vua nhap ");
			System.out.println("| 3 . Xuat danh sach ngau nhien ");
			System.out.println("| 4 . Sap xep giam dan va xuat danh sach ");
			System.out.println("| 5 . Tim va xoa ho ten tu ban phim ");
			System.out.println("| 6 . Thoat ");
		}

	}
