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

import com.domain.ComProgramDutyEditor;

/**
 * A data access object (DAO) providing persistence and search support for
 * ComProgramDutyEditor entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.domain.ComProgramDutyEditor
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ComProgramDutyEditorDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ComProgramDutyEditorDAO.class);
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

	public void save(ComProgramDutyEditor transientInstance) {
		log.debug("saving ComProgramDutyEditor instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ComProgramDutyEditor persistentInstance) {
		log.debug("deleting ComProgramDutyEditor instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ComProgramDutyEditor findById(java.lang.String id) {
		log.debug("getting ComProgramDutyEditor instance with id: " + id);
		try {
			ComProgramDutyEditor instance = (ComProgramDutyEditor) getCurrentSession()
					.get("com.domain.ComProgramDutyEditor", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ComProgramDutyEditor> findByExample(
			ComProgramDutyEditor instance) {
		log.debug("finding ComProgramDutyEditor instance by example");
		try {
			List<ComProgramDutyEditor> results = (List<ComProgramDutyEditor>) getCurrentSession()
					.createCriteria("com.domain.ComProgramDutyEditor")
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
		log.debug("finding ComProgramDutyEditor instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ComProgramDutyEditor as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ComProgramDutyEditor> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all ComProgramDutyEditor instances");
		try {
			String queryString = "from ComProgramDutyEditor";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ComProgramDutyEditor merge(ComProgramDutyEditor detachedInstance) {
		log.debug("merging ComProgramDutyEditor instance");
		try {
			ComProgramDutyEditor result = (ComProgramDutyEditor) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ComProgramDutyEditor instance) {
		log.debug("attaching dirty ComProgramDutyEditor instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ComProgramDutyEditor instance) {
		log.debug("attaching clean ComProgramDutyEditor instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComProgramDutyEditorDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ComProgramDutyEditorDAO) ctx.getBean("ComProgramDutyEditorDAO");
	}
}