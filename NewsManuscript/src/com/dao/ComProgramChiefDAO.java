package com.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.domain.ComProgramChief;

/**
 * A data access object (DAO) providing persistence and search support for
 * ComProgramChief entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see ComProgramChief
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ComProgramChiefDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ComProgramChiefDAO.class);
	// property constants
	public static final String STATUS = "status";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(ComProgramChief transientInstance) {
		log.debug("saving ComProgramChief instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ComProgramChief persistentInstance) {
		log.debug("deleting ComProgramChief instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ComProgramChief findById(String id) {
		log.debug("getting ComProgramChief instance with id: " + id);
		try {
			ComProgramChief instance = (ComProgramChief) getCurrentSession()
					.get("com.domain.ComProgramChief", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ComProgramChief> findByExample(ComProgramChief instance) {
		log.debug("finding ComProgramChief instance by example");
		try {
			List<ComProgramChief> results = (List<ComProgramChief>) getCurrentSession()
					.createCriteria("com.domain.ComProgramChief")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ComProgramChief instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ComProgramChief as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ComProgramChief> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all ComProgramChief instances");
		try {
			String queryString = "from ComProgramChief";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ComProgramChief merge(ComProgramChief detachedInstance) {
		log.debug("merging ComProgramChief instance");
		try {
			ComProgramChief result = (ComProgramChief) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ComProgramChief instance) {
		log.debug("attaching dirty ComProgramChief instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ComProgramChief instance) {
		log.debug("attaching clean ComProgramChief instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComProgramChiefDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ComProgramChiefDAO) ctx.getBean("ComProgramChiefDAO");
	}
}