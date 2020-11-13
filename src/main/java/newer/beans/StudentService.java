package newer.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.hibernate.Session;

import newer.model.Student;
import newer.utils.HibernateUtils;
import java.io.Serializable;

@Named
@SessionScoped
public class StudentService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		students = session.createNativeQuery("select * from student", Student.class).list();
		session.getTransaction().commit();

		return students;
	}
}
