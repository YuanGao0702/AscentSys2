package hibernate.daoimpl;

import hibernate.dao.UserDao;
import hibernate.po.Productuser;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public List findAllUser() {
		HibernateTemplate template = this.getHibernateTemplate();
		List users = template.find("from Productuser");
		return users;
	}

	public Productuser findUserById(Integer id) {
		HibernateTemplate template = this.getHibernateTemplate();
		List users = template.find("from Productuser user where user.uid=?",
				new Object[] { id });
		if (users != null && users.size() > 0) {
			return (Productuser) users.get(0);
		}
		return null;
	}

	public Productuser findUserByUsernameAndPassword(String username,
			String password) {
		HibernateTemplate template = this.getHibernateTemplate();
		List users = template
				.find(
						"from Productuser user where user.username=? and user.password=?",
						new Object[] { username, password });
		if (users != null && users.size() > 0) {
			return (Productuser) users.get(0);
		}
		return null;
	}

	public Productuser findUserByUsername(String username) {
		HibernateTemplate template = this.getHibernateTemplate();
		List users = template.find(
				"from Productuser user where user.username=?",
				new Object[] { username });
		if (users != null && users.size() > 0) {
			return (Productuser) users.get(0);
		}
		return null;
	}

	public Integer addUser(Productuser user) {
		HibernateTemplate template = this.getHibernateTemplate();
		Integer id = (Integer) template.save(user);
		return id;
	}

	public void updateUser(Productuser user) {
		HibernateTemplate template = this.getHibernateTemplate();
		template.update(user);
	}

}
