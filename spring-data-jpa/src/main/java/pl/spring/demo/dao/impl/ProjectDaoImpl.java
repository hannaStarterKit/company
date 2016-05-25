/**
 * 
 */
package pl.spring.demo.dao.impl;

import pl.spring.demo.dao.ProjectDao;
import pl.spring.demo.entity.ProjectEntity;

/**
 * @author HSIENKIE
 *
 */
public class ProjectDaoImpl extends AbstractDao<ProjectEntity, Long> implements ProjectDao {

	@Override
	public ProjectEntity findProjectByName(String projectName) {
		return entityManager.createQuery("from ProjectEntity project where upper(project.name) like concat(upper(:projectName), '%')", ProjectEntity.class)
				.setParameter("projectName", projectName).getSingleResult();
	}


}
