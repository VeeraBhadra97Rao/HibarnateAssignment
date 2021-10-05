package com.technoelevate.CruddOperation;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentManagementSystem {
	private Scanner scanner;

	public StudentManagementSystem(Scanner scanner) {
		this.scanner = scanner;
	}

	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	Student student = new Student();
	boolean flag;

	public void insert() {
		System.out.println("enter the rollno");
		int rollno = scanner.nextInt();
		System.out.println("enter the name");
		String name = scanner.next();
		System.out.println("enter the phno");
		long phno = scanner.nextLong();
		System.out.println("enter the standard");
		String st = scanner.next();
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			student.setRollno(rollno);
			student.setName(name);
			student.setPhno(phno);
			student.setStandard(st);
			manager.persist(student);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (factory != null || manager != null) {
				factory.close();
				manager.close();
			}
		}

	}

	public void selectAll() {
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			String display = "from Student";
			Query query = manager.createQuery(display);
			List<Student> list = query.getResultList();

			for (Student student : list) {
				System.out.println(student);
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (factory != null || manager != null) {
				factory.close();
				manager.close();
			}
		}

	}

	public void selectParticular() {
		System.out.println("enter the rollno");
		int id = scanner.nextInt();
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			String display = "from Student where id=:id";
			Query query = manager.createQuery(display);
			query.setParameter("id", id);
			Student student = (Student) query.getSingleResult();
			System.out.println(student);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (factory != null || manager != null) {
				factory.close();
				manager.close();
			}
		}

	}

	public void delete() {
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			System.out.println("enter the rollno");
			int rollno = scanner.nextInt();
			String delete = "delete from Student where id=:id";
			Query query = manager.createQuery(delete);
			query.setParameter("id", rollno);
			int result = query.executeUpdate();
			if (result > 0) {
				System.out.println("data is erased");
			} else {
				System.out.println("data is not erased");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (factory != null || manager != null) {
				factory.close();
				manager.close();
			}
		}
	}

	public void update() {
for(;;) {
	System.out.println("1.updateOnlyName\n2.updateOnlyPhno\n3.updateOnlyStandard\n4.updateNameAndPhno\n5.updateNameAndStandard\n6.updatePhnoAndStandard\n7.updateNameAndPhnoAndStandard\n8.exit");
System.out.println("enter the choice ");
int choice=scanner.nextInt();
switch(choice) {

case 1:
	try {
		System.out.println("enter the rollno");
		int rollno=scanner.nextInt();
		System.out.println("enter the name");
		String name=scanner.next();
		factory = Persistence.createEntityManagerFactory("emp");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		String update = "update Student set name=:name where id=:id";
		Query query = manager.createQuery(update);
		query.setParameter("name", name);
		query.setParameter("id", rollno);
		int result = query.executeUpdate();
		transaction.commit();
	} catch (Exception e) {
	if (transaction != null) {
		transaction.rollback();
	}
	e.printStackTrace();
} finally {
	if (factory != null || manager != null) {
		factory.close();
		manager.close();
	}
}
	System.out.println("you want to continue press y or to discontinue n");
	String option1 =scanner.next();
	if(option1.equalsIgnoreCase("y")) {
		break;
	}else {
		return;
	}
	
case 2:
	try {
		System.out.println("enter the rollno");
		int rollno=scanner.nextInt();
		System.out.println("enter the Phno");
		long phno=scanner.nextLong();
		factory = Persistence.createEntityManagerFactory("emp");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		String update = "update Student set phno=:phno where id=:id";
		Query query = manager.createQuery(update);
		query.setParameter("phno", phno);
		query.setParameter("id", rollno);
		int result = query.executeUpdate();
		transaction.commit();
	} catch (Exception e) {
	if (transaction != null) {
		transaction.rollback();
	}
	e.printStackTrace();
} finally {
	if (factory != null || manager != null) {
		factory.close();
		manager.close();
	}
}
	System.out.println("you want to continue press y or to discontinue n");
	String option2 =scanner.next();
	if(option2.equalsIgnoreCase("y")) {
		break;
	}else {
		return;
	}
	
case 3:
	try {
		System.out.println("enter the rollno");
		int rollno=scanner.nextInt();
		System.out.println("enter the Standard");
		String st=scanner.next();
		factory = Persistence.createEntityManagerFactory("emp");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		String update = "update Student set standard=:st where id=:id";
		Query query = manager.createQuery(update);
		query.setParameter("st", st);
		query.setParameter("id", rollno);
		int result = query.executeUpdate();
		transaction.commit();
	} catch (Exception e) {
	if (transaction != null) {
		transaction.rollback();
	}
	e.printStackTrace();
} finally {
	if (factory != null || manager != null) {
		factory.close();
		manager.close();
	}
}
	System.out.println("you want to continue press y or to discontinue n");
	String option =scanner.next();
	if(option.equalsIgnoreCase("y")) {
		break;
	}else {
		return;
	}
	
case 4:
	try {
		System.out.println("enter the rollno");
		int rollno=scanner.nextInt();
		System.out.println("enter the name");
		String name=scanner.next();
		System.out.println("enter the Phno");
		long phno=scanner.nextLong();
		factory = Persistence.createEntityManagerFactory("emp");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		String update = "update Student set name=:name,phno= :phno where id=:id";
		Query query = manager.createQuery(update);
		query.setParameter("name", name);
		query.setParameter("phno", phno);
		query.setParameter("id", rollno);
		int result = query.executeUpdate();
		transaction.commit();
	} catch (Exception e) {
	if (transaction != null) {
		transaction.rollback();
	}
	e.printStackTrace();
} finally {
	if (factory != null || manager != null) {
		factory.close();
		manager.close();
	}
}
	System.out.println("you want to continue press y or to discontinue n");
	String option4 =scanner.next();
	if(option4.equalsIgnoreCase("y")) {
		break;
	}else {
		return;
	}
case 5:
	try {
		System.out.println("enter the rollno");
		int rollno=scanner.nextInt();
		System.out.println("enter the name");
		String name=scanner.next();
		System.out.println("enter the Standard");
		String st=scanner.next();
		factory = Persistence.createEntityManagerFactory("emp");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		String update = "update Student set name=:name,standard= :st where id=:id";
		Query query = manager.createQuery(update);
		query.setParameter("name", name);
		query.setParameter("st", st);
		query.setParameter("id", rollno);
		int result = query.executeUpdate();
		transaction.commit();
	} catch (Exception e) {
	if (transaction != null) {
		transaction.rollback();
	}
	e.printStackTrace();
} finally {
	if (factory != null || manager != null) {
		factory.close();
		manager.close();
	}
}
	System.out.println("you want to continue press y or to discontinue n");
	String option5 =scanner.next();
	if(option5.equalsIgnoreCase("y")) {
		break;
	}else {
		return;
	}
case 6:
	try {
		System.out.println("enter the rollno");
		int rollno=scanner.nextInt();
		System.out.println("enter the Standard");
		String st=scanner.next();
		System.out.println("enter the Phno");
		long phno=scanner.nextLong();
		factory = Persistence.createEntityManagerFactory("emp");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		String update = "update Student set standard= :st,phno= :phno where id=:id";
		Query query = manager.createQuery(update);
		query.setParameter("st", st);
		query.setParameter("phno", phno);
		query.setParameter("id", rollno);
		int result = query.executeUpdate();
		transaction.commit();
	} catch (Exception e) {
	if (transaction != null) {
		transaction.rollback();
	}
	e.printStackTrace();
} finally {
	if (factory != null || manager != null) {
		factory.close();
		manager.close();
	}
}
	System.out.println("you want to continue press y or to discontinue n");
	String option6 =scanner.next();
	if(option6.equalsIgnoreCase("y")) {
		break;
	}else {
		return;
	}
	
case 7:
	try {
		System.out.println("enter the rollno");
		int rollno=scanner.nextInt();
		System.out.println("enter the name");
		String name=scanner.next();
		System.out.println("enter the Phno");
		long phno=scanner.nextLong();
		System.out.println("enter the Standard");
		String st=scanner.next();
		factory = Persistence.createEntityManagerFactory("emp");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		String update = "update Student set name=:name,phno= :phno,standard= :st where id=:id";
		Query query = manager.createQuery(update);
		query.setParameter("name", name);
		query.setParameter("phno", phno);
		query.setParameter("st", st);
		query.setParameter("id", rollno);
		int result = query.executeUpdate();
		transaction.commit();
	} catch (Exception e) {
	if (transaction != null) {
		transaction.rollback();
	}
	e.printStackTrace();
} finally {
	if (factory != null || manager != null) {
		factory.close();
		manager.close();
	}
}
	System.out.println("you want to continue press y or to discontinue n");
	String option7 =scanner.next();
	if(option7.equalsIgnoreCase("y")) {
		break;
	}else {
		return;
	}
case 8:
	System.exit(0);
	break;
	default:
		try {
			throw new CustomException("Invalid data");
		}catch(CustomException e) {
			System.out.println(e.getMessage());
		}
		break;

	
	
}
}
	}

}
