package crud.pojo;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Save {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Employee emp = new Employee();
			Scanner s = new Scanner(System.in);
			
			System.out.println("Enter the empno");
			int empno = s.nextInt();
			emp.setEmpno(empno);

			System.out.println("Enter the ename");
			String ename = s.next();
			emp.setEname(ename);

			System.out.println("Enter the sal");
			int sal = s.nextInt();
			emp.setSal(sal);
			

			System.out.println("Enter the JOB");
			String job = s.next();
			emp.setJob(job);

			System.out.println("Enter the deptno");
			int deptno = s.nextInt();
			emp.setDeptno(deptno);

			session.saveOrUpdate(emp);
            transaction.commit();
            
			System.out.println("Records inserted sucessessfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
