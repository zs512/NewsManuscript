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

import com.domain.ComProgramAppraiser;

/**
 * A data access object (DAO) providing persistence and search support for
 * ComProgramAppraiser entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see ComProgramAppraiser
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ComProgramAppraiserDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ComProgramAppraiserDAO.class);
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

	public void save(ComProgramAppraiser transientInstance) {
		log.debug("saving ComProgramAppraiser instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ComProgramAppraiser persistentInstance) {
		log.debug("deleting ComProgramAppraiser instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ComProgramAppraiser findById(String id) {
		log.debug("getting ComProgramAppraiser instance with id: " + id);
		try {
			ComProgramAppraiser instance = (ComProgramAppraiser) getCurrentSession()
					.get("com.domain.ComProgramAppraiser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ComProgramAppraiser> findByExample(ComProgramAppraiser instance) {
		log.debug("finding ComProgramAppraiser instance by example");
		try {
			List<ComProgramAppraiser> results = (List<ComProgramAppraiser>) getCurrentSession()
					.createCriteria("com.domain.ComProgramAppraiser")
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
		log.debug("finding ComProgramAppraiser instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ComProgramAppraiser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ComProgramAppraiser> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all ComProgramAppraiser instances");
		try {
			String queryString = "from ComProgramAppraiser";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ComProgramAppraiser merge(ComProgramAppraiser detachedInstance) {
		log.debug("merging ComProgramAppraiser instance");
		try {
			ComProgramAppraiser result = (ComProgramAppraiser) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ComProgramAppraiser instance) {
		log.debug("attaching dirty ComProgramAppraiser instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ComProgramAppraiser instance) {
		log.debug("attaching clean ComProgramAppraiser instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComProgramAppraiserDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ComProgramAppraiserDAO) ctx.getBean("ComProgramAppraiserDAO");
	}
}