package StudentManagement;

import java.util.ArrayList;
import java.util.Collections;

public class Manager {
	public static void menu() {
		System.out.println(" 1.	Create");
		System.out.println(" 2.	Find and Sort");
		System.out.println(" 3.	Update/Delete");
		System.out.println(" 4.	Report");
		System.out.println(" 5.	Exit");
		System.out.print(" Enter your choice: ");
	}

	// Allow user create new student
	public static void createStudent(int count, ArrayList<Student> ls) {
		// gioi han so luong nguoi ( toi da 10 nguoi)
		if (count > 10) {
			System.out.print("Do you want to continue (Y/N): ");
			if (!Validation.checkInputYN()) {
				return;
			}
		}
		// loop until user input not duplicate
		while (true) {
			System.out.print("Nhap id: ");
			String id = Validation.checkInputString();
			System.out.print("Nhap ten sinh vien: ");
			String name = Validation.checkInputString();
			if (!Validation.checkIdExist(ls, id, name)) {
				System.err.println("Da ton tai");
				continue;
			}
			System.out.print("Nhap ten mon hoc: ");
			String semester = Validation.checkInputString();
			System.out.print("Nhap Khoa hoc: ");
			String course = Validation.checkInputCourse();
			if (Validation.checkStudentExist(ls, id, name, semester, course)) {
				ls.add(new Student(id, name, semester, course));
				count++;
				System.err.println("ADD success.");
				return;
			}
			System.err.println("FAIL.");

		}
	}
	
	// Tim kiem va sap xep theo ten
	public static void findAndSort(ArrayList<Student> ls) {
		// check rong
		if (ls.isEmpty()) {
			System.err.println("List empty.");
			return;
		}
		ArrayList<Student> listStudentFindByName = listStudentFindByName(ls);
		if (listStudentFindByName.isEmpty()) {
			System.err.println("Not exist.");
		} else {
			Collections.sort(listStudentFindByName);
			System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
			for (Student student : listStudentFindByName) {
				student.print();
			}
		}
	}

// Tim kiem ten
	public static ArrayList<Student> listStudentFindByName(ArrayList<Student> ls) {
		ArrayList<Student> listStudentFindByName = new ArrayList<>();
		System.out.print("Enter name to search: ");
		String name = Validation.checkInputString();
		for (Student student : ls) {
			if (student.getStudentName().contains(name)) {
				listStudentFindByName.add(student);
			}
		}
		return listStudentFindByName;
	}

	// Allow user update and delete
	public static void updateOrDelete(int count, ArrayList<Student> ls) {
		// if list empty
		if (ls.isEmpty()) {
			System.err.println("List empty.");
			return;
		}
		System.out.print("Enter id: ");
		String id = Validation.checkInputString();
		ArrayList<Student> listStudentFindByName = getListStudentById(ls, id);
		// check list empty
		if (listStudentFindByName.isEmpty()) {
			System.err.println("Not found student.");
			return;
		} else {
			Student student = getStudentByListFound(listStudentFindByName);
			System.out.print("Do you want to update (U) or delete (D) student: ");
			// check user want to update or delete
			if (Validation.checkInputUD()) {
				System.out.print("Enter id: ");
				String idStudent = Validation.checkInputString();
				System.out.print("Enter name student: ");
				String name = Validation.checkInputString();
				System.out.print("Enter semester: ");
				String semester = Validation.checkInputString();
				System.out.print("Enter name course: ");
				String course = Validation.checkInputCourse();
				// check user change or not
				if (!Validation.checkChangeInfomation(student, id, name, semester, course)) {
					System.err.println("Nothing change.");
				}
				// check student exist or not
				if (Validation.checkStudentExist(ls, id, name, semester, course)) {
					student.setId(idStudent);
					student.setStudentName(name);
					student.setSemester(semester);
					student.setCourseName(course);
					System.err.println("Update success.");
				}
				return;
			} else {
				ls.remove(student);
				count--;
				System.err.println("Delete success.");
				return;
			}
		}
	}

	// Get student user want to update/delete in list found
	public static Student getStudentByListFound(ArrayList<Student> listStudentFindByName) {
		System.out.println("List student found: ");
		int count = 1;
		System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name", "semester", "Course Name");
		// display list student found
		for (Student student : listStudentFindByName) {
			System.out.printf("%-10d%-15s%-15s%-15s\n", count, student.getStudentName(), student.getSemester(),
					student.getCourseName());
			count++;
		}
		System.out.print("Enter student: ");
		int choice = Validation.checkInputIntLimit(1, listStudentFindByName.size());
		return listStudentFindByName.get(choice - 1);
	}

	// Get list student find by id
	public static ArrayList<Student> getListStudentById(ArrayList<Student> ls, String id) {
		ArrayList<Student> getListStudentById = new ArrayList<>();
		for (Student student : ls) {
			if (id.equalsIgnoreCase(student.getId())) {
				getListStudentById.add(student);
			}
		}
		return getListStudentById;
	}

	// Print report
	public static void report(ArrayList<Student> ls) {
		if (ls.isEmpty()) {
			System.err.println("List empty.");
			return;
		}
		ArrayList<Report> lr = new ArrayList<>();
		int size = ls.size();
		for (int i = 0; i < size; i++) {
			int total = 0;
			for (Student student : ls) {
				String id = student.getId();
				String courseName = student.getCourseName();
				String studentName = student.getStudentName();
				for (Student studentCountTotal : ls) {
					if (id.equalsIgnoreCase(studentCountTotal.getId())
							&& courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
						total++;
					}
				}
				if (Validation.checkReportExist(lr, studentName, courseName, total)) {
					lr.add(new Report(student.getStudentName(), studentName, total));
				}
			}
		}
		// print report
		for (int i = 0; i < lr.size(); i++) {
			System.out.printf("%-15s|%-10s|%-5d\n", lr.get(i).getStudentName(), lr.get(i).getCourseName(),
					lr.get(i).getTotalCourse());
		}
	}
}
