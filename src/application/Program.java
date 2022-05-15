/* Module 4 - Chapter 12 - EmployeeOO Challenge - Escola Devsuperior
 * Prof. Nelio Alves
 * 
 * Student: rsdepaula67@gmail.com
 * 
 * Description:
 * Program to exercise principles of OOP, inheritance and polymorphism mostly
 * Compute the total duration of a course based on the classes Video and Task,
 * which are subclasses of the class Lesson
 */

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalDuration = 0;
		List<Lesson> lessonList = new ArrayList<>();
		
		// Number of classes or tasks
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		System.out.println();
		
		// Framing in the correct template and storing in lessonList
		for (int i = 1; i <= n; i++) {
			System.out.println("Dados da " + i + "a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char classType = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			if (classType == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int videoDuration = sc.nextInt();
				lessonList.add(new Video(title, url, videoDuration));
			} else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				lessonList.add(new Task(title, description, questionCount));
			}
			System.out.println();
		}
		
		// Computing the total
		for (Lesson l : lessonList) {
			totalDuration += l.duration();
		}
		
		// Output
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + totalDuration + " segundos");
		
		sc.close();
	}

}